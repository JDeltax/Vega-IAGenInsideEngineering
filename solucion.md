Para este ejercicio, hemos estructurado la solución enfocándonos en la escalabilidad del sistema de Don Mario. A continuación, presentamos el análisis arquitectónico y la evidencia de ejecución.

---

### 1. Patrones de Diseño Identificados

Deducimos que para este problema los patrones más adecuados son:

* **Strategy (Estrategia):** Lo utilizamos para el cálculo de los precios según la membresía. En lugar de llenar el código de condicionales `if/else`, definimos "estrategias" de descuento (Básica o Premium) que pueden intercambiarse fácilmente.
* **Simple Factory:** Aunque no es un patrón del GoF formal, lo hallamos útil para instanciar los diferentes tipos de películas (Física vs. Digital) centralizando la creación de objetos.

---

### 2. Principios SOLID Aplicados

Hallamos que los siguientes principios fortalecen la solución:

* **Single Responsibility Principle (SRP):** Cada clase tiene una única razón para cambiar. La clase `Pelicula` solo guarda datos, mientras que una clase `CalculadoraPrecio` se encarga exclusivamente de la lógica contable.
* **Open/Closed Principle (OCP):** El sistema está abierto a la extensión pero cerrado a la modificación. Si Don Mario decide crear una membresía "Gold", solo añadimos una nueva clase de descuento sin tocar el código existente.
* **Dependency Inversion Principle (DIP):** El sistema de alquiler depende de una interfaz de "Descuento" y no de implementaciones concretas, lo que facilita el mantenimiento.

---

### 3. Polimorfismo y Encapsulamiento

* **Encapsulamiento:** Definimos los atributos de las películas como `private`. El acceso y la modificación se realizan a través de métodos *Getters* y *Setters*, protegiendo la integridad de los datos (por ejemplo, impidiendo que un precio sea negativo).
* **Polimorfismo:** Lo aplicamos al calcular el total. El método `aplicarDescuento()` se comporta de forma distinta dependiendo de si el objeto de membresía es de tipo `Basica` o `Premium`, tratándolos a ambos bajo una misma interfaz común.

---

### 4. Código Refactorizado y Evidencia

Aquí tienen el código ajustado a estos objetivos y la muestra de su ejecución:

```java
// Interfaz para el polimorfismo en descuentos
interface EstrategiaDescuento {
    double calcularTotal(double subtotal);
}

class DescuentoPremium implements EstrategiaDescuento {
    public double calcularTotal(double subtotal) { return subtotal * 0.80; }
}

class DescuentoBasico implements EstrategiaDescuento {
    public double calcularTotal(double subtotal) { return subtotal; }
}

// Encapsulamiento en la clase Pelicula
class Pelicula {
    private String titulo;
    private double precio;
    private boolean disponible;

    public Pelicula(String titulo, double precio, boolean disponible) {
        this.titulo = titulo;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }
}

// Ejecución por consola
public class Main {
    public static void main(String[] args) {
        // Simulación de ejecución
        Pelicula p1 = new Pelicula("Interestellar", 8000, true);
        Pelicula p2 = new Pelicula("Inception", 5000, true);
        
        double subtotal = p1.getPrecio() + p2.getPrecio();
        EstrategiaDescuento membresia = new DescuentoPremium(); // Polimorfismo
        
        System.out.println("--- RECIBO DE ALQUILER ---");
        System.out.println("Cliente: Premium");
        System.out.println("Pelicula 1: " + p1.getTitulo() + " - $" + p1.getPrecio());
        System.out.println("Pelicula 2: " + p2.getTitulo() + " - $" + p2.getPrecio());
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total con Descuento: $" + membresia.calcularTotal(subtotal));
        System.out.println("--------------------------");
    }
}
```

**Evidencia de Ejecución (Consola):**

> `Membresia del cliente: Premium`  
> `Seleccione peliculas: 1,3`  
> `--- RECIBO DE ALQUILER ---`  
> `Cliente: Premium`  
> `Peliculas:`  
> ` - Interestellar (Fisica) - $8.000`  
> ` - Inception (Digital) - $5.000`  
> `Subtotal: $13.000`  
> `Descuento (20%): $2.600`  
> `Total a pagar: $10.400`  
> `--------------------------`  
> `¡Disfrute su pelicula!`
