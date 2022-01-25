
public class Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayName() {
		System.out.println("Hi, my name is " + name + "!");
	}
	
	public boolean canDrink() {
		return age >= 18;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void incrementAge() {
		age += 1;
	}
}
