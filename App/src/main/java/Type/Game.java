package Type;
import java.util.ArrayList;
import java.util.List;
import Parser.OutputParser;
import java.io.PrintStream;
/**
 * Questa classe astratta rappresenta il nucleo di un gioco. Fornisce un'interfaccia
 * per gestire comandi, stanze, inventario e la logica del gioco.
 */
public abstract class Game {

    private final List<SetComandi> comandi = new ArrayList<>();
    private final List<Stanza> stanze = new ArrayList<>();
    private final List<Oggetti> inventario = new ArrayList<>();
    private Stanza stanzaCorrente;
    /**
     * Restituisce la lista dei comandi disponibili nel gioco.
     *
     * @return La lista dei comandi.
     */
    public List<SetComandi> getComandi() {
        return comandi;
    }
    /**
     * Restituisce la lista delle stanze nel gioco.
     *
     * @return La lista delle stanze.
     */
    public List<Stanza> getStanze() {
        return stanze;
    }
    /**
     * Restituisce la lista degli oggetti nell'inventario del giocatore.
     *
     * @return La lista degli oggetti nell'inventario.
     */
    public List<Oggetti> getInventario() {
        return inventario;
    }
    /**
     * Restituisce la stanza corrente in cui si trova il giocatore.
     *
     * @return La stanza corrente.
     */
    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }
    /**
     * Imposta la stanza corrente in cui si trova il giocatore.
     *
     * @param stanza La stanza corrente.
     */
    public void setStanzaCorrente(Stanza stanza) {
        this.stanzaCorrente = stanza;
    }
    /**
     * Definisce il comportamento per la prossima mossa del giocatore.
     *
     * @param parser L'oggetto che analizza l'input del giocatore.
     * @param print Il flusso di stampa su cui verranno visualizzati gli output.
     */
    public abstract void prossimaMossa(OutputParser parser, PrintStream print);
    /**
     * Inizializza il gioco. Questo metodo deve essere implementato dalle sottoclassi
     * per configurare il gioco iniziale, le stanze, gli oggetti, ecc.
     *
     * @throws Exception Se si verificano eccezioni durante l'inizializzazione del gioco.
     */
    public abstract void init() throws Exception;

}