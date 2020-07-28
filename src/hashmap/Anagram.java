package hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
       /* char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);*/
        /*HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            Integer aa = hashMap1.get(a);
            Integer bb = hashMap2.get(b);
            if (aa == null) {
                hashMap1.put(a, 1);
            } else {
                hashMap1.put(a, ++aa);
            }
            if (bb == null) {
                hashMap2.put(b, 1);
            } else {
                hashMap2.put(b, ++bb);
            }
        }
        return hashMap1.equals(hashMap2);*/
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[s.charAt(i) - 'a']--;
            if (count[s.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
