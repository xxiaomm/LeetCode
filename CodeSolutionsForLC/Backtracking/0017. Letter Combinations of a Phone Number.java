

/*
Idea:

1. time: 

2. space: 
*/
class Solution {
    List<String> res = new LinkedList<>();
    Map<Character, String[]> map = new HashMap<>() {
        {
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }  
    };
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) 
            return new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, digits);
        return res;
    }
    public void backtrack(StringBuilder sb, int index,String digits) {
        if (sb.length() == digits.length()){
            // System.out.println(sb.toString());
            res.add(sb.toString());
            return;
        }
        
        char c = digits.charAt(index);
        for (int i = 0; i < map.get(c).length; i++) {
            sb.append(map.get(c)[i]);
            backtrack(sb, index+1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}


/*
Optimization: 


1. time: 

2. space: 
*/

