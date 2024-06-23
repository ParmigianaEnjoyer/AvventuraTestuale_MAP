package com.mycompany.avventuratestuale_cheesywizards.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nico0
 */
public class Room implements Serializable{
    
    private final int id;               //identificatore univoco della stanza

    private String name;                //nome della stanza

    private String description;         //descrizione della stanza

    private String look;                //descrizione degli oggetti che si vedono nella stanza

    private Room south;          //indica se è collegata a un'altra stanza a SUD

    private Room north;          //indica se è collegata a un'altra stanza a NORD

    private Room east;          //indica se è collegata a un'altra stanza a EST

    private Room west;          //indica se è collegata a un'altra stanza a OVEST

    private List<AdventureObject> objects;        //lista di tutti gli oggetti contenuti all'interno della stanza

    public Room(int id, String name, String description, String look, Room south, Room north, Room east, Room west, List<AdventureObject> objects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.look = look;
        this.south = south;
        this.north = north;
        this.east = east;
        this.west = west;
        this.objects = objects;
    }

    /**
     * 
     * @param id 
     */
    public Room(int id) {
        this.id = id;
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

    /**
     * 
     * @return 
     */
    public String getLook() {
        return look;
    }

    /**
     * 
     * @param look 
     */
    public void setLook(String look) {
        this.look = look;
    }

    /**
     * 
     * @return 
     */
    public Room getSouth() {
        return south;
    }

    /**
     * 
     * @param south 
     */
    public void setSouth(Room south) {
        this.south = south;
    }

    /**
     * 
     * @return 
     */
    public Room getNorth() {
        return north;
    }

    /**
     * 
     * @param north 
     */
    public void setNorth(Room north) {
        this.north = north;
    }

    /**
     * 
     * @return 
     */
    public Room getEast() {
        return east;
    }

    /**
     * 
     * @param east 
     */
    public void setEast(Room east) {
        this.east = east;
    }

    /**
     * 
     * @return 
     */
    public Room getWest() {
        return west;
    }

    /**
     * 
     * @param west 
     */
    public void setWest(Room west) {
        this.west = west;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public AdventureObject getObject(int id) {
        for (AdventureObject o : objects) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
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
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
