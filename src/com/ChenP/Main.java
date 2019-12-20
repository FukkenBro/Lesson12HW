package com.ChenP;

//
//1) Написать класс Person, у которого если следующие поля:
//        - Фамилия, Имя, Отчество, дата рождения.
//        Написать конструкторы:
//        - на все поля,
//        - только на ФИО
//        - который принимает 1 параметр - строку с полным именем "Иванов Иван Иванович", и задает отдельные значения в поля Фамилия, Имя, Отчество.
//        Написать методы:
//        - который возвращает полное ФИО типа "Иванов Иван Иванович"
//        - краткое ФИО типа "Иванов И. И."
//        - который на основе даты рождения выводит количество полных лет.
//        2*) Дата рождения задается как строка типа "18.12.1985"

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] name = PersonGenerator.setName();
        String[] date = PersonGenerator.setDate();
        Person person1 = new Person(name[1], name[0], name[2], date);
        Person person2 = new Person(name[1], name[0], name[2]);
        System.out.println(person1.getDob());
        System.out.println(person1.getAge() + " лет");
        System.out.println(person1.getNameTemplate1());
        System.out.println(person1.getNameTemplate2());
    }
}
