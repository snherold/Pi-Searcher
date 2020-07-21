import structures.*;
import utils.*;

import java.io.*;
import java.util.LinkedList;

public class MainDriver {
  final static int SEQUENCE_LENGTH = 7;

  public static void main(String[] args) {

    long[] countArray = new long[SEQUENCE_LENGTH];
    long[] lastFound = new long[SEQUENCE_LENGTH];
    TreeNode testTree = new TreeNode(SEQUENCE_LENGTH);
    long[] powArray = new long[SEQUENCE_LENGTH];

    for (int i = 0; i < powArray.length; i++) {
      powArray[i] = (long)Math.pow(10, i+1);
      lastFound[i] = 0;
      countArray[i] = 0;
    }

    try {
      long posCounter = 0;
      //BufferedReader br = new BufferedReader(new FileReader("100000Pi.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(
          new FileInputStream("C:\\Users\\herol\\Desktop\\1_million_pi_digits.txt")));
      LinkedList<Integer> currentSequence = new LinkedList<Integer>();

      // fill currentSequence with enough values from txt file to reach SEQUENCE_LENGTH
      int input = -1;
      while (currentSequence.size() < SEQUENCE_LENGTH) {
        input = Misc.parseInt(br.read());
        if (input >= 0) {
          currentSequence.addLast(input);
        }
        else if (input == -1) {
          break;
        }
      }

      // main processing
      while (input != -1) {
        Tree.processSequence(currentSequence, testTree, countArray);
        posCounter++;
        currentSequence.pop();

        for (int checkIter = 0; checkIter < countArray.length; checkIter++) {
          if (lastFound[checkIter] == 0 && countArray[checkIter] == powArray[checkIter]) {
            lastFound[checkIter] = posCounter;
          }
        }

        // Find next single digit int in file or eof (ignore non-integer characters).
        // Add int to end of currentSequence if found.
        // Continue to exit loop if eof
        do {
          input = Misc.parseInt(br.read());
        } while (input < -1);
        if (input != -1) {
          currentSequence.addLast(input);
        }
      }

      // TODO: another loop that continues processing sequences and removing the first element
      // without adding anything back to the end so that the sequence continues to shrink
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      System.out.println(e);
    }
    System.out.printf("%10s : %10s | %10s | %s\n", "Length", "Found", "Out of", "Last Found Position");
    for (int i = 0; i < countArray.length; i++) {
      System.out.printf("%10d : %10d | %10d |", i+1, countArray[i], (int)Math.pow(10, i+1));
      if (powArray[i] <= countArray[i]) {
        System.out.printf("%10d", lastFound[i]);
      }
      System.out.print("\n");
    }
  }


}
