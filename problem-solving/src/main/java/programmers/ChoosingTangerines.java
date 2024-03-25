package programmers;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 귤 고르기
 * url: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/138476">문제 링크</a>
 */
public class ChoosingTangerines {
    static class Solution {
        public int solution(int k, int[] tangerine) {
            int sum = 0;
            int answer = 0;
            Map<Integer, Integer> storage = new HashMap<>();

            for (int i : tangerine) {
                storage.put(i, storage.getOrDefault(i, 0) + 1);
            }

            List<Integer> values = new ArrayList<>(List.copyOf(storage.values()));
            values.sort(Collections.reverseOrder());

            for (Integer value : values) {
                answer++;
                if (sum + value >= k) {
                    break;
                } else {
                    sum += value;
                }
            }
            return answer;
        }
    }
}

class ChoosingTangerinesTest {

    @Test
    void test() {
        ChoosingTangerines.Solution solution = new ChoosingTangerines.Solution();
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 4;

        int result = solution.solution(k, tangerine);

        Assertions.assertThat(result).isEqualTo(2);
    }
}
