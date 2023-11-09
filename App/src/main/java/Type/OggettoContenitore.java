package Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Questa classe rappresenta un oggetto contenitore all'interno del gioco. Gli
 * oggetti contenitori sono
 * oggetti speciali in grado di contenere altri oggetti. Sono una sottoclasse
 * della classe `Oggetti`.
 */
public class OggettoContenitore extends Oggetti {

    private List<Oggetti> list = new ArrayList<>();

    /**
     * Costruttore per un oggetto contenitore con identificatore.
     *
     * @param id L'identificatore unico dell'oggetto contenitore.
     */
    public OggettoContenitore(int id) {
        super(id);
    }

    /**
     * Costruttore per un oggetto contenitore con identificatore e nome.
     *
     * @param id   L'identificatore unico dell'oggetto contenitore.
     * @param name Il nome dell'oggetto contenitore.
     */
    public OggettoContenitore(int id, String name) {
        super(id, name);
    }

    /**
     * Costruttore per un oggetto contenitore con identificatore, nome e
     * descrizione.
     *
     * @param id          L'identificatore unico dell'oggetto contenitore.
     * @param name        Il nome dell'oggetto contenitore.
     * @param description La descrizione dell'oggetto contenitore.
     */
    public OggettoContenitore(int id, String name, String description) {
        super(id, name, description);
    }

    /**
     * Costruttore per un oggetto contenitore con identificatore, nome, descrizione
     * e alias.
     *
     * @param id          L'identificatore unico dell'oggetto contenitore.
     * @param name        Il nome dell'oggetto contenitore.
     * @param description La descrizione dell'oggetto contenitore.
     * @param alias       Gli alias dell'oggetto contenitore.
     */
    public OggettoContenitore(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }

    /**
     * Restituisce la lista degli oggetti contenuti all'interno del contenitore.
     *
     * @return La lista di oggetti contenuti.
     */
    public List<Oggetti> getList() {
        return list;
    }

    /**
     * Imposta la lista degli oggetti contenuti all'interno del contenitore.
     *
     * @param list La lista di oggetti contenuti.
     */
    public void setList(List<Oggetti> list) {
        this.list = list;
    }

    /**
     * Aggiunge un oggetto alla lista di oggetti contenuti all'interno del
     * contenitore.
     *
     * @param oggetto L'oggetto da aggiungere.
     */
    public void add(Oggetti oggetto) {
        list.add(oggetto);
    }

    /**
     * Rimuove un oggetto dalla lista di oggetti contenuti all'interno del
     * contenitore.
     *
     * @param oggetto L'oggetto da rimuovere.
     */
    public void remove(Oggetti oggetto) {
        list.remove(oggetto);
    }

}