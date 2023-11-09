package Type;

import java.util.Scanner;

/**
 * Questa classe fornisce metodi per la stampa di testo colorato e diverse
 * funzionalità
 * utili all'interno di un gioco. Implementa l'interfaccia `Printable` per la
 * personalizzazione
 * della stampa.
 */
public class GamePrint implements Printable {
        // Costanti per i colori del testo
        public static final String GREEN = "\033[0;32m";
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String CYAN = "\033[0;36m";
        public static final String BLUE = "\u001B[33m";
        public static final String RED = "\033[0;31m";
        public static final String BLACK = "\033[0;30m";
        public static final String YELLOW = "\033[0;33m";
        public static final String PURPLE = "\033[0;35m";
        public static final String GREEN_BRIGHT = "\033[0;92m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        // Costanti per lo sfondo
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        Scanner scan = new Scanner(System.in);

        @Override
        public void print() {
                System.out.println("");
        }

        /**
         * Stampa il logo del gioco.
         */
        public void UnluckyPrint() {
                System.out.println(BLACK + ANSI_WHITE_BACKGROUND +
                                "===================================================================================================="
                                + ANSI_RESET);

                String[] asciiText = {
                                " _   _   _   _   _       _   _    ____   _  __ __   __    ____    ___    ____   _  __  _       _____ ",
                                "| | | | | \\ | | | |     | | | |  / ___| | |/ / \\ \\ / /   |  _ \\  |_ _|  / ___| | |/ / | |     | ____|",
                                "| | | | |  \\| | | |     | | | | | |     | ' /   \\ V /    | |_) |  | |  | |     | ' /  | |     |  _|  ",
                                "| |_| | | |\\  | | |___  | |_| | | |___  | . \\    | |     |  __/   | |  | |___  | . \\  | |___  | |___ ",
                                " \\___/  |_| \\_| |_____|  \\___/   \\____| |_|\\_\\   |_|     |_|     |___|  \\____| |_|\\_\\ |_____| |_____|"
                };

                for (String line : asciiText) {
                        System.out.println(GREEN_BRIGHT + line + ANSI_RESET);
                }

                System.out.println(BLACK + ANSI_WHITE_BACKGROUND +
                                "\n====================================================================================================\n"
                                + ANSI_RESET);
        }

        /**
         * Stampa la storia introduttiva del gioco.
         */

        public void printStory() {
                System.out.println(
                                "Sei lo scienziato più bravo dell'universo dal 1953, quando inventasti lo sparaporte, uno strumento che permette di viaggiare tra gli infiniti universi, consentendo di esplorare le sfaccettature più stravanganti e ignote mai immaginate dall'essere umano. Da allora, hai fatto numerosissime scoperte che hanno contributo all'umanità.\n\n"
                                                + "( - ENTER per continuare - )");
                String p = scan.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(
                                "In questo momento ti trovi sul divano. Oramai sei in pensione, passi la maggior parte delle tue giornate in tranquillità a guardare documentari, però non abbandoni la tua passione per la scienza. Infatti, stai sperimentando una pozione anti-aging, che ti permette di non invecchiare ulteriormente e ti fa sentire più energico e ringiovanito. È pronta, ce l'hai in mano, ora devi solo berla per vedere se funziona davvero!\n");
        }

        /**
         * Stampa gli indovinelli del gioco.
         */
        public void printEnigmi() {
                System.out.println(PURPLE + "  _               _                   _                  _   _   _ \r\n" + //
                                " (_)             | |                 (_)                | | | | (_)\r\n" + //
                                "  _   _ __     __| |   ___   __   __  _   _ __     ___  | | | |  _ \r\n" + //
                                " | | | '_ \\   / _` |  / _ \\  \\ \\ / / | | | '_ \\   / _ \\ | | | | | |\r\n" + //
                                " | | | | | | | (_| | | (_) |  \\ V /  | | | | | | |  __/ | | | | | |\r\n" + //
                                " |_| |_| |_|  \\__,_|  \\___/    \\_/   |_| |_| |_|  \\___| |_| |_| |_|\r\n" + //
                                "                                                                   " + ANSI_RESET);
                System.out.println(GREEN + ANSI_WHITE_BACKGROUND +
                                "\n-> Per trovare il primo tassello dovrai risolvere questo indovinello! Se il primo tassello vorrai trovare, solo dove riposare dovrai cercare. Non è un letto ma si sa, un bel pisolino avrà!"
                                + ANSI_RESET);
                System.out.println(GREEN + ANSI_WHITE_BACKGROUND +
                                "\n-> Per il secondo tassello, dovrai ragionare se lo vorrai trovare! Il prossimo indizio si è sporcato, a fare un bagnetto io l'ho portato!"
                                + ANSI_RESET);
                System.out.println(GREEN + ANSI_WHITE_BACKGROUND +
                                "\n-> È un liquido marroncino, può piacere macchiato o marocchino, se lo vuoi offrire 50cent dovrai uscire."
                                + ANSI_RESET);
        }

