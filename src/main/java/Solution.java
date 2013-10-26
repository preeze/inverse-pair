/**
 * Create date: 24-10-2013
 *
 * @author axkostyliev
 */
public class Solution {

    public int solution(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    if (++result > 1000000000) {
                        return -1;
                    }
                }
            }
        }
        return result;
    }
}
