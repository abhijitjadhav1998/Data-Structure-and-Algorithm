import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {

	private LinkedList<StoredEmployee>[] hashtable;

	public ChainedHashTable() {
		hashtable = new LinkedList[10];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<StoredEmployee>();
		}
	}

	public void put(String key, Employee employee) {
		int hashedValue = hashKey(key);
		hashtable[hashedValue].add(new StoredEmployee(key, employee));
	}

	public Employee get(String key) {
		int hashedValue = hashKey(key);
		ListIterator<StoredEmployee> iterator = hashtable[hashedValue].listIterator();
		StoredEmployee employee = null;
		while (iterator.hasNext()) {
			employee = iterator.next();
			if (employee.key.equals(key)) {
				break;
			}
		}
		if (employee == null) {
			return null;
		} else {
			return employee.employee;
		}
	}
	
	public Employee remove(String key) {
		int hashedValue = hashKey(key);
		ListIterator<StoredEmployee> iterator = hashtable[hashedValue].listIterator();
		StoredEmployee employee = null;
		int index = -1;
		while(iterator.hasNext()) {
			employee = iterator.next();
			index++;
			if(employee.key.equals(key)) {
				break;
			}
		}
		if(employee == null) {
			return null;
		}
		hashtable[hashedValue].remove(index);
		return employee.employee;
	}

	private int hashKey(String key) {
		//return key.length() % hashtable.length;
		return Math.abs(key.hashCode() % hashtable.length);
	}
	
	public void printHashTable() {

		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] == null) {
				System.out.println("empty");
			} else {
				ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
				while(iterator.hasNext()) {
					System.out.print(iterator.next().employee + " => ");
				}
				System.out.println("null");
			}
		}
	}

	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "Abhijit", "Jadhav");
		Employee employee2 = new Employee(2, "Ram", "Sharma");

		Employee employee3 = new Employee(3, "Jadhav", "Saurabh");
		Employee employee4 = new Employee(4, "Jadhav", "Saurabh1");
		Employee employee5 = new Employee(5, "Jadhav", "Saurabh11");
		Employee employee6 = new Employee(6, "Jadhav", "Saurabh11");

		ChainedHashTable hashtable = new ChainedHashTable();
		hashtable.put(employee1.getLastName(), employee1);
		hashtable.put(employee3.getLastName(), employee3);

		hashtable.put(employee2.getLastName(), employee2);
		hashtable.put(employee4.getLastName(), employee4);
		hashtable.put(employee5.getLastName(), employee5);
		hashtable.put(employee6.getLastName(), employee6);

		hashtable.printHashTable();
		System.out.println(hashtable.get(employee2.getLastName()));
		System.out.println(hashtable.remove(employee3.getLastName()));
		hashtable.printHashTable();
	}

}
