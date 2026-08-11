class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }

        // Store all characters present in the current string
        boolean[] present = new boolean[128];

        for (char c : s.toCharArray()) {
            present[c] = true;
        }

        // Find a character that doesn't have both cases
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!present[Character.toLowerCase(c)] ||
                !present[Character.toUpperCase(c)]) {

                // This character cannot be part of a nice substring
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));

                // Return left in case of a tie (earlier occurrence)
                return left.length() >= right.length() ? left : right;
            }
        }

        // Every character has both uppercase and lowercase
        return s;
    }
}