import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        a.chars().forEach(c -> System.out.println((char)c));
    }
}
