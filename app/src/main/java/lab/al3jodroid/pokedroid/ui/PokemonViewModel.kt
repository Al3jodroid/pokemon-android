package lab.al3jodroid.pokedroid.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lab.al3jodroid.pokedroid.interactor.PokemonUseCase
import javax.inject.Inject

const val INITIAL_COUNT = 1 //initial value for pokemon sequence

@HiltViewModel
class PokemonViewModel @Inject constructor(private val useCase: PokemonUseCase) : ViewModel() {

    private var countPokemon = INITIAL_COUNT
    private val _urlState: MutableStateFlow<String> = MutableStateFlow("")
    val urlState: StateFlow<String> = _urlState //let access to the state here

    fun getUrlImageSequence() {
        val urlPokemonImage = useCase.generateUrlImage(countPokemon)
        _urlState.value = urlPokemonImage
        countPokemon++
    }

    fun getUrlImageRandom() {
        val urlPokemonImage = useCase.generateRandomUrlImage()
        _urlState.value = urlPokemonImage
    }
}