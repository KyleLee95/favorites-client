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
import favorites.client.presentation.screens.search.paging.PokemonList
import favorites.client.presentation.screens.search.paging.SearchOperation


@Composable
fun CustomOutlinedTextField(
    title: String,
    placeHolder: String,
    textState: String,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    onSearchDone: (() -> Unit)?,
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        placeholder = { Text(text = placeHolder) },
        value = textState,
        onValueChange = { onTextChange(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType, imeAction = imeAction,
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                if (onSearchDone != null) {
                    onSearchDone()
                }
                focusManager.clearFocus()
            }
        ),
        singleLine = true,
        label = { Text(title) },
        modifier = Modifier.padding(10.dp, 0.dp),
        textStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp, color = Color.Black,
        ),

        )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    pokemonViewModel: PokemonViewModel,
    navController: NavController
) {
    val state = pokemonViewModel.searchState.value
    val queryText = pokemonViewModel.queryText.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Search Pokemon",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }


            )
        },
    ) { paddingValues: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            CustomOutlinedTextField(
                title = "For a pokemon",
                placeHolder = "e.g. Pikachu",
                textState = queryText,
                onTextChange = pokemonViewModel::setQueryText,
                keyboardType = KeyboardType.Text,
                ImeAction.Search,
                pokemonViewModel::onSearch
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
                    PokemonList(pokemonViewModel = pokemonViewModel, navController = navController)
                }

                else -> {
                    Box {}
                }

            }

        }

    }
}



