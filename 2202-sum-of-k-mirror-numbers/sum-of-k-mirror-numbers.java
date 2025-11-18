class Solution {
    public long kMirror(int k, int n) {
        long ans = 0;
        List<Character> A = new ArrayList<>();
        A.add('0');

        for (int count = 0; count < n; count++) {
            long num;
            while (true) {
                A = nextKMirror(A, k);
                num = convertToBase10(A, k);
                if (isPalindrome(num)) {
                    break;
                }
            }
            ans += num;
        }

        return ans;
    }

    private List<Character> nextKMirror(List<Character> A, int k) {
        int n = A.size();

        for (int i = n / 2; i < n; i++) {
            int nextNum = (A.get(i) - '0') + 1;
            if (nextNum < k) {
                A.set(i, (char) ('0' + nextNum));
                A.set(n - 1 - i, (char) ('0' + nextNum));
                for (int j = n / 2; j < i; j++) {
                    A.set(j, '0');
                    A.set(n - 1 - j, '0');
                }
                return A;
            }
        }

        List<Character> newA = new ArrayList<>();
        newA.add('1');
        for (int i = 0; i < n - 1; i++)
            newA.add('0');
        newA.add('1');

        return newA;
    }

    private long convertToBase10(List<Character> A, int k) {
        long num = 0;
        for (char c : A) {
            num = num * k + (c - '0');
        }
        return num;
    }

    private boolean isPalindrome(long num) {
        String s = Long.toString(num);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
