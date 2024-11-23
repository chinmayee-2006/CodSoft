import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class QuizApp {
    static String[][] quizData = {
            {"What is the capital of France?", "Berlin", "Paris", "Rome", "Madrid", "2"},
            {"Who developed the theory of relativity?", "Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla", "2"},
            {"Which planet is known as the Red Planet?", "Earth", "Venus", "Mars", "Jupiter", "3"}
    };

    static int score = 0; 
    static boolean timeUp = false; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz! Answer the questions before the timer runs out.");
        for (int i = 0; i < quizData.length; i++) {
            String question = quizData[i][0];
            String option1 = quizData[i][1];
            String option2 = quizData[i][2];
            String option3 = quizData[i][3];
            String option4 = quizData[i][4];
            String correctAnswer = quizData[i][5];
            System.out.println("\nQuestion " + (i + 1) + ": " + question);
            System.out.println("1. " + option1);
            System.out.println("2. " + option2);
            System.out.println("3. " + option3);
            System.out.println("4. " + option4);
            Timer timer = new Timer();
            timeUp = false;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up! Moving to the next question...");
                    synchronized (scanner) {
                        scanner.notify();
                    }
                }
            }, 10000); 
            int userAnswer = 0;
            synchronized (scanner) {
                while (!timeUp && userAnswer == 0) {
                    System.out.print("Your answer (1-4): ");
                    try {
                        if (scanner.hasNextInt()) {
                            userAnswer = scanner.nextInt();
                            if (userAnswer >= 1 && userAnswer <= 4) {
                                break;
                            } else {
                                System.out.println("Please enter a valid option (1-4).");
                                userAnswer = 0;
                            }
                        } else {
                            scanner.next(); // Clear invalid input
                            System.out.println("Please enter a valid option (1-4).");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
            timer.cancel();

            // Check the answer
            if (!timeUp && String.valueOf(userAnswer).equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else if (!timeUp) {
                System.out.println("Incorrect! The correct answer was: " + correctAnswer);
            }
        }

        // Display the result
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score: " + score + "/" + quizData.length);
        scanner.close();
    }
}
