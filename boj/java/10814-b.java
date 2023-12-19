import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static class Person {
        private final int age;
        private final String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

    }

    private final Comparator<Person> comparator = new Comparator<>() {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.age, o2.age);
        }
    };

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
            List<Person> sortedMembers = members
                    .stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
            for (Person member : sortedMembers) {
                bw.write(member.age + " " + member.name + System.lineSeparator());
            }
            bw.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().bojSolution();
    }
}
