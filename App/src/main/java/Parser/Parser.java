package Parser;
import Type.Oggetti;
import Type.SetComandi;
import java.util.Set;
import java.util.List;

public class Parser {

    private final Set<String> paroleInutili;

    public Parser(Set<String> paroleInutili) {

        this.paroleInutili = paroleInutili;
    }

    public int findCommand(List<SetComandi> listaComandi, String tokenInput) { 
        int y = listaComandi.size();
        for (int i = 0; i < y; i++) {
            if (listaComandi.get(i).getName().equals(tokenInput)
                    || listaComandi.get(i).getAlias().contains(tokenInput)) {
                return i;
            }
        }
        return -1;
    }

    public int findObject(String tokenInput, List<Oggetti> listaOggetti) { 
        for (int i = 0; i < listaOggetti.size(); i++) {
            if (listaOggetti.get(i).getName().equals(tokenInput)) {
                return i;
            }
        }
        return -1;
    }

    
    public OutputParser parser(String fraseInserita, List<Oggetti> oggetti, List<SetComandi> comandi,
            List<Oggetti> inventario) {

        List<String> tokens = ParserBase.parseString(fraseInserita, paroleInutili);
        int indiceComando;
        int indiceOggetto;

        if (!tokens.isEmpty()) {
            indiceComando = findCommand(comandi, tokens.get(0));
            if (indiceComando > -1) { 
                if (tokens.size() > 1) {
                    indiceOggetto = findObject(tokens.get(1), oggetti);
                    int indiceOggInv = -1;
                    if (indiceOggetto < 0 && tokens.size() > 2) {
                        indiceOggetto = findObject(tokens.get(2), oggetti);
                    }
                    if (indiceOggetto < 0) { 
                        indiceOggInv = findObject(tokens.get(1), inventario);
                        if (indiceOggInv < 0 && tokens.size() > 2) {
                            indiceOggInv = findObject(tokens.get(2), inventario);
                        }
                    }
                    if (indiceOggetto > -1 && indiceOggInv > -1) {
                        return new OutputParser(comandi.get(indiceComando), oggetti.get(indiceOggetto),
                                inventario.get(indiceOggInv));
                    } else if (indiceOggetto > -1) {
                        return new OutputParser(comandi.get(indiceComando), oggetti.get(indiceOggetto), null);
                    } else if (indiceOggInv > -1) {
                        return new OutputParser(comandi.get(indiceComando), null, inventario.get(indiceOggInv));
                    } else {
                        return new OutputParser(comandi.get(indiceComando), null, null);
                    }
                } else {
                    return new OutputParser(comandi.get(indiceComando), null);
                }
            } else {
                return new OutputParser(null, null);
            }
        } else {
            return null;
        }
    }
}
