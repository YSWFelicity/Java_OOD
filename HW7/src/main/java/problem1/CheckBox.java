package problem1;

/**
 * CheckBox is a class that implements the IValidator interface, which takes
 * Boolean as its generics.
 */
public class CheckBox implements IValidator<Boolean>{

  /**
   * isValid is a method to check whether the given input is valid or not
   *
   * @param input - the given input, expected as a boolean
   * @return true if the input is null
   */
  @Override
  public boolean isValid(Boolean input) {
    if (input == null){
      return true;
    }
    return false;
  }


}