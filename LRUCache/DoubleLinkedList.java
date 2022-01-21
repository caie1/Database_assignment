package LRUCache;

public class DoubleLinkedList {
    DoubleLinkedNode head, tail;

    public DoubleLinkedList(){
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(DoubleLinkedNode node){
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addNode(DoubleLinkedNode node){
        DoubleLinkedNode second = head.next;
        head.next = node;
        node.prev = head;
        node.next = second;
        second.prev = node;
    }

    public DoubleLinkedNode removeLastNode(){
        DoubleLinkedNode last = tail.prev;
        if (last != null){
            removeNode(last);
        }
        return last;
    }
}
