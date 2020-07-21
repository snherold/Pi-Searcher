package structures;

public class Digit {

  private TreeNode nextNode;  // stores reference to the next node in the tree.
                              // This represents the next digit in the number
  private int count;          // Number of times this digit has been found in this position

  //-----------------------------------------------------------
  // Constructors
  //-----------------------------------------------------------

  // for automatic generation of tree
  public Digit(int height) {

    if (height > 1) {
      setNextNode(new TreeNode(height - 1));
    }
    else {
      setNextNode(null);
    }

    setCount(0);
  }

  // allows manual setting of nextNode
  public Digit(TreeNode nextNode) {
    setNextNode(nextNode);
    setCount(0);
  }

  public Digit() {
    this(null);
  }


  //-----------------------------------------------------------
  // Getters and Setters
  //-----------------------------------------------------------

  public void setNextNode(TreeNode nextNode) {
    this.nextNode = nextNode;
  }

  public TreeNode getNextNode() {
    return nextNode;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getCount() {
    return count;
  }

  public void increaseCount() {
    if (getCount() == 0)
      this.count += 1;
  }

  //-----------------------------------------------------------
  // Helpers
  //-----------------------------------------------------------


}
