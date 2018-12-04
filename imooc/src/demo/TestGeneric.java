package demo;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	
	public List<Course> courses;
	public TestGeneric() {
		this.courses = new ArrayList<Course>();
		
	}
	public void testAdd() {
		Course cr1 =new Course("1","大学物理");
		courses.add(cr1);
		Course cr2 =new Course("2","java基础");
		courses.add(cr2);
	}
	public void testForEach() {
		System.out.println("FouEach");
		for(Course cr:courses) {			
			System.out.println("课程"+cr.id+":"+cr.name);
		}
	}
	

	public static void main(String[] args) {
	TestGeneric tg = new TestGeneric();
	tg.testAdd();
	tg.testForEach();

	}

}
