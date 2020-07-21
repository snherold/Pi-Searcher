package utils;

public class Misc {

  // converts ascii numbers into integers if applicable
  // returns -1 if passed -1 meaning buffered reader is at eof
  // returns -2 if number doesn't map to an integer character and can be ignored
  public static int parseInt(int c) {
    switch(c) {
      case 48: return 0;
      case 49: return 1;
      case 50: return 2;
      case 51: return 3;
      case 52: return 4;
      case 53: return 5;
      case 54: return 6;
      case 55: return 7;
      case 56: return 8;
      case 57: return 9;
      case -1: return -1; //eof
      default: return -2;
    }
  }
}
