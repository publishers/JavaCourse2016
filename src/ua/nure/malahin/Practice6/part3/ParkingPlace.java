package ua.nure.malahin.Practice6.part3;

import java.util.Arrays;

/**
 * Created by sergey on 15.06.16.
 */
public class ParkingPlace {
    private int [] parkingPlace = new int[10];
    private int setNumberPlace;

    private void findPlace() {
        int randomPlace = (int) (Math.random() * parkingPlace.length);
        boolean markPlace = false;
        for (int i = randomPlace; i < parkingPlace.length; i++) {
            if(parkingPlace[i] == 0){
                parkingPlace[i] = 1;
                markPlace = true;
                break;
            }
        }
        if(!markPlace){
            for (int i = 0; i < randomPlace; i++) {
                if(parkingPlace[i] == 0){
                    parkingPlace[i] = 1;
                    break;
                }
            }
        }
    }

    public void come(){
        if(setNumberPlace<10) {
            findPlace();
            setNumberPlace++;
        }else{
            System.out.println("parking place is full");
        }
    }

    public void goOut(){

        if(setNumberPlace>0){
            int randomPlace = (int) (Math.random() * parkingPlace.length);
            int rememberPlase = randomPlace;
            while(parkingPlace[rememberPlase] != 1){
                rememberPlase =  (int) (Math.random() * parkingPlace.length);
            }
            parkingPlace[rememberPlase] = 0;
            setNumberPlace--;
        }else{
            System.out.println("Parking place is empty");
        }

    }

    public static void main(String[] args) {
        ParkingPlace pp = new ParkingPlace();
        System.out.println(pp);
        for (int i = 0; i < 10; i++) {
            pp.come();
            System.out.println(pp);
        }
        for (int i = 0; i < pp.parkingPlace.length; i++) {
            pp.goOut();
            System.out.println(pp);
        }
    }

    @Override
    public String toString() {
        return  Arrays.toString(parkingPlace);
    }
}
