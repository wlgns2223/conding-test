import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class CompareMain {

    public static void main(String[] args) {

        Person foo = new Person(30, "foo");
        Person bar = new Person(20, "bar");
        Person baz = new Person(10, "baz");

        List<Person> personList = new ArrayList<>();
        personList.add(foo);
        personList.add(bar);
        personList.add(baz);


        personList
                .stream()
                .sorted((a,b) -> Integer.compare(a.getAge(), b.getAge()))
                .forEach((p) -> System.out.println(p.name + " " + p.age));

//        TreeSet<Person> treeSet = new TreeSet<>();
//        treeSet.add(foo);
//        treeSet.add(bar);
//        treeSet.add(baz);
//
//        for(Person person: treeSet){
//            System.out.println(person.name + " " + person.age);
//
//        }

    }

    static class Person implements Comparable<Person> {

        private int age ;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Person o) {
            if(age < o.age) {
                return -1;
            }
            else if ( age == o.age) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
