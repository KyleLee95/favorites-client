package favorites.client.presentation.screens.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import favorites.client.auth.AmplifyService
import favorites.client.presentation.components.CustomBottomNavigationBar
import favorites.client.presentation.components.CustomTopBar
import favorites.client.common.Constants
import favorites.client.data.models.contact.SamMailerResponse
import favorites.client.observers.EventObserver
import favorites.client.presentation.viewmodels.FavoritesViewModel
import favorites.client.presentation.viewmodels.SamMailerViewModel

@Composable
fun ContactScreen(
    navController: NavController,
    amplifyService: AmplifyService,
    eventObserver: EventObserver,
    favoritesViewModel: FavoritesViewModel,
    samMailerViewModel: SamMailerViewModel
) {
    val subjectState = remember { mutableStateOf("") }
    val bodyState = remember { mutableStateOf("") }
    val emailState = remember{ mutableStateOf("") }

    val isLoading = samMailerViewModel.isLoading.value
    val isSuccess = samMailerViewModel.isSuccess.value
    val errorMessage = samMailerViewModel.errorMessage.value

    Scaffold(
        modifier = Constants.modifier,
        bottomBar = { CustomBottomNavigationBar(navController, eventObserver = eventObserver) },
        topBar = {
            CustomTopBar(
                titleText = "Contact Us",
                navController = navController,
                amplifyService = amplifyService,
                eventObserver = eventObserver
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .wrapContentSize(Alignment.Center)
        ) {
            OutlinedTextField(
                value = subjectState.value,
                onValueChange = { subjectState.value = it },
                label = { Text("Subject") },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = bodyState.value,
                onValueChange = { bodyState.value = it },
                label = { Text("Body") },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )


            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(8.dp)
                )
            }

            if (isSuccess) {
                Text(
                    text = "Email sent successfully!",
                    color = Color.Green,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Button(
                onClick = {
                    if (subjectState.value.isEmpty() || bodyState.value.isEmpty()) {
                        samMailerViewModel.setErrorMessage("Subject and Body are required.")
                    } else {
                        val emailData = SamMailerResponse(
                            subject = subjectState.value,
                            body = bodyState.value,
                            email =  emailState.value
                        )
                        samMailerViewModel.submitEmail(emailData)
                    }
                },
                enabled = !isLoading,
                modifier = Modifier.padding(8.dp)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                } else {
                    Text("Submit")
                }
            }
        }
    }
}
