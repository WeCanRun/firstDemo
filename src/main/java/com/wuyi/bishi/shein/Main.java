import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String src = sc.nextLine().trim();
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < src.length(); ++i) {
                char c = src.charAt(i);
                if (!set.contains(c)){
                    set.add(c);
                    System.out.print(c);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}