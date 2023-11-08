
package Type;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
/**
 * Questa classe rappresenta oggetti all'interno del gioco. Gli oggetti possono avere varie proprietà
 * come un nome, una descrizione, una stanza associata, la possibilità di essere presi, la possibilità di
 * aprire qualcosa, la possibilità di essere bevuti, e altre proprietà specifiche.
 */
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
/**
    * Costruttore per un oggetto con  identificativo,nome, descrizione, stanza associata, e proprietà prendibile e apre.
    *
    * @param id L'identificatore unico dell'oggetto.
    * @param name Il nome dell'oggetto.
    * @param descrizione La descrizione dell'oggetto.
    * @param stanza La stanza associata all'oggetto.
    * @param prendibile Indica se l'oggetto è prendibile.
    * @param apre Indica se l'oggetto può aprire qualcosa.
    */
   public Oggetti(int id, String name, String descrizione, Stanza stanza, boolean prendibile, boolean apre) { // costruttore
      this.id = id;
      this.name = name;
      this.descrizione = descrizione;
      this.stanza = stanza;
      this.prendibile = prendibile;
      this.apre = apre;
   }
/**
    * Costruttore per un oggetto con solo identificativo.
    *
    * @param id L'identificatore unico dell'oggetto.
    */
   public Oggetti(int id) {
      this.id = id;
   }
/**
    * Costruttore per un oggetto con identificativo e nome.
    *
    * @param id L'identificatore unico dell'oggetto.
    * @param name Il nome dell'oggetto.
    */
   public Oggetti(int id, String name) {
      this.id = id;
      this.name = name;
   }
/**
    * Costruttore per un oggetto con identificativo,nome, descrizione.
    *
    * @param id L'identificatore unico dell'oggetto.
    * @param name Il nome dell'oggetto.
    * @param descrizione La descrizione dell'oggetto.
    */
   public Oggetti(int id, String name, String descrizione) {
      this.id = id;
      this.name = name;
      this.descrizione = descrizione;
   }
/**
    * Costruttore per un oggetto con identificativo,nome, descrizione e l'insieme di alias dell'oggetto .
    *
    * @param id L'identificatore unico dell'oggetto.
    * @param name Il nome dell'oggetto.
    * @param descrizione La descrizione dell'oggetto.
    * @param alias l'insieme di alias dell'oggetto.
    */
   public Oggetti(int id, String name, String descrizione, Set<String> alias) {
      this.id = id;
      this.name = name;
      this.descrizione = descrizione;
      this.alias = alias;
   }
   /**
    * Imposta la stanza associata all'oggetto.
    *
    * @param stanza La stanza associata all'oggetto.
    */
   public void setStanza(Stanza stanza) {
      this.stanza = stanza;
   }
   /**
    * Restituisce il nome dell'oggetto.
    *
    * @return Il nome dell'oggetto.
    */
   public String getName() {
      return this.name;
   }
   /**
    * Imposta il nome dell'oggetto.
    *
    * @param name Il nome dell'oggetto.
    */
   public void setName(String name) {
      this.name = name;
   }
   /**
    * Restituisce l'identificativo unico dell'oggetto.
    *
    * @return L'identificativo unico dell'oggetto.
    */
   public int getId() {
      return this.id;
   }
   /**
    * Restituisce la descrizione dell'oggetto.
    *
    * @return La descrizione dell'oggetto.
    */
   public String getDescrizione() {
      return this.descrizione;
   }
   /**
    * Imposta la descrizione dell'oggetto.
    *
    * @param descrizione La descrizione dell'oggetto.
    */
   public void setDescrizione(String descrizione) {
      this.descrizione = descrizione;
   }
   /**
    * Restituisce la stanza associata all'oggetto.
    *
    * @return La stanza associata all'oggetto.
    */
   public Stanza getStanza() {
      return this.stanza;
   }
   /**
    * Restituisce l'insieme di alias dell'oggetto.
    *
    * @return L'insieme di alias dell'oggetto.
    */
   public Set<String> getAlias() {
      return this.alias;
   }
   /**
    * Imposta l'insieme di alias dell'oggetto.
    *
    * @param alias L'insieme di alias dell'oggetto.
    */
   public void setAlias(Set<String> alias) {
      this.alias = alias;
   }
   /**
    * Imposta l'insieme di alias dell'oggetto.
    *
    * @param alias L'insieme di alias dell'oggetto.
    */
   public void setAlias(String[] alias) {
      this.alias = new HashSet<>(Arrays.asList(alias));
   }
   /**
    * Restituisce la proprietà prendibile dell'oggetto.
    *
    * @return La proprietà prendibile dell'oggetto.
    */
   public boolean isPrendibile() {
      return prendibile;
   }
   /**
    * Imposta la proprietà prendibile dell'oggetto.
    *
    * @param prendibile La proprietà prendibile dell'oggetto.
    */
   public void setPrendibile(boolean prendibile) {
      this.prendibile = prendibile;
   }
   /**
    * Restituisce la proprietà apre dell'oggetto.
    *
    * @return La proprietà apre dell'oggetto.
    */
   public boolean isOpenable() {
      return apre;
   }
   /**
    * Imposta la proprietà apre dell'oggetto.
    *
    * @param apre La proprietà apre dell'oggetto.
    */
   public void setOpenable(boolean apre) {
      this.apre = apre;
   }
   /**
    * Restituisce la proprietà aperto dell'oggetto.
    *
    * @return La proprietà aperto dell'oggetto.
    */
   public void setOpen(boolean aperto) {
      this.aperto = aperto;
   }
   /**
    * Imposta la proprietà aperto dell'oggetto.
    *
    * @param aperto La proprietà aperto dell'oggetto.
    */
   public boolean getOpen() {
      return this.aperto;
   }
   /**
    * Imposta la proprietà bevibile dell'oggetto.
    *
    * @param bevibile La proprietà bevibile dell'oggetto.
    */
   public void setBevibile(boolean bevibile) {
      this.bevibile = bevibile;
   }
   /**
    * Restituisce la proprietà bevibile dell'oggetto.
    *
    * @return La proprietà bevibile dell'oggetto.
    */
   public boolean getBevibile() {
      return bevibile;
   }
   /**
    * Imposta la proprietà bevuta dell'oggetto.
    *
    * @param bevuta La proprietà bevuta dell'oggetto.
    */
   public void setBevuta(boolean bevuta) {
      this.bevuta = bevuta;
   }
   /**
    * Restituisce la proprietà bevuta dell'oggetto.
    *
    * @return La proprietà bevuta dell'oggetto.
    */
   public boolean getBevuta() {
      return bevuta;
   }
   /**
    * Crea il token da usare nell'hash set per i tasselli.
    *
    * @return Una stringa rappresentante l'oggetto.
    */
   public int hashCode() {
      int hash = 11;
      hash = hash * 4 + this.id;
      return hash;

   }
   /**
    * Confronta due oggetti.
    *
    * @param obj L'oggetto da confrontare.
    * @return true se i due oggetti sono uguali, false altrimenti.
    */
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

