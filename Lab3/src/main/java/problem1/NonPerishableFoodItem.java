package problem1;

public abstract class NonPerishableFoodItem extends FoodItem {

  protected NonPerishableFoodItem(String name, Double currentPrice, Integer currentQuantity, Integer maxAllowedQuantity) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity);
  }
}
