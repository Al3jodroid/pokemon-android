package lab.al3jodroid.pokedroid.interactor

interface PokemonUseCase {
    fun generateRandomUrlImage(pokemonNumber: Int): String
    fun generateUrlImage(pokemonNumber: Int): String
}