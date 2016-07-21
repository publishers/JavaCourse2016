package ua.nure.malahin.SummaryTask3.entity;

/**
 * Implements haft knife
 * 
 * @author S.Malahin
 * 
 */
public class Haft {

    private String typeHaft;
    
    private String typeWood;

    public String getTypeHaft() {
        return typeHaft;
    }

    public void setTypeHaft(String typeHaft) {
        this.typeHaft = typeHaft;
    }

    public String getTypeWood() {
        return typeWood;
    }

    public void setTypeWood(String typeWood) {
        this.typeWood = typeWood;
    }    
    
    @Override
    public String toString() {       
        return new StringBuilder().append("[").append(typeWood).append(";").append(typeHaft).append("]").toString();
    }
    
}
