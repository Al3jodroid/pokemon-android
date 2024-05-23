package lab.al3jodroid.pokedroid.interactor

class PokemonInteractor : PokemonUseCase {
    override fun generateRandomUrlImage(): String {
        return "the_image_url_random"
    }

    override fun generateUrlImage(pokemonNumber: Int): String {
        return "the_image_url_sequence"
    }
}