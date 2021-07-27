import java.util.Date;

public class LearnComparator {
    public static void main(String args[]) {
        Date d1 = new Date(2021, 10, 5);
        Date d2 = new Date(2021, 8, 5);

        int compareValue = d1.compareTo(d2);
        System.out.println("Higher date(10/5/2021) compared to lower date(8/5/2021):"+compareValue);
        compareValue = d2.compareTo(d1);
        System.out.println("Lower date(8/5/2021) compared to higher date(10/5/2021):"+compareValue);
        d2 = new Date(2021, 10, 5);
        compareValue = d1.compareTo(d2);
        System.out.println("Same date:"+compareValue);
        Date d3 = new Date();
        System.out.println("New date gives the current timestamp:"+d3);
        d2 = null;
        compareValue = d2.compareTo(d1);
        System.out.println("If input to compareTo is null:"+compareValue);

    }
}
