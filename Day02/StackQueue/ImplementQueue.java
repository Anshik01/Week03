import java.util.Stack;

public class ImplementQueue {

    // inputStack will be used to take input from user
    static Stack<Integer> inputStack = new Stack<>();
    // outputStack will be used to print output to the user using FIFO principle
    static Stack<Integer> outputStack = new Stack<>();

    // item will push in input stack
    static void pushItem(int input){
        inputStack.push(input);
    }

    static int popItem(){
        while(!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }

        // removed item contains the item we want to reamove
        int removedItem = outputStack.pop();

        // again empty the output stack to input stack
        while(!outputStack.isEmpty()){
            inputStack.push(outputStack.pop());
        }
        return removedItem;
    }

    public static void main(String[] args) {
        pushItem(1);
        pushItem(2);
        pushItem(3);
        System.out.println(popItem());
        pushItem(4);
        pushItem(5);
        System.out.println(popItem());
    }

}
