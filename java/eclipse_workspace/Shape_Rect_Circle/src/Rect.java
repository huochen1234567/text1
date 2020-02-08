
public class Rect extends Shape{
	public String text;
	Rect(String t)
	{	text=t;	}
	public void draw()
	{
		System.out.println("Rect: "+text);
	}
	public  void add(Rect c1) {
		System.out.println("Rect: "+c1.text);
		
	}


}
