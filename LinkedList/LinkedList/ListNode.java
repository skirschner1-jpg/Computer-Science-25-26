// Represents a node of a singly-linked list.

public class ListNode<E> {

private E value;
private ListNode<E> next;
private boolean seenBefore;

  public ListNode(E v) {
    value = v;
    next = null;
    seenBefore = false;
  }

  public ListNode(E v, ListNode<E> nx) {
    value = v;
    next = nx;
    seenBefore = false;
  }

  public E getValue() { return value; }
  public ListNode<E> getNext() { return next; }
  public boolean getSeenBefore(){ return seenBefore; }

  public void setValue(E v) { value = v; }
  public void setNext(ListNode<E> nx) { next = nx; }
  public void setSeenBefore(boolean seen) { seenBefore = seen; }
}


