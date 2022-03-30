
class HashFunction{
	private Employee[] hashtable;

	public HashFunction() {
		super();
		hashtable = new Employee[10]; 
	}
	
	public void put(String key, Employee employee) {
		int hashedValue = hashKey(key);
		if(hashtable[hashedValue] != null) {
			System.out.println("Already there is a entry will not be able to add new");
		}else {
			hashtable[hashedValue] = employee;
		}
	}
	
	public Employee get(String key) {
		int hashedValue = hashKey(key);
		if(hashtable[hashedValue] == null) {
			System.out.println("No entry found with the key");
		}else {
			return hashtable[hashedValue];
		}
		return null;
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	public void printHashTable() {
		for (int i = 0; i < hashtable.length; i++) {
			System.out.println(hashtable[i]);
		}
	}
	
	
}

public class SimpleHashTable {

	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "Abhijit", "Jadhav");
		Employee employee2 = new Employee(2, "Ram", "Sharma");
		Employee employee3 = new Employee(3,"Jadhav","Saurabh");
		HashFunction hashtable = new HashFunction();
		hashtable.put(employee1.getLastName(), employee1);
		hashtable.put(employee2.getLastName(), employee2);
		hashtable.put(employee3.getLastName(), employee3);
		hashtable.printHashTable();
		System.out.println(hashtable.get(employee1.getLastName()));
		
	}

}
