package QueueHW;

import StackHW.Stack;

public class Test {
    public static void main(String[] args) {
        String palindrome = "siri";
        java.util.Stack stk = new java.util.Stack();

        System.out.println(checkPalindrome(palindrome));

    }

    public static boolean checkPalindrome(String str){
        Stack myStack = new Stack(str.length());
        Queue myQueue = new Queue(str.length());

        char[] myArray = str.toCharArray();

        for (int i = 0; i < str.length(); i++){
            myStack.push(myArray[i]);
            myQueue.enqueue(myArray[i]);
        }

        for (int j = 0; j < str.length(); j++){
            if (myStack.pop() != myQueue.dequeue()){
                return false;
            }
        }

        return true;
    }
}
