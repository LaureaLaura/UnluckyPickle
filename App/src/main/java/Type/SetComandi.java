package Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * Questa classe rappresenta un insieme di comandi utilizzati nel gioco. Ogni comando è associato a un nome,
 * un tipo di comando (enum `Comandi`), e un insieme di alias che possono essere utilizzati per riconoscere il comando.
 */
public class SetComandi {
    private String nomeComando;
    private Comandi tipocomando;
    private Set<String> alias;
    /**
     * Costruttore per un comando con nome, tipo di comando e insieme di alias.
     *
     * @param nomeComando Il nome del comando.
     * @param tipocomando Il tipo di comando (enum `Comandi`).
     * @param alias Gli alias associati al comando.
     */
    public SetComandi(String nomeComando, Comandi tipocomando, Set<String> alias) { // costruttore
        this.nomeComando = nomeComando;
        this.tipocomando = tipocomando;
        this.alias = alias;
    }
    /**
     * Costruttore di default che inizializza il comando senza nome, tipo e alias.
     */
    public SetComandi() {
        this.nomeComando = null;
        this.tipocomando = null;
        this.alias = null;
    }
    /**
     * Costruttore per un comando con nome e tipo di comando.
     *
     * @param nomeComando Il nome del comando.
     * @param tipocomando Il tipo di comando (enum `Comandi`).
     */
    public SetComandi(String nomeComando, Comandi tipocomando) {
        this.nomeComando = nomeComando;
        this.tipocomando = tipocomando;
    }
    /**
     * Imposta il tipo di comando.
     *
     * @param comando Il tipo di comando da impostare.
     */
    public void setTipoComando(Comandi comando) {
        this.tipocomando = comando;
    }
    /**
     * Restituisce il tipo di comando associato al comando.
     *
     * @return Il tipo di comando (enum `Comandi`).
     */
    public Comandi getTipoComando() {
        return this.tipocomando;
    }
    /**
     * Imposta il nome del comando.
     *
     * @param nomeComando Il nome del comando da impostare.
     */
    public void setName(String nomeComando) {
        this.nomeComando = nomeComando;
    }
    /**
     * Imposta l'insieme di alias associati al comando.
     *
     * @param alias Gli alias da impostare.
     */
    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
    /**
     * Imposta l'insieme di alias associati al comando da un array di stringhe.
     *
     * @param alias Un array di stringhe rappresentanti gli alias da impostare.
     */
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }
    /**
     * Restituisce il nome del comando.
     *
     * @return Il nome del comando.
     */
    public String getNomeComando() {
        return this.nomeComando;
    }
    /**
     * Restituisce il nome del comando (sinonimo di `getNomeComando`).
     *
     * @return Il nome del comando.
     */
    public String getName() {
        return this.nomeComando;
    }
    /**
     * Restituisce il tipo di comando associato al comando.
     *
     * @return Il tipo di comando (enum `Comandi`).
     */
    public Comandi getType() {
        return this.tipocomando;
    }
    /**
     * Restituisce l'insieme di alias associati al comando.
     *
     * @return Un insieme di stringhe rappresentanti gli alias del comando.
     */
    public Set<String> getAlias() {
        return this.alias;
    }

}
