/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.type;

import com.mycompany.avventuratestuale_cheesywizards.timer.Timer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nico0
 */
public class GameStatus implements Serializable{
    
    private Timer timer_partita;
    private Room current_room;
    private AdventureObject pezzoChiave1;
    private AdventureObject pezzoChiave2;
    private AdventureObject osso;
    private AdventureObject ascia;
    private AdventureObject chiaveOro;
    private AdventureObject chiaveIntera;
    private AdventureObject tappetoScacchiera;
    private AdventureObject tappetoRosso;
    private AdventureObject lampadario;
    private AdventureObject divanetto;
    private AdventureObject bancoDaLavoro;
    private AdventureObject orologio;
    private AdventureObject divano;
    private AdventureObject specchio;
    private AdventureObject tavoloTronco;
    private AdventureObject telescopio;
    private AdventureObject orologioDaParete;
    private AdventureObject poltrona;
    private AdventureObject lavandino;
    private AdventureObject tavoloDaPranzo;
    private AdventureObject camino;
    private AdventureObject porta;
    
    private AdventureObjectContainer como;
    private AdventureObjectContainer scrivania;
    private AdventureObjectContainer comodino;
    private AdventureObjectContainer dispensa;
    private AdventureObjectContainer cucciaConCane;
    private AdventureObjectContainer armadioAttrezzi;
    private AdventureObjectContainer mobile;
    private AdventureObjectContainer mobiletto;
    private AdventureObjectContainer mobileCucina;
    private AdventureObjectContainer frigorifero;
    
    private Room stanzaSoggiorno;
    private Room stanzaBancoDaLavoro;
    private Room stanzaCucina;
    private Room stanzaGiardino;
    
    private Inventory inventario;

