class Solution {
    public int[] constructRectangle(int area) {
        int s = (int)Math.sqrt(area);

        for (int i = s; i >= 1; i--) {
            if (area % i == 0) {
                int div = area / i;
                return new int[]{Math.max(div, i), Math.min(div, i)};
            }
        }

        return new int[]{area, 1};
    }
}