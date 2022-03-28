package problem1;

/**
 * RadioButton is a class that implements the IValidator interface, which takes
 * Boolean as its generics.
 */
public class RadioButton implements IValidator<Boolean>{

  /**
   * isValid is a method to check whether the given input is valid or not
   *
   * @param input - the given input, expected as a boolean
   * @return false if the input is null
   */
  @Override
  public boolean isValid(Boolean input) {
    if (input == null){
      return false;
    }
    return true;
  }
}