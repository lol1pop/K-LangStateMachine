import core.LangStateMachine
import core.StateMachine
import gui.MainForm
import javafx.application.Application
import tornadofx.*

class MainApp : App(MainForm::class)

fun gui__main(args: Array<String>) {
    Application.launch(MainApp::class.java, *args)
}

fun main() {
    val states = "pqr"
    val alphabet = "01"
    val regulation = listOf(
        listOf("q","p"),
        listOf("r","p"),
        listOf("r","r")
    )
    val startState = 'p'
    val acceptStates = "r"
    val chain = "01001"

    val data = LangStateMachine(
        states,
        alphabet,
        regulation,
        startState,
        acceptStates
    )

    val stateMachineTest = StateMachine(data)
    val result = stateMachineTest.identifyChain(chain)
    println(result.Log)
    if (result.IsRecognized)
        println("The string '$chain' is ACCEPTED")
    else
        println("The string '$chain' is NOT ACCEPTED")
}