
public class Main {

	
	public static void main(String[] args) {
		System.out.println("123");
		Board board=new Board();
		Rect r1=new Rect("r1");
		Rect r2=new Rect("r2");
		Rect r3=new Rect("r3");
		
		Circle c1=new Circle("c1");
		Circle c2=new Circle("c2");
		Circle c3=new Circle("c3");
		
		board.AddShape(r1);
		board.AddShape(r2);
		board.AddShape(r3);
		board.AddShape(c1);
		board.AddShape(c2);
		board.AddShape(c3);
		//board.draw();
		System.out.println();
		board.Refresh();

	}

}
