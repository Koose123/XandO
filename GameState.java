
package ui;

public class GameState {
    public static String playerOneName = "Player 1";
    public static String playerTwoName = "Player 2";
    public static int playerOneScore = 0;
    public static int playerTwoScore = 0;
    public static int draws = 0;

    public static void setPlayerNames(String one, String two) {
        playerOneName = (one == null || one.trim().isEmpty()) ? "Player 1" : one.trim();
        playerTwoName = (two == null || two.trim().isEmpty()) ? "Player 2" : two.trim();
    }
}
