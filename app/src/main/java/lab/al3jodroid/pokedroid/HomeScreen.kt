package lab.al3jodroid.pokedroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import lab.al3jodroid.pokedroid.ui.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    //reference to the viewModel that contains the business logic and emit states for UI
    val viewModel = hiltViewModel<PokemonViewModel>()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),

                title = {
                    Text(
                        "Compose Demo Home Page",
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
        Greeting()
        RenderImage(urlState.value) //access to the value stored in the state for render in UI
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "You have pushed the button this many times:",
        modifier = modifier
    )
}
@Composable
fun RenderImage(urlString: String) {
    Text(
        text = urlString,
        fontSize = 32.sp
    )
}

@Composable
fun RenderFloatingActionButton(viewModel: PokemonViewModel) {
    FloatingActionButton(
        // onClick = { viewModel.getUrlImageRandom() },  // Classic way to execute code when click its done
        onClick =  viewModel::getUrlImageSequence, // Definition as reference when its clicked
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}