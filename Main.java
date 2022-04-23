import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/*

Test 1:
1110110
k = 2:
1010101010

Test 2:
011101
k = 2:
01010101

Test 3:
0100000
k = 2:
01010101010

*/

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			char[] t = fs.next().toCharArray();
			int ones = 0;
			for(int i = 0; i < t.length; i++) {
				if(t[i] == '1') {
					ones++;
				}
			}
			int zeroes = t.length - ones;
			if(ones == 0 || zeroes == 0) {
				out.println(String.valueOf(t));
				continue;
			}
			char prev = t[0];
			String ans = String.valueOf(prev);
			for(int i = 1; i < t.length; i++) {
				if(t[i] == prev) {
					ans += (char) (t[i] ^ ('0' ^ '1'));
				}
				ans += t[i];
				prev = t[i];
			}
			out.println(ans);
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
