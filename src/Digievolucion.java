import java.util.Random;

public class Digievolucion{
    private String nombre;
    private String efecto;
    private String descripcion;
    private int valorEfecto;
    private int probabilidad;



// Constructor
    public Digievolucion(String nombre, String efecto, String descripcion, int valorEfecto, int probabilidad){
        this.nombre = nombre;
        this.efecto = efecto;
        this.valorEfecto = valorEfecto;
        this.probabilidad = probabilidad;
        this.descripcion = descripcion;
    }

    // Getters

    public String getNombre(){
        return this.nombre;
    }

    public String getEfecto(){
        return this.efecto;
    }

     public int getValorEfecto(){
        return this.valorEfecto;
    }

    public int getprobabilidad(){
        return this.probabilidad;
    }

    //Metodos
    // se intenta activar la digievolucion 
    public boolean intentarActivar(){
        Random random = new Random();
        int validacion = random.nextInt(100) + 1;

        if (validacion <= probabilidad) {
            return true;
        }else{
            return false;
        }


    }


    // Override
    @Override

    public String toString(){
         return 
            "\nDigievolucion: " + nombre +
           "\nefecto: " + efecto + valorEfecto + 
           "\nProbabilidad de activar: " + probabilidad + "%"+
           "\nDescripcion: " + descripcion + "%";
    }
}