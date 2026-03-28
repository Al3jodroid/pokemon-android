package lab.al3jodroid.pokedroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import lab.al3jodroid.pokedroid.ui.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    //reference to the viewModel that contains the business logic and emit states for UI
    val viewModel = hiltViewModel<PokemonViewModel>()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),

                title = {
                    Text(
                        "Pokedroid v0.1"
                    )
                }
            )
        },
        //pass the viewmodel for access to the method required to execute
        //the count of taps inside of it.
        floatingActionButton = { RenderFloatingActionButton(viewModel) }

    ) { innerPadding ->
        //pass the viewmodel too for access to the value counter that gonna
        //be rendered in the content of the screen.
        HomeContent(viewModel, innerPadding)
    }
}

@Composable
fun HomeContent(viewModel: PokemonViewModel, innerPadding: PaddingValues) {
    //ready to collect values when the viewModel emit it, here the state its consumed
    val urlState = viewModel.urlState.collectAsState()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RenderImage(urlState.value) //access to the value stored in the state for render in UI
    }
}

@Composable
fun RenderImage(urlString: String) {
    AsyncImage(
        modifier = Modifier.width(256.dp),
        model = urlString,
        contentDescription = "pokemon image!"
    )
}

@Composable
fun RenderFloatingActionButton(viewModel: PokemonViewModel) {
    FloatingActionButton(
        // onClick = { viewModel.getUrlImageRandom() },  // Classic way to execute code when click its done
        onClick =  viewModel::getUrlImageSequence, // Definition as reference when clicked
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}