        /**
         * Stampa una descrizione dell'ingresso al laboratorio.
         */
        public void enterLab() {
                System.out.println(
                                "\nTi trovi davanti alla porta del laboratorio, per aprirla devi avere tutti gli ingredienti della pozione e devi inserire la password che è costituita da 3 caratteri che completano la seguente sequenza numerica:\r\n"
                                                + //
                                                "  _                     _                             __ \r\n" + //
                                                "  /        /  /         /  /          /  /  /         __)\r\n" + //
                                                " /   ---  '--/   ---   /  /_   ---   /_ '--/   ---   /   \r\n" + //
                                                "/           /         /  (__)       (__)  /         o    " + "\n");
        }

        /**
         * Stampa un messaggio di aiuto con la lista dei comandi del gioco.
         */
        public void printHelp() {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(
                                BLUE + "=================================================================================================="
                                                + ANSI_RESET);
                System.out.println("\n" + "  _   _   _____   _       ____    _ \r\n" + //
                                " | | | | | ____| | |     |  _ \\  | |\r\n" + //
                                " | |_| | |  _|   | |     | |_) | | |\r\n" + //
                                " |  _  | | |___  | |___  |  __/  |_|\r\n" + //
                                " |_| |_| |_____| |_____| |_|     (_)" + //
                                "\n\nEcco la lista di tutti i comandi del gioco:\n\n" + //
                                "*NORD*, *SUD*, *EST*, *OVEST* -> Per spostarsi tra le camere.\r\n" + //
                                "*INVENTARIO* -> Per avere la lista degli oggetti del tuo inventario.\r\n" + //
                                "*END* -> Per uscire dal gioco.\r\n" + //
                                "*INDIZI* -> Per avere la lista di indizi per aprire la cassettiera.\r\n" + //
                                "*LEGGI*, *BEVI*, *INSERISCI*, *PRENDI*, *GUARDA*, *APRI* -> Sono i possibili comandi per gli oggetti.\n");
                System.out.println(
                                BLUE + "=================================================================================================="
                                                + ANSI_RESET);
        }

        /**
         * Stampa un messaggio per comunicare la trasformazione in un cetriolo.
         */
        public void printTransform() {
                System.out.println(GREEN + "\n\n*** Santo cielo! Sono diventato un cetriolo! ***\n" + ANSI_RESET);
                System.out.println(
                                "\nTi guardi, la tua faccia è tutta verde e il tuo corpo è tondeggiante. Hai braccia e gambe costituite da cetrioli!"
                                                + "\nSei in panico, non sai cosa fare. Qualcosa deve essere andato storto...... o forse sai benissimo cosa. "
                                                + "\nAvrai messo troppo concentrato di cetriolo nella pozione! Per fortuna nel tuo quaderno degli appunti hai la ricetta dell'antidoto della pozione.");
        }

        /**
         * Stampa un messaggio di game over.
         */
        public void printGameOver() {
                System.out.println(BLUE
                                + "                                                                                    \r\n"
                                + //
                                "                                                                                    \r\n"
                                + //
                                "   __        __       ___ ___       __                ___    __  __     __    _ __  \r\n"
                                + //
                                " /'_ `\\    /'__`\\   /' __` __`\\   /'__`\\             / __`\\ /\\ \\/\\ \\  /'__`\\ /\\`'__\\\r\n"
                                + //
                                "/\\ \\L\\ \\  /\\ \\L\\.\\_ /\\ \\/\\ \\/\\ \\ /\\  __/            /\\ \\L\\ \\\\ \\ \\_/ |/\\  __/ \\ \\ \\/ \r\n"
                                + //
                                "\\ \\____ \\ \\ \\__/.\\_\\\\ \\_\\ \\_\\ \\_\\\\ \\____\\           \\ \\____/ \\ \\___/ \\ \\____\\ \\ \\_\\ \r\n"
                                + //
                                " \\/___L\\ \\ \\/__/\\/_/ \\/_/\\/_/\\/_/ \\/____/            \\/___/   \\/__/   \\/____/  \\/_/ \r\n"
                                + //
                                "   /\\____/                                                                          \r\n"
                                + //
                                "   \\_/__/                                                                           "
                                + ANSI_RESET);
        }

        /**
         * Chiede all'utente se desidera iniziare il gioco.
         *
         * @param ready La risposta dell'utente.
         * @return true se l'utente è pronto a iniziare il gioco, altrimenti false.
         */
        public boolean startGame(String ready) {
                boolean start = false;
                String risp = "";
                Scanner scanner = new Scanner(System.in);

                if (ready.equals("si")) {
                        start = true;
                } else if (ready.equals("no")) {
                        start = false;
                } else {
                        while (!risp.equals("si") && !risp.equals("no")) {
                                System.out.println("Risposta errata. Riprova -> ");
                                risp = scanner.nextLine();
                                risp = risp.toLowerCase();
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                        }
                        if (risp.equals("si")) {
                                start = true;
                        } else {
                                start = false;
                        }
                }
                return start;
        }
}