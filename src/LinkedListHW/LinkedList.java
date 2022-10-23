package LinkedListHW;

public class LinkedList<T extends Comparable<T>>{
    private Node<T> head;

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }

    public void addToFront(T val){
        Node<T> newNode = createNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void addAfterHead(T val){
        if (head == null){
            System.out.println("head is null");
            head = createNode(val);
        }
        Node<T> newNode = createNode(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void display(){
        Node<T> iterator = head;

        while (iterator != null){
            System.out.println(iterator.value);
            iterator = iterator.next;
        }
    }

    public void addToEnd(T val){
        if (head == null){
            head = createNode(val);
        }else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = createNode(val);
        }
    }

    public void addToEndUnique(T val){
        if (head == null){
            head = createNode(val);
        }else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                if (iterator.value.compareTo(val) == 0 || iterator.next.value.compareTo(val) == 0){
                    return;
                }
                iterator = iterator.next;
            }
            iterator.next = createNode(val);
        }
    }



    public void deleteAfterHead(){
        if (head != null && head.next != null){
            head.next = head.next.next;
        }
    }

    public void deleteValue(T val){
        if (head == null){
            System.out.println("List is empty");
        }else if (head.value == val){
            head = head.next;
        }
        else {
            Node<T> iterator = head;
            while (iterator.next != null){
                if (iterator.next.value == val){
                    iterator.next = iterator.next.next;
                    break;
                }
                iterator = iterator.next;
            }
        }
    }

    public int searchValue(T val){
        if (head == null){
            System.out.println("List is empty");
        } else {
          Node<T> iterator = head;
          int count = 0;
          while (iterator != null){
              if (iterator.value == val){
                  return count;
              }
              iterator = iterator.next;
              count++;
          }
        }
        return -1;
    }

    public int count(){
        Node<T> iterator = head;
        int count = 0;
        while (iterator != null){
            iterator = iterator.next;
            count++;
        }
        return count;
    }

    public void sortedAdd(T val){
        if (head == null){
            head = createNode(val);
        } else {
            Node<T> iterator = head;
            Node<T> newNode = createNode(val);
            while (iterator != null){
                if (head.value.compareTo(val) > 0) {
                    newNode.next = head;
                    head = newNode;
                    break;
                }else if (iterator.next != null && iterator.next.value.compareTo(val) > 0) {
                    newNode.next = iterator.next;
                    iterator.next = newNode;
                    break;
                } else if (iterator.next == null && iterator.value.compareTo(val) < 0) {
                    iterator.next = newNode;
                    break;
                }
                iterator = iterator.next;
            }
        }
    }

    public T findMin(){
        if (head == null){
            System.out.println("list is empty");
            return null;
        } else {
            T min = head.value;
            Node<T> iterator = head;
            while (iterator != null){
                if (iterator.value.compareTo(min) < 0){
                    min = iterator.value;
                }
                iterator = iterator.next;
            }
            return min;
        }
    }
}
