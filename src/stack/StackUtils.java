package stack;

import java.util.HashMap;
import java.util.Stack;

public class StackUtils {

    /**
     * 方法一
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) != null) {
                stack.push(s.charAt(i));
            } else if (stack.empty() || s.charAt(i) != hashMap.get(stack.pop())) {
                return false;
            }
            if (stack.size() > s.length() / 2) {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 方法二
     */
    public static boolean isValid2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }

}
