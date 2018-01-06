import java.util.Scanner;

public class P3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string: ");
		String str = sc.nextLine();
		sc.close();

		for (int i = 0; i < str.length() - 1; i++) {
			boolean duplicate = false;
			if (str.charAt(i) != ' ') {
				for (int j = str.length() - 1; j >= i; j--) {
					if ((str.charAt(i) == str.charAt(j) && i != j) || (i == j && duplicate)) {
						if (j == str.length() - 1)
							str = str.substring(0, j);
						else
							str = str.substring(0, j) + "" + str.substring(j + 1);
						if (i != j)
							duplicate = true;
					}
				}

			}
			if (duplicate)
				--i;
		}
		System.out.println(str);
	}
}
