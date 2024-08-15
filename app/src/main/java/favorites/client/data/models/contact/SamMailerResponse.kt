
package favorites.client.data.models.contact

import com.google.gson.annotations.SerializedName

data class SamMailerResponse(
        @SerializedName("subject")
        val subject: String,

        @SerializedName("body")
        val body: String,

        @SerializedName("email")
        val email: String
)
