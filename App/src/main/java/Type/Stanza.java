package Type;
import java.util.ArrayList;
import java.util.List;

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

    public Stanza(int id) {
        this.id = id;
    }

    public Stanza(int id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getName() {
        return this.nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public void setDescription(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescription() {
        return this.descrizione;
    }

    public void setDirections(Stanza nord, Stanza sud, Stanza est, Stanza ovest) {
        this.nord = nord;
        this.sud = sud;
        this.est = est;
        this.ovest = ovest;
    }

    public Stanza getNorth() {
        return this.nord;
    }

    public Stanza getSouth() {
        return this.sud;
    }

    public Stanza getEast() {
        return this.est;
    }

    public Stanza getWest() {
        return this.ovest;
    }

    public void setLook(String guarda) {
        this.guarda = guarda;
    }

    public int getId() {
        return this.id;
    }

    public String getLook() {
        return this.guarda;
    }

    public List<Oggetti> getObjects() {
        return objects;
    }

}