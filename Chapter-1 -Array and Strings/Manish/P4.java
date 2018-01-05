import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string 1: ");
		String str1 = sc.nextLine();
		System.out.println("Enter string 2: ");
		String str2 = sc.nextLine();
		sc.close();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			if (c != ' ') {
				if (map.containsKey(c)) {
					int count = map.get(c)+1;
					map.put(c, count);
				} else {
					map.put(c, 1);
				}
			}
		}

		boolean anagram = true;
		for (int i = 0; i < str2.length(); i++) {
			char c = str2.charAt(i);
			if (c != ' ') {
				if (map.containsKey(c) && map.get(c) > 0) {
					int count = map.get(c) - 1;
					map.put(c, count);
				} else {
					anagram = false;
					break;
				}
			}
		}
		
		if(anagram)
			System.out.println("Anagram");
		else
			System.out.println("Not Anagram");

	}

}
