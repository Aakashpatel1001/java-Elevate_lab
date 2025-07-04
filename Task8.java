import java.util.*;

public class Task8 {

    // Inner class to represent a question
    static class QuizQuestion {
        String question;
        List<String> options;
        int correctOption;

        QuizQuestion(String question, List<String> options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }

        void displayQuestion() {
            System.out.println(question);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
        }

        boolean checkAnswer(int userAnswer) {
            return userAnswer == correctOption;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<QuizQuestion> questions = new ArrayList<>();

        // Adding questions
        questions.add(new QuizQuestion(
            "Which language is used to develop Android apps?",
            Arrays.asList("Python", "Java", "Swift", "Kotlin"), 4
        ));

        questions.add(new QuizQuestion(
            "What is the capital of India?",
            Arrays.asList("Mumbai", "Delhi", "Kolkata", "Chennai"), 2
        ));

        questions.add(new QuizQuestion(
            "Which planet is known as the Red Planet?",
            Arrays.asList("Earth", "Mars", "Jupiter", "Venus"), 2
        ));

        questions.add(new QuizQuestion(
            "Who wrote the national anthem of India?",
            Arrays.asList("Tagore", "Nehru", "Gandhi", "Patel"), 1
        ));

        // Start quiz
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            QuizQuestion q = questions.get(i);
            q.displayQuestion();
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();
            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        // Display result
        System.out.println("\nQuiz Over! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}
