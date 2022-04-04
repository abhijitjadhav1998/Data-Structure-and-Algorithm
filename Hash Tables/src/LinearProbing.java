import java.util.Optional;

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
		int hashedValue = hashKey(key);
		int stopIndex = hashedValue;
		if (hashedValue == hashtable.length - 1) {
			hashedValue = 0;
		} else {
			hashedValue++;
		}
		System.out.println("before for loop");
		while (hashtable[hashedValue] != null && hashedValue != stopIndex && hashtable[hashedValue].key.equals(key)) {
			hashedValue = (hashedValue + 1) % hashtable.length;
		}
		System.out.println(hashedValue);
		if (hashedValue == stopIndex) {
			return null;
		} else {
			return hashtable[hashedValue].employee;
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
		Employee employee3 = new Employee(3, "Jadhav", "Saurabh");

		Employee employee2 = new Employee(2, "Ram", "Sharma");
		LinearHashFunction hashtable = new LinearHashFunction();
		hashtable.put(employee1.getLastName(), employee1);
		hashtable.put(employee3.getLastName(), employee3);

		hashtable.put(employee2.getLastName(), employee2);

		hashtable.printHashTable();
		System.out.println(hashtable.get(employee2.getLastName()));
	}

}
