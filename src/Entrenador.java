public class Entrenador{
    private String nombre;
    private int rondasGanadas;
    private Digimon[] digimones; 
    private int victorias;



    // Constructor
    public Entrenador(String nombre, Digimon[] digimones){
        this.nombre = nombre;
        this.rondasGanadas = 0;
        this.digimones =  digimones;
        this.victorias = 0;
    }


    // Getters
    public String getNombre(){
        return nombre;
    }

    public int getRondasGanadas(){
        return rondasGanadas;
    }

    public Digimon[] getDigimones(){
        return digimones;
    }




    //Metodos

    // se resetean las rondas
    public void ResetearRondas(){
        this.rondasGanadas = 0;
    }   
    // se resetean que se hayan usado los digimones de la partida anterior para que no aparezca "usado en partida".
    public void resetearDigimones() {

    for (int i = 0; i < digimones.length; i++) {
        digimones[i].setUsado(false);
    }
}
    // esto es para incrementar cada ronda 
    public void incrementarRonda(){
        this.rondasGanadas += 1;
    }
    // incrementar las victorias de quien gana
    public void incrementarVictoria(){
        this.victorias += 1;
    }

    // Esto es para que se elija un digimon  en las rondas, si no esta usado , lo retorna  y pone valor true de que esta usado
    //si no retorna null para que le diga al usuario que ese digimon ya esta usado 
    public Digimon elegirDigimon(int posicion){
        if(digimones[posicion].getUsado() == false){
            digimones[posicion].setUsado(true);
            return digimones[posicion];
        } else{
            return null;
        }
    }



    //Override 
    @Override

    public String toString(){

        String nombres = "";
        for (int i= 0; i < digimones.length; i++) {
            nombres = nombres + digimones[i].getNombre() + ", ";
        }

         return  "-----------------------------------" +
            "\nEntrenador: " + nombre +
           "\nVictorias: " + victorias + 
           "\nDigimones: " + nombres+
           "\n-----------------------------------";
    }

}