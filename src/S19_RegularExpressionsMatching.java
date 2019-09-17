public class S19_RegularExpressionsMatching {
    private int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        return isMatchCore(0, 0, s, p);
    }

    private boolean isMatchCore(int i, int j, String t, String p) {
        if (j == p.length())
            return i == t.length();
        if (dp[i][j] == 1)
            return false;

        boolean firstmatch = i < t.length() && (t.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean ans;
        if ((j + 1 < p.length() && p.charAt(j + 1) == '*'))
            ans = isMatchCore(i, j + 2, t, p) || (firstmatch && isMatchCore(i + 1, j, t, p));
        else
            ans = firstmatch && isMatchCore(i + 1, j + 1, t, p);

        if (!ans)
            dp[i][j] = 1;

        return ans;
    }
}
