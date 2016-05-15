package ua.nure.malahin.Practice1;

public class Demo {
    public static void main(String[] args) {
//n,f,r,t
//        48 69 0a d0 9f d1 80 0a
        System.out.println("\u0048\u0069\n\u00d0\u009f\u00d1\u0080");
        System.out.println("Part 1");
        Hello.main(new String[]{});
        System.out.println("\nPart 2");
        Sum.main(new String[]{"2", "3"});

        System.out.println("\nPart 3");
        Nod.main(new String[]{"108", "44"});

        System.out.println("\nPart 4");
        DigitsSum.main(new String[]{"45915", "123", "849"});

        System.out.println("\nPart 5");
        Spreadsheet.main(new String[] {"836" , "AFD", "BE"});
    }
}
