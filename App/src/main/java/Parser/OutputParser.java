package Parser;
import Type.Comandi;
import Type.Oggetti;
import Type.SetComandi;

/**
 * La classe è responsabile del parsing dell'output.
 */
public class OutputParser {
    private Oggetti oggetto;
    private Oggetti oggInventario;
    private SetComandi comando;

    /**
     * Costruttore della classe OutputParser con tre parametri.
     *
     * @param comando Il set di comandi associato al parser.
     * @param oggetto L'oggetto associato al parser.
     * @param oggInventario L'oggetto dell'inventario associato al parser.
     */
    public OutputParser(SetComandi comando, Oggetti oggetto, Oggetti oggInventario) {
        this.oggetto = oggetto;
        this.oggInventario = oggInventario;
        this.comando = comando;
    }

    /**
     * Costruttore della classe OutputParser con due parametri.
     *
     * @param comando Il set di comandi associato al parser.
     * @param oggetto L'oggetto associato al parser.
     */
    public OutputParser(SetComandi comando, Oggetti oggetto) {
        this.oggetto = oggetto;
        this.comando = comando;
    }

    /**
     * Restituisce il set di comandi associato al parser.
     *
     * @return Il set di comandi associato al parser.
     */
    public SetComandi getComandoParser() {
        return this.comando;
    }

    /**
     * Imposta il set di comandi associato al parser.
     *
     * @param comando Il set di comandi da associare al parser.
     */
    public void setComandoParser(SetComandi comando) {
        this.comando = comando;
    }

    /**
     * Restituisce l'oggetto associato al parser.
     *
     * @return L'oggetto associato al parser.
     */
    public Oggetti getOggetto() {
        return this.oggetto;
    }

    /**
     * Imposta l'oggetto associato al parser.
     *
     * @param oggetto L'oggetto da associare al parser.
     */
    public void setOggetto(Oggetti oggetto) {
        this.oggetto = oggetto;
    }

    /**
     * Restituisce l'oggetto dell'inventario associato al parser.
     *
     * @return L'oggetto dell'inventario associato al parser.
     */
    public Oggetti getOggInventario() {
        return this.oggInventario;
    }

    /**
     * Imposta l'oggetto dell'inventario associato al parser.
     *
     * @param oggetto L'oggetto dell'inventario da associare al parser.
     */
    public void setOggInventario(Oggetti oggetto) {
        this.oggInventario = oggetto;
    }

    /**
     * Restituisce il tipo di comando associato al parser.
     *
     * @return Il tipo di comando associato al parser.
     */
    public Comandi getTipoComando() {
        return this.comando.getType();
    }
}
