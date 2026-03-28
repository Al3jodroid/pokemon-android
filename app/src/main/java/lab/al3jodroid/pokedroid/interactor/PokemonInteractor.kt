package lab.al3jodroid.pokedroid.interactor

class PokemonInteractor : PokemonUseCase {
    companion object {
        const val URL_BASE =
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/detail/"
        const val PNG_EXTENSION = ".png"
    }

    override fun generateUrlImage(pokemonNumber: Int): String {
        return URL_BASE + pokemonNumberToUrlId(pokemonNumber) + PNG_EXTENSION
    }

    override fun generateRandomUrlImage(pokemonNumber: Int): String {
        TODO("Not yet implemented")
    }
}