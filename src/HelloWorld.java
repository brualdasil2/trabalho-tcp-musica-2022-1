
public class HelloWorld {

	public static void main(String[] args) {
		Human person = new Human("Joel", 44);
		person.sayName();
		if (person.canDrink()) {
			System.out.println(person.getName() + " can drink!");
		}
		else {
			System.out.println(person.getName() + " is too young to drink!");
		}
	}
}
//Pedro conseguiu utilizar o github
//Leo tambem conseguiu