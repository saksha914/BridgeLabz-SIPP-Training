import java.util.Scanner;

public class RockPaperScissors {
    // Method to get computer choice
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        switch (choice) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }

    // Method to find winner
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("scissors") && computer.equals("paper")) ||
            (user.equals("paper") && computer.equals("rock"))) {
            return "User";
        }
        return "Computer";
    }

    // Method to calculate stats
    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        String[][] stats = new String[3][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", (userWins * 100.0) / totalGames) + "%";
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", (computerWins * 100.0) / totalGames) + "%";
        stats[2][0] = "Draws";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f", (draws * 100.0) / totalGames) + "%";
        return stats;
    }

    // Method to display results
    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.printf("%-10s %-15s %-15s %-10s\n", "Game", "User", "Computer", "Winner");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10d %-15s %-15s %-10s\n", i + 1, gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }
        System.out.println("\nStats:");
        System.out.printf("%-10s %-10s %-15s\n", "Player", "Wins", "Win %");
        for (String[] row : stats) {
            System.out.printf("%-10s %-10s %-15s\n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[][] gameResults = new String[n][3];
        int userWins = 0, computerWins = 0, draws = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (rock/paper/scissors): ");
            String user = scanner.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = findWinner(user, computer);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;
            gameResults[i][0] = user;
            gameResults[i][1] = computer;
            gameResults[i][2] = winner;
        }
        String[][] stats = calculateStats(userWins, computerWins, draws, n);
        displayResults(gameResults, stats);
        scanner.close();
    }
} 