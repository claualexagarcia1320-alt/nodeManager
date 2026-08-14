package co.edu.uptc.nodegallery;

import co.edu.uptc.nodegallery.model.Image;
import co.edu.uptc.nodegallery.model.Node;
import co.edu.uptc.nodegallery.presenter.nodeManager;

public class Main {
    public static void main(String[] args) {
        // Image image1 = new Image("ruta.imagen1.jpg");
        // Image image2 = new Image("ruta.imagen2.jpg");
        // Image image3 = new Image("ruta.imagen3.jpg");

        // Node node1 = new Node(image1);
        // Node node2 = new Node(image2);
        // Node node3 = new Node(image3);

        // node1.setPrev(null);
        // node1.setNext(node2);

        // node2.setPrev(node1);
        // node2.setNext(node3);

        // node3.setPrev(node2);
        // node3.setNext(null);

        // System.out.println("ruta imagen 2: " + node1.getNext().getData().getRuta());

        nodeManager presenter = new nodeManager();

        long totalM1 = Runtime.getRuntime().totalMemory();
        long freeM1 = Runtime.getRuntime().freeMemory();
        long memBefore = (totalM1 - freeM1) / (1024 * 1024);
        System.out.println("Memoria inicial usada: " + memBefore+ " MB");
        int numImages = 50000;
        // comportamiento memoria
        
            for (int i = 0; i < numImages; i++) {
                presenter.addImage("ruta.foto." + i + ".jpg");
            }
            System.out.println("Se agregaron " + numImages + " nodos correcatmente");
    

        long totalM2 = Runtime.getRuntime().totalMemory();
        long freeM2 = Runtime.getRuntime().freeMemory();
        long memAfter = (totalM2 - freeM2) / (1024 * 1024);
        System.out.println("Memoria final usada: " + memAfter+ " MB");
    }
}