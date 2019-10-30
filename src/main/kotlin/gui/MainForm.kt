package gui

import tornadofx.*

class MainForm : View() {
    override val root = Form()

    init {
        with(root) {
            hbox {}
        }
    }
}