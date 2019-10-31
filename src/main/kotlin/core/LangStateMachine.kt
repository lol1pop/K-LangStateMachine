package core

data class LangStateMachine(
    val states: String,
    val alphabet: String,
    val regulation: List<List<String>> = listOf(),
    val startState: Char,
    val acceptStates: String,
    val chain: String? = null
){
    fun getState() = states.toCharArray()
    fun getAlphabet() = alphabet.toCharArray()
    fun getAcceptStates() = acceptStates.toCharArray()
    fun getRegulation(): Map<String, CharArray>{
        val mapRegulation = mutableMapOf<String, CharArray>()
        val arrSt = getState()
        val arrAlp = getAlphabet()
        for ((i, state) in regulation.withIndex()){
            for ((j,  symbol) in state.withIndex()) {
                if (symbol == "_") continue
                val key = "${arrSt[i]}${arrAlp[j]}"
                val value = symbol.toCharArray()
                mapRegulation[key] = value
            }
        }
        return mapRegulation.toMap()
    }
}