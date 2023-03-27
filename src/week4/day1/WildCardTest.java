package week4.day1;
import java.util.Date;
class Person {
}
class Worker extends Person {
}
class NewWorker extends Worker {
}
class Student extends Person {
}
class HighStudent extends Student {
}
class MiddleStudent extends Student{
}

class My<T> {
	T obj;
	My(T obj) {
		this.obj = obj;
	}
	public String toString() {
		return obj.getClass().getName()+"객체임";
	}
}
public class WildCardTest {
	static void m1(My<?> p) {
		System.out.println(p);
	}
	static void m2(My<? extends Student> p) {
		System.out.println(p);
	}
	static void m3(My<? super Worker> p) {
		System.out.println(p);
	}
	public static void main(String[] args) {
		m1(new My<Date>(new Date()));		//Date객체임
		m1(new My<String>("abc"));		//String객체임
		m1(new My<Integer>(100));		//Integer객체임
		m1(new My<Person>(new Person()));		//Person객체임
		m1(new My<Worker>(new Worker()));		//Worker객체임
		m1(new My<Student>(new Student()));		//Student객체임
		m1(new My<HighStudent>(new HighStudent()));		//HighStudent객체임
		m1(new My<MiddleStudent>(new MiddleStudent()));		//MiddleStudent객체임
		System.out.println("-----------------------");
		m2(new My<Student>(new Student()));  // Student 객체임
		m2(new My<HighStudent>(new HighStudent()));  // HighStudent 객체임
		m2(new My<MiddleStudent>(new MiddleStudent()));  // MiddleStudent 객체임
		//m2(new My<>(100));
		//m2(new My<>(new Person()));
		//m2(new My<>(new Worker()));
		System.out.println("-----------------------");		
		m3(new My<Person>(new Person())); // Person 객체임
		m3(new My<Worker>(new Worker())); // Worker 객체임
		m3(new My<Object>(new Object())); // Object 객체임
		//m3(new My<Student>(new Student()));
		//m3(new My<HighStudent>(new HighStudent()));
		//m3(new My<NewWorker>(new NewWorker()));
	}
}
