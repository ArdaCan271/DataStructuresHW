package QueueHW;

public class Queue {
    private int head;
    private int tail;
    private int[] items;

    public Queue(int size){
        this.head = -1;
        this.tail = -1;
        this.items = new int[size];
    }

    public boolean isEmpty(){
        return this.head == this.tail;
    }

    public void enqueue(int val){
        this.tail++;
        this.items[tail] = val;
    }

    public int dequeue(){
        if (this.head == this.tail){
            System.out.println("queue is empty");
            return -1;
        }
        this.head++;
        return this.items[head];
    }

    public void display(){
        for (int i = this.head + 1; i <= tail; i++){
            System.out.println(this.items[i]);
        }
    }

    public int count(){
        return this.tail - this.head;
    }
}
