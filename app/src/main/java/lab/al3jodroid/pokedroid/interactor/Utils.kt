package lab.al3jodroid.pokedroid.interactor

import java.text.DecimalFormat
import java.text.NumberFormat

const val POKEMON_ID_PATTERN = "000"
fun pokemonNumberToUrlId(pokemonNumber: Int): String {
    val formatter: NumberFormat = DecimalFormat(POKEMON_ID_PATTERN)
    return formatter.format(pokemonNumber)
}