
public class Circle extends Shape{
	public String text;
	Circle(String t)
	{	text=t;	}
	public void draw()
	{
		System.out.println("Circle: "+text);
	}
	public  void add(Circle c1) {
		System.out.println("Circle: "+c1.text);
		
	}

}
