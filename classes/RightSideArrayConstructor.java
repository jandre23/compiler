


import java.util.HashMap;

public class RightSideArrayConstructor extends RightSide {

	ArrayConstructor exp;

	RightSideArrayConstructor(ArrayConstructor e) {
		exp = e;
	}

	void printParseTree(String indent) {

		String indent1 = " " + indent;
		IO.displayln(indent + indent.length() + " <right side>");
		exp.printParseTree(indent1);
	}

	Val Eval(HashMap<String, Val> state) {
		return exp.Eval(state);
	};

	void emitInstructions() {
	};

}
