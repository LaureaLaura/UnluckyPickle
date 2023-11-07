/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Type;
import java.util.ArrayList;
import java.util.List;
import Parser.OutputParser;

import java.io.PrintStream;

public abstract class Game {

    private final List<SetComandi> comandi = new ArrayList<>();
    private final List<Stanza> stanze = new ArrayList<>();
    private final List<Oggetti> inventario = new ArrayList<>();
    private Stanza stanzaCorrente;

    public List<SetComandi> getComandi() {
        return comandi;
    }

    public List<Stanza> getStanze() {
        return stanze;
    }

    public List<Oggetti> getInventario() {
        return inventario;
    }

    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }

    public void setStanzaCorrente(Stanza stanza) {
        this.stanzaCorrente = stanza;
    }

    public abstract void prossimaMossa(OutputParser parser, PrintStream print);

    public abstract void init() throws Exception;

}