package com.mycompany.avventuratestuale_cheesywizards.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nico0
 */
public class AdventureObjectContainer extends AdventureObject {

    private List<AdventureObject> list = new ArrayList<>();         //lista degli oggetti contenuti all'interno dell'oggetto container
    
    /**
     * 
     * @param id 
     */
    public AdventureObjectContainer(int id) {
        super(id);
    }

    /**
     * 
     * @param id
     * @param name
     * @param description
     * @param alias 
     */
    public AdventureObjectContainer(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
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
