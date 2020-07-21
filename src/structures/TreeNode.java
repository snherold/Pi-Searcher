package structures;

public class TreeNode {

  // The digitArray stores the array of Digit structures.
  // Each Digit structure contains a count of occurrences and references to the next digits
  private Digit[] digitArray;


  //-----------------------------------------------------------
  // Constructors
  //-----------------------------------------------------------

  public TreeNode() {
    digitArray = new Digit[10];
  }

  public TreeNode(int height) {
    if (height > 0) {
      digitArray = new Digit[10];

      for (int digitInit = 0; digitInit < 10; digitInit++) {
        digitArray[digitInit] = new Digit(height);
      }
    }
  }


  //-----------------------------------------------------------
  // Getters and Setters
  //-----------------------------------------------------------

  public Digit getDigit(int digitIndex) throws IndexOutOfBoundsException {
    checkSingleDigit(digitIndex);
    return digitArray[digitIndex];
  }

  public void setDigit(int digitIndex, Digit newDigit) throws IndexOutOfBoundsException {
    checkSingleDigit(digitIndex);
    digitArray[digitIndex] = newDigit;
  }


  //-----------------------------------------------------------
  // Helpers
  //-----------------------------------------------------------

  private void checkSingleDigit(int digitIndex) throws IndexOutOfBoundsException {
    if (digitIndex < 0 || digitIndex > 9) {
      throw new IndexOutOfBoundsException("Index must be between 0 and 9");
    }
  }
}
