import java.util.*;

class Pelicula {
    int id;
    String titulo;
    String tipo;
    double precio;
    boolean disponible;

    public Pelicula(int id, String titulo, String tipo, double precio, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return id + ". [" + tipo + "] " + titulo + " - $" + precio + (disponible ? " (Disponible)" : " (No disponible)");
    }
}

public class SistemaVideoClub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Registro de películas
        List<Pelicula> catalogo = Arrays.asList(
            new Pelicula(1, "Interestellar", "Fisica", 8000, true),
            new Pelicula(2, "El Padrino", "Fisica", 7000, false),
            new Pelicula(3, "Inception", "Digital", 5000, true),
            new Pelicula(4, "Matrix", "Digital", 6000, true)
        );

        // 2. Selección de membresía
        System.out.print("Membresia del cliente (Basica/Premium): ");
        String membresia = sc.nextLine();

        // Mostrar catálogo
        System.out.println("\nPelículas Disponibles:");
        for (Pelicula p : catalogo) System.out.println(p);

        // 3. Selección de películas
        System.out.print("\nSeleccione peliculas (IDs separados por coma, ej: 1,3): ");
        String[] seleccion = sc.nextLine().split(",");
        
        List<Pelicula> carrito = new ArrayList<>();
        double subtotal = 0;

        for (String s : seleccion) {
            int id = Integer.parseInt(s.trim());
            for (Pelicula p : catalogo) {
                if (p.id == id && p.disponible) {
                    carrito.add(p);
                    subtotal += p.precio;
                }
            }
        }

        // 4. Cálculo de descuento y total
        double descuento = membresia.equalsIgnoreCase("Premium") ? subtotal * 0.20 : 0;
        double total = subtotal - descuento;

        // 5. Generación del Recibo
        System.out.println("\n--- RECIBO DE ALQUILER ---");
        System.out.println("Cliente: " + membresia);
        System.out.println("Peliculas:");
        for (Pelicula p : carrito) {
            System.out.println(" - " + p.titulo + " (" + p.tipo + ") - $" + p.precio);
        }
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (20%): $" + descuento);
        System.out.println("Total a pagar: $" + total);
        System.out.println("--------------------------");
        System.out.println("¡Disfrute su película!");
    }
}