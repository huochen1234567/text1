
public class Student extends CClass{

	public int grade=0;
	public String name;
	public CClass class1;
	public Student()
	{}
	public Student(String n,CClass c,int g) {
		name=n;
		class1=c;
		grade=g;
	}
	void  modifyname(String n)
	{
		name=n;
	}
	void  modifyclass(CClass c)
	{
		class1=c;
	}
	void  modifygrade(int g)
	{
		grade=g;
	}
	void print()
	{
		System.out.println("Name:"+name+"  Class:"+class1.classnum+"   Grade:"+grade);
	}
	
	
}
