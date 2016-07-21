package ua.nure.malahin.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Root container. Implements the Knife entity.
 * 
 * @author S.Malahin
 * 
 */
public class Weapon {
    private String type;
    private int handy;
    private String origin;
    
    private List<Knife> knifes;
    
    public Weapon(){
	knifes = new ArrayList<>();
    }
    
    public List<Knife> getKnifes(){
	return knifes;
    }
    
    public void add(Knife knife){
	knifes.add(knife);
    }
    
    @Override
    public String toString() {
     
        return knifes.toString();
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHandy() {
        return handy;
    }

    public void setHandy(int handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
