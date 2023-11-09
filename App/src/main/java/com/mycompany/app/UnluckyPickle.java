package com.mycompany.app;

import java.util.Scanner;
import Parser.OutputParser;
import Timer.stopWatch;
import Type.Comandi;
import Type.Game;
import Type.GamePrint;
import Type.Oggetti;
import Type.OggettoContenitore;
import Type.SetComandi;
import Type.Stanza;
import java.io.PrintStream;

/**
 * La classe `UnluckyPickle` estende la classe `Game` e rappresenta il gioco
 * UnluckyPickle.
 */
public class UnluckyPickle extends Game {

     public static final String RED = "\033[0;31m";
     public static final String YELLOW = "\033[0;33m";
     public static final String ANSI_RESET = "\u001B[0m";
     public static final String CYAN = "\033[0;36m";
     boolean transform;
     boolean openDrawer;
     boolean antidote;
     boolean secretRoom;
     static final int PASSWORD = 256;
     GamePrint print = new GamePrint();
     stopWatch tempo = new stopWatch();

     /**
      * Inizializza il gioco UnluckyPickle.
      * Si parte con l'inizializzazione delle stanze, degli oggetti e dei comandi.
      * Si inizializza la stanza corrente con la stanza salone e si settano le stanze
      * adiacenti.
      * 
      * @throws Exception Se si verifica un errore durante l'inizializzazione.
      */
     @Override
     public void init() throws Exception {

          SetComandi nord = new SetComandi("nord", Comandi.NORD);
          nord.setAlias(new String[] { "n", "N", "Nord", "NORD", "north", "North" });
          getComandi().add(nord);
          // Inizializzazione dei comandi
          SetComandi sud = new SetComandi("sud", Comandi.SUD);
          sud.setAlias(new String[] { "s", "S", "Sud", "SUD", "south", "South" });
          getComandi().add(sud);
          // Inizializzazione dei comandi
          SetComandi est = new SetComandi("est", Comandi.EST);
          est.setAlias(new String[] { "e", "E", "Est", "EST", "East", "east" });
          getComandi().add(est);

          SetComandi ovest = new SetComandi("ovest", Comandi.OVEST);
          ovest.setAlias(new String[] { "o", "O", "Ovest", "OVEST", "west", "West" });
          getComandi().add(ovest);

          SetComandi apri = new SetComandi("apri", Comandi.APRI);
          apri.setAlias(new String[] { "Apri", "aprire" });
          getComandi().add(apri);

          SetComandi guarda = new SetComandi("guarda", Comandi.GUARDA);
          guarda.setAlias(new String[] { "guardare", "Guarda", "Vedi", "vedi" });
          getComandi().add(guarda);

          SetComandi prendi = new SetComandi("prendi", Comandi.PRENDI);
          prendi.setAlias(new String[] { "Prendi", "prendere" });
          getComandi().add(prendi);

          SetComandi inserisci = new SetComandi("inserisci", Comandi.INSERISCI);
          inserisci.setAlias(new String[] { "inserire", "metti", "mettere" });
          getComandi().add(inserisci);

          SetComandi bevi = new SetComandi("bevi", Comandi.BEVI);
          bevi.setAlias(new String[] { "bere", "Bevi" });
          getComandi().add(bevi);

          SetComandi inventario = new SetComandi("inventario", Comandi.INVENTARIO);
          inventario.setAlias(new String[] { "i", "I", "inv", "INV" });
          getComandi().add(inventario);

          SetComandi indizi = new SetComandi("indizi", Comandi.INDIZI);
          indizi.setAlias(new String[] { "indizio", "Indizi", "Indizio" });
          getComandi().add(indizi);

          SetComandi help = new SetComandi("help", Comandi.HELP);
          help.setAlias(new String[] { "h", "H", "Aiuto", "aiuto", "HELP", "AIUTO" });
          getComandi().add(help);

          SetComandi leggi = new SetComandi("leggi", Comandi.LEGGI);
          leggi.setAlias(new String[] { "leggere", "Leggi" });
          getComandi().add(leggi);

          SetComandi indovinello = new SetComandi("indovinello", Comandi.INDOVINELLO);
          indovinello.setAlias(new String[] { "indovina" });
          getComandi().add(indovinello);

          SetComandi end = new SetComandi("end", Comandi.END);
          end.setAlias(new String[] { "exit", "esci", "termina" });
          getComandi().add(end);

          Stanza salone = new Stanza(1, "Salone",
                    "Il tuo soggiorno, con tocchi di modernità uniti ad un tocco di vintage, ha un'ampia finestra che da sulla strada, coperta da una tenda per privacy. Un grande divano in pelle stile anni 90. "
                              + " Davanti al divano, accanto al televisore, c'è una cassettiera stile vittoriano, che contiene i tuoi importantissimi strumenti di lavoro, tra cui i tuoi preziosi appunti segreti sui tuoi esperimenti."
                              + " Accanto alla cassettiera si trova un grande specchio.");
          salone.setLook(
                    "Stai nel salone. A Sud si trova il bagno, a Ovest si trova il tuo laboratorio. Ad est, la cucina, e a Nord la tua cameretta.\n");
          Stanza bagno = new Stanza(2, "Bagno",
                    "\nQuesto è il bagno della tua casa. Vicino alla porta c'è il lavandino con sopra del sapone e della soda caustica. Sulla parete di destra il WC, e di fronte al WC c'è la doccia.");
          bagno.setLook(
                    "A nord sta la porta che ti porta nel salone. Tutte le altre direzioni non sono accessibili.\n");
          Stanza cucina = new Stanza(3, "Cucina",
                    "Ti trovi nella cucina della tua casa, dove prepari i tuoi cibi preferiti. Ti guardi intorno, davanti a te trovi il grande forno che contiene lo sfornato avanzato da ieri sera, alla tua destra hai il tuo grande frigorifero. "
                              + "In fondo a sinistra c'è un armadio, con sopra il microonde, e accanto si trova la tua bella caffettiera, che emana la tua fragranza preferita, quella del caffè.\n");
          cucina.setLook(
                    "\nSei nella tua cucina. Ad Ovest si trova la porta per tornare in salone. Tutte le altre direzioni sono irraggiungibili.\n");
          Stanza laboratorio = new Stanza(4, "Laboratorio",
                    "\nTi trovi nel tuo laboratorio. C'è una grande scrivania dove ci sono tanti becher da dove esce il fumo, frutto dei tuoi continui esperimenti. Appeso al muro c'è una grande bacheca con tanti fogli e foto relativi ai tuoi studi scientifici, e a destra in fondo c'è una macchina del tempo che stai sviluppando, ma senza successo.\nQuando avrai tutti gli ingedienti per l'antidoto, basta inserire gli ingredienti nel becher che si trova sulla scrivania.");
          laboratorio.setLook(
                    "\nDavanti a te, c'è una scrivania con un becher e una " + YELLOW + "nota gialla." + RED
                              + " Sembra molto importante.\n" + ANSI_RESET);

          Stanza camera = new Stanza(5, "Camera", "Nella tua cameretta non c'è niente di speciale.");
          camera.setLook(
                    "Un letto, un comodino e una finestra ricoperta da una lunga tenda bianca. Niente di molto speciale.\n");

          Stanza segreta = new Stanza(6, "Stanza segreta",
                    "\nQuesta camera è così segreta che neanche tu ti ricordavi di averla costruita. Qua si trova uno degli ingredienti più preziosi di tutta la storia dell'umanità.");
          segreta.setLook(
                    "\nLa stanza è piccola, un po' buia. In mezzo si trova un tavolino con sopra una cupola di vetro che conserva il tuo prezioso sanchezium.\n");

          salone.setDirections(camera, bagno, cucina, laboratorio);
          bagno.setDirections(salone, null, null, null);
          cucina.setDirections(null, null, null, salone);
          laboratorio.setDirections(segreta, null, salone, null);
          camera.setDirections(null, salone, null, null);
          segreta.setDirections(null, laboratorio, null, null);

          getStanze().add(salone);
          getStanze().add(bagno);
          getStanze().add(cucina);
          getStanze().add(laboratorio);
          getStanze().add(camera);
          getStanze().add(segreta);

          Oggetti taselloPaperella = new Oggetti(1, "paperella",
                    "Un tasello con l'immagine di una paperella.", bagno, true, false);
          taselloPaperella.setAlias(new String[] { "tasello", "papera" });
          bagno.getObjects().add(taselloPaperella);

          Oggetti taselloKebab = new Oggetti(2, "kebab", "Un tasello con l'immagine del kebab", salone, true,
                    false);
          taselloPaperella.setAlias(new String[] { "tasello" });
          salone.getObjects().add(taselloKebab);

          Oggetti taselloCaffe = new Oggetti(3, "caffe", "Un tasello con l'immagine di un caffè", cucina, true,
                    false);
          taselloCaffe.setAlias(new String[] { "tasello", "caffettino", "caffè" });
          cucina.getObjects().add(taselloCaffe);

          Oggetti saleIodato = new Oggetti(4, "sale",
                    "\nIl sale iodato per il tuo antidoto", cucina, true, false);
          saleIodato.setAlias(new String[] { "sale", "iodato" });
          cucina.getObjects().add(saleIodato);

          Oggetti patatinePorchetta = new Oggetti(5, "patatine",
                    "\nLe buonissime e profumate patatine alla porchetta per il tuo antidoto", cucina, true, false);
          patatinePorchetta.setAlias(new String[] { "porchetta", "patatine" });
          cucina.getObjects().add(patatinePorchetta);

          Oggetti sodaCaustica = new Oggetti(20, "soda", "\nLa soda caustica per il tuo antidoto", bagno, true, false);
          sodaCaustica.setAlias(new String[] { "soda", "caustica" });
          bagno.getObjects().add(sodaCaustica);

          OggettoContenitore cassettiera = new OggettoContenitore(8, "cassettiera",
                    "\nÈ una semplice cassettiera, con qualcosa di importante dentro.");
          cassettiera.setAlias(new String[] { "cassetti", "cassetto" });
          cassettiera.setOpenable(true);
          cassettiera.setOpen(false);
          cassettiera.setPrendibile(false);
          salone.getObjects().add(cassettiera);

          Oggetti specchio = new Oggetti(9, "specchio", "\nUn grande specchio", salone, false, false);
          salone.getObjects().add(specchio);

          Oggetti doccia = new Oggetti(10, "doccia", "\nUna normale doccia, con una... paperella?!", bagno, false,
                    false);
          bagno.getObjects().add(doccia);

          Oggetti caffettiera = new Oggetti(11, "caffettiera",
                    "\nUna super caffettiera la quale usi principalmente per offrire i caffè a laura.\nAspe........ Quello è un tassello??",
                    cucina, false,
                    true);
          cucina.getObjects().add(caffettiera);

          Oggetti divano = new Oggetti(12, "divano",
                    "Il tuo bel divano in pelle color nero, talmente grande che si possono sdraiare in due. C'è anche un tassello... con l'immagine di un... kebab?!.\n",
                    salone, false, false);
          salone.getObjects().add(divano);

          Oggetti ricetta = new Oggetti(13, "ricetta",
                    CYAN + " _. _ _ _|__|_ _    _  _ _|_. _| _ _|_ _    _  _ _ . _  _  _    _  _ _|_.__ _  _ . _  _ .\r\n"
                              + //
                              "| |(_(/_ |  | (_|  (_|| | | |(_|(_) | (_)  |_)(_)/_|(_)| |(/_  (_|| | | |  (_|(_||| |(_|.\r\n"
                              + //
                              "                                           |                                   _|     _| "
                              + ANSI_RESET
                              + " \n1) Sale iodato, \n2) Patatine alla Porchetta, \n3) Soda Caustica \n4) ????\n***nota: da creare in laboratorio",
                    salone, true, false);
          salone.getObjects().add(ricetta);

          OggettoContenitore frigo = new OggettoContenitore(14, "frigo",
                    "\nTrovi nel frigo una vecchia maionese probabilmente scaduta, delle uova fresche, un po' di insalata e un filetto di tonno fresco.");
          frigo.setAlias(new String[] { "frigorifero" });
          cucina.getObjects().add(frigo);

          Oggetti antidoto = new Oggetti(17, "antidoto", "L'antidoto sembra perfetto!", laboratorio, true, false);
          antidoto.setBevibile(true);
          laboratorio.getObjects().add(antidoto);

          Oggetti pozione = new Oggetti(18, "pozione",
                    "\nLa posizione è di colore giallo, molto densa e calda al tatto.", salone, false, false);
          pozione.setBevibile(true);
          salone.getObjects().add(pozione);

          OggettoContenitore armadio = new OggettoContenitore(19, "armadio",
                    "\nL'armadio è praticamente vuoto, devi fare la spesa. Qua trovi solamente le cose per te essenziali: Due lattine di monster al mango, un pacco di patatine alla porchetta e un pacco di sale iodato.");
          armadio.setOpenable(true);
          armadio.setOpen(false);
          armadio.setPrendibile(false);
          cucina.getObjects().add(armadio);

          Oggetti ingredienti = new Oggetti(25, "ingredienti", "\nTutti gli ingredienti dell'antidoto", laboratorio,
                    false, false);
          laboratorio.getObjects().add(ingredienti);

          Oggetti postit = new Oggetti(24, "nota", YELLOW +
                    "            __  ___                __   __   __  ___           ___  __         \r\n" + //
                    " \\/   |\\ | /  \\  |   /\\    | |\\/| |__) /  \\ |__)  |   /\\  |\\ |  |  |_     \\/   \r\n"
                    + //
                    " /\\   | \\| \\__/  |  /--\\   | |  | |    \\__/ | \\   |  /--\\ | \\|  |  |__    /\\   \r\n"
                    + //
                    "                                                                               " + ANSI_RESET
                    + "\n- ricordarsi di aggiungere del sanchezium nell'antidoto!",
                    laboratorio, false,
                    false);
          laboratorio.getObjects().add(postit);

          Oggetti sanchezium = new Oggetti(23, "sanchezium",
                    "\nIl sanchezium è un elemento chimico da te scoperto nel 1999. È di colore azzurro, ed è un elemento molto raro, per cui lo tieni nascosto.",
                    segreta, true, false);
          segreta.getObjects().add(sanchezium);

          setStanzaCorrente(salone);
          pozione.setBevuta(false);
          openDrawer = false;
          antidote = false;
          secretRoom = false;
     }

