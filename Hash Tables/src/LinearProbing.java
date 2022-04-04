
class StoredEmployee {
	public String key;
	public Employee employee;

	public StoredEmployee(String key, Employee employee) {
		super();
		this.key = key;
		this.employee = employee;
	}
}

class LinearHashFunction {
	private StoredEmployee[] hashtable;

	public LinearHashFunction() {
		super();
		hashtable = new StoredEmployee[10];
	}

	public void put(String key, Employee employee) {
		StoredEmployee storedEmployee = new StoredEmployee(key, employee);
		int hashedValue = hashKey(key);
		if (isOccupied(hashedValue)) {
			int stopIndex = hashedValue;
			if (hashedValue == hashtable.length - 1) {
				hashedValue = 0;
			} else {
				hashedValue++;
			}
			System.out.println("before for loop");
			while (isOccupied(hashedValue) == true && hashedValue != stopIndex) {
				hashedValue = (hashedValue + 1) % hashtable.length;
			}

		}
		hashtable[hashedValue] = storedEmployee;

	}

	public boolean isOccupied(int hashedValue) {
		return hashtable[hashedValue] != null;
	}

	public Employee get(String key) {
		int hashedValue = getHashedPostion(key);
		if (hashedValue == -1) {
			return null;
		} else {
			return hashtable[hashedValue].employee;
		}

	}

	public Employee remove(String key) {
		int hashedValue = getHashedPostion(key);
		if (hashedValue == -1) {
			return null;
		}
		Employee employee = hashtable[hashedValue].employee;
		hashtable[hashedValue] = null;
		rehashingtable();
		return employee;

	}
	
	private void rehashingtable() {
		StoredEmployee oldHashtable[] = hashtable;
		hashtable = new StoredEmployee[oldHashtable.length];
		for(int i=0;i<oldHashtable.length;i++) {
			if(oldHashtable[i] != null) {
				put(oldHashtable[i].key, oldHashtable[i].employee);
			}
		}
	}

	public int getHashedPostion(String key) {
		int hashedValue = hashKey(key);
		if (hashtable[hashedValue] != null && hashtable[hashedValue].key.equals(key)) {
			return hashedValue;
		}
		int stopIndex = hashedValue;
		if (hashedValue == hashtable.length - 1) {
			hashedValue = 0;
		} else {
			hashedValue++;
		}
		while (hashtable[hashedValue] != null && hashedValue != stopIndex
				&& hashtable[hashedValue].key.equals(key) == false) {
			hashedValue = (hashedValue + 1) % hashtable.length;

		}

		if (hashtable[hashedValue] != null && hashtable[hashedValue].key.equals(key)) {
			return hashedValue;
		} else {
			return -1;
		}
	}

	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}

	public void printHashTable() {

		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] == null) {
				System.out.println("empty");
			} else {
				System.out.println(hashtable[i].employee);
			}
		}
	}

}

public class LinearProbing {

	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "Abhijit", "Jadhav");
		Employee employee2 = new Employee(2, "Ram", "Sharma");

		Employee employee3 = new Employee(3, "Jadhav", "Saurabh");

		LinearHashFunction hashtable = new LinearHashFunction();
		hashtable.put(employee1.getLastName(), employee1);
		hashtable.put(employee3.getLastName(), employee3);

		hashtable.put(employee2.getLastName(), employee2);

		hashtable.printHashTable();
		System.out.println(hashtable.get(employee2.getLastName()));
		System.out.println(hashtable.remove(employee3.getLastName()));
		hashtable.printHashTable();


	}

}
