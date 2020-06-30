
import java.util.*;

class ArrayVar extends Var {

    ArrayName arrayName;
    EList eList;

    ArrayVar(ArrayName aName, EList el) {
        arrayName = aName;
        eList = el;
    }

    void printParseTree(String indent) {
        String indent1 = indent + " ";
        String indent2 = indent + "  ";

        super.printParseTree(indent);
        IO.displayln("");
        IO.displayln(indent1 + indent1.length() + " <array var>");
        arrayName.printParseTree(indent2);
        eList.printParseTree(indent2);
    }

    Val Eval(HashMap<String, Val> state) {
        Val temp = state.get(arrayName.id.id);
        
        
       
        LinkedList<E> elist= eList.eList;
        
        LinkedList<Integer> sizeList= ((ArrayVal)temp).sizeList;
        Val r[]= ((ArrayVal)temp).a;
        
        
        int rank= rank(elist,state,sizeList);
      
       
        if (temp != null) {
           return ((ArrayVal)temp).a[rank];

        }

        

        return null;
    }

    void M(HashMap<String, Val> state, RightSide rightSide) // interpret assignment <array var> = <right side>
    {
        Val val = rightSide.Eval(state);
        Val temp = state.get(arrayName.id.id);
        
        
       
        LinkedList<E> elist= eList.eList;
        
        LinkedList<Integer> sizelist= ((ArrayVal)temp).sizeList;
        
        
        int rank= rank(elist,state,sizelist);
       Val r[]= ((ArrayVal)temp).a;
       
        if (val != null && temp != null) {
           ((ArrayVal)temp).a[rank]=val;

        }




    }
    
    
    private int rank(LinkedList<E> tempElist,HashMap<String, Val> state,LinkedList<Integer> sizeList){
        
    
    LinkedList<E> elist= (LinkedList<E>)tempElist.clone();
    LinkedList<Integer> sl=  (LinkedList<Integer>)sizeList.clone();
    
    
    if (tempElist.isEmpty()||sizeList.isEmpty()){return 0;}
    else {E e=elist.removeLast();
    Val temp=e.Eval(state);
  
   
    int x= (sl.removeLast());
    
        return (((IntVal)temp).val+((rank(elist,state,sl))*x));
            }
    }
}
