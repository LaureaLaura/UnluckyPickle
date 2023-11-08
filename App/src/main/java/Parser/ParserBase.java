package Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParserBase {

    public static Set<String> loadAndRead(File paroleInutili) throws IOException {
                                                                                   
                                                                                   

        Set<String> setInutili = new HashSet<>();
        BufferedReader letturaFile = new BufferedReader(new FileReader(paroleInutili));
        while (letturaFile.ready()) {
            setInutili.add(letturaFile.readLine().toLowerCase());
        }
        letturaFile.close();
        return setInutili;
    }

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
