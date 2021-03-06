package tree;

import java.util.Scanner;

public class TreeMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int j;
	    System.out.println ("Enter Tree Height");
        j=sc.nextInt();
        
        Tree(j);
      }

	public static void starsNumber(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void space(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public static void Tree(int h) {
        for (int i = 1; i <= h; i++) {
            space(h - i);
            starsNumber(i + (i - 1));
        }
     }

}
