import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainCancion {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album1 = new Album("Un Verano sin ti", "Bad Bunny");
        album1.addSong("Moscow Mule", 4.06);
        album1.addSong("Neverita", 2.54);
        album1.addSong("Tarot", 3.58);
        album1.addSong("Ojitos Lindos", 4.34);
        albums.add(album1);

        Album album2 = new Album("Goodbye & Good Ridance", "Juice WRLD");
        album2.addSong("Lucid Dreams", 4.01);
        album2.addSong("All Girls are the same", 2.57);
        album2.addSong("End of the road", 2.44);
        album2.addSong("Armed and Dangerous", 3.14);
        albums.add(album2);

        Album album3 = new Album("Certified Lover Boy", "Drake");
        album3.addSong("Fair Trade", 4.52);
        album3.addSong("IMY2", 4.13);
        album3.addSong("TSU", 5.10);
        album3.addSong("Way 2 Sexy", 4.18);
        albums.add(album3);

        LinkedList<Cancion> playlist = new LinkedList<>();
        album1.addToPlayList("Neverita", playlist);
        album1.addToPlayList("Moscow Mule", playlist);
        album1.addToPlayList("Tarot", playlist);
        album1.addToPlayList("Ojitos Lindos", playlist);
        album2.addToPlayList("Lucid Dreams", playlist);
        album2.addToPlayList("All Girls are the same", playlist);
        album2.addToPlayList("End of the road", playlist);
        album2.addToPlayList("Armed and Dangerous", playlist);
        album3.addToPlayList("Fair Trade", playlist);
        album3.addToPlayList("IMY2", playlist);
        album3.addToPlayList("TSU", playlist);
        album3.addToPlayList("Way 2 Sexy", playlist);





        printPlayList(playlist);
        play(playlist);
    }

    private static void printPlayList(LinkedList<Cancion> playlist) {
        ListIterator<Cancion> iterator = playlist.listIterator();
        System.out.println("Lista de reproducción:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    private static void play(LinkedList<Cancion> playlist) {
        ListIterator<Cancion> iterator = playlist.listIterator();
        boolean forward = true;

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        if (playlist.isEmpty()) {
            System.out.println("La lista de reproducción está vacía.");
            return;
        } else {
            System.out.println("Reproduciendo: " + iterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Reproduciendo siguiente: " + iterator.next().toString());
                    } else {
                        System.out.println("Fin de la lista de reproducción.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Reproduciendo anterior: " + iterator.previous().toString());
                    } else {
                        System.out.println("Inicio de la lista de reproducción.");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Reproduciendo actual: " + iterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Inicio de la lista de reproducción.");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("Reproduciendo actual: " + iterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Fin de la lista de reproducción.");
                        }
                    }
                    break;
                case 4:
                    printPlayList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    iterator.remove();
                    if (forward && iterator.hasNext()) {
                        System.out.println("Canción eliminada. Reproduciendo siguiente: " + iterator.next().toString());
                    } else if (!forward && iterator.hasPrevious()) {
                        System.out.println("Canción eliminada. Reproduciendo anterior: " + iterator.previous().toString());
                    } else {
                        System.out.println("Lista de reproducción vacía después de eliminar la canción.");
                        quit = true;
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Opciones del menú:");
        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir siguiente canción");
        System.out.println("2 - Reproducir la canción previa de la lista.");
        System.out.println("3 - Repetir la canción actual.");
        System.out.println("4 - Imprimir la lista de canciones en la playlist.");
        System.out.println("5 - Volver a imprimir el menú.");
        System.out.println("6 - Eliminar la canción actual de la playlist.");


    }
}
