import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (String word : wordDict) {

                int len = word.length();

                if (i >= len && dp[i - len]) {

                    String part = s.substring(i - len, i);

                    if (part.equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }
}