package Type;
import java.util.Set;
/**
 * Questa classe rappresenta l'inventario del giocatore, contenente una collezione di oggetti.
 */
public class Inventario {

    private Set<Oggetti> oggettiInventario;
    /**
     * Aggiunge un oggetto all'inventario del giocatore.
     *
     * @param oggetto L'oggetto da aggiungere all'inventario.
     */
    public void addOggetto(Oggetti oggetto) {
        this.oggettiInventario.add(oggetto);
    }
    /**
     * Rimuove un oggetto dall'inventario del giocatore.
     *
     * @param oggetto L'oggetto da rimuovere dall'inventario.
     */
    public void remOggetto(Oggetti oggetto) {
        this.oggettiInventario.remove(oggetto);
    }
    /**
     * Restituisce l'insieme di oggetti nell'inventario del giocatore.
     *
     * @return Un insieme di oggetti nell'inventario.
     */
    public Set<Oggetti> getInventario() {
        return this.oggettiInventario;
    }
    /**
     * Imposta l'insieme di oggetti nell'inventario del giocatore.
     *
     * @return Un insieme di oggetti nell'inventario.
     */
    public Set<Oggetti> setInventario() {
        return this.oggettiInventario;
    }

}