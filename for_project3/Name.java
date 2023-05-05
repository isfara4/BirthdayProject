package for_project3;

import java.io.Serializable;
import java.util.Objects;

public class Name implements Serializable, Comparable<Name> {
/*
 * Write the Name class:

A Name should consist of three Strings: first, middle, and last.
You should be able to construct a Name in two ways (two constructors): with and without a middle name.
Use Eclipse to generate standard getters and setters for all three instance variables.
Use Eclipse to generate the equals() and hashCode() method to use your three instance variables.  
Override the inherited toString() to return the Name String in two possible formats: for example "Kristin Alise Jones" or "Kristin Jones" depending on whether the middle name is empty or not.
Make Name serializable.  Ignore the serialVersionID warning.
 */
	
	private String first;
	private String middle; 
	private String last;
	
	public Name(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	} 
	
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, last, middle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last)
				&& Objects.equals(middle, other.middle);
	}

	@Override
	public String toString() {
		if (middle!=null) {
		return first + " " + middle + " " + last;
		}
		return first + " " + last;
	} 
	
    public int compareTo(Name other) {
 
            if (last.compareTo(other.last) != 0) {
                return last.compareTo(other.last);
            } else if (first.compareTo(other.first) != 0) {
                return first.compareTo(other.first);
            } else if (middle == null && other.middle == null) {
                return 0;
            } else if (middle == null) {
                return -1;
            } else if (other.middle == null) {
                return 1;
            } else {
                return middle.compareTo(other.middle);
            }
    }
}
	
	

