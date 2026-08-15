//imports
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Creamos las Digievoluciones
        Digievolucion adult = new Digievolucion("Adult", "Ataque", "Aumenta el daño en 15 puntos", 15, 40);
        Digievolucion mega = new Digievolucion("Mega", "Incrementar Defensa", "Aumenta la defensa en 20 puntos", 20, 41);
        Digievolucion ultimate = new Digievolucion("Ultimate", "Reduccion", "Reduce 10 puntos del ataque del rival", 10, 30);

        
        // Creamos los 8 digimones
        Digimon[] digimonaeleccion = new Digimon[8];
        digimonaeleccion[0] = new Digimon("Pika","Electrico",50,30,adult);
        digimonaeleccion[1] = new Digimon("Chorizo","Fuego",70,22,ultimate);
        digimonaeleccion[2] = new Digimon("Larvesta","Planta",55,26,mega);
        digimonaeleccion[3] = new Digimon("Greyninja","Agua",65,21,mega);
        digimonaeleccion[4] = new Digimon("Donalt el Pato","Agua",49,33,mega);
        digimonaeleccion[5] = new Digimon("Rayqueza","Fuego",71,20,ultimate);
        digimonaeleccion[6] = new Digimon("Agrooon","Planta",45,43,ultimate);
        digimonaeleccion[7] = new Digimon("Lux","Electrico",53,32,ultimate);


        // Creamos los arreglos de el equipo 1 (entrenador1) y el equipo2 (entrenador 2).
        Digimon[] equipo1 = new Digimon[4];
        Digimon[] equipo2 = new Digimon[4];

        //gui de inicio
        System.out.println("------------------------------");
        System.out.println("BIENVENIDO A BATALLAS DIGIMON");
        System.out.println("");
        System.out.println("Empieza tu primer combate entre amigos!");
        System.out.println("------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("\nEscribe cualquier cosa para continuar...");
        scanner.nextLine();
         System.out.println("");
        System.out.println("");
        System.out.println("");


        //se pide nombres de los entrenador
        System.out.println("\nNombre del entrenador 1: ");
        String e1 = scanner.nextLine();
        System.out.println("\nNombre del entrenador 2: ");
        String e2 = scanner.nextLine();
        System.out.println("");
        System.out.println("\nPerfecto ahora a escoger a sus digimones!");
        System.out.println("\nEscribe cualquier cosa para continuar...");
        scanner.nextLine();


        //Menu para escoger los digimones para su equipo, for de 4 tiempos
        for (int i = 0; i < 4; i++) {


        boolean seleccionCorrecta1 = false;
        // aqui se le pide al jugador 1 que escoja su digimon
        while (seleccionCorrecta1 == false) {

        System.out.println("");
        System.out.println("");
        System.out.println("TURNO DE JUGADOR 1");
        System.out.println("Escoge tu Digimon:");

            // se le muestran los 8 digimon al jugador 1
        for (int a = 0; a < digimonaeleccion.length; a++) {
            System.out.println((a + 1) + ". " + digimonaeleccion[a]);
        }
        // marca que digimon
        System.out.println(": ");

        int opcion1 = scanner.nextInt();

        // comprobacion de que el numero sea entre 8 a 1 ( osea los 8 digimon)
        if (opcion1 >= 1 && opcion1 <= 8) {

    Digimon elegido1 = digimonaeleccion[opcion1 - 1];

            // se comprueba que no este seleccionado por cualquier entrenador
    if (elegido1.getSeleccionado() == false) {

        equipo1[i] = elegido1;
        elegido1.setSeleccionado(true);

        seleccionCorrecta1 = true;

        System.out.println("");
        System.out.println("Jugador 1 escogio a "
                + elegido1.getNombre());

    } else {
         // dice si ese digimon ya fue seleccinado
         System.out.println("");
        System.out.println("Ese Digimon ya fue seleccionado.");
        System.out.println("");
    }

}        else {
        //dice opcion invalida si no es numero del 1 al 8
        System.out.println("");
        System.out.println("Opcion invalida.");
        System.out.println("Debes escoger un numero entre 1 y 8.");
        System.out.println("");
}
    }


    // aqui lo mismo pero para el entrenador 2
    boolean seleccionCorrecta2 = false;

    while (seleccionCorrecta2 == false) {

        System.out.println("");
        System.out.println("TURNO DE JUGADOR 2");
        System.out.println("Escoge tu Digimon:");
        System.out.println(": ");

    

        int opcion2 = scanner.nextInt();
        // se comprueba numero del 1 al 8
       if (opcion2 >= 1 && opcion2 <= 8) {

        Digimon elegido2 = digimonaeleccion[opcion2 - 1];
        // se comprueba si ya fue seleccinado
        if (elegido2.getSeleccionado() == false) {
        
        equipo2[i] = elegido2;
        elegido2.setSeleccionado(true);

        seleccionCorrecta2 = true;

        System.out.println("");
        System.out.println("Jugador 2 escogio a "
                + elegido2.getNombre());

    } else {

        System.out.println("");
        System.out.println("Ese Digimon ya fue seleccionado.");
        System.out.println("");
    }

} else {

    System.out.println("");
    System.out.println("Opcion invalida.");
    System.out.println("Debes escoger un numero entre 1 y 8.");
    System.out.println("");
}
    }
}

        // Se crea los entrenadores
        Entrenador entrenador1 = new Entrenador(e1, equipo1);
        Entrenador entrenador2 = new Entrenador(e2, equipo2);


            System.out.println("");
            System.out.println("DIGIMONES ESCOGIDOS CON EXITO");
            System.out.println("");



            //menu de 4 opciones , jugar partida, ver informacion de los entrenadores, ver digimones y salir. 
            boolean mantener = true;

        while (mantener == true) {

    System.out.println("------------------------------");
    System.out.println("1. Iniciar batalla");
    System.out.println("2. Ver entrenadores");
    System.out.println("3. Ver Digimones");
    System.out.println("4. Terminar programa");

    System.out.println("------------------------------");
    System.out.print("Opcion: ");

    int opcion = scanner.nextInt();
    

    // opcion 1 jugar partida
    if(opcion == 1) {

        System.out.println("");
        System.out.println("Iniciando batalla...");
        System.out.println("");

        // se crea la batalla
        BatallaDigimon batalla = new BatallaDigimon(digimonaeleccion, entrenador1, entrenador2);

        // aqui es el for para las 4 rondas 
       for(int b = 0; b < 4; b++){
        System.out.println("------------------------------");
        System.out.println("RONDA " + batalla.getRondaActual());
        System.out.println("------------------------------");
        System.out.println("");
        System.out.println("Entrenador 1: " + entrenador1.getNombre() + " escoge a tu digimon:");
        // se recorre los 4 digimons del entrenador 1 para ver cuales estan disponibles en la ronda
            for(int c = 0; c < 4; c++){
                int n = 1 +c;
                System.out.println(n + ". " + equipo1[c].getNombre() + " -  Usado en batalla: " + equipo1[c].getUsado());
            }


            // aqui se escoge el digimonq que va a utilizar
    Digimon elegido1 = null;

    while (elegido1 == null) {

        System.out.println(": ");
        int digimon1 = scanner.nextInt();
        // se le resta 1 a lo que puso al usuario por los indices
        elegido1 = entrenador1.elegirDigimon(digimon1 - 1);
        // se comprueba que elegir digimon no haya retornado null, si retorno entonces ya esta utilizado
        if (elegido1 == null) {
            System.out.println("");
            System.out.println("Ese Digimon ya fue utilizado.");
            System.out.println("Escoge otro Digimon:");
        }
    }
    // se le notifica que si lo escogio
    System.out.println("");
    System.out.println("Has escogido a: " + elegido1.getNombre());
    System.out.println("");


        System.out.println("");
        System.out.println("");

    // lo mismo para el entrenador 2
        System.out.println("Entrenador 2: " + entrenador2.getNombre() + " escoge a tu digimon:");
        // se muestran sus 4 digimon
            for(int c = 0; c < 4; c++){
                int n = 1 +c;
                System.out.println(n + ". " + equipo2[c].getNombre()+ " - Usado en batalla: " + equipo2[c].getUsado());
            }
        
    Digimon elegido2 = null;

    while (elegido2 == null) {

        System.out.println(": ");
        int digimon2 = scanner.nextInt();

        elegido2 = entrenador2.elegirDigimon(digimon2 - 1);
// se comprueba que no nos retorne null 
        if (elegido2 == null) {
            System.out.println("");
            System.out.println("Ese Digimon ya fue utilizado.");
            System.out.println("Escoge otro Digimon:");

        }
    }
        // se le notifica que lo escogio correctamente
        System.out.println("");
    System.out.println("Has escogido a: " + elegido2.getNombre());
    System.out.println("");


    // se muestra quienes se enfrentan
        System.out.println("");
        System.out.println("Digimones elegidos!!!.");
        System.out.println(elegido1.getNombre() 
        + " VS "+ 
        elegido2.getNombre());
        System.out.println("");
        System.out.println("");

        //se le pregunta al entrenador 1 si quiere activar la digievolucion y se le notifica la penalizacion si falla
        System.out.println("");
        System.out.println("Entrenador 1 " + entrenador1.getNombre());
        System.out.println("¿Quieres usar la Digievolucion?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("Nota: Si la Digievolucion falla tienes una penalizacion!");

        // esto es para que  1 , ver si colo  1 o 2 , y para ver si efectivamente si quiere la digievolucion
        boolean digievolucioonconfirmacion1 = false;
        boolean validardigievolucionn = false;

        while(validardigievolucionn == false){
            System.out.println(":");
            int digievolucioneleccion1 = scanner.nextInt();
        // se comprueba si me haya dado un numero  1 o 2
        if(digievolucioneleccion1 == 1 ){
            // se torna  true los dos ya que puso 1 y si la quiere activar
            digievolucioonconfirmacion1 = true;
            validardigievolucionn = true;
        } else if(digievolucioneleccion1 == 2){
            // se torno true uno ya que si me dio un numero 2 , pero no quiere la digievolucion
            validardigievolucionn = true;
           digievolucioonconfirmacion1 = false;
        }else{
            // mensaje de que  no coloco bien el numero 
            System.out.println("");
            System.out.println("Ingresaste un numero incorrecto.");
            System.out.println("¿Quieres usar la Digievolucion?");
        System.out.println("1. Si");
        System.out.println("2. No");
        }

        }
        // Lo mismo para entrenador 2
        System.out.println("");
        System.out.println("Entrenador 2 " + entrenador2.getNombre());
        System.out.println("¿Quieres usar la Digievolucion?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("Nota: Si la Digievolucion falla tienes una penalizacion!");

        boolean digievolucioonconfirmacion2 = false;

        boolean validardigievolucionn2 = false;

        while(validardigievolucionn2 == false){
            System.out.println(":");
            int digievolucioneleccion2 = scanner.nextInt();

        if(digievolucioneleccion2 == 1 ){
            digievolucioonconfirmacion2 = true;
            validardigievolucionn2 = true;
        } else if(digievolucioneleccion2 == 2){
            validardigievolucionn2 = true;
         digievolucioonconfirmacion2 = false;
        }else{
            System.out.println("");
            System.out.println("Ingresaste un numero incorrecto.");
            System.out.println("¿Quieres usar la Digievolucion?");
        System.out.println("1. Si");
        System.out.println("2. No");
        }

        }


        // se notifica que digimon se enfrenta a que digimon
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(elegido1.getNombre()+ " se enfrenta a " + elegido2.getNombre());
        // se juega la ronda
        int ronda = batalla.jugarRonda(elegido1, elegido2, digievolucioonconfirmacion1, digievolucioonconfirmacion2);
        // si se obtuvo la digievolucion 1 , pues se le notifica
        if(digievolucioonconfirmacion1){
        if(batalla.getDigievolucionActivadaJ1() ){
            System.out.println("");
            System.out.println(elegido1.getNombre()+ " esta activando su Digievolucion");
            System.out.println(elegido1.getDigievolucion().getNombre() + " " + elegido1.getNombre() + " esta en el campo de batalla!" );
        } 
        // si no lo logro, se le notifica la penalizacion
        else if (batalla.getDigievolucionActivadaJ1() == false) {
            System.out.println("");
            System.out.println(elegido1.getNombre()+ " no ha logrado digievolucionar!");
            System.out.println(elegido1.getNombre()+ " Obtiene una penalizacion de - 10% ataque base :(");
            System.out.println("");
        }
    }
        // lo mismo para entrenador 2 , se confirma si activo su digievolucion
    if(digievolucioonconfirmacion2){
        if(batalla.getDigievolucionActivadaJ2() ){
            System.out.println("");
            System.out.println(elegido2.getNombre()+ " esta activando su Digievolucion");
            System.out.println(elegido2.getDigievolucion().getNombre() + " " + elegido2.getNombre() + " esta en el campo de batalla!" );
        } 
        // si no lo logro, se le notifica
        else if (batalla.getDigievolucionActivadaJ2() == false) {
            System.out.println("");
            System.out.println(elegido2.getNombre()+ " no ha logrado digievolucionar!");
            System.out.println(elegido2.getNombre()+ " Obtiene una penalizacion de - 10% ataque base :(");
            System.out.println("");
        }
    }
    scanner.nextLine();
     System.out.println("");
      System.out.println("PRESIONA ENTER PARA VER EL RESULTADO DE LA RONDA");
       System.out.println("");
    scanner.nextLine();

    //si ronda retorna 1 , el main sabe que el entrenador 1 gano la ronda
    if(ronda == 1){
        System.out.println(entrenador1.getNombre() + " ha ganado la ronda con su digimon " + elegido1.getNombre());
    } 
    //si ronda retorna 2 , el main sabe que el entrenador 2 gano la ronda
    else if(ronda == 2){
        System.out.println(entrenador2.getNombre() + " ha ganado la ronda con su digimon " + elegido2.getNombre());
    } else{
        //lo demas cuenta como empate 
        System.out.println("NADIE HA GANADO, ES EMPATE!");
    }

    // se muestran que estadisitcas (ATAQUE FINAL)
    //tuvieron los dos digimon
    System.out.println("");
    System.out.println("--------------------------------------");
    System.out.println("ESTADISTICAS DEL COMBATE");
    System.out.println(elegido1.getNombre() + " - ATAQUE TOTAL: " + batalla.getAtaqueFinalJ1() + ", " + elegido2.getNombre() + " - ATAQUE TOTAL: "+  batalla.getAtaqueFinalJ2());
    System.out.println("--------------------------------------");
    System.out.println("");
   
    



       }
       // miramos quien es el ganador
       int ganadorBatalla = batalla.determinarGanador();
       System.out.println("PRESIONA ENTER PARA VER EL GANADOR DE LA PARTIDA");
       System.out.println(": ");
       scanner.nextLine();
       System.out.println("--------------------------------------");
       System.out.println("GANADOR");
       // si  ganador batalla me retorna 1 , es que gano el entrenador 1 
       if (ganadorBatalla == 1) {
           System.out.println(entrenador1.getNombre() + " FELICIDADES, HAS GANADO!");
           System.out.println(entrenador2.getNombre() + " suerte para la proxima!");
       }
       // si  ganador batalla me retorna 2 , es que gano el entrenador 2
       else if (ganadorBatalla == 2) {
           System.out.println(entrenador2.getNombre() + " FELICIDADES, HAS GANADO!");
           System.out.println(entrenador1.getNombre() + " suerte para la proxima!");
       }else{
        // si  me retorna cualquier cosa (0) empato el entrenado 1 y 2;
        System.out.println( "NADIE HA GANADO, FUE EMPATE!");
       }
       System.out.println("--------------------------------------");

       batalla.resetearBatalla();
       System.out.println(" ");
       System.out.println(" ");
       System.out.println("... la partida ha terminado! ");
       System.out.println("... PRESIONA ENTER PARA VOLVER AL MENU ");
       scanner.nextLine();
       



        
        // se miran los perfiles de los entrenadores
    } else if (opcion == 2) {

        System.out.println(entrenador1);
        System.out.println(entrenador2);
       


        // Reccorido para ver todos los digimones
    } else if (opcion == 3) {

        for (int i = 0; i < digimonaeleccion.length; i++) {
            System.out.println(digimonaeleccion[i]);
        }

        
    // se termina el programa
    } else if(opcion == 4){
        mantener = false;
    }else
    
    {
        //por si se escoge una opcion incorrecta de las 4 que se le habian plantenado
        System.out.println("");
        System.out.println("Opcion incorrecta.");
        System.out.println("Selecciona una opcion entre 1 y 4.");
        System.out.println("");
    }
}
    System.out.println("--------------------------------");
    System.out.println("PROGRAMA TERMINADO.");
    System.out.println("--------------------------------");


        }
    

        

    
    
    
    }
