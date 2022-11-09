

/*
1. time: 
    best case: O(n), 
    worst case: O(2n), both l and r traverse the whole string s
2. space: O(min(m,n)), m:字符charset/alphabet的最大数量128, n:s.length()
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int maxLen = 0; // store the maximum length
        // use Set to ensure no duplicate character
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            // if contains duplicates, move l until no duplicates
            while (set.contains(s.charAt(r)))
                set.remove(s.charAt(l++));
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}

/*
Optimization: 
if has duplicates, move l to the next pos of privious occurence directly

 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        // current character, its index
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            // if contains, move l to the next pos of privious occurrence
            if (map.containsKey(s.charAt(r))) 
                l = Math.max(l, map.get(s.charAt(r))+1);
            // update the latest index of current character
            map.put(s.charAt(r), r);
            // update the longest length 
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}