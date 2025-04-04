package org.example;

// Fig. 17.12: ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysAndStreams2 {
   public static void main(String[] args) {
      String[] strings = 
         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));

      // strings in uppercase
      System.out.printf("strings in uppercase: %s%n",
         Arrays.stream(strings)             
               .map(String::toUpperCase)   
               .collect(Collectors.toList()));

      // strings less than "n" (case insensitive) sorted ascending
      System.out.printf("strings less than n sorted ascending: %s%n",
         Arrays.stream(strings)                            
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER)
               .collect(Collectors.toList()));             

      // strings less than "n" (case insensitive) sorted descending
      System.out.printf("strings less than n sorted descending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
               .collect(Collectors.toList()));

      System.out.printf("strings that start with a vowel: %s%n",
              Arrays.stream(strings)
                      .filter(word -> {
                         String vowel = "aeiouAEIOU";
                         boolean isVowel = false;
                         for (int i = 0; i < vowel.length(); i++) {
                            if (word.startsWith(String.valueOf(vowel.charAt(i))))
                               isVowel = true;
                         }
                         return isVowel;
                      })
                      .collect(Collectors.toList()));
      StringBuilder allStrings = new StringBuilder();
      Arrays.stream(strings).forEach(word -> {
         allStrings.append(word).append(", ");
      });
      System.out.printf("all strings as one string: %s%n", allStrings.toString());
      System.out.printf("strings that have more than 5 characters: %s%n",
              Arrays.stream(strings)
                      .filter(word -> {
                          return word.length() > 5;
                      })
                      .collect(Collectors.toList()));

   }

} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
