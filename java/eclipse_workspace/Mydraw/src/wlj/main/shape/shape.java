package wlj.main.shape;

import org.eclipse.swt.graphics.GC;

public interface shape {
	public void draw();

	public void setTop(int i);

	public void setLeft(int i);

	public void setWidth(int i);

	public void setHeight(int i);

	public char[] getWidth();

	public void setGcMain(GC gcmain);

}
