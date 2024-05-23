package lab.al3jodroid.pokedroid.interactor

interface PokemonUseCase {
    fun generateRandomUrlImage(): String
    fun generateUrlImage(pokemonNumber: Int): String
}