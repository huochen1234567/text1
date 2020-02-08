import java.math.BigDecimal;
import java.util.*;
public class Main {

	
	public static void main(String[] args) {
		/*Scanner reader=new Scanner(System.in);
		System.out.println("Please input int :");
		String str=reader.nextLine ();		//ÊäÈë×Ö·û´®
		BigDecimal a=new BigDecimal(n);
		BigDecimal b=new BigDecimal(n);
		a.add(b);
		*/
		String str="1.050";
		String str1="0.250";
		Smalldecimal  n1=new Smalldecimal(str);
		Smalldecimal  n2=new Smalldecimal(str1);
		//n1.print();
		System.out.print("\n"+"num1.add(num2): ");
		
		n1.add(n2).print();
		System.out.print("\n"+"num1.sub(num2): ");
		n1.sub(n2).print();
		System.out.print("\n"+"num1.mul(num2): ");
		n1.mul(n2).print();
		System.out.print("\n"+"num1.div(num2): ");
		n1.div(n2).print();
		
	}

}
