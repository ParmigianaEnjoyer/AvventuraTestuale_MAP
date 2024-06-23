package com.mycompany.avventuratestuale_cheesywizards.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nico0
 */
public class AdventureObjectContainer extends AdventureObject implements Serializable{

    private List<AdventureObject> list;       //lista degli oggetti contenuti all'interno dell'oggetto container

    /**
     * 
     * @param list
     * @param id
     * @param name
     * @param description
     * @param alias
     * @param openable
     * @param pickupable
     * @param usable
     * @param locked
     * @param movable
     * @param observable 
     */
    public AdventureObjectContainer(int id, String name, String description, Set<String> alias, boolean openable, boolean pickupable, boolean usable, boolean locked, boolean movable, boolean observable, List<AdventureObject> list) {
        super(id, name, description, alias, openable, pickupable, usable, locked, movable, observable);
        this.list = list;
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
