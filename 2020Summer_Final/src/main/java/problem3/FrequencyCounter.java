package problem3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

  public static Map<Integer, IntegerInfo> frequencyCounter(List<Integer> consideredInts){
    Map<Integer, IntegerInfo> resultingMap = new HashMap<>();

    for(Integer myInt: consideredInts){
      IntegerInfo intInfo = resultingMap.getOrDefault(myInt, new IntegerInfo(myInt, 0, String.valueOf(myInt).length()));
      intInfo.setNumOccurrences(intInfo.getNumOccurrences() + 1);
      resultingMap.put(myInt, intInfo);
    }
    return resultingMap;
  }

}
