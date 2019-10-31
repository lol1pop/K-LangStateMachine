import core.LangStateMachine
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

    val data = LangStateMachine(
        states,
        alphabet,
        regulation,
        startState,
        acceptStates
    )
    val temp = data.getRegulation()
    println(temp)
}