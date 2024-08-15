package favorites.client.auth

import android.content.Context
import android.util.Log
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify



class AmplifyService  {
    fun configureAmplify(context: Context) {
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(context)
            Log.i("ampy", "Configured amplify")
        } catch (e: Exception) {
            Log.e("ampy", "Amplify configuration failed", e)
        }
    }

    fun fetchEmailAndLog(onEmailFetched: (String) -> Unit) {
        Amplify.Auth.fetchUserAttributes(
            { attributes: List<AuthUserAttribute> ->
                val emailAttribute = attributes.firstOrNull { it.key == AuthUserAttributeKey.email() }
                val sessionEmail = emailAttribute?.value ?: ""
                Log.i("ampy", "Session Email: $sessionEmail")
                onEmailFetched(sessionEmail) // Pass the session email back to the caller
            },
            { error: AuthException ->
                Log.e("ampy", "Failed to fetch user attributes.", error)
                onEmailFetched("") // Pass an empty string if there's an error
            }
        )
    }

    fun signUp(username: String, email: String, password: String, onComplete: (Boolean,String?) -> Unit) {
        val options = AuthSignUpOptions.builder()
            .userAttribute(AuthUserAttributeKey.email(), email)
            .build()

        Amplify.Auth.signUp(
            username,
            password,
            options,
            { result ->
                if (result.isSignUpComplete) {
                    onComplete(true, null) // Sign-up was successful, no error message
                } else {
                    onComplete(false, "Sign-up not fully completed. Please try again.")
                }
            },
            { error ->
                Log.e("ampy", "Sign Up Error:", error)
                onComplete(false, error.localizedMessage ?: "An unknown error occurred.")
            }
        )    }

    fun verifyCode(username: String, code: String, onComplete: (Boolean, String?) -> Unit) {
        Amplify.Auth.confirmSignUp(
            username,
            code,
            { result->
                if(result.isSignUpComplete){
                    onComplete(true,null)
                }else{
                    onComplete(false, "Verification Failed")
                }
            },
            { error->
                Log.e("ampy", "Verification Failed: ", error)
                onComplete(false, error.localizedMessage ?: "An unknown error occurred.")
            }
        )
    }

    fun login(username: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        Amplify.Auth.signIn(
            username,
            password,
            { result ->
                if (result.isSignInComplete) {
                    onComplete(true, null)
                } else {
                    onComplete(false, "Login not fully completed. Please try again.")
                }
            },
            { error ->
                Log.e("ampy", "Login Error:", error)
                onComplete(false, error.localizedMessage ?: "An unknown error occurred.")
            }
        )
    }

    fun logOut(onComplete: () -> Unit) {
        Amplify.Auth.signOut(
            { onComplete() },
            { Log.e("ampy", "Sign Out Failed: ", it) }
        )
    }
}
