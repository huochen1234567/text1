
public class Teacher extends CClass {
	public String name;
	public CClass class1;	
	public Teacher()
	{}
	public Teacher(String n,CClass c) {
		name=n;
		class1=c;		
	}
	void  modifyname(String n)
	{
		name=n;
	}
	void  modifyclass(CClass c)
	{
		class1=c;
	}
	void print()
	{
		System.out.println("Name:"+name+"  Class:"+class1.classnum);
	}
}
