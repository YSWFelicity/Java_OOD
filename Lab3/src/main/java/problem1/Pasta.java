package problem1;

import java.time.LocalDateTime;

public class Pasta extends NonPerishableFoodItem{

  protected Pasta(String name, Double currentPrice, Integer currentQuantity, Integer maxAllowedQuantity) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity);
  }
}
