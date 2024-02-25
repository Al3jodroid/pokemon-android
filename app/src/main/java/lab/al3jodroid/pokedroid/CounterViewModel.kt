package lab.al3jodroid.pokedroid

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

const val INITIAL_COUNT = 0 //define the initial value for the counter of taps
class CounterViewModel : ViewModel() {
    private var _counter = INITIAL_COUNT //make private the "business" value
    private val _counterState: MutableStateFlow<Int> = MutableStateFlow(_counter)
    val counterState: StateFlow<Int> = _counterState //let access to the state here

    fun incrementCounter() {
        _counter++
        _counterState.value = _counter // store the counter value in the value of the state
    }
}