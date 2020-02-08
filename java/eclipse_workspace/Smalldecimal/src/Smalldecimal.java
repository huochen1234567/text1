import java.lang.reflect.Array;
import java.util.Arrays;
public class Smalldecimal {

	public static int numcarry=0;
	public int num1;
	public String num2;
	Smalldecimal(){
		num1=0;		
		num2="0";
	}
	Smalldecimal(String str)
	{
		String[] str1=str.split("\\.");
		num1=Integer.parseInt(str1[0]);
		num2=str1[1];		
		System.out.println("num: "+num1+"."+num2);		
	}
	public int[] translate(String str)
	{
		int p[]=new int [str.length()];
		char ch[]=str.toCharArray();	
		for(int i=0;i<str.length();i++)
		{
			p[i]=Integer.parseInt(String.valueOf(ch[i]));
		}
		return p;
				
	}
	public int[] add(int a[],int b[])
	{
		numcarry=0; 
		if(a.length>b.length){
			int p1[]=a;
			int p2[]=b;
			for(int i=b.length-1;i>=0;i--) {
				int t=p1[i]+p2[i];
				p1[i]=t%10+numcarry;
				numcarry=t/10;
				if(p1[i]>=10) {		//进位之后的数numcarry+t%10>=10,则，再进一位			
					p1[i]=p1[i]%10;
					numcarry++;
				}
			}
			return p1;
		}
		else {
			int p1[]=b;
			int p2[]=a;
			for(int i=a.length-1;i>=0;i--) {
				int t=p1[i]+p2[i];
				p1[i]=t%10+numcarry;
				numcarry=t/10;
				if(p1[i]>=10) {		//进位之后的数numcarry+t%10>=10,则，再进一位			
					p1[i]=p1[i]%10;
					numcarry++;
				}
			}
			return p1;
		}		
	}
	public Smalldecimal add(Smalldecimal n2)
	{
		Smalldecimal n3=new Smalldecimal();
		n3.num2="";
		int a[]=translate(num2);	
		int b[]=translate(n2.num2);		
		int p[]=add(a,b);	
		for(int i=0;i<p.length;i++)
			n3.num2=n3.num2+p[i];		
		n3.num1=num1+n2.num1+numcarry;
		return n3;		
	}
	public int[] sub(int a[],int b[])
	{
		numcarry=0;
		int p[]=new int [Math.max(a.length, b.length)];		
		for(int i=Math.max(a.length, b.length)-1;i>=0;i--) {
			if(a.length< b.length&&i>a.length-1)
				{
				if(b[i]==0){
					p[i]=0;
					numcarry=0;					
				}
				else {
					p[i]=10-b[i]+numcarry;
					numcarry=-1;
				}
					
				}
			else if(a.length>= b.length&&i>b.length-1)
				{
					p[i]=a[i]+numcarry;
					numcarry=0;
				}
			else{
				if(a[i]+numcarry<b[i]){
					p[i]=10+a[i]-b[i]+numcarry;
					numcarry=-1;		//向前一位借一
				}
				else {
					p[i]=a[i]-b[i]+numcarry;
					numcarry=0;
				}	
			}	
		}		
		return p;
	}
	public Smalldecimal sub(Smalldecimal n2)
	{
		Smalldecimal n3=new Smalldecimal();
		if(num1<n2.num1||(num2.compareTo(n2.num2)<0&&num1==n2.num1)){	//n1<n2,-->wrong
			System.out.println("请输入正确的数据：");
			return n3;
		}		
		int a[]=translate(num2);	
		int b[]=translate(n2.num2);
		int p[]=sub(a,b);
		n3.num2="";
		for(int i=0;i<p.length;i++)
			n3.num2=n3.num2+p[i];
		n3.num1=num1-n2.num1+numcarry;
		return n3;		
	}
	public int len0(int a[])
	{
		int len=0;
		for(int i=0;i<a.length-num1||a[i]!=0;i++){
			len++;
		}
		return len;
	}
	public Smalldecimal mul(Smalldecimal n2)
	{
		Smalldecimal n3=new Smalldecimal();		
		n3.num2="";
		int n1num2=Integer.parseInt(num2);
		int n2num2=Integer.parseInt(n2.num2);
		//System.out.println("num2:  "+n1num2+"  n2.num2: "+n2num2);
		n3.num1=num1*n2.num1+
				num1*n2num2/(int)(Math.pow(10, n2.num2.length()))+
				n1num2*n2.num1/(int)(Math.pow(10, num2.length()))+
				n1num2*n2num2/(int)(Math.pow(10, num2.length()+n2.num2.length()));
		String s1=Integer.toString(num1*n2num2%(int)(Math.pow(10, n2.num2.length())));
		while(s1.length()< n2.num2.length())
			s1="0"+s1;
		String s2=Integer.toString(n1num2*n2.num1%(int)(Math.pow(10, num2.length())));
		while(s2.length()<num2.length())
			s2="0"+s2;
		String s3=Integer.toString(n1num2*n2num2%(int)(Math.pow(10, num2.length()+n2.num2.length())));
		while(s3.length()<num2.length()+n2.num2.length())
			s3="0"+s3;
		int t1[]=translate(s1);
		int	t2[]=translate(s2);
		int t3[]=translate(s3);
		int p[]=add(add(t1, t2), t3);
		for(int i=0;i<p.length;i++)
			n3.num2=n3.num2+p[i];
		return n3;			
	}
	public Smalldecimal div(Smalldecimal n2)
	{
		Smalldecimal n3=new Smalldecimal();
		if(num1<n2.num1||(num2.compareTo(n2.num2)<0&&num1==n2.num1)){	//n1<n2,-->wrong
			System.out.println("请输入正确的数据：");
			return n3;
		}
		n3.num2="";
		String num2String,n2num2String;
		if(num2.length()<n2.num2.length()){
			int t=n2.num2.length()-num2.length();
			num2String=num2;
			n2num2String=n2.num2;
			while(t>0){
				num2String=num2String+"0";
				t--;
			}				
		}
		else {
			int t=num2.length()-n2.num2.length();
			num2String=num2;
			n2num2String=n2.num2;
			while(t>0){
				n2num2String=n2num2String+"0";
				t--;
			}
		}	
		int a=num1*(int)(Math.pow(10,num2String.length()))+Integer.parseInt(num2String);
		int b=n2.num1*(int)(Math.pow(10,n2num2String.length()))+Integer.parseInt(n2num2String);
		//System.out.println("*********n1:"+a+"  n2:"+b);
		int remainder,quotient;
		n3.num1=a/b;
		remainder=a%b;
		for(int i=0;i<20;i++)
		{
			if(remainder==0&&i==0){
				n3.num2="0";
				break;
			}
			else if(remainder==0)
				break;
			quotient=remainder*10/b;
			remainder=remainder*10%b;
			n3.num2=n3.num2+Integer.toString(quotient);				
		}
		return n3;			
	}
	public  void print() {
		System.out.println("num:  "+num1+"."+num2);				
	}
}

