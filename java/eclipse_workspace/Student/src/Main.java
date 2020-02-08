import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		CClass class1=new CClass(1);
		CClass class2=new CClass(2);
		Teacher t1=new Teacher("zhangtan",class1);
		Teacher t2=new Teacher("liti",class1);
		t1.print();
		t1.modifyname("wangwu");
		t1.print();
		t2.modifyclass(class2);
		Course course1=new Course("IS",class1);
		course1.add("Englishi-1", "Englishi-2", "Englishi-3", "Englishi-4");
		course1.print();
		course1.dele(1);
		course1.print();
		Student s1=new Student("zhangsan",class1,4);
		s1.print();
		if(s1.grade==04)
			System.out.println("Student1：已满足毕业条件！");
		else
			System.out.println("Student1：未满足毕业条件！");
		Student s2=new Student("lisi",class1,4);
		Student s3=new Student("wangwu",class1,4);
		s2.print();
		s3.print();
		
		
	}

}

