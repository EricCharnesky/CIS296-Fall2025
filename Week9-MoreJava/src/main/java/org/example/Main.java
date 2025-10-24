package org.example;

import java.sql.*;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.time.*;






public class Main {




    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        while ( choice != 3 ) {

            System.out.println("Enter 1 to add, 2 to read, 3 to quit");
            choice = Integer.parseInt(keyboard.nextLine());

            if (choice == 1) {

                    System.out.println("Enter firstname, lastname, major, gpa");
                    String text = keyboard.nextLine();
                    String[] split = text.split(",");
                    String firstName = split[0];
                    String lastName = split[1];
                    String major = split[2];
                    double gpa = Double.parseDouble(split[3]);

                CollegeDB.addStudent(new Student(0,  firstName, lastName, major, gpa));


            } else if (choice == 2) {

                ArrayList<Student> students = CollegeDB.getStudents();

                for (Student student : students) {
                    System.out.println(student);
                }

            }
        }



//
//        LocalDate now = LocalDate.now();
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL);
//        String currentDateTimeFormatted = dtf.format(now);
//        System.out.println(currentDateTimeFormatted);
//
//        HashMap<String, ArrayList<Food>> stores = new HashMap<>();
//        ArrayList<Food> foods = new ArrayList<>();
//        foods.add(new Food("Olive Burger", 5.99, 1));
//        stores.put("A&W", foods);
//
//        ArrayList<Food> listOfFood =  new ArrayList<>();
//        listOfFood.add(new Food("Popcorn", 700, 1));
//        listOfFood.add( new Food("Pizza", 800, 1));
//        listOfFood.add( new Food("Chicken", 900, 2));
//        listOfFood.add( new Food("Beef", 900, 3));
//
//        Collections.sort(listOfFood);
//
//
//
//        String longSentence = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,";
//
//        String[] tokens = longSentence.split(" ");
//
//        for (String token : tokens) {
//            System.out.println(token);
//        }
//
//        //List<String> foods = new java.util.ArrayList<>(List.of(new String[]{"popcorn", "pizza", "hamburger", "rib-eye"}));
//
//        Collections.sort(foods);
//
//        System.out.print("My favorite foods are ");
//        //System.out.println(String.join(", ", foods));
//
//        // memory efficient way of building a string from tokens
//        StringBuilder someList = new StringBuilder();
//        for (String token : tokens) {
//            someList.append(token).append(", ");
//        }
//
//        // use toString() to get the final string out
//        System.out.println(someList.toString());
    }
}