package week2.day4.singleton;

class MySingleton2 {
	private static MySingleton2 obj = null;
	private MySingleton2() {
		
	}
	static synchronized MySingleton2 getMy() {
		if (obj == null) {
			synchronized (MySingleton2.class){
				obj = new MySingleton2();
			}
		}
		return obj;
	}
	void printMyName() {
		System.out.println("유니코");	
	}
	void printFavoriteFood() {
		System.out.println("떡볶이");	
	}
}
public class MySingletonTest2 {
	public static void main(String[] args) {
		//MySingleton my = new MySingleton();
		MySingleton2 my = MySingleton2.getMy();
		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);
		System.out.println(MySingleton2.getMy());
		System.out.println(MySingleton2.getMy());
	}
}
