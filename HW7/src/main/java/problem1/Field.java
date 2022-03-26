package problem1;

public class Field <T> {
  private String label;
  private T value;
  private boolean required;
  private IValidator validator;

  public void updateValue(T input) {
    if (validator.isValid(input)) {
      this.value = input;
    }
  }

  public boolean isFilled() {
    return !this.required || (this.value != null & validator.isValid(this.value));
  }

}
