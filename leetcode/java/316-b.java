import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        removeDuplicateLettersRecursive(sb, s);

        return sb.toString();
    }

    private void removeDuplicateLettersRecursive(StringBuilder sb, String s) {
        Set<Character> set = s.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(TreeSet::new));
        for (char c : set) {
            String suffix = s.substring(s.indexOf(c));
            if (set.equals(suffix.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet()))) {
                sb.append(c);
                removeDuplicateLettersRecursive(sb, suffix.replace(Character.toString(c), ""));
                return;
            }
        }
    }
}
