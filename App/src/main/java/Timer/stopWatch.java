/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            System.out.printf("SEI RIUSCUTAO A FINIRE IL GIOCO IN %.1f SECONDI\n", elapsedTime);
        } else {
            System.out.printf("SEI RIUSCITO A FINIRE IL GIOCO IN %.1f SECONDI\n", elapsedTime / 60);
        }
    }

    public void getTimeEndGame() {
        elapsedTime = (System.nanoTime() - startTime) / 1000000000;
        if (elapsedTime < 60) {
            System.out.printf("HAI GIOCATO PER %.1f SECONDI\n", elapsedTime);
        } else {
            System.out.printf("HAI GIOCATO PER %.1f MINUTI\n", elapsedTime / 60);
        }

    }
}