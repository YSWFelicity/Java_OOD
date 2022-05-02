package problem3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BiotechTrends {

  /**
   * Method trackEngagements takes a list of investors into biotech companies,
   * and returns a map, parametrized by the name of the biotech company, where the corresponding value
   * is equal to the number of investors who have engaged with the company
   * @param investors - list of investors
   * @return - map of biotech companies, where the key is the name of the company, and the value is
   * the number of investors
   */
  public static Map<String, Integer> trackEngagements(List<Investor> investors){
    Map<String, Integer> resultingMap = new HashMap<>();

    for(Investor investor: investors){
      for(String company: investor.getEngagedComapnies()){
        Integer numInterestedInvestors = resultingMap.getOrDefault(company, 0);
        resultingMap.put(company, ++numInterestedInvestors);
      }
    }
    return resultingMap;

  }

  public static Map<String, Long> trackEngagements2(List<Investor> investors){

    Map<String, Long> resultingMap = new HashMap<>();

//    for(Investor investor: investors){
//      resultingMap.putAll(investor.getEngagedComapnies()
//                                    .stream()
//                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
//    }

    resultingMap = investors.stream().flatMap(investor -> investor.getEngagedComapnies().stream())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return resultingMap;
  }

}
