package utils;

import structures.TreeNode;

import java.util.LinkedList;

public class Tree {

  // returns the height of the node in the tree with bottom leaves=1
  public static int getHeight(TreeNode node) {
    int height = 1;
    TreeNode currentNode = node;
    while (currentNode.getDigit(0).getNextNode() != null) {
      currentNode = currentNode.getDigit(0).getNextNode();
      height++;
    }
    return height;
  }

  // length of sequence can't be more than the height of the top node
  public static void processSequence(LinkedList<Integer> sequence, TreeNode topNode, long[] countArray) {
    TreeNode currentNode = topNode;
    int pos = 0;
    while (pos < sequence.size() && currentNode != null) {
      if (currentNode.getDigit(sequence.get(pos)).getCount() == 0)
        countArray[pos]++;
      currentNode.getDigit(sequence.get(pos)).increaseCount();
      currentNode = currentNode.getDigit(sequence.get(pos)).getNextNode();
      pos++;
    }
  }

  //-----------------------------------------------------------
  // Helpers
  //-----------------------------------------------------------



}
