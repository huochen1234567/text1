package wlj.main.shape;

import org.eclipse.swt.graphics.GC;

public class RegularPenfaton implements shape {
	private int top;
	private int left;
	private int height;
	private int weight;
	private  GC gcmain ;
	private int circleX,circleY;
	public RegularPenfaton() 
	{}
	public RegularPenfaton(int top,int left,int height,int weight,GC gc) {
		this.top=top;
		this.left=left;
		this.height=height;
		this.weight=weight;
		gcmain=gc;
		
	}
	public void draw()
	{
		circleX=this.top+this.weight/2;
		circleY=this.left+this.height/2;
		int a1,a2,a3,a4,a5;
		int b1,b2,b3,b4,b5;
		a1=circleX;
		b1=circleY+height/2;
		a2=(int)(circleX-weight/2*Math.cos(Math.PI/10));
		b2=(int)(circleY+height/2*Math.sin(Math.PI/10));
		
		a3=(int)(circleX-weight/2*Math.cos(Math.PI*3/10));
		b3=(int)(circleY-height/2*Math.sin(Math.PI*3/10));
		
		a4=(int)(circleX+weight/2*Math.cos(Math.PI*3/10));
		b4=(int)(circleY-height/2*Math.sin(Math.PI*3/10));
		
		
		a5=(int)(circleX+weight/2*Math.cos(Math.PI/10));
		b5=(int)(circleY+height/2*Math.sin(Math.PI/10));
//		gcmain.drawOval(top, left,weight , height);
//		gcmain.drawLine(500,500,700,700);
//		
		gcmain.drawLine(a1, b1, a2, b2);
		gcmain.drawLine(a2, b2, a3, b3);
		gcmain.drawLine(a3, b3, a4, b4);
		gcmain.drawLine(a4, b4, a5, b5);
		gcmain.drawLine(a5, b5, a1, b1);
		System.out.println("********");
		System.out.println(a1+"********"+b1+"********"+a2+"********"+ b2+"********");
		System.out.println(a2+"********"+b2+"********"+a3+"********"+ b3+"********");
		System.out.println(a3+"********"+b3+"********"+a4+"********"+ b4+"********");
		System.out.println(a4+"********"+b4+"********"+a5+"********"+ b5+"********");
		System.out.println(a5+"********"+b5+"********"+a1+"********"+ b1+"********");
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
	@Override
	public void setGcMain(GC g) {		gcmain=g;		}
	public static String getToolText()
	{
		return "RPenfaton";
	}

}
