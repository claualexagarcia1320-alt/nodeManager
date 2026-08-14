package co.edu.uptc.nodegallery.presenter;

import co.edu.uptc.nodegallery.model.Image;
import co.edu.uptc.nodegallery.model.Node;

public class nodeManager {
    private Node head;

    public nodeManager() {
        this.head = null;
    }

    // Agregar imagen al final de la lista
    public void addImage(String ruta) {
        Image newImage = new Image(ruta);
        Node newNode = new Node(newImage);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            // Se recorre hasta encontrar el último nodo
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // Se conecta el nuevo nodo al final
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    public Node getHead() {
        return head;
    }
}