package p3;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor1 {

  public StringProcessor1() {

  }
  public static List<StringData> replaceLetters(char sourceChar, char destChar, List<String> stringList){
    List<StringData> myList = new ArrayList<>();
    for (String string : stringList) {
      Integer numberTimesReplaced = (int) countCharInString(string, sourceChar);
      String refactored = refactorString(sourceChar, destChar, string);
      StringData data = new StringData(string, refactored, numberTimesReplaced);
      myList.add(data);
    }
    return myList;
  }

  private static long countCharInString(String string, char sourceChar) {
    return string.toLowerCase().chars().mapToObj(c -> (char) c)
        .filter(c -> c.equals(sourceChar)).count();
  }

  private static String refactorString(char sourceChar, char destChar, String string) {
    if (countCharInString(string, sourceChar) ==0) {
      return null;
    }
    return string.toLowerCase().replace(sourceChar, destChar);
  }



}
