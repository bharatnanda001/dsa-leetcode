
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            long val = 1;

            row.add(1); // first element

            for (int j = 1; j <= i; j++) {
                val = val * (i - j + 1) / j;
                row.add((int) val);
            }

            triangle.add(row);
        }
        return triangle;
    }
}
