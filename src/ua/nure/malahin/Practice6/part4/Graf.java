package ua.nure.malahin.Practice6.part4;


/**
 * Created by sergey on 15.06.16.
 */
public class Graf {

   private int[][] arrGraf;

    Graf(int numberRibs) {
	arrGraf = new int[numberRibs][numberRibs];
    }

    public void sumRibs(int rib1, int rib2) {
	add(rib1, rib2);
    }

    private void add(int x, int y) {
	if (x >= arrGraf.length || y >= arrGraf.length){
	    return;
	}
	if (x < 0 || y < 0){
	    return;
	}
	arrGraf[y][x] = 1;
	arrGraf[x][y] = 1;
    }

    public void delete(int x, int y) {
	if (x >= arrGraf.length || y >= arrGraf.length) {
	    return;
	}
	if (x < 0 || y < 0) {
	    return;
	}
	if (arrGraf[y][x] == 1) {
	    arrGraf[y][x] = 0;
	    arrGraf[x][y] = 0;
	}
    }
    
    public String toString(){
	StringBuilder sb = new StringBuilder();
	for (int[] is : arrGraf) {
	    for (int i : is) {
		sb.append(i).append(" ");
	    }
	    sb.append(System.lineSeparator());
	}
	
	return sb.toString();
    }

    public static void main(String[] args) {
	Graf g = new Graf(5);
	g.sumRibs(4, 3);
	g.sumRibs(2, 3);
	g.sumRibs(4, 4);
	System.out.println(g);
	g.delete(2, 3);
	System.out.println();
	System.out.println(g);
    }

}
