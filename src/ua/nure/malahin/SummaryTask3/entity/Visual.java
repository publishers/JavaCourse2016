package ua.nure.malahin.SummaryTask3.entity;

/**
 * Implements the Visual entity for a knife.
 * 
 * @author S.Malahin
 * 
 */
public class Visual {
    	private int width;
    	private int size;
    	private String material;
    	private Haft haft;
    	private boolean krovostok;
    	
	public Visual(int width, int size, String material, Haft haft, boolean krovostok) {
	    super();
	    this.width = width;
	    this.size = size;
	    this.material = material;
	    this.haft = haft;
	    this.krovostok = krovostok;
	}

	public Visual() {
	   
	}

	public int getWidth() {
	    return width;
	}

	public void setWidth(int width) {
	    this.width = width;
	}

	public int getSize() {
	    return size;
	}

	public void setSize(int size) {
	    this.size = size;
	}

	public String getMaterial() {
	    return material;
	}

	public void setMaterial(String material) {
	    this.material = material;
	}

	public Haft getHaft() {
	    return haft;
	}

	public void setHaft(Haft haft) {
	    this.haft = haft;
	}

	public boolean getKrovostok() {
	    return krovostok;
	}

	public void setKrovostok(boolean krovostok) {
	    this.krovostok = krovostok;
	}
    	
	@Override
	public String toString() {
	
	return new StringBuilder().append("[")
		.append(getWidth()).append(";")
		.append(getSize()).append(";")
		.append(getMaterial()).append(";")
		.append(getHaft()).append(";")
		.append(getKrovostok()).append("]").toString();
	}
    	
}
