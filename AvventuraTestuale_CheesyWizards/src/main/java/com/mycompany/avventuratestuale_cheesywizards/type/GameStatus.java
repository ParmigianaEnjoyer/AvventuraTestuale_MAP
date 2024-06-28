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
    
    private AdventureObject pezzoChiave1;
    private AdventureObject pezzoChiave2;
    private AdventureObject osso;
    private AdventureObject ascia;
    private AdventureObject chiaveOro;
    private AdventureObject tappetoScacchiera;
    private AdventureObject bancoDaLavoro;
    
    private AdventureObjectContainer comodino;
    private AdventureObjectContainer dispensa;
    private AdventureObjectContainer cucciaConCane;
    private AdventureObjectContainer armadioAttrezzi;
    
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
            + "", AliasPezzoChiave1, false, true, true, false, false, false);
        
        
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
                + "", AliasPezzoChiave2, false, true, true, false, false, false);
        
        /**
         * Osso
         */
        Set<String> AliasOsso = new HashSet<>();
        AliasOsso.add("osso");
        AliasOsso.add("ossa");
        AliasOsso.add("scheletro");
        AliasOsso.add("costola");
        osso = new AdventureObject(2, "Osso", "Sembra un osso di prosciutto, i cani ne vanno ghiotti, farebbero di tutto pur di "
                + "averlo.", AliasOsso, false, true, true, false, false, false);
        
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
                + "", AliasAscia, false, true, true, false, false, false);
        
        /**
         * Chiave d'oro
         */
        Set<String> AliasChiaveOro = new HashSet<>();
        AliasChiaveOro.add("cardine");
        AliasChiaveOro.add("clef");
        AliasChiaveOro.add("chiave");
        chiaveOro = new AdventureObject(4, "Chiave d'oro", "È una chiave d'oro, sembra una chiave molto importante.\n"
                + "Che sia finalmente la chiave per poter scappare dalla casa di questa pazza?"
                + "", AliasChiaveOro, false, true, true, false, false, false);
        
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
                + "", AliasTappetoScacchiera, false, false, true, false, false, true);
        
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
                + "", AliasComodino, true, false, false, false, false, true, oggettiNelComodino);
        
        /**
         * Banco da lavoro
         */
        Set<String> AliasBancoDaLavoro = new HashSet<>();
        AliasBancoDaLavoro.add("crafting table");
        AliasBancoDaLavoro.add("banco");
        AliasBancoDaLavoro.add("tavolo");
        AliasBancoDaLavoro.add("piano");
        bancoDaLavoro = new AdventureObject(7, "Banco da lavoro", "È un banco da lavoro, utile per costruire e riparare qualsiasi cosa."
                + "", AliasBancoDaLavoro, false, false, true, false, false, true);
        
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
                + "", AliasDispensa, true, false, false, true, false, true, oggettiNellaDispensa);
        
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
                + "", AliasArmadio, true, false, false, true, false, true, oggettiNellArmadio);
        
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
                + "", AliasCuccia, false, false, false, true, false, true, oggettiNellaCuccia);
        
        /**
         * Stanza soggiorno #00
         */
        List<AdventureObject> oggettiNelSoggiorno = new ArrayList<>();
        List<AdventureObjectContainer> contenitoriNelSoggiorno = new ArrayList<>();
        contenitoriNelSoggiorno.add(comodino);
        stanzaSoggiorno = new Room(0, "Soggiorno", "", "", null, stanzaBancoDaLavoro, null, null, oggettiNelSoggiorno, contenitoriNelSoggiorno);
        
        /**
         * Stanza banco da lavoro #01
         */
        List<AdventureObject> oggettiSalaBancoDaLavoro = new ArrayList<>();
        oggettiSalaBancoDaLavoro.add(tappetoScacchiera);
        oggettiSalaBancoDaLavoro.add(bancoDaLavoro);
        List<AdventureObjectContainer> contenitoriSalaBancoDaLavoro = new ArrayList<>();
        stanzaBancoDaLavoro = new Room(1, "Stanza lavoro", "", "", stanzaSoggiorno, null, stanzaCucina, null, oggettiSalaBancoDaLavoro, contenitoriSalaBancoDaLavoro);
        
        /**
         * Stanza cucina #02
         */
        List<AdventureObject> oggettiCucina = new ArrayList<>();
        List<AdventureObjectContainer> contenitoriCucina = new ArrayList<>();
        contenitoriCucina.add(dispensa);
        stanzaCucina = new Room(2, "Cucina", "", "", stanzaGiardino, null, null, stanzaBancoDaLavoro, oggettiCucina, contenitoriCucina);
        
        /**
         * Stanza giardino #03
         */
        List<AdventureObject> oggettiGiardino = new ArrayList<>();
        List<AdventureObjectContainer> contenitoriGiardino = new ArrayList<>();
        contenitoriGiardino.add(cucciaConCane);
        contenitoriGiardino.add(dispensa);
        stanzaGiardino = new Room(3, "Giardino", "", "", null, stanzaCucina, null, null, oggettiGiardino, contenitoriGiardino);
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