     /**
      * Questo metodo gestisce la prossima mossa del gioco in base al comando
      * fornito.
      *
      * @param op    L'oggetto OutputParser contenente i dettagli del comando immesso
      *              dall'utente.
      * @param print Oggetto PrintStream per la stampa dei messaggi di gioco.
      */
     public void prossimaMossa(OutputParser op, PrintStream print) {
          GamePrint p = new GamePrint();
          // se il comando è nullo
          if (op.getComandoParser() == null) {
               System.out.println("Ma che vuol dire?!\n");
          } else {
               boolean noCamera = false;
               boolean mossa = false;
               // se il comando è nord
               if (op.getComandoParser().getTipoComando() == Comandi.NORD) {

                    if (getStanzaCorrente().getNorth() != null) {

                         if (getStanzaCorrente().getId() == 4) {
                              if (secretRoom) {
                                   setStanzaCorrente(getStanzaCorrente().getNorth());
                                   mossa = true;
                              } else {
                                   System.out.println("\nLì non c'è niente");
                              }
                         } else {
                              setStanzaCorrente(getStanzaCorrente().getNorth()); // cambia la stanza corrente
                              mossa = true; // c'è stata una mossa
                         }
                    } else {
                         noCamera = true;
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.SUD) {
                    // controlla che ci sia una stanza alla direzione sud
                    if (getStanzaCorrente().getSouth() != null) {
                         setStanzaCorrente(getStanzaCorrente().getSouth()); // cambia la stanza corrente
                         mossa = true; // c'è stata una mossa
                    } else {
                         noCamera = true;
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.EST) {
                    if (getStanzaCorrente().getEast() != null) {
                         setStanzaCorrente(getStanzaCorrente().getEast());
                         mossa = true;
                    } else {
                         noCamera = true;
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.OVEST) {
                    if (getStanzaCorrente().getWest() != null) {
                         if (getStanzaCorrente().getId() == 1) {
                              int count = 0;
                              for (Oggetti o : getInventario()) {
                                   if (o.getName() == "soda" || o.getName() == "patatine"
                                             || o.getName() == "sale") {
                                        count++;
                                   }
                              }
                              p.enterLab();
                              Scanner scanner = new Scanner(System.in);
                              int password = 0;
                              try {
                                   password = scanner.nextInt();
                                   while (password != PASSWORD) {
                                        System.out.println("\nPassword sbagliata.");
                                        password = scanner.nextInt();
                                   }
                              } catch (Exception e) {
                                   System.err.println("Non hai inserito la password ma un comando");
                              }
                              if (count == 3 && password == PASSWORD) {
                                   setStanzaCorrente(getStanzaCorrente().getWest());
                                   mossa = true;
                              } else {
                                   System.out.println("\nMancano degli ingredienti!");
                              }
                         } else {
                              setStanzaCorrente(getStanzaCorrente().getWest());
                              mossa = true;
                         }
                    } else {
                         noCamera = true;
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.INVENTARIO) { // se l'utente vuole sapere
                                                                                          // gli oggetti dell'inventario
                    System.out.println("\nQuesti sono gli oggetti del tuo inventario:");
                    if (getInventario().size() == 0) {
                         System.out.println("\n********** Non ci sono oggetti nell'inventario. **********");
                    } else {
                         for (Oggetti o : getInventario()) {
                              System.out.println("\n- " + o.getName() + "---> " + o.getDescrizione());
                         }
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.GUARDA) { // se l'utente vuole guardare
                    if (op.getOggetto() != null) { // intorno
                         if (op.getOggetto().getName() == "specchio") {
                              if (!transform) {
                                   System.out.println("\nTi piaci allo specchio?\n");
                              } else {
                                   p.printTransform();
                              }
                         } else {
                              System.out.println("\n" + op.getOggetto().getDescrizione() + "\n");
                         }
                    } else if (getStanzaCorrente().getLook() != null) {
                         System.out.println("\n" + getStanzaCorrente().getLook());
                         System.out.println(getStanzaCorrente().getDescription());
                    } else {
                         System.out.println("A quanto pare qui non c'è niente che ti possa aiutare.");
                    }

               } else if (op.getComandoParser().getTipoComando() == Comandi.PRENDI) {
                    if (op.getOggetto() != null && op.getOggetto().getId() != 13) {
                         if (op.getOggetto().isPrendibile()) {
                              getInventario().add(op.getOggetto());
                              getStanzaCorrente().getObjects().remove(op.getOggetto());
                              System.out.println(
                                        "\n* " + op.getOggetto().getName() + " è stato aggiunto all'inventario *");
                         } else {
                              System.out.println("Non puoi prendere questo oggetto.");
                         }
                    } else if (op.getOggetto() != null && op.getOggetto().getId() == 13) {
                         if (openDrawer) {
                              getInventario().add(op.getOggetto());
                              // getStanzaCorrente().getObjects().remove(op.getOggetto());
                              System.out.println(op.getOggetto().getName() + " è stato aggiunto all'inventario");
                         } else {
                              System.out.println("\nLa cassettiera è chiusa!");
                         }
                    } else {
                         System.out.println("Qui non c'è niente.");
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.APRI) {

                    if (op.getOggetto() == null) {
                         System.out.println("Non c'è niente da aprire!");
                    } else {
                         if (op.getOggetto() != null) { // controllo che ci sia un oggetto da aprire
                              if (op.getOggetto().getId() == 8) { // controllo che sia la cassettiera
                                   if (op.getOggetto().getOpen() == false) { // controllo che sia chiusa
                                        int count = 0;
                                        for (Oggetti o : getInventario()) {
                                             if (o.getName() == "kebab" || o.getName() == "caffe"
                                                       || o.getName() == "paperella")
                                                  ;
                                             count++;
                                        } // controllo che ci siano tutti gli oggetti nell'inventario
                                        if (count == 3) { // se ci sono tutti i tasselli, la cassettiera si apre
                                             op.getOggetto().setOpen(true);
                                             openDrawer = true;
                                             System.out.println(
                                                       "Aggiungi i tre tasselli e magicamente la cassettiera si apre, svelando i tuoi appunti e la ricetta che ti salverà da questa bizzarra situazione. È proprio la ricetta dell'antidoto alla tua pozione!!");
                                        } else {

                                             System.out.println(
                                                       "\nMannaggia alle caramelle! LA CASSETTIERA NON SI APRE! Sei stato troppo intelligente a creare un sistema di sicurezza per proteggere i tuoi pregiati averi scientifici.\r\n"
                                                                 +
                                                                 "\nENIGMA: ci sono tre tasselli mancanti per aprire il cassetto. Devi trovarli:\n");
                                             p.printEnigmi();
                                        }
                                   }
                              } else if (op.getOggetto().isOpenable() == true) {
                                   System.out.println("Hai aperto: " + op.getOggetto().getName());
                                   System.out.println("\n" + op.getOggetto().getDescrizione());
                              } else {
                                   System.out.println("Non puoi aprire questo oggetto");
                              }
                         }
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.BEVI) {
                    if (op.getOggetto().getBevibile() == false) {
                         System.out.println("Cosa vorresti bere esattamente?");
                    } else {
                         if (op.getOggetto().getId() == 17) {
                              if (antidote) {
                                   System.out.println(
                                             "Non si può negare che le patatine alla porchetta hanno sempre il loro fascino, per questo sono le tue preferite. Forse un pochino salato.\nIl mondo pian piano inizia a diventare più grande, alla sua forma normale.\nTi guardi le braccia e vedi che non sono più verdi, non odori più di cetriolo, è incredibile!! SEI DI NUOVO UN ESSERE UMANO!\n\n");
                                   end(print);
                              } else {
                                   System.out.println("\nPrima devi prepararlo.");
                              }
                         } else if (op.getOggetto().getId() == 18) {
                              op.getOggetto().setBevuta(true);
                              transform = true;
                              System.out.println(
                                        "\nLa pozione è amara, acida e un po' salata, ma funziona solo se la bevi tutta, quindi fai un ulteriore sforzo e finalmente la finisci. Ti senti energico, e sembra che stia funzionando!\n\nAll'improvviso, senti cambiare qualcosa dentro te. La stanza diventa sempre più grande e ti senti il pavimento sempre più vicino. Diventi sempre più piccolo... C'è qualcosa che non va.");
                         }
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.INDIZI) {
                    p.printEnigmi();
               } else if (op.getComandoParser().getTipoComando() == Comandi.LEGGI) {
                    if (op.getOggetto() != null) {
                         if (op.getOggetto().getName().equals("nota")) {
                              System.out.println("\n" + op.getOggetto().getDescrizione());
                              System.out.println(
                                        "\nOra inizi a ricordarti... Il sanchezium è un elemento chimico da te scoperto nel 1999. È un elemento molto raro, per cui lo tieni nascosto in una stanza segreta.\n\nPer aprire la stanza, devi dire la parola segreta.");
                              System.out.println(
                                        "\n*inserisci il comando *indovinello* per avere l'indovinello che ti svelerà la parola segreta.*");
                         } else {
                              boolean check = false;
                              for (Oggetti o : getInventario()) {
                                   if (o.getId() == 13) {
                                        check = true;
                                   }
                              }
                              if (op.getOggetto().getId() == 13 && check == true) {
                                   System.out.println("\n" + op.getOggetto().getDescrizione());
                              }
                         }
                    } else {
                         System.out.println("\nChe cosa stai dicendo\n");
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.INSERISCI) {
                    if (op.getOggetto() != null) {
                         if (op.getOggetto().getId() == 25) {
                              int count = 0;
                              for (Oggetti o : getInventario()) {
                                   if (o.getId() == 4 || o.getId() == 5
                                             || o.getId() == 20 || o.getId() == 23) {
                                        count++;
                                   }
                              }

                              if (count == 4) {
                                   System.out.println(
                                             "\nInizi a mettere la soda caustica insieme alle patatine alla porchetta. Di seguito inizia ad uscire del fumo giallastro che ha un piacevole odore di porchetta. Aggiungi subito dopo un pizzico di sale, non vuoi che sia troppo salato. Di seguito aggiungi 3ml del tuo così prezioso sanchezium... Che bontà di Dio! Puff! L'antidoto diventa rosa ed è pronto! \nOra non ti resta che berlo!");
                                   antidote = true;
                              } else {
                                   System.out.println("\nManca un ingrediente!");
                              }
                         }
                    } else {
                         System.out.println("\nCosa vai facendo?");
                    }
               } else if (op.getComandoParser().getTipoComando() == Comandi.HELP) {
                    p.printHelp();
               } else if (op.getComandoParser().getTipoComando() == Comandi.INDOVINELLO) {
                    Scanner scanner = new Scanner(System.in);
                    String risposta = "orologio";
                    System.out.println(
                              "\nChe cosa ha due mani, una faccia rotonda, corre sempre ma comunque rimane sempre nello stesso posto?");
                    String parola = scanner.nextLine();

                    while (!parola.equals(risposta)) {
                         System.out.println("\nProvaci ancora.");
                         parola = scanner.nextLine();
                    }
                    secretRoom = true;
                    System.out.println(
                              "\nAll'improvviso senti un forte rumore di una porta rossa che compare davanti ai tuoi occhi. Sembra la porta della stanza segreta! Si trova a nord");

               }

               if (noCamera) {
                    System.out.println("Non puoi andare in questa direzione.");
               } else if (mossa) {
                    System.out.println("Ti trovi in: " + getStanzaCorrente().getName());
                    System.out.println(getStanzaCorrente().getDescription());
               }

          }

     }

     /**
      * Termina il gioco e stampa un messaggio di vittoria.
      * 
      * Questo metodo è chiamato per concludere il gioco e visualizzare un messaggio
      * di vittoria.
      * Dopo la chiamata a questo metodo, il gioco viene interrotto e il programma
      * termina.
      * 
      * @param out Il flusso di stampa su cui verrà stampato il messaggio di
      *            vittoria.
      */
     private void end(PrintStream out) {
          print = new GamePrint();
          System.out.println();
          out.println(
                    "\nSei lo scienziato più forte del mondo!\n");
          print.printGameOver();
          System.out.println();
          tempo.getTimeEndGame();
          System.out.println();
          System.exit(0);
     }

}
