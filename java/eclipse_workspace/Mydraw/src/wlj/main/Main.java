package wlj.main;
import java.lang.reflect.Method;
import java.util.*;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;



import wlj.main.shape.Board;
import wlj.main.ClassUtil;
import wlj.main.shape.shape;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {
	private static GC gcmain=null;
	private static int startx,starty,lastx,lasty;
	private static Board board=null;
	private static boolean leftbuttondown=false;
	private static String shapetype="wlj.main.shape.Circle";


	public static void main(String[] args) {
		
		List<?> listClass = null;
		String pkg = "wlj.main.shape";
		listClass = ClassUtil.getClassList(pkg, true, null);
		if (listClass==null) {
			//System.out.println("123null");
		}
		
		ArrayList<String> shapetypes = new ArrayList<String>();
		for (Object object : listClass) {
		String name = ((Class<?>) object).getName();			//这里错了
			//System.out.println("123null");
		if(!name.equals("wlj.main.shape.shape")&&!name.equals("wlj.main.shape.Board")){
			shapetypes.add(name);
			
		}
		}
		for(String str : shapetypes) {
		System.out.println(str);
		//System.out.println("123null");		//	 shapetypes-->OK!
		}

		
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		gcmain=new GC (shell);
		board=new Board();
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				board.refresh();
			}
		}
		);
		
		shell.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
			//	gcmain.drawRectangle(startx, starty, arg0.x-startx, arg0.y-starty);
				board.refresh();
				if(leftbuttondown)
				{
					//del old line
					gcmain.setLineStyle(SWT.LINE_DOT);
					gcmain.setForeground(shell.getBackground());
					gcmain.drawRectangle(startx, starty,lastx-startx, lasty-starty);
					
					
					//draw dot line
					gcmain.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
					gcmain.drawRectangle(startx, starty,arg0.x-startx, arg0.y-starty);
					gcmain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
					gcmain.setLineStyle(SWT.LINE_SOLID);
					lastx=arg0.x;
					lasty=arg0.y;					
				}
			}
		});
		shell.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseDown(MouseEvent e) {
				
					//shell.setCursor(cursor);
					shell.setCursor(new Cursor(null	, SWT.CURSOR_CROSS));
					
					startx=e.x;		//按下去的坐标
					starty=e.y;
					leftbuttondown=true;
			}
			@Override
			public void mouseUp(MouseEvent e) {
				if (e.button==1) {	
					shell.setCursor(new Cursor(null	, SWT.CURSOR_ARROW));
					//gcmain.drawRectangle( e.x-startx, e.y-starty);
					
					
					gcmain.setLineStyle(SWT.LINE_DOT);					//擦除Circle外圈的方形框框
					gcmain.setForeground(shell.getBackground());
					gcmain.drawRectangle(startx, starty,e.x-startx,e.y-starty );
					gcmain.setLineStyle(SWT.LINE_SOLID);
					gcmain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
					
					
					shape shape1=null;
					
					try{
					
					Class shapeClass = Class.forName(shapetype);
					@SuppressWarnings("deprecation")
					Object oShape = shapeClass.newInstance();
					shape1 = (shape)oShape;
					shape1.setTop(startx);
					shape1.setLeft(starty);
					shape1.setWidth(e.x - startx);
					shape1.setHeight(e.y - starty);
					shape1.setGcMain(gcmain);
					}
					catch (Exception ex) {
					shape1 = null;
					}
					if(shape1 != null) {
					board.insertshape(shape1);
					board.refresh();
					}					
					leftbuttondown=false;
				}			
			}						
		}
		);
		shell.setSize(950, 900);
		shell.setText("SWT Application");
		
		
		
		
		/*
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			}
		});
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setCursor(new Cursor(null, SWT.CURSOR_HELP));
				shapetype="Rect1";
				

				
			}
		});
		btnNewButton.setBounds(10, 27, 114, 61);
		btnNewButton.setText("Rect");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {}
		});
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setCursor(new Cursor(null, SWT.CURSOR_HELP));
				shapetype="Circle";
				
			}
		});
		btnNewButton_1.setBounds(10, 127, 114, 61);
		btnNewButton_1.setText("Circle");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			}
		});
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapetype="RoundRect";
			}
		});
		btnNewButton_2.setBounds(10, 224, 114, 61);
		btnNewButton_2.setText("RRect");
		*/
		
		
		
		
		
		////////////////////////////////////////////////////////
		//add button by shapeTypes
		int indexButton = 0;
		for (String strClass : shapetypes) {
			Button btn = new Button(shell, SWT.NONE);
			btn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					shapetype = strClass;
					
				}
			});
			btn.setBounds(130 * indexButton+20, 10, 110, 47);
			
			//System.out.println(shapetype+"******************");	
			indexButton++;
			try {
				Class<?> shapeClass = Class.forName(strClass);
				//btn.setText(shapeClass.getTypeName());
				Method method=shapeClass.getMethod("getToolText");
				btn.setText(method.invoke(null, null).toString());
				btn.setData("shapetype", strClass);
				System.out.println("11");
			} 
			catch (Exception e) {
				btn.setText(strClass);
				btn.setData("shapetype", strClass);
				System.out.println("11");
			}
		
		}
		////////////////////////////////////////////////////////


		shell.open();
		
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
