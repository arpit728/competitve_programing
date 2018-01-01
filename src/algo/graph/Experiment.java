package algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arpit on 11-Dec-15.
 */
    public class Experiment {
        public static void main(String args[]) {
            final List<String>list=new ArrayList<>();
            list.add("abc");
            System.out.println(list);
        }
    }
    class Student{

        String name;

        public Student(String name) {this.name=name;}

       /* @Override
        public int hashCode() {
            return name.length();
        }*/

        @Override
        public boolean equals(Object obj) {
            if (name.length()==((Student)obj).name.length())return true;
            return false;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
