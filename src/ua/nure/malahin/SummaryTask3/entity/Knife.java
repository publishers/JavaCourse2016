package ua.nure.malahin.SummaryTask3.entity;

/**
 * Implements data Knife entity.
 * 
 * @author S.Malahin
 * 
 */
public class Knife extends Weapon{
    
    private Visual visual;
    
    private boolean value;
   
    public Visual getVisual() {
        return visual;
    }

    public void setVisual(Visual visual) {
        this.visual = visual;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
    
    @Override
    public String toString() {     
        return new StringBuilder()
        	.append("[")
                	.append(getType()).append(";")
                	.append(getHandy()).append(";")
                	.append(getOrigin()).append(";")
                	.append(getVisual()).append(";")
                	.append(getValue())
        	.append("]").toString();
    }
  
    
}