    /**
     * Costruttore di GameStatus
     */
    public GameStatus() {
    }
    
    
    /**
     * Funzione che inizializza tutti gli oggetti dell'avventura al loro stato di default, per la nuova partita
     */
    public void initialize_game_status(){
        inventario = new Inventory();
        timer_partita = new Timer();
        /**
         * Pezzo di chiave blu #1
         */
        pezzoChiave1 = new AdventureObject(0, "Pezzo di chiave #1", "E' uno strano oggetto, sembra "
            + "esattamente la prima metà di una chiave spezzata. \nChe quella pazza l'abbia rotta "
            + "di proposito e nascosto l'altra metà non so dove? Mi servirebbe un banco da lavoro per unirle..."
            + "", false, true, true, false, false, false, "/immagini/chiaveparte1.png");
        
        
        /**
         * Pezzo di chiave blu #2
         */
        pezzoChiave2 = new AdventureObject(1, "Pezzo di chiave #2", "E' uno strano oggetto, sembra "
                + "esattamente la seconda metà di una chiave spezzata. \nChe quella pazza l'abbia rotta "
                + "di proposito e nascosto l'altra metà non so dove? Mi servirebbe un banco da lavoro per unirle..."
                + "", false, true, true, false, false, false, "/immagini/chiaveparte2.png");
        
        chiaveIntera = new AdventureObject(80, "Chiave giardino", "E' uno strano oggetto, sembra "
                + "esattamente la seconda metà di una chiave spezzata. \nChe quella pazza l'abbia rotta "
                + "di proposito e nascosto l'altra metà non so dove? Mi servirebbe un banco da lavoro per unirle..."
                + "", false, true, true, false, false, false, "/immagini/chiave.png");
        
        /**
         * Osso
         */
        osso = new AdventureObject(2, "Osso", "Sembra un osso di prosciutto, i cani ne vanno ghiotti, farebbero di tutto pur di "
                + "averlo.", false, true, true, false, false, false, "/immagini/bone.png");
        
        /**
         * Ascia
         */
        ascia = new AdventureObject(3, "Ascia da boscaiolo", "Sembra un'ascia. Sembra proprio l'arma che "
                + "quella pazza userebbe per farmi fuori... "
                + "\nCredo sia lo strumento che suo padre usa a lavoro. Con quest'ascia tra le mie mani nessuna "
                + "serratura in legno potrà fermarmi!"
                + "", false, true, true, false, false, false, "/immagini/ascia.png");
        
        /**
         * Chiave d'oro
         */
        chiaveOro = new AdventureObject(4, "Chiave d'oro", "È una chiave d'oro, sembra una chiave molto importante.\n"
                + "Che sia finalmente la chiave per poter scappare dalla casa di questa pazza? Devo correre nel soggiorno e aprire la porta dìuscita per scoprirlo!"
                + "", false, true, true, false, false, false, "/immagini/chiaveOro.png");
        
        /**
         * Tappeto a scacchiera
         */
        tappetoScacchiera = new AdventureObject(5, "Tappeto a scacchiera", "È un tappeto di dubbio gusto estetico.\n"
                + "È molto grande e sembra super mrbido, però si nota un rialzamento al centro, come se ci "
                + "fosse qualcosa di nascosto al di sotto."
                + "", false, false, false, false, true, true, "/immagini/ItemBancoDalavoro/tappetoScacchiera.jpg");
        
        /**
         * Orologio
         */
        orologio = new AdventureObject(11, "Orologio", "È un orologio a pendolo, sembra molto antico.\n"
                + "Non pensavo li producessero ancora, il suo ticchettio fa quasi paura..."
                + "", false, false, false, false, false, true, "/immagini/ItemSoggiorno/orologio_comodino.jpg");
        
        /**
         * Tappeto rosso
         */
        tappetoRosso = new AdventureObject(12, "Tappeto rosso", "È un tappeto rosso molto carino, sembra anche molto morbido.\n"
                + "Sarà nuovo."
                + "", false, false, false, false, false, true, "/immagini/ItemSoggiorno/lampadario_tappetoRosso.jpg");
        
        /**
         * Lampadario
         */
        lampadario = new AdventureObject(13, "Lampadario", "È un lampadario molto grande.\n"
                + "È così ingombrante che devo fare attenzione a non sbatterci la testa."
                + "", false, false, false, false, false, true, "/immagini/ItemSoggiorno/lampadario_tappetoRosso.jpg");
        
        /**
         * Divanetto
         */
        divanetto = new AdventureObject(14, "Divanetto rosso", "È un divanetto abbastanza piccolo in pelle sintentica.\n"
                + "Sembra molto comodo ma fa troppo caldo, vorrei evitare di sedermi e appiccicarmi per il sudore."
                + "", false, false, false, false, false, true, "/immagini/ItemSoggiorno/divanetto.jpg");
        
        /**
         * Divano
         */
        divano = new AdventureObject(15, "Divano rosso", "È un divano rosso abbastanza grande in pelle sintentica.\n"
                + "Sembra molto comodo ma fa troppo caldo, vorrei evitare di sedermi e appiccicarmi per il sudore."
                + "", false, false, false, false, false, true, "/immagini/ItemSoggiorno/divano_como.jpg");
        
        /**
         * Specchio
         */
        specchio = new AdventureObject(16, "Specchio", "È uno specchio a misura d'uomo.\n"
                + "WOW! Non ricordavo di essere così bello!"
                + "", false, false, false, false, false, true, "/immagini/ItemSoggiorno/scrivania_specchio.jpg");
        
        /**
         * TavoloTronco
         */
        tavoloTronco = new AdventureObject(20, "Tavolo tronco", "È un tavolo ricavato da un tronco.\n"
                + "L'arredamento di questa casa è davvero strano!"
                + "", false, false, false, false, false, true, "/immagini/ItemBancoDalavoro/tavolo.jpg");
        
        /**
         * Telescopio
         */
        telescopio = new AdventureObject(19, "Telescopio", "È un telescopio usato per gli osservare gli astri.\n"
                + "Sembra costare tantissimo, se lo rompo mi ammazzano a doppio!"
                + "", false, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobile_telescopio.jpg");
        
        /**
         * Mobile
         * Il mobile è vuoto.
         */
        List<AdventureObject> OggettiNelMobile = new ArrayList<>();
        mobile = new AdventureObjectContainer(21, "Mobile a tre ante", "È un mobile a tre ante molto antico.\n"
                + "Non sembra chiuso a chiave, chissà cosa c'è dentro."
                + "", true, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobile_telescopio.jpg", OggettiNelMobile);
        
        /**
         * Mobile
         * Il mobiletto è vuoto.
         */
        List<AdventureObject> OggettiNelMobiletto = new ArrayList<>();
        mobiletto = new AdventureObjectContainer(22, "Mobiletto", "È un mobiletto con sopra una lampada.\n"
                + "Ci sono dei tiretti, chissà cosa c'è dentro."
                + "", true, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobiletto_orologio.jpg", OggettiNelMobiletto);
        
        /**
         * Orologio
         */
        orologioDaParete = new AdventureObject(23, "Orologio da parete", "È un orologio da parete.\n"
                + "È veramente brutto, ha una forma tutta quadrata, sembra uscito da Minecraft!"
                + "", false, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobiletto_orologio.jpg");

        
        /**
         * Scrivania
         * La scrivania è vuota
         */
        List<AdventureObject> oggettiNellaScrivania = new ArrayList<>();
        scrivania = new AdventureObjectContainer(17, "Scrivania", "È una scrivania, forse usata per studiare.\n"
                + "C'è un tiretto, chissà cosa c'è dentro."
                + "", true, false, false, false, false, true, "/immagini/ItemSoggiorno/scrivania_specchio.jpg",oggettiNellaScrivania);
        
        /**
         * Comò
         * Il comò è vuoto.
         */
        List<AdventureObject> OggettiNelComo = new ArrayList<>();
        como = new AdventureObjectContainer(18, "Comò", "È un comò molto antico e di gran classe.\n"
                + "Ci sono dei tiretti, chissà cosa c'è dentro."
                + "", true, false, false, false, false, true, "/immagini/ItemSoggiorno/divano_como.jpg", OggettiNelComo);
        
        /**
         * Frigorifero
         * Il frigorifero è vuoto.
         */
        List<AdventureObject> OggettiNelFrigo = new ArrayList<>();
        frigorifero = new AdventureObjectContainer(24, "Frigorifero", "È un frigorifer divecchissima generazione.\n"
                + "Fa un rumore madornale e sembra anche chiusa a chiave, che famiglia di spilorci!."
                + "", true, false, false, false, false, true, "/immagini/ItemCucina/frigo_lavandino_dispensa.png", OggettiNelFrigo);
        
        /**
         * Lavandino
         */
        lavandino = new AdventureObject(25, "Lavandino", "È un tipico lavandino da cucina.\n"
                + "A meno che io non volgia lavare i piatti, è inutile."
                + "", false, false, false, false, false, true, "/immagini/ItemCucina/frigo_lavandino_dispensa.png");
        
        /**
         * Tavolo da pranzo
         */
        tavoloDaPranzo = new AdventureObject(26, "Tavolo da pranzo", "È il tavolo dove quella pazza e la sua famiglia pranzano.\n"
                + "... non riesco a pensare a niente di divertente per un semplice tavolo da pranzo."
                + "", false, false, false, false, false, true, "/immagini/ItemCucina/tavoloDaPranzo.png");
        
        /**
         * Camino
         */
        camino = new AdventureObject(27, "Camino", "È un camino ed è acceso.\n"
                + "Si, è letteralmente un camino accesso e siamo a Luglio. Fa caldissimo!"
                + "", false, false, false, false, false, true, "/immagini/ItemCucina/camino_poltrona.png");
        
        /**
         * Poltrona
         */
        poltrona = new AdventureObject(28, "Poltrona", "È una poltrona rossa in pelle sintetica.\n"
                + "Chi ha avuto la brillante idea di metterla di fronte ad un camino acceso? È bollente!!"
                + "", false, false, false, false, false, true, "/immagini/ItemCucina/camino_poltrona.png");
        
        /**
         * Porta giardino
         */
        porta = new AdventureObject(29, "Porta", "È la porta del giardino, magari lì fuori trovo qualcosa per scappare.\n"
                + "La porta, però, sembra chiusa a chiave...CHE TU SIA MALEDETTA!"
                + "", true, false, false, true, false, true, "/immagini/ItemCucina/porta.png");
        
        /**
         * Mobile a tre ante cucina
         * Il mobile in cucina è vuoto.
         */
        List<AdventureObject> OggettiNelMobileCucina = new ArrayList<>();
        mobileCucina = new AdventureObjectContainer(29, "Mobile a tre ante", "È un mobile a tre ante.\n"
                + "Chissà cosa ci sarà dentro?!."
                + "", true, false, false, false, false, true, "/immagini/ItemCucina/mobile_cucina.png", OggettiNelMobileCucina);
        
        /**
         * Comodino
         */
        List<AdventureObject> oggettiNelComodino = new ArrayList<>();
        oggettiNelComodino.add(pezzoChiave1);
        comodino = new AdventureObjectContainer(6, "Comodino", "È un grazioso comodino di un legno molto antico."
                + "\nSembra che uno dei tiretti non sia stato chiuso correttamente, forse per la fretta di dover nascondere qualcosa?"
                + "", true, false, false, false, false, true, "/immagini/ItemSoggiorno/orologio_comodino.jpg", oggettiNelComodino);
        
        /**
         * Banco da lavoro
         */
        bancoDaLavoro = new AdventureObject(7, "Banco da lavoro", "È un banco da lavoro, utile per costruire e riparare qualsiasi cosa."
                + "", false, false, true, false, false, true, "/immagini/ItemBancoDalavoro/banco_da_lavoro.jpg");
        
        /**
         * Dispensa in cucina
         */
        List<AdventureObject> oggettiNellaDispensa = new ArrayList<>();
        oggettiNellaDispensa.add(osso);
        dispensa = new AdventureObjectContainer(8, "Dispensa della cucina", "È una graziosa dispensa fatta di un legno molto antico."
                + "\nSembra chiusa dall'interno da una serrattuura in legno, che possa usare qualche oggetto per forzarla?"
                + "", true, false, false, true, false, true, "/immagini/ItemCucina/frigo_lavandino_dispensa.png", oggettiNellaDispensa);
        
        /**
         * Armadio degli attrezzi
         */
        List<AdventureObject> oggettiNellArmadio= new ArrayList<>();
        oggettiNellArmadio.add(ascia);
        armadioAttrezzi = new AdventureObjectContainer(9, "Armadio degli attrezzi", "È un armadio molto vecchio e consumato, non è chiuso a chiave."
                + "\nSicuramente viene utilizzato come ripostiglio per gli attrezzi."
                + "", true, false, false, false, false, true, "/immagini/ItemGiardino/armadioAttrezzi.png", oggettiNellArmadio);
        
        /**
         * Cuccia con cane
         */
        List<AdventureObject> oggettiNellaCuccia = new ArrayList<>();
        oggettiNellaCuccia.add(chiaveOro);
        cucciaConCane = new AdventureObjectContainer(10, "Cuccia del cane", "È una cuccia per cani con dentro Cupcake, "
                + "il cane di quella svitata. Non lo sopporto, è una bestia di satana."
                + "\nOvviamente... accanto a lui c'è una chiave d'oro che sembra proprio essere la chiave della porta di casa, "
                + "come posso prenderla senza che questa bestia mi sbrani."
                + "", true, false, true, true, false, true, "/immagini/ItemGiardino/cucciaCane.png", oggettiNellaCuccia);
        
        /**
         * Stanza soggiorno #00
         */
        List<AdventureObject> oggettiNelSoggiorno = new ArrayList<>();
        List<AdventureObjectContainer> contenitoriNelSoggiorno = new ArrayList<>();
        
        oggettiNelSoggiorno.add(orologio);
        oggettiNelSoggiorno.add(tappetoRosso);
        oggettiNelSoggiorno.add(lampadario);
        oggettiNelSoggiorno.add(specchio);
        oggettiNelSoggiorno.add(divanetto);
        oggettiNelSoggiorno.add(divano);
                
        contenitoriNelSoggiorno.add(comodino);
        contenitoriNelSoggiorno.add(scrivania);
        contenitoriNelSoggiorno.add(como);
        stanzaSoggiorno = new Room(0, "Soggiorno", "", "", null, stanzaBancoDaLavoro, null, null, oggettiNelSoggiorno, contenitoriNelSoggiorno, "/immagini/stanza1.png");
        
        /**
         * Stanza banco da lavoro #01
         */
        List<AdventureObject> oggettiSalaBancoDaLavoro = new ArrayList<>();
        oggettiSalaBancoDaLavoro.add(tappetoScacchiera);
        oggettiSalaBancoDaLavoro.add(bancoDaLavoro);
        oggettiSalaBancoDaLavoro.add(orologioDaParete);
        oggettiSalaBancoDaLavoro.add(telescopio);
        oggettiSalaBancoDaLavoro.add(tavoloTronco);
        oggettiSalaBancoDaLavoro.add(pezzoChiave2);
        List<AdventureObjectContainer> contenitoriSalaBancoDaLavoro = new ArrayList<>();
        contenitoriSalaBancoDaLavoro.add(mobile);
        contenitoriSalaBancoDaLavoro.add(mobiletto);
        stanzaBancoDaLavoro = new Room(1, "Stanza lavoro", "", "", stanzaSoggiorno, null, null, stanzaCucina, oggettiSalaBancoDaLavoro, contenitoriSalaBancoDaLavoro, "/immagini/stanza2.png");
        stanzaSoggiorno.setNorth(stanzaBancoDaLavoro);
        
        /**
         * Stanza cucina #02
         */
        List<AdventureObject> oggettiCucina = new ArrayList<>();
        oggettiCucina.add(camino);
        oggettiCucina.add(poltrona);
        oggettiCucina.add(tavoloDaPranzo);
        oggettiCucina.add(mobileCucina);
        oggettiCucina.add(lavandino);
        oggettiCucina.add(porta);
        List<AdventureObjectContainer> contenitoriCucina = new ArrayList<>();
        contenitoriCucina.add(dispensa);
        contenitoriCucina.add(frigorifero);
        stanzaCucina = new Room(2, "Cucina", "", "", stanzaGiardino, null, stanzaBancoDaLavoro, null, oggettiCucina, contenitoriCucina, "/immagini/stanza3.png");
        stanzaBancoDaLavoro.setWest(stanzaCucina);
        
        /**
         * Stanza giardino #03
         */
        List<AdventureObject> oggettiGiardino = new ArrayList<>();
        List<AdventureObjectContainer> contenitoriGiardino = new ArrayList<>();
        contenitoriGiardino.add(cucciaConCane);
        contenitoriGiardino.add(armadioAttrezzi);
        stanzaGiardino = new Room(3, "Giardino", "", "", null, stanzaCucina, null, null, oggettiGiardino, contenitoriGiardino, "/immagini/stanza4.png");
        stanzaCucina.setSouth(stanzaGiardino);
        current_room = stanzaSoggiorno;
    }

    public Room getCurrent_room() {
        return current_room;
    }

    public void setCurrent_room(Room current_room) {
        this.current_room = current_room;
    }

    public AdventureObject getTappetoRosso() {
        return tappetoRosso;
    }

    public void setTappetoRosso(AdventureObject tappetoRosso) {
        this.tappetoRosso = tappetoRosso;
    }

    public AdventureObject getLampadario() {
        return lampadario;
    }

    public void setLampadario(AdventureObject lampadario) {
        this.lampadario = lampadario;
    }

    public AdventureObject getDivanetto() {
        return divanetto;
    }

    public void setDivanetto(AdventureObject divanetto) {
        this.divanetto = divanetto;
    }

    public AdventureObject getOrologio() {
        return orologio;
    }

    public void setOrologio(AdventureObject orologio) {
        this.orologio = orologio;
    }

    public AdventureObject getDivano() {
        return divano;
    }

    public void setDivano(AdventureObject divano) {
        this.divano = divano;
    }

    public AdventureObject getSpecchio() {
        return specchio;
    }

    public void setSpecchio(AdventureObject specchio) {
        this.specchio = specchio;
    }

    public AdventureObjectContainer getComo() {
        return como;
    }

    public void setComo(AdventureObjectContainer como) {
        this.como = como;
    }

    public AdventureObjectContainer getScrivania() {
        return scrivania;
    }

    public void setScrivania(AdventureObjectContainer scrivania) {
        this.scrivania = scrivania;
    }


    
    /**
     * 
     * @return 
     */
    public AdventureObject getPezzoChiave1() {
        return pezzoChiave1;
    }

    /**
     * 
     * @param pezzoChiave1 
     */
    public void setPezzoChiave1(AdventureObject pezzoChiave1) {
        this.pezzoChiave1 = pezzoChiave1;
    }

    /**
     * 
     * @return 
     */
    public AdventureObject getPezzoChiave2() {
        return pezzoChiave2;
    }

    /**
     * 
     * @param pezzoChiave2 
     */
    public void setPezzoChiave2(AdventureObject pezzoChiave2) {
        this.pezzoChiave2 = pezzoChiave2;
    }

    /**
     * 
     * @return 
     */
    public AdventureObject getOsso() {
        return osso;
    }

    /**
     * 
     * @param osso 
     */
    public void setOsso(AdventureObject osso) {
        this.osso = osso;
    }

    /**
     * 
     * @return 
     */
    public AdventureObject getAscia() {
        return ascia;
    }

    /**
     * 
     * @param ascia 
     */
    public void setAscia(AdventureObject ascia) {
        this.ascia = ascia;
    }

    /**
     * 
     * @return 
     */
    public AdventureObject getChiaveOro() {
        return chiaveOro;
    }

    /**
     * 
     * @param chiaveOro 
     */
    public void setChiaveOro(AdventureObject chiaveOro) {
        this.chiaveOro = chiaveOro;
    }
    
    /**
     * 
     * @return 
     */
    public AdventureObject getChiaveIntera() {
        return chiaveIntera;
    }

    /**
     * 
     * @param chiaveIntera 
     */
    public void setChiaveIntera(AdventureObject chiaveIntera) {
        this.chiaveIntera = chiaveIntera;
    }

    /**
     * 
     * @return 
     */
    public AdventureObject getTappetoScacchiera() {
        return tappetoScacchiera;
    }

    /**
     * 
     * @param tappetoScacchiera 
     */
    public void setTappetoScacchiera(AdventureObject tappetoScacchiera) {
        this.tappetoScacchiera = tappetoScacchiera;
    }

    /**
     * 
     * @return 
     */
    public AdventureObject getBancoDaLavoro() {
        return bancoDaLavoro;
    }

    /**
     * 
     * @param bancoDaLavoro 
     */
    public void setBancoDaLavoro(AdventureObject bancoDaLavoro) {
        this.bancoDaLavoro = bancoDaLavoro;
    }

    /**
     * 
     * @return 
     */
    public AdventureObjectContainer getComodino() {
        return comodino;
    }

    /**
     * 
     * @param comodino 
     */
    public void setComodino(AdventureObjectContainer comodino) {
        this.comodino = comodino;
    }

    /**
     * 
     * @return 
     */
    public AdventureObjectContainer getDispensa() {
        return dispensa;
    }

    /**
     * 
     * @param dispensa 
     */
    public void setDispensa(AdventureObjectContainer dispensa) {
        this.dispensa = dispensa;
    }

    /**
     * 
     * @return 
     */
    public AdventureObjectContainer getCucciaConCane() {
        return cucciaConCane;
    }

    /**
     * 
     * @param cucciaConCane 
     */
    public void setCucciaConCane(AdventureObjectContainer cucciaConCane) {
        this.cucciaConCane = cucciaConCane;
    }

    /**
     * 
     * @return 
     */
    public AdventureObjectContainer getArmadioAttrezzi() {
        return armadioAttrezzi;
    }

    /**
     * 
     * @param armadioAttrezzi 
     */
    public void setArmadioAttrezzi(AdventureObjectContainer armadioAttrezzi) {
        this.armadioAttrezzi = armadioAttrezzi;
    }

    /**
     * 
     * @return 
     */
    public Room getStanzaSoggiorno() {
        return stanzaSoggiorno;
    }

    /**
     * 
     * @param stanzaSoggiorno 
     */
    public void setStanzaSoggiorno(Room stanzaSoggiorno) {
        this.stanzaSoggiorno = stanzaSoggiorno;
    }

    /**
     * 
     * @return 
     */
    public Room getStanzaBancoDaLavoro() {
        return stanzaBancoDaLavoro;
    }

    /**
     * 
     * @param stanzaBancoDaLavoro 
     */
    public void setStanzaBancoDaLavoro(Room stanzaBancoDaLavoro) {
        this.stanzaBancoDaLavoro = stanzaBancoDaLavoro;
    }

    /**
     * 
     * @return 
     */
    public Room getStanzaCucina() {
        return stanzaCucina;
    }

    /**
     * 
     * @param stanzaCucina 
     */
    public void setStanzaCucina(Room stanzaCucina) {
        this.stanzaCucina = stanzaCucina;
    }

    /**
     * 
     * @return 
     */
    public Room getStanzaGiardino() {
        return stanzaGiardino;
    }

    /**
     * 
     * @param stanzaGiardino 
     */
    public void setStanzaGiardino(Room stanzaGiardino) {
        this.stanzaGiardino = stanzaGiardino;
    }

    /**
     * 
     * @return 
     */
    public Inventory getInventario() {
        return inventario;
    }

    /**
     * 
     * @param inventario 
     */
    public void setInventario(Inventory inventario) {
        this.inventario = inventario;
    }

    /**
     * 
     * @return 
     */
    public Timer getTimer_partita() {
        return timer_partita;
    }

    /**
     * 
     * @param timer_partita 
     */
    public void setTimer_partita(Timer timer_partita) {
        this.timer_partita = timer_partita;
    }
}