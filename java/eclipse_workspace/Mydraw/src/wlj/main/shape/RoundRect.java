package wlj.main.shape;
import org.eclipse.swt.graphics.GC;

public class RoundRect implements shape {
	private int top;
	private int left;
	private int height;
	private int weight;
	private  GC gcmain ;
	
	public RoundRect() {
		// TODO Auto-generated constructor stub
	}
	public RoundRect(int top,int left,int height,int weight,GC gc) {
		this.top=top;
		this.left=left;
		this.height=height;
		this.weight=weight;
		gcmain=gc;
	}
	public void draw()
	{
		gcmain.drawRoundRectangle(top, left, weight,height,50,50);
	}
	@Override
	public void setTop(int i) {		top=i;		}
	@Override
		public void setLeft(int i) {		left=i;		}
	@Override
	public void setWidth(int i)  {	 	weight=i;		}
	@Override
	public void setHeight(int i) {	 	height=i;		}
	@Override
	public char[] getWidth() {
		
		return null;
	}
	public void setGcMain(GC g) {		gcmain=g;		}
	public static String getToolText()
	{
		return "RoundRect";
	}

}
