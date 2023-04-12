package lv1.picvperiod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privates) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<String, Integer> termTable = makeTermTable(terms);
        Mycalender checkCal = makeCal(today);

        for (int i = 0; i < privates.length; i++) {
            String[] privacy = privates[i].split(" ");
            String collectionDate = privacy[0];
            String term = privacy[1];

            Integer termMonth = termTable.get(term);
            System.out.println(termMonth);
            Mycalender collectionCal = makeCal(collectionDate); // 수집 일자
            Mycalender finalValidationCal = addCal(collectionCal, termMonth); // 유효 기간 : 수집 일자 + term에 기간
            if (checkCal.getTimeInMillis() < finalValidationCal.getTimeInMillis()) {
                pq.add(i);
            }
        }

        Integer[] ex = pq.toArray(new Integer[0]);
        return Arrays.stream(ex).mapToInt(Integer::intValue).toArray();
    }

    public Mycalender makeCal(String today) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY.MM.DD");
        Date todayDate;
        try {
            todayDate = dateFormat.parse(today);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Mycalender calendar = (Mycalender) Mycalender.getInstance();
        calendar.setTime(todayDate);
        return calendar;
    }

    public Mycalender addCal(Calendar cal, Integer month){
        cal.add(Mycalender.MONTH, month);
//        System.out.println(cal); // Debug
        return (Mycalender) cal;
    }

    public HashMap<String, Integer> makeTermTable(String[] terms) {
        HashMap<String, Integer> termTable = new HashMap<>();
        for (String e : terms) {
            String[] term = e.split(" ");
            termTable.put(term[0], Integer.parseInt(term[1]));
        }
        return termTable;
    }
}

class Mycalender extends GregorianCalendar {

    @Override
    public int getActualMaximum(int field) {
        if (field == Calendar.DAY_OF_MONTH) {
            return 28;
        }
        else {
            return super.getActualMaximum(field);
        }
    }
}
