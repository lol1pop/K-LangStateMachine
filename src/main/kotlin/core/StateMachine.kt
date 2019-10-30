package core

class StateMachine(initData: LangStateMachine) {

    val state: CharArray = initData.getState()
    val alphabet: CharArray = initData.getAlphabet();
    val transitionFunction = null
    val startState: String = initData.startState;
    val acceptStates: String = initData.acceptStates;

    fun identifyChain(str: String):IdentifyResult {

        return IdentifyResult(true,"lol")
    }

}