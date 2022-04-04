/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.medium;

/**
 *
 * @author lgirardin
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String... args){
        String s1 = "abcabcbb";
        int result1 = 3;
        
        String s2 = "bbbb";
        int result2 = 1;
        
        String s3 = "pwwkew";
        int result3 = 3;
        
        System.out.println("Example 1, Expected: " + result1 + " Result: " + Solution.lengthOfLongestSubstring(s1));
        System.out.println("Example 2, Expected: " + result2 + " Result: " + Solution.lengthOfLongestSubstring(s2));
        System.out.println("Example 3, Expected: " + result3 + " Result: " + Solution.lengthOfLongestSubstring(s3));

               
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
        /*int n = s.length();
        int res = 0;
        
        for(int i=0; i < n; i++){
            for(int j = i; j < n; j++){
                if(checkRepetition(s, i, j)){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        
        return res;
        */
    }

    private static boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];
        for(int i = start; start < end; i++){
            System.out.println(s.subSequence(start, end-1));

            int c = s.charAt(i);
            chars[c]++;
            if(chars[c] > 1)
                return false;
        }
        
        return true;
    }
}