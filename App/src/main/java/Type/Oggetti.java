
package Type;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class Oggetti {

   private final int id;
   private String name;
   private String descrizione;
   private Stanza stanza;
   private Set<String> alias;
   private boolean prendibile;
   private boolean apre;
   private boolean aperto;
   private boolean bevibile;
   private boolean bevuta; // true se ha gia bevuto la bevanda

   public Oggetti(int id, String name, String descrizione, Stanza stanza, boolean prendibile, boolean apre) { // costruttore
      this.id = id;
      this.name = name;
      this.descrizione = descrizione;
      this.stanza = stanza;
      this.prendibile = prendibile;
      this.apre = apre;
   }

   public Oggetti(int id) {
      this.id = id;
   }

   public Oggetti(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public Oggetti(int id, String name, String descrizione) {
      this.id = id;
      this.name = name;
      this.descrizione = descrizione;
   }

   public Oggetti(int id, String name, String descrizione, Set<String> alias) {
      this.id = id;
      this.name = name;
      this.descrizione = descrizione;
      this.alias = alias;
   }

   public void setStanza(Stanza stanza) {
      this.stanza = stanza;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getId() {
      return this.id;
   }

   public String getDescrizione() {
      return this.descrizione;
   }

   public void setDescrizione(String descrizione) {
      this.descrizione = descrizione;
   }

   public Stanza getStanza() {
      return this.stanza;
   }

   public Set<String> getAlias() {
      return this.alias;
   }

   public void setAlias(Set<String> alias) {
      this.alias = alias;
   }

   public void setAlias(String[] alias) {
      this.alias = new HashSet<>(Arrays.asList(alias));
   }

   public boolean isPrendibile() {
      return prendibile;
   }

   public void setPrendibile(boolean prendibile) {
      this.prendibile = prendibile;
   }

   public boolean isOpenable() {
      return apre;
   }

   public void setOpenable(boolean apre) {
      this.apre = apre;
   }

   public void setOpen(boolean aperto) {
      this.aperto = aperto;
   }

   public boolean getOpen() {
      return this.aperto;
   }

   public void setBevibile(boolean bevibile) {
      this.bevibile = bevibile;
   }

   public boolean getBevibile() {
      return bevibile;
   }

   public void setBevuta(boolean bevuta) {
      this.bevuta = bevuta;
   }

   public boolean getBevuta() {
      return bevuta;
   }

   public int hashCode() { // crea il token da usare nell'hash set per i taselli
      int hash = 11;
      hash = hash * 4 + this.id;
      return hash;

   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Oggetti other = (Oggetti) obj;
      if (this.id != other.id) {
         return false;
      }
      return true;
   }

}

