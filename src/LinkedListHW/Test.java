package LinkedListHW;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();

        String items = "4,57,5,54,54,54,54,4,4,4,4,4,57,55,5,5,8";

        String[] strArr = items.split(",");

        int[] itemArray = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++){
            itemArray[i] = Integer.parseInt(strArr[i]);
        }

        for (int j = 0 ; j < itemArray.length; j++){
            myList.addToEndUnique(itemArray[j]);
        }

        myList.display();
    }
}
