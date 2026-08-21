package co.edu.uptc.nodegallery.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Image {
    private String path;
    private byte[] content;

    public Image(String path) {
        this.path = path;
        try {
            this.content = Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            System.err.println("No se pudo leer la imagen de la ruta: " + path);
            this.content = new byte[0]; 
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String ruta) {
        this.path = ruta;
    }

    public byte[] getContent() {
        return content;
    }
}