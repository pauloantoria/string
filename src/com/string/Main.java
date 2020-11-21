package com.string;

import java.util.*;

public class Main {
    List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.loadStrings ("Goku",
                "Vegeta",
                "Gohan",
                "Goten",
                "Trunks",
                "Piccoro",
                "Bulma",
                "Jiren",
                "Gogeta",
                "Pan");

        var sortAlphabeticByAnonymousClass = main.sortAlpabheticAnonymousClass();
        var sortAlphabeticByLamda = main.sortAlpabheticLambaFunction();
        var sortAlphabeticByReference = main.sortAlpabheticReference();
        var sortLenghtAnonymousClass = main.sortLenghtAnonymousClass();
        var sortLenghtLambaFunction = main.sortLenghtLambaFunction();
        var sortLenghtReference = main.sortLenghtReference();

        main.showList(sortAlphabeticByAnonymousClass);
        main.showList(sortAlphabeticByLamda);
        main.showList(sortAlphabeticByReference);
        main.showList(sortLenghtAnonymousClass);
        main.showList(sortLenghtLambaFunction);
        main.showList(sortLenghtReference);

    }

    public void loadStrings(String...strings){
        this.strings.addAll(Arrays.asList(strings));
    }

    public List<String> sortAlpabheticAnonymousClass(){
        List<String> strings = this.strings;
        strings.sort(String::compareToIgnoreCase);
        return strings;
    }

    public List<String> sortAlpabheticLambaFunction(){
        List<String> strings = this.strings;
        strings.sort(String::compareToIgnoreCase);
        return  strings;
    }

    public List<String> sortAlpabheticReference(){
        List<String> strings = this.strings;
        SortAlphabetic sortAlphabetic = new SortAlphabetic();
        strings.sort(sortAlphabetic::compare);
        return  strings;
    }

    public List<String> sortLenghtAnonymousClass(){
        List<String> strings = this.strings;
        strings.sort( new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        return strings;
    }

    public List<String> sortLenghtLambaFunction(){
        List<String> strings = this.strings;
        strings.sort((str1,str2) ->  str1.length() - str2.length());
        return  strings;
    }

    public List<String> sortLenghtReference(){
        List<String> strings = this.strings;
        SortLenght sortLenght = new SortLenght();
        strings.sort(sortLenght::compare);
        return  strings;
    }


    public void showList(List<String> list){
        list.forEach(System.out::println);
    }
}

class SortAlphabetic implements Comparator{

    public static int sort(Object o, Object o1) {
        return o.toString().compareToIgnoreCase(o1.toString());
    }

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}

class SortLenght implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().length() - o2.toString().length();
    }
}