public class Digimon{

    private String nombre;
    private String tipo;
    private  int ataque;
    private int defensa;
    private boolean seleccionado;
    private boolean usado;
    private Digievolucion digievolucion;


    // Constructor
    public Digimon(String nombre, String tipo, int ataque, int defensa, Digievolucion digievolucion){
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.digievolucion = digievolucion;
        seleccionado = false;
        usado = false;
    }


    // getters

    public String getNombre(){
        return this.nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getAtaque(){
        return this.ataque;
    }

    public int getDefensa(){
        return this.defensa;
    }

    public Digievolucion getDigievolucion(){
        return this.digievolucion;
    }

        public boolean getUsado(){
            return this.usado;
        }

      public boolean getSeleccionado(){
            return this.seleccionado;
        }
  
    // Setters


    public void setUsado(boolean valor){
        this.usado = valor;
    }

    public void setSeleccionado(boolean valor){
        this.seleccionado = valor;
    
    }


    // Override
    @Override

    public String toString(){

        String disponibilidad;

        if (seleccionado == true) {
            disponibilidad = "No";
        } else{
            disponibilidad = "Si";
        }
         return          "\n-----------------------------------" +
         "\nDigimon: " + nombre +
           "\nAtaque: " + ataque +
           "\nDefensa: " + defensa + 
           "\nTipo: " + tipo +
           "\nDisponibilidad: " + disponibilidad +
           "\n"+digievolucion +
            "\n-----------------------------------";
    }



}