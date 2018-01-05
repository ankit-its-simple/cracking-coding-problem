import java.util.Scanner;

public class P5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string 1: ");
		String str = sc.nextLine();
		System.out.println(str.replaceAll(" ", "%20"));
		sc.close();
	}
}
