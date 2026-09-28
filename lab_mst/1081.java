class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            freq.put(ch, freq.getOrDefault(ch, 0) - 1);

            if (seen[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty()) {
                if (st.peek() <= ch) {
                    break;
                }

                if (freq.get(st.peek()) == 0) {
                    break;
                }

                char poppedChar = st.pop();
                seen[poppedChar - 'a'] = false;
            }

            st.push(ch);
            seen[ch - 'a'] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}