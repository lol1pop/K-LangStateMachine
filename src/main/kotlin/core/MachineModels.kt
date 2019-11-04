package core

import java.util.*


data class IdentifyResult(
    val IsRecognized: Boolean,
    val Log: String
)

data class Branch(
    val previous: Branch?,
    val state: Char,
    private val str: String,
    val charIndex: Int
) {
    val remainingString = if (charIndex < str.length) {
        str.substring(charIndex)
    } else {
        "λ"
    }

    fun ReconstructHistory(): String {
        val stack = Stack<Branch>()
        var c: Branch?  = this
        while ( c != null){
            stack.push(c)
            c = c.previous
        }
        val res = stack.reversed()
        return res.joinToString(" ⊢ ")
    }
    override fun toString(): String {
        return "(${state}, ${remainingString})"
    }
}
