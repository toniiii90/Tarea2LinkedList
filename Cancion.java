import java.util.ArrayList;
import java.util.LinkedList;

public class Cancion {
    private String titulo;
    private double duracion;

    public Cancion(String titulo, double duracion)  {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return titulo + ": " + duracion;
    }
}

class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    private Cancion findSong(String titulo) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equals(titulo)) {
                return cancion;
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion) {
        if (findSong(titulo) == null) {
            return canciones.add(new Cancion(titulo, duracion));
        }
        return false;
    }

    public boolean addToPlayList(int numeroPista, LinkedList<Cancion> playlist) {
        if (numeroPista > 0 && numeroPista <= canciones.size()) {
            Cancion cancion = canciones.get(numeroPista - 1);
            return playlist.add(cancion);
        }
        return false;
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playlist) {
        Cancion cancion = findSong(titulo);
        if (cancion != null) {
            return playlist.add(cancion);
        }
        return false;
    }
}
