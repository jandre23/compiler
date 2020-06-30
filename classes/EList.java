
import java.util.*;

class EList {

    LinkedList<E> eList;

    EList(LinkedList<E> el) {
        eList = el;
    }

    void printParseTree(String indent) {
        IO.displayln(indent + indent.length() + " <E list>");
        for (E e : eList) {
            e.printParseTree(indent + " ");
        }
    }

    Val Eval(HashMap<String, Val> state) {

        LinkedList<Integer> sizeList = new LinkedList<Integer>();
        int sizeOfArr = 1;
        Val arr_[];
        for (E e : eList) {
            Val temp = e.Eval(state);

            if (((IntVal) temp).val < 0) {
                return null;
            } else {
                
                sizeOfArr = sizeOfArr * ((IntVal) temp).val;

                sizeList.add(((IntVal) temp).val);
            }

        }
        arr_ = new Val[sizeOfArr];

        return new ArrayVal(sizeList, arr_);

    }

    
}
