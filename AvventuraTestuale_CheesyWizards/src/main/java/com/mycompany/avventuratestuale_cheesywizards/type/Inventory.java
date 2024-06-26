package com.mycompany.avventuratestuale_cheesywizards.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nico0
 */
public class Inventory implements Serializable{

    private List<AdventureObject> list = new ArrayList<>();     //lista di oggetti di tipo AdventureObject

    /**
     * 
     */
    public Inventory() {
    }

    /**
     *
     * @return
     */
    public List<AdventureObject> getList() {
        return list;
    }

    /**
     *
     * @param list
     */
    public void setList(List<AdventureObject> list) {
        this.list = list;
    }

    /**
     *
     * @param obj
     */
    public void addObject(AdventureObject obj) {
        list.add(obj);
    }

    /**
     *
     * @param obj
     */
    public void removeObject(AdventureObject obj) {
        list.remove(obj);
    }
}
