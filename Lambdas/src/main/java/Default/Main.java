package Default;

import  java.util.*;
import java.net.*;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void demo() {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        //if error on above line, hover and change JRE to JavaSE-1.8 for Lambda
        System.out.println(filtered);

        List<Integer> numbers1 = Arrays.asList(3,2,2,3,7,3,5);
        List<Integer> squaresList = numbers1.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        List<String> names = Arrays.asList("Reflection", "Collection", "Stream", "Sandbox");
        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        List<String> lstSorted = names.stream().sorted().collect(Collectors.toList());
        System.out.println(lstSorted);

        numbers1.stream().map(x -> x*x).distinct().forEach(y -> System.out.println(y));

    }

    public static List<Person> GetPeople()
    {

        ObjectMapper mapper = new ObjectMapper();
        URL url = null;
        Person[] peopleArray = null;

        try {
            url = new URL("file:lambda.people.json");

        } catch (MalformedURLException e) {

            e.printStackTrace();
        }

        try {
            peopleArray = mapper.readValue(url, Person[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArray));

        return people;
    }

    public static void OldWay(List<Person> people) {
        List<Person> utahns= new ArrayList<Person>();

        //old way
        for (Person person: people)
        {
            if(person.getState().equals("UT"))
                utahns.add(person);
        }
        System.out.println(utahns);

    }

    public static void NewWayUtah(List<Person> people) {
        List<Person> utahns= people.stream().filter(person -> person.getState().equals("UT")).collect(Collectors.toList());
        System.out.println(utahns);
    }

    public static void floridaMan(List<Person> people) {
        List<Person> floridaMan = people.stream().filter(person -> person.getState().equals("FL")).collect(Collectors.toList());
        System.out.println(floridaMan);
    }

    public static void NewWayDoNet(List<Person> people){
        List<Person> dotNetOrAE = people.stream().filter
                (person -> (person.getName().charAt(0) >= 'A' &&
                        person.getName().charAt(0) <= 'E')
                || person.getEmail().endsWith(".net")).collect(Collectors.toList());
        for (Person p: dotNetOrAE){
            System.out.println(p.getName());
            System.out.println(p.getEmail());
            System.out.print("\n");
        }
    }

    public static void NewWayCAUT(List<Person> people) {
        List<Person> phoneNumberInCAUT = people.stream().filter
                        (p -> p.getState().equals("CA") || p.getState().equals("UT"))
                .sorted(Comparator.comparing(Person::getPhone)).collect(Collectors.toList());

        for (Person p : phoneNumberInCAUT) {
            System.out.println(p.getPhone());
            System.out.println(p.getState());
        }
    }

    public static void qAnonFinderLol(List<Person> people) {
        List<Person> qEmail = people.stream().filter
                (p -> p.getEmail().contains("q")).sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        for (Person p: qEmail){
            System.out.println(p.getName());
            System.out.println(p.getEmail() + "\n");
        }
    }

    public static void main(String[] args) {
        List<Person> people = GetPeople();
        floridaMan(people);
        NewWayDoNet(people);
        NewWayCAUT(people);
        qAnonFinderLol(people);
    }
}
