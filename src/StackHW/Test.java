package StackHW;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String[] parenthesis = {"(", "[", "]", ")", "[", "]", "(", ")"};

        System.out.println(checkBalance(parenthesis));


    }
    public static boolean checkBalance(String[] string){
        GenericStack<String> myStack = new GenericStack<>(String.class, string.length);
        if (string.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < string.length; i++){
            if (string[i].equals("(") || string[i].equals("[") || string[i].equals("{")){
                myStack.push(string[i]);
            }else if (myStack.isEmpty()){
                return false;
            }else if (string[i].equals(")") && !myStack.pop().equals("(")){
                return false;
            }else if (string[i].equals("]") && !myStack.pop().equals("[")){
                return false;
            }else if (string[i].equals("}") && !myStack.pop().equals("{")){
                return false;
            }
        }return myStack.isEmpty();
    }
}
