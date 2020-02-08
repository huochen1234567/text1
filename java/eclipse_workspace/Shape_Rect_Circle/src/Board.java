import java.util.ArrayList;
import java.util.List;


public class Board {
	/*public List<Rect> Rects;
	public List<Circle> Circles;
	*/
	public List<Shape> Shapes;
	public Board()
	{
		/*Rects=new ArrayList<Rect>();
		Circles=new ArrayList<Circle>();
		*/
		Shapes=new ArrayList<Shape>();
		
	}
	public void AddShape(Shape c1)
	{
		Shapes.add(c1);
	}
	public void draw()
	{
		for (Shape iqwe :Shapes) {
			iqwe.draw();
		}
	}
	public void Refresh()
	{
		for (Shape qwe : Shapes) {
			qwe.draw();
		}
	}

}
