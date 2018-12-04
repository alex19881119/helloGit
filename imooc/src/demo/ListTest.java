package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;



public class ListTest {
	private ArrayList coursesToSelect;
	//public List coursesToSelect=new ArrayList();
	public ListTest() {
		this.coursesToSelect=new ArrayList();
	}
	public void testAdd() {
		Course cr1=new Course("1","数据结构");
		coursesToSelect.add(cr1);
		Course temp=(Course)coursesToSelect.get(0);
		System.out.println("添加了课程:"+temp.id+temp.name);
		
		Course cr2=new Course("2","C语言");
		coursesToSelect.add(0, cr2);
		Course temp2=(Course)coursesToSelect.get(0);
		System.out.println("添加了课程:"+temp2.id+temp2.name);
		
		coursesToSelect.add(cr1);
		Course temp0=(Course)coursesToSelect.get(2);
		System.out.println("添加了课程:"+temp0.id+temp0.name);
		
//		数组下表越界
//		Course cr3=new Course("3","java");
//		coursesToSelect.add(4, cr3);
		Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3=(Course)coursesToSelect.get(3);
		Course temp4=(Course)coursesToSelect.get(4);
		System.out.println("添加了两门课程："+ temp3.id+temp3.name+";"+temp4.id+temp4.name);
		
		Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5=(Course)coursesToSelect.get(2);
		Course temp6=(Course)coursesToSelect.get(3);
		System.out.println("添加了两门课程："+ temp5.id+temp5.name+";"+temp6.id+temp6.name);
	}
	public void testGet() {
		int size=coursesToSelect.size();
		System.out.println("有如下课程可选");
		for(int i=0;i<size;i++) {
			Course cr=(Course)coursesToSelect.get(i);
			System.out.println("课程"+cr.id+":"+cr.name);
		}		
	}
	public void testIterator() {
		Iterator it=coursesToSelect.iterator();
		System.out.println("迭代器");
		while(it.hasNext()) {
		Course cr = (Course) it.next();
		System.out.println("课程"+cr.id+":"+cr.name); 
			}
	}
	public void testForEach() {
		System.out.println("FouEach");
		for(Object obj:coursesToSelect) {
			Course cr=(Course) obj;
			System.out.println("课程"+cr.id+":"+cr.name);
		}
	}
	public void testModify() {
		coursesToSelect.set(4,new Course("7","毛概"));
	}
	public void testRemove() {
		//Course cr = (Course) coursesToSelect.get(4);
		System.out.println("即将删除4和5位置上的课程");
		//coursesToSelect.remove(4);
		Course[] courses = {(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		System.out.println("成功删除");
		coursesToSelect.removeAll(Arrays.asList(courses));
		testForEach();
	}
	
	public void testType() {
		System.out.println("能否往list中添加一些奇怪的东西呢？");
		coursesToSelect.add("我不是课程我是字符串");
	}
 public static void main(String[] args) {
	ListTest lt=new ListTest();
	lt.testAdd();
	lt.testType();
	lt.testForEach();
//	lt.testGet();
//	lt.testIterator();
//	lt.testForEach();
//	lt.testModify();
//	lt.testForEach();
//	lt.testRemove();
}
}
