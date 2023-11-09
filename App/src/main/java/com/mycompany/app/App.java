/*
 * Progetto per l'esame di Metodi Avanzati di Programmazione
   - Catherine Martin Duarte
   - Elisa Stufano
   - Nicolò Orsi
 */

package com.mycompany.app;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import Parser.OutputParser;
import Parser.Parser;
import Parser.ParserBase;
import Timer.stopWatch;
import Type.Comandi;
import Type.Game;
import Type.GamePrint;
import Type.Printable;
import java.util.Scanner;

/**
 * La classe `App` rappresenta il punto di ingresso per l'applicazione del
 * gioco.
 */
public class App {
    private final Game game;
    private Parser parser;
    public static final String GREEN = "\033[0;32m"; // GREEN
    public static final String ANSI_RESET = "\u001B[0m"; // COLORE STANDARD DI JAVA
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    /**
     * Costruttore della classe `App`.
     *
     * @param game L'oggetto `Game` che rappresenta il gioco.
     */
    public App(Game game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception excep) {
            System.err.println(excep);
        }

        try {
            Set<String> paroleInutili = ParserBase.loadAndRead(
                    new File(getClass().getClassLoader().getResource("paroleInutili.txt").getFile()));
            parser = new Parser(paroleInutili);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    

    /**
     * Esegue il gioco e interagisce con l'utente.
     */
    public void execute() {
        stopWatch watch = new stopWatch();
        watch.start();
        boolean start;
        Scanner scanner = new Scanner(System.in);
        GamePrint print = new GamePrint();
        print.UnluckyPrint();

        Printable lambdaPrintable = () -> System.out
                .println(GREEN_BRIGHT + ANSI_WHITE_BACKGROUND + "\n\t\t\tSei pronto per questa avventura? (si/no)\n"
                        + ANSI_RESET);
        printThing(lambdaPrintable);
        String risp = scanner.nextLine();
        risp = risp.toLowerCase();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        start = print.startGame(risp);

        if (start) {
            print.printStory();
            System.out.println("\nTi trovi in: " + game.getStanzaCorrente().getName());
            System.out.println();

            while (scanner.hasNextLine()) {
                String comando = scanner.nextLine();
                OutputParser op = parser.parser(comando, game.getStanzaCorrente().getObjects(), game.getComandi(),
                        game.getInventario());

                if (op == null || op.getComandoParser() == null) {
                    System.out.println("Cosa vorresti dire?");
                } else if (op.getComandoParser() != null && op.getComandoParser().getTipoComando() == Comandi.END) {
                    watch.getTimeEndGame();
                    System.out.println("\nAlla prossima!\n");
                    break;
                } else {
                    game.prossimaMossa(op, System.out);
                    System.out.println();
                }
            }
        } else {
            System.out.println(
                    "                                                                                                            \r\n"
                            + //
                            "                  |    o                                                                                    \r\n"
                            + //
                            "             ,---.|---...   .,---..   .,---.,---.    ,---.,---.,---.,---.,---.,---.,-.-.,-.-.,---.          \r\n"
                            + //
                            "---------    |    |   |||   |`---.|   ||    ,---|    |   ||    |   ||   ||    ,---|| | || | |,---|    ------\r\n"
                            + //
                            "             `---'`   '``---'`---'`---'`    `---^    |---'`    `---'`---|`    `---^` ' '` ' '`---^          \r\n"
                            + //
                            "                                                     |              `---'                                   ");
        }
    }

    /**
     * Metodo principale per l'avvio dell'applicazione.
     *
     * @param args Gli argomenti della riga di comando.
     */
    public static void main(String[] args) {
        App app = new App(new UnluckyPickle());
        app.execute();
    }

    /**
     * Stampa l'oggetto `thing` implementando l'interfaccia `Printable`.
     *
     * @param thing L'oggetto da stampare.
     */
    static void printThing(Printable thing) {
        thing.print();
    }

}
