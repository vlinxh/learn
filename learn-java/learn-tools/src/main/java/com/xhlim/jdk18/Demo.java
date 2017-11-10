package com.xhlim.jdk18;

import jdk.nashorn.internal.runtime.options.Option;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * jdk1.8学习
 * http://www.importnew.com/11908.html
 *
 * @author xhlim@outlook.com
 * @create 2017-09-11 17:22
 */
public class Demo {

    public static void main(String[] args) throws NoSuchMethodException {
        each();
        // ------------ ------------ ------------ ------------ ------------
        Defaulable defaulable = new Defaulable.DefaultableImpl();
        System.out.println(defaulable.noRequirep());
        Defaulable overridable = new Defaulable.OverridableImpl();
        System.out.println(overridable.noRequirep());
        Defaulable defaulableFactory = Defaulable.DefaulableFactory.create(Defaulable.DefaultableImpl::new);
        System.out.println(defaulableFactory.noRequirep());
        Defaulable overridableFactory = Defaulable.DefaulableFactory.create(Defaulable.OverridableImpl::new);
        System.out.println(overridableFactory.noRequirep());
        // ------------ ------------ ------------ ------------ ------------
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        System.out.println(car.toString());
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
        // ------------ ------------ ------------ ------------ ------------
        Arrays.asList(RepeatingAnnotations.Filterable.class.getAnnotationsByType(RepeatingAnnotations.Filter.class)).forEach(e -> System.out.println(e.value()));
        // ------------ ------------ ------------ ------------ ------------
        final Value<String> str = new Value<>();
        String value = str.getOrDefault("1", Value.defaultValue());
        System.out.println(value);
        // ------------ ------------ ------------ ------------ ------------
        final Annotations.Holder<String> holder = new Annotations.Holder<>();
        @Annotations.NonEmpty Collection<@Annotations.NonEmpty String> strings = new ArrayDeque<>();
        // ------------ ------------ ------------ ------------ ------------
        Method method = Demo.class.getMethod("main", String[].class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
        // ------------ ------------ ------------ ------------ ------------
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        Optional<String> fullNameNotNull = Optional.ofNullable("不为空");
        System.out.println("Full Name is set? " + fullNameNotNull.isPresent());
        System.out.println("Full Name: " + fullNameNotNull.orElseGet(() -> "[none]"));
        System.out.println(fullNameNotNull.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        // ------------ ------------ ------------ ------------ ------------
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Random().nextInt(100));
        }

        List<Integer> collect = list.parallelStream()
                .distinct()                                                     // 去掉重复的
                .filter(e -> e > 5)                                             // 筛选大于5的
                .sorted(Comparator.comparing(Integer::intValue).reversed())     // 倒序排列
                // .sorted(Comparator.comparing(Integer::intValue))
                .map(e -> e * e)                                                // 评分
                .collect(Collectors.toList());
        System.out.println(collect);
        final Collection<Streams.Task> tasks = Arrays.asList(
                new Streams.Task(Streams.Status.OPEN, 5),
                new Streams.Task(Streams.Status.OPEN, 13),
                new Streams.Task(Streams.Status.CLOSED, 8)
        );

        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Streams.Status.OPEN)
                .mapToInt(Streams.Task::getPoints)
                .sum();

        System.out.println("Total points: " + totalPointsOfOpenTasks);

        final double totalPoints = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints())
                // .mapToInt(Streams.Task::getPoints )
                .reduce(0, Integer::sum);

        System.out.println("Total points (all tasks): " + totalPoints);

        final Collection<String> result = tasks
                .stream()                                       // Stream< String >
                .mapToInt(Streams.Task::getPoints)              // IntStream
                .asLongStream()                                 // LongStream
                .mapToDouble(points -> points / totalPoints)    // DoubleStream
                .boxed()                                        // Stream< Double >
                .mapToLong(weigth -> (long) (weigth * 100))     // LongStream
                .mapToObj(percentage -> percentage + "%")       // Stream< String>
                .collect(Collectors.toList());                  // List< String >

        System.out.println(result);
        // ------------ ------------ ------------ ------------ ------------
    }

    public static void each() {
        List<Integer> list = new ArrayList();
        list.add(11);
        list.add(111111);
        list.add(111);
        list.add(1111111);
        list.add(11111);
        list.add(1111);
        list.forEach(e -> System.out.println(e));

        Arrays.asList("1", "2", "3").forEach(e -> System.out.println(e));

        Arrays.asList("11", "22", "33").forEach((String e) -> System.out.println(e));

        Arrays.asList("111", "222", "333").forEach((String e) -> {
            System.out.println(Integer.parseInt(e) + 1);
            System.out.println(e);
        });

        String s = "张三";
        Arrays.asList("111", "222", "333").forEach(e -> System.out.println(s + e));

        list.sort((e1, e2) -> e1.compareTo(e2));
        System.out.println(list);
    }


}
