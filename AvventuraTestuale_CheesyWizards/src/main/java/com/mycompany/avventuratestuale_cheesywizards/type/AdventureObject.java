package com.mycompany.avventuratestuale_cheesywizards.type;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author nico0
 */
public class AdventureObject implements Serializable{
    
    private final int id;                   //rappresenta identificatore univoco dell'oggetto

    private String name;                    //nome dell'oggetto

    private String description;             //descrizione dell'oggetto

    private boolean openable;       //indica se l'oggetto può essere aperto

    private boolean pickupable ;      //indica se l'oggetto può essere raccolto

    private boolean usable;         //indica se l'oggetto può essere usato

    private boolean locked;         //indica se l'oggetto è chiuso a chiave

    private boolean movable;        //indica se l'oggetto può essere spostato
    
    private boolean observable;     //indica se l'oggetto può essere osservato
    
    private String path_image;      //path dell'immagine dell'oggetto

    /**
     * 
     * @param id
     * @param name
     * @param description
     * @param openable
     * @param pickupable
     * @param usable
     * @param locked
     * @param movable
     * @param observable
     * @param path_image 
     */
    public AdventureObject(int id, String name, String description, boolean openable, boolean pickupable, boolean usable, boolean locked, boolean movable, boolean observable, String path_image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openable = openable;
        this.pickupable = pickupable;
        this.usable = usable;
        this.locked = locked;
        this.movable = movable;
        this.observable = observable;
        this.path_image = path_image;
    }

    /**
     * 
     * @return 
     */
    public String getPath_image() {
        return path_image;
    }

    /**
     * 
     * @param path_image 
     */
    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpenable() {
        return openable;
    }

    /**
     * 
     * @param openable 
     */
    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    /**
     * 
     * @return 
     */
    public boolean isPickupable() {
        return pickupable;
    }

    /**
     * 
     * @param pickupable 
     */
    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    /**
     * 
     * @return 
     */
    public boolean isUsable() {
        return usable;
    }

    /**
     * 
     * @param usable 
     */
    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    /**
     * 
     * @return 
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * 
     * @param locked 
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * 
     * @return 
     */
    public boolean isMovable() {
        return movable;
    }

    /**
     * 
     * @param movable 
     */
    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    /**
     * 
     * @return 
     */
    public boolean isObservable() {
        return observable;
    }
    
    /**
     * 
     * @param observable 
     */
    public void setObservable(boolean observable) {
        this.observable = observable;
    }
    
    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param obj
     * @return 
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
        final AdventureObject other = (AdventureObject) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }
    
}

