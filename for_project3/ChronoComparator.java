package for_project3;

import java.util.Comparator;

public class ChronoComparator implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        Date o1 = p1.getDate();
        Date o2 = p2.getDate();
        int y1 = o1.getYear();
        int y2 = o2.getYear();
        Month m1 = o1.getMonth();
        Month m2 = o2.getMonth();
        int d1 = o1.getDay();
        int d2 = o2.getDay();

        if(Integer.compare(y1, y2) == 0) {
        	if(Integer.compare(m1.getNum(), m2.getNum()) == 0) {
        		if(Integer.compare(d1, d2) == 0) {
        			return 0;
                }else {
                	return Integer.compare(d1, d2);
                }
            }else {
            	return Integer.compare(m1.getNum(), m2.getNum());
            }
        }else {
        	return Integer.compare(y1, y2);
        }
    }
}

