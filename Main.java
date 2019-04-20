package let;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Poly p1 = new Poly();
			int [][] f = {{0,0}};
			p1.setPolynomial('R', f);
			Scanner input  = new Scanner(System.in);
			Scanner take  = new Scanner(System.in);
			Scanner take2 = new Scanner(System.in);
			Scanner take3 = new Scanner(System.in);
			 for(;;) {
			System.out.println("ensert the operation");
		    int choose = input.nextInt();
		   
		    switch(choose) {
		    case(1):{
		    	System.out.println("pol");
		    	String s = take.nextLine();
		    	int [][] a = ToInt(s);
		    	System.out.println("name");
		    	char c = take2.nextLine().charAt(0);
		    	p1.setPolynomial(c , a);
		    	break;
		    }
		    case(2):{
                        System.out.println("enter name");
		    	char ch = input.next().charAt(0);
		    	if(!p1.l1.contains(ch)) break;
                        System.out.println("enter value");
		    	System.out.println(p1.evaluatePolynomial(ch, input.nextInt()));
		    	break;
		    }
		    case(3):{
		    	System.out.println("c1");
		    	char c1 = take.nextLine().charAt(0);
		    	System.out.println("c2");
		    	char c2 = take2.nextLine().charAt(0);
		    	if(!p1.l1.contains(c1) && !p1.l1.contains(c2)) break;
		    	int [][] ans = p1.add(c1, c2);
		    	p1.l1.modify('R',ans);
		    	String ss = "";
		    	for(int i = 0; i < ans.length; i++)
		    		ss += "(" + ans[i][0] + "," + ans[i][1] + ")";
		    	System.out.println(ss);
                        break;
		    }
		    case(4):{
		    	System.out.println("c1");
		    	char c1 = take.nextLine().charAt(0);
		    	System.out.println("c2");
		    	char c2 = take2.nextLine().charAt(0);
		    	if(!p1.l1.contains(c1) & !p1.l1.contains(c2)) break;
		    	int [][] ans1 = p1.subtract(c1,c2);
		    	p1.l1.modify('R',ans1);
	    		for(int i = 0; i < ans1.length; i++)
	    			System.out.println("(" + ans1[i][0] + "," + ans1[i][1] + ")");
		    	break;
		    }
		    case(5):{
		    	System.out.println("c1");
		    	char c1 = take.nextLine().charAt(0);
		    	System.out.println("c2");
		    	char c2 = take2.nextLine().charAt(0);
		    	if(!p1.l1.contains(c1) & !p1.l1.contains(c2)) break;
		    	int [][] ans2 = p1.multiply(c1,c2);
		   	p1.l1.modify('R',ans2);
	    		for(int i = 0; i < ans2.length; i++)
	    			System.out.println("(" + ans2[i][0] + "," + ans2[i][1] + ")");
	    		break;
		    }
		    case(6):{
                        System.out.println("enter name");
		    	char c1 = take2.nextLine().charAt(0);
		    	if(!p1.l1.contains(c1)) break;
		    	System.out.println(p1.print(c1));
		    	break;
		    }
		    case(7):{
		    	char c1 = take.nextLine().charAt(0);
		    	if(!p1.l1.contains(c1)) break;
		    	p1.clearPolynomial(c1);
		    	break;
		    }
		    
		 }
  }
}
	
	
	public static int [][] ToInt (String s){
		String s1  = s.replaceAll("[^0-9,]", "");
		String[] s2 = s1.split(",");
		int[] numbers = new int[s2.length];
		for(int i = 0; i < s2.length; i++)
			numbers[i] = Integer.parseInt(s2[i]);
		int [][] result = new int [s2.length/2][2];
		int n1 =0;
		for(int i=0 ; i<numbers.length ; i++) {
			if(i%2 == 0) result[n1][0] = numbers[i];
			else result[n1++][1] = numbers[i];
		}
		return result;	
	}
}
