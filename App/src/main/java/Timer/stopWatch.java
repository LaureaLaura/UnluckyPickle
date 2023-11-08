package Timer;
 
public class stopWatch extends Thread {
    static long startTime;
    static double elapsedTime;
 
    public void run() {
        startTime = System.nanoTime();
    }
 
    public void getTimeStopGame() {
        elapsedTime = (System.nanoTime() - startTime) / 1000000000;
        if (elapsedTime < 60) {
            System.out.printf("SEI RIUSCUTO A FINIRE IL GIOCO IN %.1f SECONDI!\n", elapsedTime);
        } else {
            int sec;
            if(elapsedTime%60 == 0){
            System.out.printf("HAI GIOCATO PER %.1f MINUTI!\n", elapsedTime / 60);
            } else {
                sec = (int) elapsedTime%60;
                System.out.printf("HAI GIOCATO PER %d MINUTI E %d SECONDI!\n", (int) elapsedTime / 60, sec);
            }
        }
    }
 
    public void getTimeEndGame() {
        elapsedTime = (System.nanoTime() - startTime) / 1000000000;
        if (elapsedTime < 60) {
            System.out.printf("HAI GIOCATO PER %.1f SECONDI!\n", elapsedTime);
        } else {
            int sec;
            if(elapsedTime%60 == 0){
            System.out.printf("HAI GIOCATO PER %.1f MINUTI!\n", elapsedTime / 60);
            } else {
                sec = (int) elapsedTime%60;
                System.out.printf("HAI GIOCATO PER %d MINUTI E %d SECONDI!\n", (int) elapsedTime / 60, sec);
            }
        }
 
    }
}
