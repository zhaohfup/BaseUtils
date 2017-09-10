package lambda;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by bst on 2017/9/7.
 */
public class LambdaDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student[]{
                new Student("zhangsan", 89),
                new Student("lisi", 89),
                new Student("wangwu", 98)});
        students = filter(students, t -> t.getScore() > 90);
        List<String> names = map(students, t -> t.getName());
        //函数式数据处理，调用collect才会触发实际的遍历执行，在一次遍历中完成过滤、转换以及收集结果的任务。
        List<Student> students1 = students.stream().filter(t -> t.getScore() > 90).collect(Collectors.toList());
        List<String> nameList = students.stream().map(Student::getName).collect(Collectors.toList());
        List<String> above90Name = students.stream().filter(t -> t.getScore() > 90).map(Student::getName).collect(Collectors.toList());
        //像filter和map这种不实际触发执行、用于构建流水线、返回Stream的操作被称为中间操作(intermediate operation)，
        // 而像collect这种触发实际执行、返回具体结果的操作被称为终端操作(terminal operation)。
        List<String> list = Arrays.asList(new String[]{"abc", "hello", "def", "ABC"});
        List<String> resList = list.stream().filter(t -> t.length() >= 3).map(String::toLowerCase).distinct().collect(Collectors.toList());
        File[] files = new File(".").listFiles();
        Arrays.stream(files).filter(File::isFile).map(File::getName).forEach(System.out::println);
        List<Student> res = students.stream().sorted(Comparator.comparing(Student::getScore).reversed()).skip(2).limit(3).collect(Collectors.toList());
        Map<String,Integer> stringIntegerMap = students.stream().collect(Collectors.toMap(Student::getName,Student::getScore));
        Map<String,Student> stringStudentMap = students.stream().collect(Collectors.toMap(Student::getName,t->t));
    }

    public static <E> List<E> filter(List<E> es, Predicate<E> predicate) {
        List<E> list = new ArrayList<E>();
        for (E e : es) {
            if (predicate.test(e)) {
                list.add(e);
            }
        }
        return list;

    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> retList = new ArrayList<>(list.size());
        for (T e : list) {
            retList.add(mapper.apply(e));
        }
        return retList;
    }

    public static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }


}