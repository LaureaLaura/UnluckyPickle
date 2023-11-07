/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parser;
import Type.Comandi;
import Type.Oggetti;
import Type.SetComandi;

public class OutputParser {
    private Oggetti oggetto;
    private Oggetti oggInventario;
    private SetComandi comando;

    public OutputParser(SetComandi comando, Oggetti oggetto, Oggetti oggInventario) {
        this.oggetto = oggetto;
        this.oggInventario = oggInventario;
        this.comando = comando;
    }

    public OutputParser(SetComandi comando, Oggetti oggetto) {
        this.oggetto = oggetto;
        this.comando = comando;
    }

    public SetComandi getComandoParser() {
        return this.comando;
    }

    public void setComandoParser(SetComandi comando) {
        this.comando = comando;
    }

    public Oggetti getOggetto() {
        return this.oggetto;
    }

    public void setOggetto(Oggetti oggetto) {
        this.oggetto = oggetto;
    }

    public Oggetti getOggInventario() {
        return this.oggInventario;
    }

    public void setOggInventario(Oggetti oggetto) {
        this.oggInventario = oggetto;
    }

    public Comandi getTipoComando() {
        return this.comando.getType();
    }
}
