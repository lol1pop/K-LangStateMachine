package core

data class LangStateMachine(
    val states: String,
    val alphabet: String,
    val regulation: List<List<String>> = listOf(),
    val startState: String,
    val acceptStates: String
){
    fun getState() = states.toCharArray()
    fun getAlphabet() = alphabet.toCharArray()
    fun getRegulation(){

    }
}