package for_project3;
import java.io.EOFException;
import java.io.*;

public class PersonList {
	
	private LinkedList<Person> list;
	
	public PersonList() {
		list = new LinkedList<Person>();
	}
	
	public boolean add(Person p){

		if(!list.contains(p)) {
			list.add(p);
			return true;
		}
		return false;
	}



	public boolean addAlpha(Person p) {

		if(!list.contains(p)) {
			list.addAlpha(p);
			return true;
		}
		return false;

	}
	
	public Person search(Person p) {
        if (list.contains(p)) {
            return p;
        } else {
            return null;
        }
    }
	
	public String saveToFile(String fileName) {
		 String messageFromSave = "";
		 try {
		   ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
		   for(int i = 0; i < list.size(); i++) {
		    oOS.writeObject(list.get(i));
		   }
		   oOS.flush();
		   oOS.close();
		 }catch(Exception e) {
		   messageFromSave = e.toString();
		 }
		  return messageFromSave;
		}

		public String loadFromFile(String fileName) {
		  String toReturn = ""; 
		  try{
		     ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
		     while(oIS.available() > -1) {
		       Person fromFile = (Person)(oIS.readObject());
		       Person found = search(fromFile);
		       if(found == null) {
		         if(add(fromFile)) {
		             toReturn += fromFile + "\n";
		        }else {
		             toReturn += fromFile + " not successfully added to DB.\n";
		        }
		      }else {
		        toReturn += found + " already in the DB.\n";
		      }
		   }
		   oIS.close();
		   }catch (EOFException eOF){
		   }
		   catch(Exception e) {
		      toReturn += e;
		   }
		   return toReturn;
		}
		
		public boolean delete(Name n) {
		    MyListIterator<Person> iterator = (MyListIterator<Person>) list.iterator();
		    while (iterator.hasNext()) {
		        Person p = iterator.next();
		        if (p.getName().equals(n)) {
		            iterator.remove();
		            return true;
		        }
		    }
		    return false;
		}
		
		public String hasBirthdayOn(Date date) {
	        for (Person p : list) {
	            if(p.getDate().equals(date)){
	                return p.toString();
	            }
	        }
	        return "Nobody has a birthday on that date.";
	    }
	
		
		public String printList() {
			String toReturn = "";
			for(Person p: list) {
				toReturn+= p.toString();
				}
			return toReturn;
		}
		
		public String sortAlphab() {
			return printList();
		}
		
		public String sortChronol() {
		    LinkedList<Person> sortedList = new LinkedList<>(new ChronoComparator());
		    for (Person p : list) {
		        sortedList.add(p);
		    }
		    sortedList.sort();
		    String toReturn = "";
		    for (Person p : sortedList) {
		        toReturn += p.toString();
		    }
		    return toReturn;
		}
		
		public String findPersonByName(Name name) {
			for(Person p: list) {
				if(p.getName().compareTo(name) == 0) {
					return p.toString();
				}
			}
			return "Person was not found.";
		}
		
}
