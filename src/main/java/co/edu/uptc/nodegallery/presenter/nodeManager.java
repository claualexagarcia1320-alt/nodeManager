package co.edu.uptc.nodegallery.presenter;

import co.edu.uptc.nodegallery.model.Image;
import co.edu.uptc.nodegallery.model.Node;
import co.edu.uptc.nodegallery.view.ConsoleView;
import java.io.File;

public class nodeManager {
    private Node head;
    private ConsoleView view;

    public nodeManager(ConsoleView view) {
        this.head = null;
        this.view = view;
    }

    public void loadFolderByOption(int option) {
        String rutaCarpeta = "";
        if (option == 1) {
            rutaCarpeta = "src/main/java/co/edu/uptc/nodegallery/images1";
        } else if (option == 2) {
            rutaCarpeta = "src/main/java/co/edu/uptc/nodegallery/images2";
        } else if (option == 3) {
            rutaCarpeta = "src/main/java/co/edu/uptc/nodegallery/images3";
        }

        long memBefore = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);

        File folder = new File(rutaCarpeta);
        File[] files = folder.listFiles();

        if (files != null) {
            int count = 0;
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isFile()) {
                    String name = file.getName().toLowerCase();
                    if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
                        addImage(file.getAbsolutePath());
                        count++;
                    }
                }
            }
            view.showMessage("¡Se cargaron " + count + " imágenes exitosamente!");
        } else {
            view.showMessage("La carpeta está vacía o la ruta no es válida.");
        }

        long memAfter = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
        view.showMessage("Memoria antes: " + memBefore + " MB | Memoria después: " + memAfter + " MB");
        view.showMessage("Impacto en RAM: " + (memAfter - memBefore) + " MB");
    }

    public void addImage(String ruta) {
        Image newImage = new Image(ruta);
        Node newNode = new Node(newImage);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    public void countImages() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        view.showMessage("Hay " + count + " imágenes en los nodos.");

        long memCurrent = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
        view.showMessage("Memoria RAM usada actualmente: " + memCurrent + " MB");
    }

    public void cleanNodes() {
        head = null;
    }

    public Node getHead() {
        return head;
    }
}