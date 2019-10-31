package core

import java.util.*

class StateMachine(initData: LangStateMachine) {

    private val states: CharArray = initData.getState()
    private val alphabets: CharArray = initData.getAlphabet()
    private val mapRegulation = initData.getRegulation()
    private val startState: Char = initData.startState
    private val acceptStates: CharArray = initData.getAcceptStates()

    fun identifyChain(chain: String): IdentifyResult {
        val branches = Stack<Branch>()
        val fails = listOf<String>()
        var currencyBranch = Branch(null, startState, chain, 0)
        do {
            var state = currencyBranch.state
            var charIndex = currencyBranch.charIndex
            for (symbol in chain) {
                if (!alphabets.contains(symbol)) return IdentifyResult( false, "${currencyBranch.ReconstructHistory()}\nIllegal symbol '${symbol}'.")
                val nextPossibleStates: CharArray = mapRegulation["$state$symbol"] ?: charArrayOf()
                if (nextPossibleStates.isEmpty()) {
                    fails + "${currencyBranch.ReconstructHistory()}: No transition for (${state}, ${symbol})."
                    break
                }
                val nextState = nextPossibleStates[0]
                val otherState = nextPossibleStates.drop(1)
                for (altered in otherState){
                    branches.push(Branch(currencyBranch, altered, chain, charIndex))
                }
                state = nextState
                currencyBranch = Branch(currencyBranch, state, chain, charIndex)
                charIndex++
            }
            if (charIndex == chain.length) {
                if (acceptStates.contains(state)){
                    return IdentifyResult( true, currencyBranch.ReconstructHistory())
                }else {
                    fails + "${currencyBranch.ReconstructHistory()}: Stopped not in final configuration."
                }
            }
            if (!branches.empty()){
                currencyBranch = branches.pop()
            } else {
                break
            }
        } while (true)

        return IdentifyResult(true, "lol")
    }

}