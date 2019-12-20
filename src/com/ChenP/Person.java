package com.ChenP;

import java.util.Calendar;

public class Person {

    private String firstName;
    private String lastName;
    private String patronym;
    private String[] dob;


    public Person(String firstName, String lastName, String patronym, String[] dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronym = patronym;
        this.dob = dob;
    }

    public Person(String firstName, String lastName, String patronym) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronym = patronym;
    }

    public String getNameTemplate1() {
        String result = lastName + " " + firstName + " " + patronym;
        return result;
    }

    public String getNameTemplate2() {
        String result = lastName + " " + firstName.charAt(0) + ". " + patronym.charAt(0) + ".";
        return result;
    }

    public String getDob() {
        StringBuilder sb = new StringBuilder("");
        return sb.append(dob[0]).append(".").append(dob[1]).append(".").append(dob[2]).toString();
    }

    public int getAge() {
        StringBuilder sb = new StringBuilder("");
        sb.append(dob[0]).append(".").append(dob[1]).append(".").append(dob[2]);
        String dob = sb.toString();
        String[] date = dob.split("\\.");
        int tmpD = Integer.parseInt(date[0]);
        int tmpM = Integer.parseInt(date[1]);
        int tmpY = Integer.parseInt(date[2]);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        // +/- один день в каждый из высокостных годов
        int daysSince1900 = ((tmpY - 1900) * 12 + tmpM) * 365 + tmpD;

        int currentDSince1900 = ((currentYear - 1900) * 12 + currentMonth) * 365 + currentDay;

        double age = (currentDSince1900 - daysSince1900) / 365 / 12;
        return (int) Math.round(age);

    }

}
