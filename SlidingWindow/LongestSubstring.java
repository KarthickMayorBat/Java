package SlidingWindow;

import java.util.HashMap;
/*
 * Given a string s, find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.
Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); // Character and its last seen index
        int maxLength = 0;
        int i = 0; // Start of the sliding window

        for (int j = 0; j < s.length(); j++) { // End of the sliding window
            char currentChar = s.charAt(j);

            // If the character is already in the map, move the start pointer
            if (map.containsKey(currentChar)) {
                i = Math.max(i, map.get(currentChar) + 1); // Move 'i' to avoid overlap
            }

            // Update the map with the current character's index
            map.put(currentChar, j);

            // Calculate the maximum length of the substring
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }

}
