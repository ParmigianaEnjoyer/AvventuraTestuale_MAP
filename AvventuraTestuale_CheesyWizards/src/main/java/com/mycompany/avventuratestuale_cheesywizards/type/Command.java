package com.mycompany.avventuratestuale_cheesywizards.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author nico0
 */
public class Command {
    
    private final CommandType type;         //specifica il tipo di comando

    private final String name;              //nome del comando

    private Set<String> alias;              //insieme di alias del comando

    /**
     * 
     * @param type
     * @param name 
     */
    public Command(CommandType type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 
     * @param type
     * @param name
     * @param alias 
     */
    public Command(CommandType type, String name, Set<String> alias) {
        this.type = type;
        this.name = name;
        this.alias = alias;
    }

    /**
     * 
     * @return 
     */
    public Set<String> getAlias() {
        return alias;
    }

    /**
     * 
     * @param alias 
     */
    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

    /**
     *
     * @param alias
     */
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    /**
     * 
     * @return 
     */
    public CommandType getType() {
        return type;
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
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.type);
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
        final Command other = (Command) obj;
        if (this.type != other.type) {
            return false;
        }
        return true;
    }
}
