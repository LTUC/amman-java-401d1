package linkedList;

import java.util.Objects;

public class LinkedList<T> {

    Node<T> head;
    //Node<T> tail;

    public void insert(T val){
        this.head = new Node(val, this.head);
    }

    public void append(T val){
        Node<T> addedNode = new Node<>(val, null);
        Node<T> current = head;

        if(current != null) {

            while (current.next != null) {
                current = current.next;
            }
            current.next = addedNode;
        } else {
            head = addedNode;
        }

    }

    public void insertBefore(T value,T newValue){
        Node<T> current = this.head;
        Node<T> node = new Node(newValue,null);

        if(head == null){
            head = node;
        } else  { // condition to deal with head value
            while(current.next != null){
                if(current.next.value == value){
                    node.next = current.next;
                    current.next = node;
                    break;
                }
                current = current.next;
            }
        }

    }


    public String toString(){
        // StringBuilder
        String str="";

        Node current = head;
        while(current != null) {
            str+= "{" + current.value + "} ->";
            current = current.next;
        }

        str+= "NULL";
        return str;
    }
}

class Node<T> {
    T value;
    Node next;

    public Node(T value, Node next){
        this.value = value;
        this.next = next;
    }
}