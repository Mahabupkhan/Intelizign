package csvTraining;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvDemo {
    static Map<Integer, Person> peoples = new HashMap<Integer, Person>();
    static String fileLocation = "C:\\Users\\abdur\\OneDrive\\Desktop\\Intelizign\\Json Practice\\csvExample.csv";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        read2();
    }

    public static void read2() throws FileNotFoundException, IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(fileLocation))) {
            String line = "";
            while ((line = bf.readLine()) != null) {
                if (line.contains("id")) {
                    continue;
                }
                String[] splitted = line.split(",");
                int id = Integer.parseInt(splitted[0].trim());
                String name = splitted[1].trim();
                int age = Integer.parseInt(splitted[2].trim());
                String city = splitted[3].trim();
                int grade = Integer.parseInt(splitted[4].trim());

                peoples.put(id, new Person(id, name, age, city, grade));
            }
            for (Map.Entry<Integer, Person> en : peoples.entrySet()) {
                System.out.println(en.getKey() + "\n" + en.getValue());
            }
        }
    }
}

class Person {
    int id;
    String name;
    int age;
    String city;
    int grade;

    Person(int id, String name, int age, String city, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name : " + name + "\n" +
                "Age : " + age + "\n" +
                "City : " + city + "\n" +
                "Grade : " + grade;
    }
}
