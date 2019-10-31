package core


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

        return " ⊢ {}"
    }
    override fun toString(): String {
        return "(${state}, ${remainingString})"
    }
}

//public readonly Configuration Previous;
//public readonly char State;
//public readonly string RemainingString;
//public readonly int CharIndex;
//
//public Configuration(Configuration previous, char state, string str, int charIndex)
//{
//    Previous = previous;
//    State = state;
//    CharIndex = charIndex;
//    RemainingString = charIndex < str.Length ? str.Substring(charIndex) : "λ";
//}
//
//public string ReconstructHistory()
//{
//    var stack = new Stack<Configuration>();
//    for (var c = this; c != null; c = c.Previous)
//    {
//        stack.Push(c);
//    }
//    return string.Join(" ⊢ ", stack);
//}
//
//public override string ToString()
//{
//    return $"({State}, {RemainingString})";
//}