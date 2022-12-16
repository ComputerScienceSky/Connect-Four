package connectfour;

/** Implements a ConnectFour board */
public class Board {
  static final int ROWS = 6; // The number of rows on the board.
  static final int COLUMNS = 7; // The number of columns on the board.

  // board is the instance variable that stores the actual board, a 2-array of
  // chars.
  // The possible characters stored in the board include:
  // ' ' - Empty Space
  // 'R' - Red checker
  // 'Y' - Yellow checker
  private char[][] board;

  /**
   * Constructor of a Board object.
   *
   * Instantiates the 'board' variable and initializes all of the cells to ' '.
   */
  public Board() {
    board = new char[6][7];

    for (int i = 0; i < ROWS; i++) {
      for (int x = 0; x < COLUMNS; x++) {
        board[i][x] = ' ';
      }
    }
  }

  /**
   * Returns a String representation of the current board. The String will be
   * printed to System.out by ConnectFour.java.
   * See the format in the assignment PDF.
   */
  public String toString() {
    String str = "";
    for (int i = 0; i < ROWS; i++) {
      for (int x = 0; x < COLUMNS; x++) {
        str += "|" + board[i][x];
      }
      str += "| \n";
    }
    str += "----------------";
    return str;
  }

  /**
   * Attempts to drop the specified checker in the specified column. If the
   * checker is
   * successfully dropped, the method adds the checker to the board variable and
   * returns true.
   * If the specified column is full, the method returns false.
   */
  public boolean dropChecker(int column, char checker) {
    for (int i = ROWS - 1; i >= 0; i--) {
      if (board[i][column] == ' ') {
        board[i][column] = checker;
        return true;
      }
    }
    return false;
  }

  /** Determines if the game has a winner.  The method returns true if either user
    * has four in a row in any direction (including along a diagonal!).
    **/
  public boolean checkWinner() {
    //horizontal
    for(int i = ROWS - 1; i > 0; i--){
      for(int x = COLUMNS - 1; x > 2; x--){
        if(board[i][x] == board[i][x - 1]  && board[i][x-1] == board[i][x - 2] && board[i][x - 2] == board[i][x - 3] && board[i][x - 3] != ' '){
          return true;
        }
      }
      if(i > 3){
        for(int j = 0; j < COLUMNS; j++){
          if(board[i][j] == board[i - 1][j]  && board[i - 1][j] == board[i - 2][j] && board[i - 2][j] == board[i - 3][j] && board[i][j] != ' '){
            return true;
          }
        }
        for(int c = 0; c < COLUMNS - 3; c++){
          if (board[i][c] == board[i - 1][c + 1] && board[i - 1][c + 1] == board[i - 2][c + 2] && board[i - 2][c + 2] == board[i - 3][c + 3] && board[i][c] != ' '){
            return true;
          } 
        }
      }
    }
    for(int i = 0; i < ROWS - 3; i++){
      for(int x = 0; x < COLUMNS-3; x++){
        if(board[i][x] == board[i + 1][x + 1] && board[i + 1][x + 1] == board[i + 2][x + 2] && board[i + 2][x + 2] == board[i + 3][x + 3] && board[i][x] != ' '){
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Determines if the game is a draw.
   * This method assumes the user already checked if there is a winner via a call
   * to
   * checkWinner. This method returns true if there are no more blank squares.
   */
  public boolean checkDraw() {
    for (int i = 0; i < ROWS; i++) {
      for (int x = 0; x < COLUMNS; x++) {
        if (board[i][x] == ' ') {
          return false;
        }
      }
    }
    return true;
  }
}
