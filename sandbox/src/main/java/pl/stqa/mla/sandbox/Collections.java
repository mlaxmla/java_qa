package pl.stqa.mla.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");

    List<String> languages2 = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languages) {
      System.out.println(">I want to learn " + l);
    }

    for (String l2 : languages2) {
      System.out.println(">>I want to learn " + l2);
    }

    for (int i = 0; i < languages2.size(); i++) {
      System.out.println(">>>I want to learn " + languages2.get(i));
    }

    // konstrukcja iteracji po listach, tablicach, kolekcjach (bez licznika)
    for (String l : languages2) {
      System.out.println(">>>>I want to learn " + l);
    }
  }

}
