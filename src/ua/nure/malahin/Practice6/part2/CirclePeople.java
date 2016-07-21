package ua.nure.malahin.Practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sergey on 15.06.16.
 */
public class CirclePeople {
    private List<People> arrPeople;
    private List<People> listPeople;

    public CirclePeople(int numberPeople) {
	arrPeople = new ArrayList<People>();
	listPeople = new LinkedList<People>();

	createPeople(numberPeople);
    }

    private void createPeople(int numberPeople) {
	for (int i = 0; i < numberPeople; i++) {
	    arrPeople.add(new People("people" + (i + 1)));
	    listPeople.add(new People("people" + (i + 1)));
	}
    }

    public void deleteLinkedListPeople(int k) {
	Iterator<People> iter = listPeople.iterator();
	int tmp = 0;
	int index = 1;

	while (listPeople.size() > 0) {
	    if (listPeople.size() == 1) {
		break;
	    }
	    while (iter.hasNext()) {
		if (tmp >= listPeople.size()) {
		    tmp = 0;
		    iter = listPeople.iterator();
		}
		if (index == k && listPeople.size() > 0) {

		    iter.next();
		    iter.remove();
		    index = 1;
		    break;

		}
		iter.next();
		tmp++;
		index++;
	    }
	    if (tmp >= listPeople.size()) {
		tmp = 0;
		iter = listPeople.iterator();
	    }
	}
    }

    public void deleteArrayListPeople(int k) {
	int tmp = 0;
	int index = 1;
	while (arrPeople.size() > 1) {
	    if (tmp >= arrPeople.size()) {
		tmp = 0;
	    }
	    if (index == k) {
		arrPeople.remove(tmp);
		index = 1;
		continue;
	    }
	    tmp++;
	    index++;
	}
    }

    public List<People> getArrPeople() {
	return arrPeople;
    }

    public void setArrPeople(List<People> arrPeople) {
	this.arrPeople = arrPeople;
    }

    public List<People> getListPeople() {
	return listPeople;
    }

    public void setListPeople(List<People> listPeople) {
	this.listPeople = listPeople;
    }

    public static void main(String[] args) {

	CirclePeople cp = new CirclePeople(500);
	int position = 3;
	long time = System.currentTimeMillis();
	cp.deleteArrayListPeople(position);
	System.out.println("Array People Time is : " + (System.currentTimeMillis() - time));
	System.out.println(cp.getArrPeople());

	time = System.currentTimeMillis();
	cp.deleteLinkedListPeople(position);
	System.out.println("Linked People Time is : " + (System.currentTimeMillis() - time));
	System.out.println(cp.getListPeople());

    }
}
