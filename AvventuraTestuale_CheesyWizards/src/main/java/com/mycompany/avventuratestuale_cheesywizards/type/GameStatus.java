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
    
    private AdventureObjectContainer como;
    private AdventureObjectContainer scrivania;
    private AdventureObjectContainer comodino;
    private AdventureObjectContainer dispensa;
    private AdventureObjectContainer cucciaConCane;
    private AdventureObjectContainer armadioAttrezzi;
    private AdventureObjectContainer mobile;
    private AdventureObjectContainer mobiletto;
    
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
        Set<String> AliasPezzoChiave1 = new HashSet<>();
        AliasPezzoChiave1.add("prima metà chiave");
        AliasPezzoChiave1.add("metà chiave");
        AliasPezzoChiave1.add("metà chiave 1");
        AliasPezzoChiave1.add("primo pezzo chiave");
        AliasPezzoChiave1.add("pezzo chiave");
        AliasPezzoChiave1.add("pezzo");
        AliasPezzoChiave1.add("pezzo chiave 1");
        AliasPezzoChiave1.add("prima parte chiave");
        AliasPezzoChiave1.add("parte chiave");
        AliasPezzoChiave1.add("parte chiave 1");
        AliasPezzoChiave1.add("chiave blu");
        pezzoChiave1 = new AdventureObject(0, "Pezzo di chiave blu #1", "E' uno strano oggetto, sembra "
            + "esattamente la prima metà di una chiave spezzata. /nChe quella pazza l'abbia rotta "
            + "di proposito e nascosto l'altra metà non so dove? Mi servirebbe un banco da lavoro per unirle..."
            + "", AliasPezzoChiave1, false, true, true, false, false, false, "");
        
        
        /**
         * Pezzo di chiave blu #2
         */
        Set<String> AliasPezzoChiave2 = new HashSet<>();
        AliasPezzoChiave2.add("seconda metà chiave");
        AliasPezzoChiave2.add("metà chiave");
        AliasPezzoChiave2.add("metà chiave 2");
        AliasPezzoChiave2.add("secondo pezzo chiave");
        AliasPezzoChiave2.add("pezzo chiave");
        AliasPezzoChiave2.add("pezzo chiave 2");
        AliasPezzoChiave2.add("pezzo");
        AliasPezzoChiave2.add("seconda parte chiave");
        AliasPezzoChiave2.add("parte chiave");
        AliasPezzoChiave2.add("parte chiave 2");
        AliasPezzoChiave2.add("chiave blu");
        pezzoChiave2 = new AdventureObject(1, "Pezzo di chiave blu #2", "E' uno strano oggetto, sembra "
                + "esattamente la seconda metà di una chiave spezzata. /nChe quella pazza l'abbia rotta "
                + "di proposito e nascosto l'altra metà non so dove? Mi servirebbe un banco da lavoro per unirle..."
                + "", AliasPezzoChiave2, false, true, true, false, false, false, "");
        
        /**
         * Osso
         */
        Set<String> AliasOsso = new HashSet<>();
        AliasOsso.add("osso");
        AliasOsso.add("ossa");
        AliasOsso.add("scheletro");
        AliasOsso.add("costola");
        osso = new AdventureObject(2, "Osso", "Sembra un osso di prosciutto, i cani ne vanno ghiotti, farebbero di tutto pur di "
                + "averlo.", AliasOsso, false, true, true, false, false, false, "");
        
        /**
         * Ascia
         */
        Set<String> AliasAscia = new HashSet<>();
        AliasAscia.add("lama");
        AliasAscia.add("strumento");
        AliasAscia.add("utensile");
        AliasAscia.add("accetta");
        AliasAscia.add("scure");
        AliasAscia.add("scuretta");
        ascia = new AdventureObject(3, "Ascia da boscaiolo", "Sembra un'ascia. Sembra proprio l'arma che "
                + "quella pazza userebbe per farmi fuori... "
                + "\nCredo sia lo strumento che suo padre usa a lavoro. Con quest'ascia tra le mie mani nessuna "
                + "serratura in legno potrà fermarmi!"
                + "", AliasAscia, false, true, true, false, false, false, "");
        
        /**
         * Chiave d'oro
         */
        Set<String> AliasChiaveOro = new HashSet<>();
        AliasChiaveOro.add("cardine");
        AliasChiaveOro.add("clef");
        AliasChiaveOro.add("chiave");
        chiaveOro = new AdventureObject(4, "Chiave d'oro", "È una chiave d'oro, sembra una chiave molto importante.\n"
                + "Che sia finalmente la chiave per poter scappare dalla casa di questa pazza?"
                + "", AliasChiaveOro, false, true, true, false, false, false, "");
        
        /**
         * Tappeto a scacchiera
         */
        Set<String> AliasTappetoScacchiera = new HashSet<>();
        AliasTappetoScacchiera.add("tappeto");
        AliasTappetoScacchiera.add("telo");
        AliasTappetoScacchiera.add("kilim");
        AliasTappetoScacchiera.add("scacchiera");
        tappetoScacchiera = new AdventureObject(5, "Tappeto a scacchiera", "È un tappeto di dubbio gusto estetico.\n"
                + "È molto grande e sembra super mrbido, però si nota un rialzamento al centro, come se ci "
                + "fosse qualcosa di nascosto al di sotto."
                + "", AliasTappetoScacchiera, false, false, true, false, false, true, "/immagini/ItemBancoDalavoro/tappetoScacchiera.jpg");
        
        /**
         * Orologio
         */
        Set<String> AliasVuoto = new HashSet<>();
        orologio = new AdventureObject(11, "Orologio", "È un orologio a pendolo, sembra molto antico.\n"
                + "Non pensavo li producessero ancora, il suo ticchettio fa quasi paura..."
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemSoggiorno/orologio_comodino.png");
        
        /**
         * Tappeto rosso
         */
        tappetoRosso = new AdventureObject(12, "Tappeto rosso", "È un tappeto rosso molto carino, sembra anche molto morbido.\n"
                + "Sarà nuovo."
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemSoggiorno/lampadario_tappetoRosso.png");
        
        /**
         * Lampadario
         */
        lampadario = new AdventureObject(13, "Lampadario", "È un lampadario molto grande.\n"
                + "È così ingombrante che devo fare attenzione a non sbatterci la testa."
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemSoggiorno/lampadario_tappetoRosso.png");
        
        /**
         * Divanetto
         */
        divanetto = new AdventureObject(14, "Divanetto rosso", "È un divanetto abbastanza piccolo in pelle sintentica.\n"
                + "Sembra molto comodo ma fa troppo caldo, vorrei evitare di sedermi e appiccicarmi per il sudore."
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemSoggiorno/divanetto.png");
        
        /**
         * Divano
         */
        divano = new AdventureObject(15, "Divano rosso", "È un divano rosso abbastanza grande in pelle sintentica.\n"
                + "Sembra molto comodo ma fa troppo caldo, vorrei evitare di sedermi e appiccicarmi per il sudore."
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemSoggiorno/divano_como.png");
        
        /**
         * Specchio
         */
        specchio = new AdventureObject(16, "Specchio", "È uno specchio a misura d'uomo.\n"
                + "WOW! Non ricordavo di essere così bello!"
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemSoggiorno/scrivania_specchio.png");
        
        /**
         * TavoloTronco
         */
        tavoloTronco = new AdventureObject(20, "Tavolo tronco", "È un tavolo ricavato da un tronco.\n"
                + "L'arredamento di questa casa è davvero strano!"
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemBancoDalavoro/tavolo.jpg");
        
        /**
         * Telescopio
         */
        telescopio = new AdventureObject(19, "Telescopio", "È un telescopio usato per gli osservare gli astri.\n"
                + "Sembra costare tantissimo, se lo rompo mi ammazzano a doppio!"
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobile_telescopio.jpg");
        
        /**
         * Mobile
         * Il mobile è vuoto.
         */
        List<AdventureObject> OggettiNelMobile = new ArrayList<>();
        mobile = new AdventureObjectContainer(21, "Mobile a tre ante", "È un mobile a tre ante molto antico.\n"
                + "Non sembra chiuso a chiave, chissà cosa c'è dentro."
                + "", AliasVuoto, true, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobile_telescopio.jpg", OggettiNelMobile);
        
        /**
         * Mobile
         * Il mobiletto è vuoto.
         */
        List<AdventureObject> OggettiNelMobiletto = new ArrayList<>();
        mobiletto = new AdventureObjectContainer(22, "Mobiletto", "È un mobiletto con sopra una lampada.\n"
                + "Ci sono dei tiretti, chissà cosa c'è dentro."
                + "", AliasVuoto, true, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobiletto_orologio.jpg", OggettiNelMobiletto);
        
        /**
         * Orologio
         */
        orologioDaParete = new AdventureObject(23, "Orologio da parete", "È un orologio da parete.\n"
                + "È veramente brutto, ha una forma tutta quadrata, sembra uscito da Minecraft!"
                + "", AliasVuoto, false, false, false, false, false, true, "/immagini/ItemBancoDalavoro/mobiletto_orologio.jpg");

        
        /**
         * Scrivania
         * La scrivania è vuota
         */
        List<AdventureObject> oggettiNellaScrivania = new ArrayList<>();
        scrivania = new AdventureObjectContainer(17, "Scrivania", "È una scrivania, forse usata per studiare.\n"
                + "C'è un tiretto, chissà cosa c'è dentro."
                + "", AliasVuoto, true, false, false, false, false, true, "/immagini/ItemSoggiorno/scrivania_specchio.png",oggettiNellaScrivania);
        
        /**
         * Comò
         * Il comò è vuoto.
         */
        List<AdventureObject> OggettiNelComo = new ArrayList<>();
        como = new AdventureObjectContainer(18, "Comò", "È un comò molto antico e di gran classe.\n"
                + "Ci sono dei tiretti, chissà cosa c'è dentro."
                + "", AliasVuoto, true, false, false, false, false, true, "/immagini/ItemSoggiorno/divano_como.png", OggettiNelComo);
        
        /**
         * Comodino
         */
        Set<String> AliasComodino = new HashSet<>();
        AliasComodino.add("mobile");
        AliasComodino.add("mobiletto");
        AliasComodino.add("cassettiera");
        List<AdventureObject> oggettiNelComodino = new ArrayList<>();
        oggettiNelComodino.add(pezzoChiave1);
        comodino = new AdventureObjectContainer(6, "Comodino stanza orologio", "È un grazioso comodino di un legno molto antico."
                + "\nSembra che uno dei tiretti non sia stato chiuso correttamente, forse per la fretta di dover nascondere qualcosa?"
                + "", AliasComodino, true, false, false, false, false, true, "/immagini/ItemSoggiorno/orologio_comodino.png", oggettiNelComodino);
        
        /**
         * Banco da lavoro
         */
        Set<String> AliasBancoDaLavoro = new HashSet<>();
        AliasBancoDaLavoro.add("crafting table");
        AliasBancoDaLavoro.add("banco");
        AliasBancoDaLavoro.add("tavolo");
        AliasBancoDaLavoro.add("piano");
        bancoDaLavoro = new AdventureObject(7, "Banco da lavoro", "È un banco da lavoro, utile per costruire e riparare qualsiasi cosa."
                + "", AliasBancoDaLavoro, false, false, true, false, false, true, "/immagini/ItemBancoDalavoro/banco_da_lavoro.jpg");
        
        /**
         * Dispensa in cucina
         */
        Set<String> AliasDispensa = new HashSet<>();
        AliasDispensa.add("mobile");
        AliasDispensa.add("mobiletto");
        AliasDispensa.add("cucina");
        AliasDispensa.add("magazzino");
        AliasDispensa.add("ripostiglio");
        AliasDispensa.add("armadietto");
        AliasDispensa.add("stipetto");
        List<AdventureObject> oggettiNellaDispensa = new ArrayList<>();
        oggettiNelComodino.add(osso);
        dispensa = new AdventureObjectContainer(8, "Dispensa della cucina", "È una graziosa dispensa fatta di un legno molto antico."
                + "\nSembra chiusa dall'interno da una serrattuura in legno, che possa usare qualche oggetto per forzarla?"
                + "", AliasDispensa, true, false, false, true, false, true, "", oggettiNellaDispensa);
        
        /**
         * Armadio degli attrezzi
         */
        Set<String> AliasArmadio = new HashSet<>();
        AliasArmadio.add("ripostiglio");
        AliasArmadio.add("armadietto");
        AliasArmadio.add("mobile");
        AliasArmadio.add("cassettiera");
        AliasArmadio.add("stipo");
        AliasArmadio.add("box");
        AliasArmadio.add("deposito");
        AliasArmadio.add("cassone");
        List<AdventureObject> oggettiNellArmadio= new ArrayList<>();
        oggettiNellArmadio.add(ascia);
        armadioAttrezzi = new AdventureObjectContainer(9, "Armadio degli attrezzi", "È un armadio molto vecchio e consumato, non è chiuso a chiave."
                + "\nSicuramente viene utilizzato come ripostiglio per gli attrezzi."
                + "", AliasArmadio, true, false, false, true, false, true, "", oggettiNellArmadio);
        
        /**
         * Cuccia con cane
         */
        Set<String> AliasCuccia = new HashSet<>();
        AliasCuccia.add("casetta");
        AliasCuccia.add("cuccia");
        AliasCuccia.add("rifugio");
        AliasCuccia.add("riparo");
        AliasCuccia.add("cane");
        AliasCuccia.add("casa");
        AliasCuccia.add("cuccetta");
        AliasCuccia.add("tana");
        List<AdventureObject> oggettiNellaCuccia = new ArrayList<>();
        oggettiNellArmadio.add(chiaveOro);
        cucciaConCane = new AdventureObjectContainer(10, "Cuccia del cane", "È una cuccia per cani con dentro Cupcake, "
                + "il cane di quella svitata. Non lo sopporto, è una bestia di satana."
                + "\nOvviamente... accanto a lui c'è una chiave d'oro che sembra proprio essere la chiave della porta di casa, "
                + "come posso prenderla senza che questa bestia mi sbrani."
                + "", AliasCuccia, false, false, false, true, false, true, "", oggettiNellaCuccia);
        
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
        List<AdventureObjectContainer> contenitoriSalaBancoDaLavoro = new ArrayList<>();
        contenitoriSalaBancoDaLavoro.add(mobile);
        contenitoriSalaBancoDaLavoro.add(mobiletto);
        stanzaBancoDaLavoro = new Room(1, "Stanza lavoro", "", "", stanzaSoggiorno, null, stanzaCucina, null, oggettiSalaBancoDaLavoro, contenitoriSalaBancoDaLavoro, "/immagini/stanza2.png");
        stanzaSoggiorno.setNorth(stanzaBancoDaLavoro);
        /**
         * Stanza cucina #02
         */
        List<AdventureObject> oggettiCucina = new ArrayList<>();
        List<AdventureObjectContainer> contenitoriCucina = new ArrayList<>();
        contenitoriCucina.add(dispensa);
        stanzaCucina = new Room(2, "Cucina", "", "", stanzaGiardino, null, null, stanzaBancoDaLavoro, oggettiCucina, contenitoriCucina, "/immagini/stanza3.png");
        stanzaBancoDaLavoro.setEast(stanzaCucina);
        /**
         * Stanza giardino #03
         */
        List<AdventureObject> oggettiGiardino = new ArrayList<>();
        List<AdventureObjectContainer> contenitoriGiardino = new ArrayList<>();
        contenitoriGiardino.add(cucciaConCane);
        contenitoriGiardino.add(dispensa);
        stanzaGiardino = new Room(3, "Giardino", "", "", null, stanzaCucina, null, null, oggettiGiardino, contenitoriGiardino, "/immagini/stanza4.png");
        stanzaCucina.setNorth(stanzaGiardino);
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