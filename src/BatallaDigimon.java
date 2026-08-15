public class BatallaDigimon{
    private Digimon[] digimonesDisponibles;
    private Entrenador jugador1;
    private Entrenador jugador2;
    private int rondaActual;

    private int ataqueFinalJ1;
    private int ataqueFinalJ2;

    private boolean digievolucionActivadaJ1;
    private boolean digievolucionActivadaJ2;

    private int efectoAnteriorDEvolucionJ1;
    private int efectoAnteriorDEvolucionJ2;

    private String tipoEfectoAnteriorDEvolucionJ1;
    private String tipoEfectoAnteriorDEvolucionJ2;


    // constructor

    public BatallaDigimon(Digimon[] digimonesDisponibles, Entrenador jugador1, Entrenador jugador2){
        this.digimonesDisponibles = digimonesDisponibles;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.rondaActual = 1;

        this.ataqueFinalJ1 = 0;
        this.ataqueFinalJ2 = 0;

        this.digievolucionActivadaJ1 = false;
        this.digievolucionActivadaJ2 = false;

        this.efectoAnteriorDEvolucionJ1 = 0;
        this.efectoAnteriorDEvolucionJ2 = 0;

        this.tipoEfectoAnteriorDEvolucionJ1 = "";
        this.tipoEfectoAnteriorDEvolucionJ2 = "";
    }

    //Getters

    public int getAtaqueFinalJ1() {
    return ataqueFinalJ1;
}

    public int getAtaqueFinalJ2() {
    return ataqueFinalJ2;
}

    public boolean getDigievolucionActivadaJ1() {
    return digievolucionActivadaJ1;
}

    public boolean getDigievolucionActivadaJ2() {
    return digievolucionActivadaJ2;
}

    public Digimon[] getDigimonesDisponibles(){
        return this.digimonesDisponibles;
    }

    public Entrenador getJugador1(){
        return this.jugador1;
    }

    public Entrenador getJugador2(){
        return this.jugador2;
    }
public int getRondaActual(){
    return this.rondaActual;
}

// Metodos

// Resetear Efectos de anteores rondas

        // metodo para resetear efectos
        public void resetearAnteriorEfectos(){
        this.efectoAnteriorDEvolucionJ1 = 0;
        this.efectoAnteriorDEvolucionJ2 = 0;

        this.tipoEfectoAnteriorDEvolucionJ1 = "";
        this.tipoEfectoAnteriorDEvolucionJ2 = "";
}

// Calculamos el efecto en base a la tabla de tipos proporcionada de tipos de laboratorio
    public int calcularTipoEfecto(Digimon atacante, Digimon defensor){

        if(atacante.getTipo().equals("Fuego") && defensor.getTipo().equals("Planta")){
            return 20;
        } else if (atacante.getTipo().equals("Planta") && defensor.getTipo().equals("Agua")) {
            return 20;
        } else if (atacante.getTipo().equals("Agua") && defensor.getTipo().equals("Fuego")) {
            return 20;
        }else if (atacante.getTipo().equals("Electrico") && defensor.getTipo().equals("Agua")) {
            return 20;
        } else if (atacante.getTipo().equals("Planta") && defensor.getTipo().equals("Fuego")) {
            return -10;
        } else if (atacante.getTipo().equals("Agua") && defensor.getTipo().equals("Planta")) {
            return -10;
        }else if (atacante.getTipo().equals("Fuego") && defensor.getTipo().equals("Agua")) {
            return -10;
        }else if (atacante.getTipo().equals("Agua") && defensor.getTipo().equals("Electrico")) {
            return -10;
    } else{
        return 0;
    }
}
    


// se juega la ronda y se mira quien hace mas ataque
    public int jugarRonda(Digimon d1, Digimon d2, boolean habilidad1, boolean habilidadd2){
        
        // aqui siemopre  se pone false ya que queremos saber despues si el nuevo digimon  al final activo la digievolucion o no
        digievolucionActivadaJ1 = false;
        digievolucionActivadaJ2 = false;
        //variables base de ataque y defensa de ambos
        int ataqued1 = d1.getAtaque();
        int ataqued2 = d2.getAtaque();
        int defensad1 = d1.getDefensa();
        int defensad2 = d2.getDefensa();

        // Esta seccion es por si se jugo una digievolucion anterior, se le suma a la actual por 1 ronda, como lo indica el pdf
        if (tipoEfectoAnteriorDEvolucionJ1.equals("Ataque")) {
            ataqued1 += efectoAnteriorDEvolucionJ1;
            }

        if (tipoEfectoAnteriorDEvolucionJ1.equals("Reduccion")) {
            ataqued2 -= efectoAnteriorDEvolucionJ1;
}

        if (tipoEfectoAnteriorDEvolucionJ1.equals("Incrementar Defensa")) {
            defensad1 += efectoAnteriorDEvolucionJ1;
            }

        if (tipoEfectoAnteriorDEvolucionJ2.equals("Ataque")) {
            ataqued2 += efectoAnteriorDEvolucionJ2;
            }

        if (tipoEfectoAnteriorDEvolucionJ2.equals("Reduccion")) {
            ataqued1 -= efectoAnteriorDEvolucionJ2;
}

        if (tipoEfectoAnteriorDEvolucionJ2.equals("Incrementar Defensa")) {
            defensad2 += efectoAnteriorDEvolucionJ2;
            }    
            
            
            // se resetean los efectos de la digievolucion anterior para que despues no se apliquen denuevo
            resetearAnteriorEfectos();


           // Aqui se confirma por parte del usuario si quiere la digievolucion y se intenta activar 
           // la digievolucion tiene una penalizacion si no se activa que es -10% de ataque 
           // Ademas si se activa devuelve un true que lo confirma para textos posteriores.
        if(habilidad1){
           if(d1.getDigievolucion().intentarActivar()){

            tipoEfectoAnteriorDEvolucionJ1 = d1.getDigievolucion().getEfecto();
            efectoAnteriorDEvolucionJ1 = d1.getDigievolucion().getValorEfecto();

             digievolucionActivadaJ1 = true;

            if(d1.getDigievolucion().getEfecto().equals("Ataque")){
            ataqued1 += d1.getDigievolucion().getValorEfecto();

            }

            if(d1.getDigievolucion().getEfecto().equals("Reduccion")){
            ataqued2 -= d1.getDigievolucion().getValorEfecto();

            }

            if(d1.getDigievolucion().getEfecto().equals("Incrementar Defensa")){
            defensad1 += d1.getDigievolucion().getValorEfecto();

            }


           }else{
             ataqued1 -= ataqued1 * 10 / 100;
           }

        } 


        // lo mismo del entrenador dos
        if(habilidadd2){
           if(d2.getDigievolucion().intentarActivar()){

            tipoEfectoAnteriorDEvolucionJ2 = d2.getDigievolucion().getEfecto();
            efectoAnteriorDEvolucionJ2 = d2.getDigievolucion().getValorEfecto();

             digievolucionActivadaJ2 = true;

            if(d2.getDigievolucion().getEfecto().equals("Ataque")){
            ataqued2 += d2.getDigievolucion().getValorEfecto();

            }

            if(d2.getDigievolucion().getEfecto().equals("Reduccion")){
            ataqued1 -= d2.getDigievolucion().getValorEfecto();

            }

            if(d2.getDigievolucion().getEfecto().equals("Incrementar Defensa")){
            defensad2 += d2.getDigievolucion().getValorEfecto();

            }

           }else{
             ataqued2 -= ataqued2 * 10 / 100;
           }
           
        } 


        // Aqui convertimos la defensa a que reste el ataque, cada 3 puntos de defensa resta el ataque, esto ya sumado si digievoluciona
        defensad1 = defensad1 / 3;
        defensad2 = defensad2 / 3;

        // sumamos el ataque base(ya con efectos de la digievo anterior o la penalizacion), tabla de tipos y restamos la defensa del otro digimon
        int ataqueTd1= ataqued1 + calcularTipoEfecto(d1, d2) - defensad2 ;
        int ataqueTd2= ataqued2 + calcularTipoEfecto(d2, d1) - defensad1;
        this.ataqueFinalJ1 = ataqueTd1;
        this.ataqueFinalJ2 = ataqueTd2;


        // Aqui vemos quien gana la ronda
        if(ataqueTd1 > ataqueTd2){
            jugador1.incrementarRonda();
            rondaActual++;
            return 1;
        } 

        if(ataqueTd2 > ataqueTd1){
            jugador2.incrementarRonda();
            rondaActual++;
            return 2;
            
        } 

        // si no gana nadie empate
     rondaActual++;
     return 0;


    


    }



        // Determinamos el ganador en base aquien hace mas ataque
        // 1 si gana el entrenandor 1, 2 si gana el entrenador 2 , 0 empate, esto para ver que jugador gano.
    public int determinarGanador() {

    int resultado;

    if (jugador1.getRondasGanadas() > jugador2.getRondasGanadas()) {

        jugador1.incrementarVictoria();
        resultado = 1;

    } else if (jugador2.getRondasGanadas() > jugador1.getRondasGanadas()) {

        jugador2.incrementarVictoria();
        resultado = 2;

    } else {

        resultado = 0;
    }


    

    return resultado;


}


// Reseteamos la batalla para una posible segunda batalla
public void resetearBatalla() {

    jugador1.ResetearRondas();
    jugador2.ResetearRondas();

    jugador1.resetearDigimones();
    jugador2.resetearDigimones();
    resetearAnteriorEfectos();
    this.digievolucionActivadaJ1 = false;
    this.digievolucionActivadaJ2 = false;

    this.ataqueFinalJ1 = 0;
    this.ataqueFinalJ2 = 0;

    this.rondaActual = 1;
}

}

