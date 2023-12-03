import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        a.chars().mapToObj(
                c -> Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c)
        ).forEach(c -> System.out.print(Character.toChars(c)));
    }
}
