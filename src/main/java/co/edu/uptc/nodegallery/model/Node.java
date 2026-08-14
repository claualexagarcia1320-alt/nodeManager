package co.edu.uptc.nodegallery.model;

public class Node {
    
    private Image data;
    private Node next; // Referencia al siguiente nodo
    private Node prev; // Referencia al nodo anterior

    public Image getData() {
        return data;
    }

    public void setData(Image data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node(Image data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
