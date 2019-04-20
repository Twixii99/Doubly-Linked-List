package let;

import java.util.Vector;

public class Poly implements IPolynomialSolver{
	LinkedList l1 = new LinkedList();

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		l1.add(terms,poly);
	}

	@Override
	public String print(char poly) {
		String ans = "";
		int arr[][] = (int [][])l1.get(poly);
		for(int i = 0; i < arr.length; i++) {
			if(i != arr.length-1)
				ans += arr[i][0] + "x" + "^" + arr[i][1] + "+";
			else
				ans += arr[i][0] + "x" + "^" + arr[i][1];
		}
		return ans;
	}

	@Override
	public void clearPolynomial(char poly) {
 	  l1.remove(poly);
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		float ans = 0;
		int arr[][] = (int [][])l1.get(poly);
		for(int i = 0; i < arr.length; i++)
			ans += arr[i][0]*Math.pow(value, arr[i][1]);
		return ans;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		int [][] a = (int [][])l1.get(poly1);
		int [][] b = (int [][])l1.get(poly2);
		int [][] c = new int[a.length + b.length][2];
		int n1 =0;
		for(int i=0 ; i<a.length ; i++) {
			c[n1][0] = a[i][0];
			c[n1++][1] = a[i][1];	
		}
		int found =0;
		for(int j=0 ; j<b.length ; j++) {
			found =0;
			for(int k=0 ; k<n1 ; k++) {
				if(b[j][1] == c[k][1]) {
					found =1;
					c[k][0] += b[j][0];
				}
			}
			if(found ==0) {
				c[n1][0] = b[j][0];
				c[n1++][1] = b[j][1];
			}
		}
		int ans[][] = new int[n1][2];
		for(int i = 0; i < ans.length; i++) {
			ans[i][1] = c[i][1];
			ans[i][0] = c[i][0];
		}
		return ans;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		int [][] a = (int [][])l1.get(poly1);
		int [][] b = (int [][])l1.get(poly2);
		int [][] c = new int[a.length + b.length][2];
		int n1 =0;
		for(int i=0 ; i<a.length ; i++) {
			c[n1][0] = a[i][0];
			c[n1++][1] = a[i][1];	
		}
		int found =0;
		for(int j=0 ; j<b.length ; j++) {
			found =0;
			for(int k=0 ; k<n1 ; k++) {
				if(b[j][1] == c[k][1]) {
					found =1;
					c[k][0] -= b[j][0];
				}
			}
			if(found ==0) {
				c[n1][0] = b[j][0];
				c[n1++][1] = b[j][1];
			}
		}
		int ans[][] = new int[n1][2];
		for(int i = 0; i < ans.length; i++) {
			ans[i][1] = c[i][1];
			ans[i][0] = c[i][0];
		}
		return ans;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		int [][] a = (int [][])l1.get(poly1);
		int [][] b = (int [][])l1.get(poly2);
		int [][] c = new int[a.length * b.length][2];
		int n1 = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				c[n1][0] = a[i][0]*b[j][0];
				c[n1++][1] = a[i][1]+b[j][1];
			}
		}
		return dublicated(c);
	}
	public int[][] dublicated(int [][] arr){
		Vector<Integer> coff = new Vector<Integer>();
		Vector<Integer>  pow = new Vector<Integer>();
		coff.add(arr[0][0]);	pow.add(arr[0][1]);
		int n = 1;
		for(int i = 1; i < arr.length; i++) {
			if(pow.contains(arr[i][1])) 
				coff.set(pow.indexOf(arr[i][1]), arr[i][0] + coff.get(pow.indexOf(arr[i][1])));
			else {
				coff.add(arr[n][0]);
				pow.add(arr[n++][1]);
			}
		}
		int[][] ans = new int[coff.size()][2];
		for(int i = 0; i < coff.size(); i++) {
			ans[i][0] = coff.get(i);
			ans[i][1] = pow.get(i);
		}
		return ans;
	}	
}
