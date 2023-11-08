package Type;
import java.util.ArrayList;
import java.util.List;
/**
 * Questa classe rappresenta una stanza all'interno del gioco. Ogni stanza ha un identificatore unico, un nome, una descrizione,
 * indicazioni sui punti cardinali, un testo di osservazione (`guarda`), e una lista di oggetti presenti nella stanza.
 */
public class Stanza {

    private final int id;
    private String nome;
    private String descrizione;
    private String guarda;
    private Stanza nord = null;
    private Stanza sud = null;
    private Stanza est = null;
    private Stanza ovest = null;
    private List<Oggetti> objects = new ArrayList<>();
    /**
     * Costruttore per una stanza con identificatore.
     *
     * @param id L'identificatore unico della stanza.
     */
    public Stanza(int id) {
        this.id = id;
    }
    /**
     * Costruttore per una stanza con identificatore, nome e descrizione.
     *
     * @param id L'identificatore unico della stanza.
     * @param nome Il nome della stanza.
     * @param descrizione La descrizione della stanza.
     */
    public Stanza(int id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }
    /**
     * Restituisce il nome della stanza.
     *
     * @return Il nome della stanza.
     */
    public String getName() {
        return this.nome;
    }
    /**
     * Imposta il nome della stanza.
     *
     * @param nome Il nome da impostare.
     */
    public void setName(String nome) {
        this.nome = nome;
    }
    /**
     * Imposta la descrizione della stanza.
     *
     * @param descrizione La descrizione da impostare.
     */
    public void setDescription(String descrizione) {
        this.descrizione = descrizione;
    }
    /**
     * Restituisce la descrizione della stanza.
     *
     * @return La descrizione della stanza.
     */
    public String getDescription() {
        return this.descrizione;
    }
    /**
     * Imposta le stanze adiacenti (nord, sud, est, ovest) alla stanza corrente.
     *
     * @param nord La stanza a nord.
     * @param sud La stanza a sud.
     * @param est La stanza a est.
     * @param ovest La stanza a ovest.
     */
    public void setDirections(Stanza nord, Stanza sud, Stanza est, Stanza ovest) {
        this.nord = nord;
        this.sud = sud;
        this.est = est;
        this.ovest = ovest;
    }
    /**
     * Restituisce la stanza a nord.
     *
     * @return La stanza a nord.
     */
    public Stanza getNorth() {
        return this.nord;
    }
    /**
     * Restituisce la stanza a sud.
     *
     * @return La stanza a sud.
     */
    public Stanza getSouth() {
        return this.sud;
    }
    /**
     * Restituisce la stanza a est.
     *
     * @return La stanza a est.
     */
    public Stanza getEast() {
        return this.est;
    }
    /**
     * Restituisce la stanza a ovest.
     *
     * @return La stanza a ovest.
     */
    public Stanza getWest() {
        return this.ovest;
    }
    /**
     * Imposta il testo di osservazione della stanza.
     *
     * @param guarda Il testo di osservazione da impostare.
     */
    public void setLook(String guarda) {
        this.guarda = guarda;
    }
    /**
     * Restituisce l'identificatore unico della stanza.
     *
     * @return L'identificatore della stanza.
     */
    public int getId() {
        return this.id;
    }
    /**
     * Restituisce il testo di osservazione della stanza.
     *
     * @return Il testo di osservazione della stanza.
     */
    public String getLook() {
        return this.guarda;
    }
    /**
     * Restituisce la lista degli oggetti presenti nella stanza.
     *
     * @return La lista degli oggetti nella stanza.
     */
    public List<Oggetti> getObjects() {
        return objects;
    }

}