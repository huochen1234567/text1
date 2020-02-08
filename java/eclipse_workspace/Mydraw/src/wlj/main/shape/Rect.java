package wlj.main.shape;


import org.eclipse.swt.graphics.GC;

public class Rect implements shape {
	private int top;
	private int left;
	private int height;
	private int weight;
	private  GC gcmain ;
	public Rect() 
	{}
	public Rect(int top,int left,int height,int weight,GC gc) {
		this.top=top;
		this.left=left;
		this.height=height;
		this.weight=weight;
		gcmain=gc;
	}
	public void draw()
	{
		gcmain.drawRectangle(top, left, weight, height);
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
		return "Rect";
	}

}
