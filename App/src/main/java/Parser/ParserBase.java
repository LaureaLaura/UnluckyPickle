package Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * La classe ParserBase fornisce metodi per la gestione di parole inutili e
 * l'analisi di stringhe.
 */
public class ParserBase {

    /**
     * Carica e legge un file di parole inutili, restituendole come un insieme.
     *
     * @param paroleInutili Il file contenente le parole inutili da leggere.
     * @return Un insieme di parole inutili in minuscolo.
     * @throws IOException Se si verifica un errore durante la lettura del file.
     */
    public static Set<String> loadAndRead(File paroleInutili) throws IOException {

        Set<String> setInutili = new HashSet<>();
        BufferedReader letturaFile = new BufferedReader(new FileReader(paroleInutili));
        while (letturaFile.ready()) {
            setInutili.add(letturaFile.readLine().toLowerCase());
        }
        letturaFile.close();
        return setInutili;
    }

    /**
     * Analizza una stringa di parole, rimuovendo le stopwords specificate.
     *
     * @param string    La stringa da analizzare.
     * @param stopwords Un insieme di stopwords da rimuovere dalla stringa.
     * @return Una lista di parole risultanti dall'analisi della stringa.
     */
    public static List<String> parseString(String string, Set<String> stopwords) {
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for (int i = 0; i < split.length; i++) {
            if (!stopwords.contains(split[i])) {
                tokens.add(split[i]);
            }
        }
        return tokens;
    }

}
