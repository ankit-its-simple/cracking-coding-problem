import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string: ");
		String str = sc.nextLine();
		sc.close();
		boolean unique = true;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				for (int j = 0; j < i; j++) {
					if (str.charAt(i) == str.charAt(j)) {
						unique = false;
						break;
					}
				}
			}
			if (!unique)
				break;
		}

		if (unique)
			System.out.println("String is unique");
		else
			System.out.println("String is not unique");

	}

}
