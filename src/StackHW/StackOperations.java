package StackHW;

public class StackOperations {
    public static void main(String[] args) {
        Stack stack1 = new Stack(10);
        Stack stack2 = new Stack(10);

        stack1.push(1);
        stack1.push(9);
        stack1.push(8);
        stack1.push(1);
        stack1.push(10);

        stack2.push(19);
        stack2.push(18);
        stack2.push(11);
        stack2.push(29);

        System.out.println("Remove Minimum (stack1):");
        removeMin(stack1);
        stack1.display();

        System.out.println("-------------------------");

        System.out.println("Combine stack1 and stack2:");
        Stack testStack = sortStacks(stack1, stack2);
        testStack.display();
    }

    public static void removeMin(Stack stack){
        Stack tempStack = new Stack(stack.count());
        int min = stack.peek();
        for (int i = stack.count(); i > 0; i--){
            if (min > stack.peek()){
                min = stack.peek();
            }
            tempStack.push(stack.pop());
        }
        for (int j = tempStack.count(); j > 0; j--){
            if (tempStack.peek() == min){
                tempStack.pop();
            }else{
                stack.push(tempStack.pop());
            }
        }
    }

    public static Stack sortStacks(Stack stack1, Stack stack2){
        Stack newStack = new Stack(stack1.count() + stack2.count());
      //----------------------------------------------------------------//
        int stack1Count = stack1.count();                               //
        int stack2Count = stack2.count();                               //
        Stack tempStack = new Stack(stack1Count + stack2Count);    //
        Stack helperStack = new Stack(stack1Count + stack2Count);  //
        int tempItem;                                                   //
        for (int k = (stack1Count * 2); k > 0; k--){                    //
            if (tempStack.count() == stack1Count){                      //
                stack1.push(helperStack.pop());                         // Before I wrote this
            } else {                                                    // part, stack1 and stack2
                tempItem = stack1.pop();                                // would be empty after
                tempStack.push(tempItem);                               // the function finishes.
                helperStack.push(tempItem);                             //
            }                                                           // This part keeps a copy
        }                                                               // of stack1 and stack2
        for (int l = (stack2Count * 2); l > 0; l--){                    // in "tempStack". At the
            if (tempStack.count() == stack1Count + stack2Count){        // end of the function,
                stack2.push(helperStack.pop());                         // before returning
            } else {                                                    // "newStack" I redistribute
                tempItem = stack2.pop();                                // the items back into
                tempStack.push(tempItem);                               // stack1 and stack2.
                helperStack.push(tempItem);                             //
            }                                                           //
        }                                                               //
      //----------------------------------------------------------------//
        for (int i = stack1.count(); i > 0; i--){
            stack2.push(stack1.pop());
        }
        while (newStack.count() != newStack.size()){
            int min = stack2.peek();
            for (int j = stack2.count(); j > 0; j--){
                if (min > stack2.peek()){
                    min = stack2.peek();
                }
                stack1.push(stack2.pop());

            }
            for(int m = stack1.count(); m > 0; m--) {
                if (stack1.peek() == min) {
                    newStack.push(stack1.pop());
                } else {
                    stack2.push(stack1.pop());
                }
            }
        }
        for (int p = stack1Count + stack2Count; p > 0; p--){
            if (stack2.count() != stack2Count){
                stack2.push(tempStack.pop());
            } else {
                stack1.push(tempStack.pop());
            }
        }
        return newStack;
    }

}
