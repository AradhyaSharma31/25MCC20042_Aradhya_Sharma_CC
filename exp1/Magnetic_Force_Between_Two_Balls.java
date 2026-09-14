class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];
        int res = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(position, m, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    private boolean isValid(int[] position, int m, int d) {
        int prev = position[0];
        int cnt = 1;

        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= d) {
                prev = position[i];
                cnt++;
                if (cnt == m) {
                    return true;
                }
            }
        }

        return false;
    }
}