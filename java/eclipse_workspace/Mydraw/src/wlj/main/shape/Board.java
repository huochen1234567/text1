package wlj.main.shape;

import java.awt.Shape;
import java.util.*;

public class Board {
	private List<shape> shapes;
	public Board()
	{
		shapes=new ArrayList<shape>();
		
	}
	public void insertshape(shape shape)
	{
		shapes.add(shape);
	}
	public void refresh()
	{
		for (shape shape : shapes) {
			shape.draw();
		}	}
	

}
