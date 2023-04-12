package lv1.picvperiod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        // Table 만들기
        HashMap<String, String> termTable = makeTermTable(terms);
        // ArrayList 만들기, 정렬하기 위함
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" "); // "2021.05.02 A" split해서 Date와 Table의 Key로 분리
            String key = privacy[1];
            String collectionDate = privacy[0];
            String validationTerm = addDate(collectionDate, termTable.get(key)); // 수집 일자에 Table에서 조회한 유효기간을 더함
            if (compareDate(validationTerm, today)) { // 비교해서 true면 ArrayList에 삽입
                res.add(i);
            }
        }
        Collections.sort(res); // ArrayList 정렬
        Integer[] primitiveRes = res.toArray(new Integer[0]);  // 인수를 빈 배열로 바꿔도 됨, 동적으로 사이즈 할당해줌. res.toArray(new Integer[res.size()]);
        int[] answer = new int[primitiveRes.length]; // Interger -> int 변환
        for (int i = 0; i < primitiveRes.length; i++) {
            answer[i] = primitiveRes[i] + 1; // 인덱스에 1씩 더해줘야 한다. answer이 1부터 시작이기 때문이다.
        }
        return answer;
    }

    public HashMap<String, String> makeTermTable(String[] terms) {
        HashMap<String, String> termTable = new HashMap<>();
        for (String e : terms) {
            String[] term = e.split(" ");
            termTable.put(term[0], term[1]);
        }
        return termTable;
    }

    public String addDate(String collectionDate, String month) {
        String[] date = collectionDate.split("\\.");
        String collectionMonth = date[1];
        String collectionYear = date[0];
        String resMonth;
        String resYear;
        int condition;

        condition = Integer.parseInt(collectionMonth) + Integer.parseInt(month);
        if (condition > 12) {
            if (condition % 12 == 0) { // 12로 나눈 나머지는 0~11뿐이다.따라서 12월은 edge로 따로 처리해줘야한다.
                resYear = Integer.toString(Integer.parseInt(collectionYear) + (condition / 12) - 1);
                resMonth = Integer.toString(12);
            } else {
                resYear = Integer.toString(Integer.parseInt(collectionYear) + condition / 12);
                resMonth = Integer.toString(condition % 12);
            }
        } else {
            resYear = collectionYear;
            resMonth = Integer.toString(condition);
        }
        String[] arr = {resYear, resMonth, date[2]};
        return String.join(".", arr);
    }

    public boolean compareDate(String validation, String today) {
        String[] validationYMD = validation.split("\\.");
        String[] todayYMD = today.split("\\.");
        return compare(validationYMD, todayYMD, 0);
    }

    public boolean compare(String[] validation, String[] today, int i) {

        if (i > 2)
            return true;
        if (Integer.parseInt(validation[i]) > Integer.parseInt(today[i])) {
            return false;
        } else if (Integer.parseInt(validation[i]) == Integer.parseInt(today[i])) {
            return compare(validation, today, i + 1);
        } else {
            return true;
        }
    }
}