package Timer;

/**
 * Questa classe rappresenta un cronometro per misurare il tempo trascorso
 * durante il gioco.
 * Utilizza il tempo di sistema per calcolare il tempo trascorso.
 */
public class stopWatch extends Thread {
    static long startTime;
    static double elapsedTime;

    /**
     * Avvia il cronometro impostando il tempo iniziale.
     */
    public void run() {
        startTime = System.nanoTime();
    }

    /**
     * Restituisce il tempo trascorso dal momento in cui il cronometro è stato
     * avviato
     * e stampa il risultato in secondi o minuti, a seconda della durata.
     */
    public void getTimeStopGame() {
        elapsedTime = (System.nanoTime() - startTime) / 1000000000;
        if (elapsedTime < 60) {
            System.out.printf("SEI RIUSCUTO A FINIRE IL GIOCO IN %.1f SECONDI!\n", elapsedTime);
        } else {
            int sec;
            if (elapsedTime % 60 == 0) {
                System.out.printf("HAI GIOCATO PER %.1f MINUTI!\n", elapsedTime / 60);
            } else {
                sec = (int) elapsedTime % 60;
                System.out.printf("HAI GIOCATO PER %d MINUTI E %d SECONDI!\n", (int) elapsedTime / 60, sec);
            }
        }
    }

    /**
     * Restituisce il tempo trascorso dal momento in cui il cronometro è stato
     * avviato
     * e stampa il risultato in secondi o minuti, a seconda della durata.
     */
    public void getTimeEndGame() {
        elapsedTime = (System.nanoTime() - startTime) / 1000000000;
        if (elapsedTime < 60) {
            System.out.printf("HAI GIOCATO PER %.1f SECONDI!\n", elapsedTime);
        } else {
            int sec;
            if (elapsedTime % 60 == 0) {
                System.out.printf("HAI GIOCATO PER %.1f MINUTI!\n", elapsedTime / 60);
            } else {
                sec = (int) elapsedTime % 60;
                System.out.printf("HAI GIOCATO PER %d MINUTI E %d SECONDI!\n", (int) elapsedTime / 60, sec);
            }
        }

    }
}
