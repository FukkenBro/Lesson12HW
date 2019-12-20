package com.ChenP;

import java.util.*;

public class PersonGenerator {

    public static String[] setName() {
        System.out.println("Введите ФИО");
        Scanner scanner = new Scanner(System.in);
        String nameScanner = scanner.nextLine();
        StringBuilder sb = new StringBuilder(nameScanner);
        try {
            String[] name = nameScanner.split("\\s+");
            String[] nameRecognized = nameRecognizer(name);
            return nameRecognized;
        } catch (Exception e) {
            error();
            setName();
        }
        return setName();
    }

    private static String[] nameRecognizer(String[] name) {

        String[] result = new String[3];
        //Лишние переменные создаю осознанно для наглядности
        if (name.length == 1) {
            Scanner scanner = new Scanner(System.in);
            String lasttName = name[0];
            result[0] = lasttName;
            System.out.println("Введите Имя");
            if (scanner.hasNextLine()) {
                String firstName = scanner.nextLine();
                result[1] = firstName;
            } else {
                error();
                setName();
            }
            System.out.println("Введите Отчество");
            String patronym = scanner.nextLine();
            result[2] = patronym;
            return result;
        } else {
            String firstName = name[0];
            result[0] = firstName;
            String lastName = name[1];
            result[1] = lastName;
            String patronym = name[2];
            result[2] = patronym;
            return result;
        }
    }

    public static String[] setDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате ДД.ММ.ГГГГ");
        String dateScanner = "";
        if (scanner.hasNextLine()) {
            dateScanner = scanner.nextLine();
            StringBuilder sb = new StringBuilder(dateScanner);
            if (sb.length() == 10) {
                try {
                    String[] date = sb.toString().split("\\.");
                    dateValidator(date);
                    return date;
                } catch (Exception e) {
                    error();
                    setDate();
                }
            } else {
                error();
                setDate();
            }
        }
        error();
        return setDate();
    }

    private static void dateValidator(String[] date) {

        int tmpD = Integer.parseInt(date[0]);
        int tmpM = Integer.parseInt(date[1]);
        int tmpY = Integer.parseInt(date[2]);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        boolean dateValidatorD = false;
        boolean dateValidatorM = false;
        boolean dateValidatorY = false;

        if (tmpY >= 1900 && tmpY <= currentYear) {
            dateValidatorY = true;
        }
        if (tmpD <= 31 && tmpD != 0) {
            dateValidatorD = true;
        }

        if (tmpM <= 12 && tmpM != 0) {
            dateValidatorM = true;
        }
        if (tmpM == 2 && tmpD > 29) {
            error();
            setDate();
        }

        if (dateValidatorD == true && dateValidatorM == true && dateValidatorY == true) {
            return;
        }
        error();
        setDate();
    }

    private static void error() {
        System.out.println("Ошибка ввода");
    }
}