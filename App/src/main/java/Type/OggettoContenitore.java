package Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OggettoContenitore extends Oggetti { 

    private List<Oggetti> list = new ArrayList<>();

    public OggettoContenitore(int id) {
        super(id);
    }

    public OggettoContenitore(int id, String name) {
        super(id, name);
    }

    public OggettoContenitore(int id, String name, String description) {
        super(id, name, description);
    }

    public OggettoContenitore(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }

    public List<Oggetti> getList() {
        return list;
    }

    public void setList(List<Oggetti> list) {
        this.list = list;
    }

    public void add(Oggetti oggetto) {
        list.add(oggetto);
    }

    public void remove(Oggetti oggetto) {
        list.remove(oggetto);
    }

}