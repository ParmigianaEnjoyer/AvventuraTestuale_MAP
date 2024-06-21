/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.type;

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
    
    private AdventureObject pezzoChiave1;
    private AdventureObject pezzoChiave2;
    private AdventureObject osso;
    private AdventureObject ascia;
    private AdventureObject chiaveOro;
    
    private AdventureObjectContainer comodino;
    
    /**
     * Funzione che inizializza tutti gli oggetti dell'avventura al loro stato di default, per la nuova partita
     */
    public void intialize_game_status(){
        
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
            + "di proposito e nascosto l'altra metà non so dove? Mi servirebbe un banco da lavoro per unirle...", AliasPezzoChiave1, false, true, true, false, false, false);
        
        
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
            + "di proposito e nascosto l'altra metà non so dove? Mi servirebbe un banco da lavoro per unirle...", AliasPezzoChiave2, false, true, true, false, false, false);
        
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
        ascia = new AdventureObject(3, "Ascia da boscaiolo", "Sembra un'ascia. Sembra proprio l'arma che quella pazza userebbe per farmi fuori... "
                + "\nCredo sia lo strumento che suo padre usa a lavoro. Con quest'ascia tra le mie mani nessuna serratura in legno potrà fermarmi!"
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
        chiaveOro = new AdventureObject(5, "Tappeto a scacchiera", "È un tappeto di dubbio gusto estetico.\n"
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
        oggettiNelComodino.add(0, pezzoChiave1);
        comodino = new AdventureObjectContainer(6, "Comodino stanza orologio", "È un grazioso comodino di un legno molto antico."
                + "\nSembra che uno dei tiretti non sia stato chiuso correttamente, forse per la fretta di dover nascondere qualcosa?"
                + "", AliasComodino, true, false, false, false, false, true, oggettiNelComodino);
        
    }
}
