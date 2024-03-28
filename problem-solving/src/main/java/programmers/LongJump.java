package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongJump {
    static class Solution {
        public long solution(int n) {
            long answer = 0;
            int[] dp = new int[2001];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }

            answer = dp[n];

            return answer;
        }
    }
}

class LongJumpTest {

    @Test
    void test() {
        int n = 4;

        LongJump.Solution solution = new LongJump.Solution();

        long result = solution.solution(n);

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void test2() {
        int n = 3;

        LongJump.Solution solution = new LongJump.Solution();

        long result = solution.solution(n);

        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void test3() {
        int n = 2;

        LongJump.Solution solution = new LongJump.Solution();

        long result = solution.solution(n);

        Assertions.assertThat(result).isEqualTo(2);
    }
}
