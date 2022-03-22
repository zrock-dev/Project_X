package Informacion_de_peliculas;
import java.util.ArrayList;

public final class BASE_DE_DATOS {

    public static  ArrayList<Pelicula> LISTA_DE_PELICULAS() {
        ArrayList<Pelicula>peliculasDisponibles = new ArrayList<>();

        //MIDSOMMAR
        Pelicula midsommar = new Pelicula("Midsomar", "2 horas 25 minutos", "Una pareja de " +
                "estadounidenses acude con unos amigos a Midsommar,un fesival de verano que se celebra cada 90 años" +
                " en una aldea remota de Suecia ", 7);
        midsommar.setGeneros("Terror");
        midsommar.setGeneros("Drama");

        //JujutsuKaisen
        Pelicula jujutsuKaisen=new Pelicula("Jujutsu Kaisen 0","1 hora 45 minutos","Jujutsu" +
                " Kaisen 0 es una pelicula de anime japonesa de fantasia oscura, basada en el manga de Jujutsu Kaisen" +
                ",creado por Gege AKutami", 10);
        jujutsuKaisen.setGeneros("Animacion");
        jujutsuKaisen.setGeneros("Ciencia Ficcion");
        jujutsuKaisen.setGeneros("Drama");
        jujutsuKaisen.setGeneros("Fantasia");

        //Langosta
        Pelicula langosta = new Pelicula("Langosta", "1 hora 58 minutos", "Un futuro " +
                "cercano los solteros no tienen cabida en la soledad. Por esta razon, todos son arrestados y" +
                " llevados a un hotel donde tienen 45 dias para conocer a alguien y enamorarse de por vida." +
                " Si no lo consiguen seran convertidos en el animal que ellos escojan", 7);
        langosta.setGeneros("Romance");
        langosta.setGeneros("Ciencia Ficcion");
        langosta.setGeneros("Drama");

        //Kissing Booth
        Pelicula kissinBooth = new Pelicula("Kissing Booth","1 hora 45 minutos", "Evance " +
                "es un adolecente que acaba de desarrollarse fisicamente y que nunca beso a nadie, nacio el mismo" +
                " dia que su mejor amigo con el cual tiene una relacion muy estrecha,ambos tienen un pacto de " +
                "amistad con ciertas normas que seguir y entre ellas esta no meterse con el hermano de el", 5);
        kissinBooth.setGeneros("Romance");
        kissinBooth.setGeneros("Comedioa");

        //Cat
        Pelicula cats = new Pelicula("Cats","1 hora 50 minutos","En el basurero de los gatos" +
                " jelicos una tribu de gatos debera decidir como cada año cual ascendera a una nueva vida jelical"
                , 2);
        cats.setGeneros("Fantasia");
        cats.setGeneros("Musical");

        //Coraline
        Pelicula coraline = new Pelicula("Coraline", "1 hora 40 minutos", "Los mundos de " +
                "Coraline giran alrededor de una niña llamada Coraline Jones que con 11 años de edad sueña con " +
                "vivir mil experiencias, al descubrir en su casa una puerta secreta esta descubre que la transporta" +
                "a un mundo paralelo semejante a su vida pero mucho mas divertida", 9);
        coraline.setGeneros("Animacion");
        coraline.setGeneros("Fantasia");

        //DragonBall Broly
        Pelicula dragonBallBroly = new Pelicula("Dragon Ball Super: Broly", "1 hora 40 minutos",
                "Goku y Vegeta encuentran a Broly un guerrero Saiyajin. Pero ¿Como sobrevivio a la " +
                        "destruccion de su planeta y donde estuvo todo este tiempo? La situacion empeora todavia mas" +
                        " cuando Freezer vuelve al mundo de los vivos desde el infierno", 9);
        dragonBallBroly.setGeneros("Animacion");
        dragonBallBroly.setGeneros("Ciencia Ficcion");
        dragonBallBroly.setGeneros("Accion");

        //Spiderman No Way Homer
        Pelicula spiderman = new Pelicula("Spider-Man: No Way Home", "2 horas 28 minutos",
                "Tras descubrir la identidad secreta de Peter Parker como Spider-Man, la vida del joven se" +
                        " vuelve una locura. Peter decide pedirle ayuda al Doctor Strange para recuperar su vida." +
                        " Pero algo sale mal y provoca una fractura en el multiverso", 9);
        spiderman.setGeneros("Ciencia Ficcion");
        spiderman.setGeneros("Accion");
        spiderman.setGeneros("Comedia");

        //THe Batman
        Pelicula thebatman = new Pelicula("The Batman", "2 horas 56 minutos","En su segundo" +
                " año luchanddo contra el crimen, Batman explora la corrupcion existente en la ciudad de Gotham y" +
                " el vinculo de esta con su propia familia. Ademas, entrara en conflicto con un asesino en serie" +
                " conocido como El acertijo", 9);
        thebatman.setGeneros("Accion");
        thebatman.setGeneros("Drama");

        //La liga de la justicia
        Pelicula ligaDeLaJusticio = new Pelicula("La liga de la justicia", "2 horas", "Tras" +
                " el acto del altruista de Superman, que termino con su muerte, Batman esta decidido a hacer lo que" +
                " sea necesario para salvar a la humanidad. Asi junto a su aliada, Wonder Woman, decide reclutar " +
                "a un equipo de meta-humanos", 7);
        ligaDeLaJusticio.setGeneros("Accion");
        ligaDeLaJusticio.setGeneros("Ciencia Ficcion");

        //La habitacion
        Pelicula laHabitacion = new Pelicula("La habitacion","1 hora 58 minutos","Desde que" +
                " nacio hace 5 años Jack vive con su cariñosa madre en LA HABITACION, el unico mundo que el niño " +
                "conoce es un pequeño cuarto en el que el captor de su madre los tiene retenidos", 7);
        laHabitacion.setGeneros("Drama");
        laHabitacion.setGeneros("Suspenso");

        //Bohemiam Rapsody
        Pelicula bohemiamRhapsody = new Pelicula("Bohemian Rhapsody", "2 horas 14 minutos",
                "El joven farrock, Freddy para los amigos trabaja en el aeropuerto, estudie diseño grafico" +
                        " y escribe canciones. Un dia tras escuchar al grupo Smile en un bar se ofrece como cantante" +
                        " de la banda al enterarse que se han quedado sin vocalista", 8);
        bohemiamRhapsody.setGeneros("Documental");
        bohemiamRhapsody.setGeneros("Drama");
        bohemiamRhapsody.setGeneros("Musical");

        //The Room
        Pelicula theRoom = new Pelicula("The room", "1 hora 31 minutos", "Jhonny es un " +
                "banquero de exito que vive felizmente en San Francisco con su prometida Lisa. Un dia " +
                "inesplicablemente ella se aburre de el e intenta seducir a su mejor amigo, a partir de ese momento" +
                " nada volvera a ser lo mismo", 3);
        theRoom.setGeneros("Romance");
        theRoom.setGeneros("Drama");

        //Titanic 2
        Pelicula titanic2 = new Pelicula("Titanic 2", "1 hora 30 minutos", "Amy Maine ah " +
                "sido contratada para trabajar en el Titanic 2, el transclantico mas moderno y sofisticado " +
                "de todos los tiempo, que inicia un viaje por el oceano atlantico", 1);
        titanic2.setGeneros("Accion");

        //Guapies
        Pelicula Guapies = new Pelicula("Guapis", "1 hora 36 minutoss", "Amy una niña de 11 " +
                "años se une al grupo de danza de su escuela llamada cuties, un grupo cuyos intereses chocan con " +
                "los valores tradicionales de su madre Mariam", 2);
        Guapies.setGeneros("Drama");

        //Emojis
        Pelicula emojis = new Pelicula("Emojis", "1 hora 26 minutos", "Gene, un emoji con " +
                "varias expresiones pide a su amigo hi5 y al desencriptador que lo ayuden a covertirse un emoji de" +
                " una cara al igual que todos sus amigos, durante su aventura recorren varias aplicaciones y " +
                "descubren que el telefono en el que viven esta en peligro", 4);
        emojis.setGeneros("Animacion");
        emojis.setGeneros("Comedia");

        //SE ESTA ALIMENTANDO LA BASE DE DATOS
        peliculasDisponibles.add(midsommar);
        peliculasDisponibles.add(jujutsuKaisen);
        peliculasDisponibles.add(langosta);
        peliculasDisponibles.add(kissinBooth);
        peliculasDisponibles.add(cats);

        peliculasDisponibles.add(coraline);
        peliculasDisponibles.add(dragonBallBroly);
        peliculasDisponibles.add(spiderman);
        peliculasDisponibles.add(thebatman);
        peliculasDisponibles.add(ligaDeLaJusticio);

        peliculasDisponibles.add(laHabitacion);
        peliculasDisponibles.add(bohemiamRhapsody);
        peliculasDisponibles.add(titanic2);
        peliculasDisponibles.add(Guapies);
        peliculasDisponibles.add(emojis);
        peliculasDisponibles.add(theRoom);

        return peliculasDisponibles;
    }
}
