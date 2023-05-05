package for_project3;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
	
	private int day;
	private int year; 
	private Month month;
	
	public Date(Month month, int day, int year) {
		
		if(year > 0) {
			if(Month.isValidDay(month, day)) {
				this.day = day;
				this.year = year;
				this.month = month;
			}
		}else {
			throw new IllegalArgumentException();
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(Month.isValidDay(month, day)){
			this.day = day;
		}else {
			throw new IllegalArgumentException(); 
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year > 0) {
			this.year = year;
		}else {
			throw new IllegalArgumentException(); 
		}
	}

	@Override
	public String toString() {
		return month + " " + day + ", " + year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	} 
	
	
	
}
