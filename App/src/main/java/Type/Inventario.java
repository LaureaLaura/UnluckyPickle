package Type;
import java.util.Set;

public class Inventario {

    private Set<Oggetti> oggettiInventario;

    public void addOggetto(Oggetti oggetto) {
        this.oggettiInventario.add(oggetto);
    }

    public void remOggetto(Oggetti oggetto) {
        this.oggettiInventario.remove(oggetto);
    }

    public Set<Oggetti> getInventario() {
        return this.oggettiInventario;
    }

    public Set<Oggetti> setInventario() {
        return this.oggettiInventario;
    }

}