package co.edu.uptc.nodegallery.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Image {
    private String ruta;
    private byte[] content;

    public Image(String ruta) {
        this.ruta = ruta;
        try {
            this.content = Files.readAllBytes(Path.of(ruta));
        } catch (IOException e) {
            System.err.println("No se pudo leer la imagen de la ruta: " + ruta);
            this.content = new byte[0]; 
        }
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public byte[] getContent() {
        return content;
    }
}