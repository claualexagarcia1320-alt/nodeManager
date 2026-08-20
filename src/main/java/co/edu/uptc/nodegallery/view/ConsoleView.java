package co.edu.uptc.nodegallery.view;

import co.edu.uptc.nodegallery.presenter.nodeManager;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    private nodeManager presenter;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.presenter = new nodeManager(this);
    }

    public void start() {
        boolean activo = true;

        while (activo) {
            System.out.println("\nMENÚ:");
            System.out.println("1. Cargar Carpeta 1");
            System.out.println("2. Cargar Carpeta 2");
            System.out.println("3. Cargar Carpeta 3");
            System.out.println("4. Ver estado de memoria y total de imágenes");
            System.out.println("5. Limpiar Nodos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion >= 1 && opcion <= 3) {
                presenter.cargarCarpetaPorOpcion(opcion);
            } else {
                switch (opcion) {
                    case 4:
                        presenter.countImages();
                        break;
                    case 5:
                        presenter.cleanNodes();
                        System.out.println("Nodos liberados correctamente");
                        break;
                    case 6:
                        activo = false;
                        System.out.println("¡Saliendo del programa!");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }
        scanner.close();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}