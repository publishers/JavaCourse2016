package ua.nure.malahin.SummaryTask3.util;

import java.util.Collections;
import java.util.Comparator;

import ua.nure.malahin.SummaryTask3.entity.Knife;
import ua.nure.malahin.SummaryTask3.entity.Weapon;

/**
 * Contains static methods for sorting.
 * 
 * @author S.Malahin
 * 
 */
public class Sorter {

    // //////////////////////////////////////////////////////////
    // these are comparators
    // //////////////////////////////////////////////////////////

    /**
     * Sorts Knifes by Knife type
     */
    public static final Comparator<Knife> SORT_KNIFES_BY_TYPE = new Comparator<Knife>() {
	@Override
	public int compare(Knife o1, Knife o2) {
	    return o1.getType().compareTo(o2.getType());
	}
    };

    /**
     * Sorts knifes by origin.
     */
    public static final Comparator<Knife> SORT_KNIFE_BY_ORIGIN = new Comparator<Knife>() {
	@Override
	public int compare(Knife o1, Knife o2) {
	    return o1.getOrigin().compareTo(o2.getOrigin());
	}
    };

    /**
     * Sorts knifes by visual size.
     */
    public static final Comparator<Knife> SORT_KNIFE_BY_VISUAL_SIZE = new Comparator<Knife>() {
	@Override
	public int compare(Knife o1, Knife o2) {
	    return o1.getVisual().getSize() - o2.getVisual().getSize();
	}
    };

    /**
     * Sorts knifes by visual width.
     */
    public static final Comparator<Knife> SORT_KNIFE_BY_VISUAL_WIDTH = new Comparator<Knife>() {
	@Override
	public int compare(Knife o1, Knife o2) {
	    return o1.getVisual().getWidth() - o2.getVisual().getWidth();
	}
    };

    /**
     * Sorts knifes by handy.
     */
    public static final Comparator<Knife> SORT_KNIFE_BY_HANDY = new Comparator<Knife>() {
	@Override
	public int compare(Knife o1, Knife o2) {
	    return o1.getHandy() - o2.getHandy();
	}
    };
    // //////////////////////////////////////////////////////////
    // these methods take Weapon object and sort it
    // with according comparator
    // //////////////////////////////////////////////////////////

    /**
     * @param weapon
     * 		sort Weapon by handy
     * */
    public static final void sortKnifesByHandy(Weapon weapon) {
	Collections.sort(weapon.getKnifes(), SORT_KNIFE_BY_HANDY);
    }
    /**
     * @param weapon
     * 		sort Weapon by origin
     * */
    public static final void sortKnifesByOrigin(Weapon weapon) {
	Collections.sort(weapon.getKnifes(), SORT_KNIFE_BY_ORIGIN);
    }
    /**
     * @param weapon
     * 		sort Weapon by Size
     * */
    public static final void sortKnifesByVisualSize(Weapon weapon) {
	Collections.sort(weapon.getKnifes(), SORT_KNIFE_BY_VISUAL_SIZE);
    }
    /**
     * @param weapon
     * 		sort Weapon by width
     * */
    public static final void sortKnifesByVisualWidth(Weapon weapon) {
	Collections.sort(weapon.getKnifes(), SORT_KNIFE_BY_VISUAL_WIDTH);
    }
    /**
     * @param weapon
     * 		sort Weapon by type
     * */
    public static final void sortKnifesByType(Weapon weapon) {
	Collections.sort(weapon.getKnifes(), SORT_KNIFES_BY_TYPE);
    }
   
}