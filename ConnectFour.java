package connectfour;

import java.util.Scanner;

public class ConnectFour {
  // Player 0 is Red; Player 1 is Yellow
  // Use the following arrays to get a label or checker letter for the player.
  static String colorLabelCaps[] = { "Red", "Yellow" };
  static String colorLabel[] = { "red", "yellow" };
  static char colorChar[] = { 'R', 'Y' };

  public static void main(String[] args) {
    int player = 0; // Player 0 is red; Player 1 is yellow.

    Board board = new Board();
    Scanner input = new Scanner(System.in);

    System.out.println("> run connect 4");
    System.out.println(board);

    while (board.checkWinner() == false && board.checkDraw() == false) {
      System.out.println("Drop a " + colorLabel[player] + " chip at column (0-6)");
      int columnDrop = input.nextInt();

      if (board.dropChecker(columnDrop, colorChar[player])) {
        if (player == 1) {
          player = 0;
        } else {
          player = 1;
        }
        System.out.println(board);
      } else {
        System.out.println("The column is full. Please pick another column to drop your token in.");
      }
    }

    if (board.checkWinner()) {
      if (player == 1) {
        player = 0;
      } else {
        player = 1;
      }
      System.out.println(colorLabelCaps[player] + " wins!");
    } else {
      System.out.println("It's a Draw!");
    }
  }
}
