package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TowerOfHanoi {
    static class Solution {
        List<int[]> result = new ArrayList<>();

        public int[][] solution(int n) {
            int[][] answer = {};
            hanoi(n, 1, 2, 3);
            answer = result.toArray(new int[1][result.size()]);
            return answer;
        }

        public void hanoi(int n, int from, int temp, int to) {
            if (n == 1) {
                result.add(new int[]{from, to});
                return;
            }
            hanoi(n - 1, from, to, temp);
            result.add(new int[]{from, to});
            hanoi(n - 1, temp, from, to);
        }
    }
}

class TowerOfHanoiTest {

    @Test
    void test() {
        int n = 2;
        TowerOfHanoi.Solution solution = new TowerOfHanoi.Solution();
        int[][] expect = {{1, 2}, {1, 3}, {2, 3}};


        int[][] result = solution.solution(n);

        Assertions.assertThat(result).isDeepEqualTo(expect);
    }
}
