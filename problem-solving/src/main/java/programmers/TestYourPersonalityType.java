package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 성격 유형 검사 하기
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/118666">문제 링크</a>
 */

public class TestYourPersonalityType {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            String[] type = {"RT", "CF", "JM", "AN"};
            int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
            Map<Character, Integer> storage = new HashMap<>();

            for (int i = 0; i < survey.length; i++) {
                if (choices[i] < 4) {
                    storage.put(survey[i].toCharArray()[0], storage.getOrDefault(survey[i].toCharArray()[0], 0) + score[choices[i]]);
                } else {
                    storage.put(survey[i].toCharArray()[1], storage.getOrDefault(survey[i].toCharArray()[1], 0) + score[choices[i]]);
                }
            }

            StringBuilder stringBuilder = new StringBuilder(answer);

            for (String str : type) {
                if (storage.getOrDefault(str.charAt(0), 0) < storage.getOrDefault(str.charAt(1), 0)) {
                    stringBuilder.append(str.charAt(1));
                } else {
                    stringBuilder.append(str.charAt(0));
                }
            }

            return stringBuilder.toString();
        }
    }
}
