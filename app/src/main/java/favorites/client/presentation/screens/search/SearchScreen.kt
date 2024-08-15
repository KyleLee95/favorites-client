package favorites.client.presentation.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import favorites.client.observers.EventObserver
import favorites.client.presentation.components.CustomBottomNavigationBar
import favorites.client.presentation.components.CustomOutlinedTextField
import favorites.client.presentation.screens.search.paging.ArtList
import favorites.client.presentation.screens.search.paging.SearchOperation
import favorites.client.presentation.viewmodels.ArtViewModel




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    artViewModel: ArtViewModel,
    navController: NavController,
    eventObserver: EventObserver
) {
    val state = artViewModel.searchState.value
    val queryText = artViewModel.queryText.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Search the Art Institute's collection",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            )
        },
        bottomBar = {
            CustomBottomNavigationBar(navController = navController, eventObserver=eventObserver)
        }
    ) { paddingValues: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            CustomOutlinedTextField(
                title = "Search the AIC's Collection",
                placeHolder = "e.g. Van Gogh",
                textState = queryText,
                onTextChange = artViewModel::setQueryText,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
                onSearchDone = artViewModel::onSearch,
                logEvent = {searchTerm -> eventObserver.logUserEvent("search=$searchTerm")}
            )



            Spacer(modifier = Modifier.height(10.dp))
            when (state.searchOperation) {
                SearchOperation.LOADING -> {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(12.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                SearchOperation.DONE -> {
                    ArtList(artViewModel = artViewModel, navController=navController, eventObserver=eventObserver)
                }
                else -> {
                    Box {}
                }

            }

        }

    }
}



