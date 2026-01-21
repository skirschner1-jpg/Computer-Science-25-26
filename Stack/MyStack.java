public class MyStack<E>{
    private ListNode head;
    private boolean isEmpty;
    private int size;

    public MyStack() {
        head = null;
        isEmpty = true;
        size = 0;
    }

    private void setIsEmpty() {
        if (head == null) {
            isEmpty= true;
        } else {
            isEmpty = false;
        }
    }

    public boolean empty() {
        return isEmpty;
    }

    public void push(E obj) {
        ListNode toAdd = new ListNode(obj);
        toAdd.setNext(head);
        head = toAdd;
        isEmpty = false;
        size++;
    }

    public int size(){  
        return size;
    }

    public Object pop() {
        if (head == null) {
            return null;
        }
        Object toReturn = head.getValue();
        head = head.getNext();
        setIsEmpty();
        size--;
        return toReturn;
        // head.setNext(null);
    }

    public Object peek() {
        return head.getValue();
    }
}