package week2.day4.singleton;

class MySingleton3 {
	private static MySingleton3 obj = new MySingleton3();
	private MySingleton3() {}

	private static class MySingleton3Holder{
		private static final MySingleton3  mySingleton3 = new MySingleton3();
	}

	static MySingleton3 getMy() {
		return MySingleton3Holder.mySingleton3;
	}

	void printMyName() {
		System.out.println("유니코");	
	}
	void printFavoriteFood() {
		System.out.println("떡볶이");	
	}
}
public class MySingletonTest3 {
	public static void main(String[] args) {
		//MySingleton my = new MySingleton();
		MySingleton3 my = MySingleton3.getMy();
		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);
		System.out.println(MySingleton3.getMy());
		System.out.println(MySingleton3.getMy());
	}
}
