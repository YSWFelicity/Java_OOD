package problem1;

import java.util.Objects;

/**
 * generic class IField, including label, value, required, and validator
 *
 * @param <T> the type of the field value
 */
public class Field<T> implements IField<T> {

  private String label;
  private T value;
  private boolean required;
  private IValidator<T> validator;

  /**
   * @param label     String, associated with the form field
   * @param required  Boolean, A boolean indicating whether a particular field must be completed
   *                  before the form can be submitted.
   * @param validator IValidator<T>, perform input validation value is instantiated to null
   */
  public Field(String label, boolean required, IValidator<T> validator) {
    this.label = label;
    this.value = null;
    this.required = required;
    this.validator = validator;
  }

  /** set value
   * @param value T, value
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * get label
   * @return String, the label
   */
  public String getLabel() {
    return label;
  }

  /** get value
   * @return T, the value
   */
  public T getValue() {
    return value;
  }

  /** check is the particular required
   * @return true if required, false otherwise
   */
  public boolean isRequired() {
    return required;
  }

  /**
   * get validator
   * @return IValidator, validator
   */
  public IValidator<T> getValidator() {
    return validator;
  }

  /**
   * update the value of the field
   * @param input T, either be String or Boolean
   * @throws InvalidInputException  If input is not valid, throw an exception and do
   *                                not update value.
   */
  @Override
  public void updateValue(T input) throws InvalidInputException {
    if (validator.isValid(input)) {
      this.value = input;
    } else {
      throw new InvalidInputException("Invalid input");
    }
  }

  /**
   * check if the field is filled.
   *
   * @return Boolean -- return true if the Field is not required, or has been filled out if it
   * required.
   */
  @Override
  public boolean isFilled() {
    return !this.required || (this.value != null && validator.isValid(this.value));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Field<?> field = (Field<?>) o;
    return required == field.required && Objects.equals(label, field.label)
        && Objects.equals(value, field.value) && Objects.equals(validator,
        field.validator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, value, required, validator);
  }

  @Override
  public String toString() {
    return "Field{" +
        "label='" + label + '\'' +
        ", value=" + value +
        ", required=" + required +
        ", validator=" + validator +
        '}';
  }
}