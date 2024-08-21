import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Menampilkan menu utama
            System.out.println("Pilih opsi:");
            System.out.println("1. Sudoku Verification");
            System.out.println("2. Longest Consecutive Sequence");
            System.out.println("3. Knights Tour Problem");
            System.out.println("4. Maximum Rectangle");
            System.out.println("5. Keluar");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    SudokuVerification sudokuVerification = new SudokuVerification();
                    sudokuVerification.run();
                    break;

                case 2:
                    LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
                    longestConsecutiveSequence.run();
                    break;

                case 3:
                    KnightsTourProblem knightsTourProblem = new KnightsTourProblem();
                    knightsTourProblem.run();
                    break;

                case 4:
                    MaximumRectangle maximumRectangle = new MaximumRectangle();
                    maximumRectangle.run();
                    break;

                case 5:
                    running = false;
                    System.out.println("Keluar dari aplikasi.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
                    break;
            }

            if (choice >= 1 && choice <= 4) {
                System.out.println("Tekan Enter untuk kembali ke menu utama...");
                scanner.nextLine();  // Wait for user to press Enter
            }
        }

        scanner.close();
    }
}