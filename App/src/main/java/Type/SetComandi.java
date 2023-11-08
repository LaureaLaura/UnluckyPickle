package Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetComandi {
    private String nomeComando;
    private Comandi tipocomando;
    private Set<String> alias;

    public SetComandi(String nomeComando, Comandi tipocomando, Set<String> alias) { // costruttore
        this.nomeComando = nomeComando;
        this.tipocomando = tipocomando;
        this.alias = alias;
    }

    public SetComandi() {
        this.nomeComando = null;
        this.tipocomando = null;
        this.alias = null;
    }

    public SetComandi(String nomeComando, Comandi tipocomando) {
        this.nomeComando = nomeComando;
        this.tipocomando = tipocomando;
    }

    public void setTipoComando(Comandi comando) {
        this.tipocomando = comando;
    }

    public Comandi getTipoComando() {
        return this.tipocomando;
    }

    public void setName(String nomeComando) {
        this.nomeComando = nomeComando;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    public String getNomeComando() {
        return this.nomeComando;
    }

    public String getName() {
        return this.nomeComando;
    }

    public Comandi getType() {
        return this.tipocomando;
    }

    public Set<String> getAlias() {
        return this.alias;
    }

}
