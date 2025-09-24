class MyCircularQueue {
    private int[] queue;

    int front;
    int rear;
    int size;


    public MyCircularQueue(int k) {
        queue =new int[k];
        front =0;
        rear =-1;
        size =0;
        
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        rear = (rear+1)%queue.length;
        queue[rear]=value;
        size++;        

        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        front = (front+1)%queue.length;
        size--;

        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return-1;
        return queue[front];
        
    }
    
    public int Rear() {
        if(isEmpty())
            return-1;
        return queue[rear];
        
    }
    
    public boolean isEmpty() {
        if(size ==0)
            return true;
        else
            return false;
        
    }
    
    public boolean isFull() {
        if(size ==queue.length)
            return true;
        else
            return false;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */