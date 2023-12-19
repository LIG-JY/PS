import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Person implements Comparable<Person> {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person other) {
            // 값이 양수면 this가 뒤로 이동한다.
            // 값이 음수면 this가 앞으로 이동한다.
            // 오름차순 정렬
            return Integer.compare(this.age, other.age); // this.age - other.age 와 동일하다.
        }
    }

    public void bojSolution() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            List<Person> members = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                members.add(i, new Person(age, name));
            }
            Collections.sort(members);
            for (Person member : members) {
                bw.write(member.age + " " + member.name + System.lineSeparator());
            }
            bw.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
