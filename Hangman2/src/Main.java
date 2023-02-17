import javax.script.Bindings;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main
{
    public static void drawHangman(int strikes)
    {
        String art = "art";

        if(strikes >= 0 && strikes <= 5)
        {
            art += "" + strikes;
        }
        else
        {
            art += "6";
        }
        art += ".txt";
        try
        {
            String str = new String(Files.readAllBytes(Paths.get(art)));
            System.out.println(str);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void hangman()
    {
        Scanner scan = new Scanner(System.in);

        boolean isPlaying = true;
        String missedLetters = "";

        String guessString;
        char guess;
        String answerWord = "cat";
        char[] progress = new char[answerWord.length()];
        progress[0] = '_';
        progress[1] = '_';
        progress[2] = '_';
        char[] answer = new char[answerWord.length()];
        answer[0] = answerWord.charAt(0);
        answer[1] = answerWord.charAt(1);
        answer[2] = answerWord.charAt(2);

        ArrayList<Character> guesses = new ArrayList<>();
        int wrongGuesses = 0;

        String name;
        String scoreString = "6";
        String scoreHolder = "Matt";
        int highScore;

        System.out.println("H A N G M A N");

        System.out.println("What is your name?");
        name = scan.nextLine();

        try
        {
            scoreString = new String(Files.readAllBytes(Paths.get("score.txt")));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        highScore = Integer.parseInt("" + scoreString.charAt(0));
        scoreHolder = scoreString.substring(scoreString.indexOf('_') + 1);

        if(scoreHolder.equals(name))
        {
            System.out.println("You have the high score: " + highScore);
        }
        else
        {
            System.out.println("High Score is " + highScore + ", achieved by " + scoreHolder);
        }

        while(missedLetters.length() < 6 && isPlaying)
        {
            drawHangman(missedLetters.length());
            System.out.println("Missed letters: " + missedLetters);
            System.out.println("Number of missed guesses: " + wrongGuesses);
            System.out.println(progress);
            System.out.println("Guess a letter");
            guessString = scan.nextLine();
            guessString.toLowerCase();
            guess = guessString.charAt(0);

            if(missedLetters.indexOf(guess) != -1 ||
                    (answerWord.indexOf(guess) != -1 && progress[answerWord.indexOf(guess)] != '_'))
            {
                System.out.println("You have already guessed that letter.");
            }
            else
            {
                if(answerWord.indexOf(guess) == -1)
                {
                    missedLetters += guess;

                    guesses.add(guess);

                    wrongGuesses = (int) guesses.stream().map(c -> c.toString()).filter(c -> !answerWord.contains(c)).count();
                }
                else
                {
                    if(answer[0] == guess)
                    {
                        progress[0] = guess;
                        guesses.add(guess);
                    }
                    if(answer[1] == guess)
                    {
                        progress[1] = guess;
                        guesses.add(guess);
                    }
                    if(answer[2] == guess)
                    {
                        progress[2] = guess;
                        guesses.add(guess);
                    }
                    isPlaying = false;
                    if(progress[0] == '_')
                    {
                        isPlaying = true;
                    }
                    if(progress[1] == '_')
                    {
                        isPlaying = true;
                    }
                    if(progress[2] == '_')
                    {
                        isPlaying = true;
                    }
                }
            }
        }

        if(isPlaying)
        {
            drawHangman(missedLetters.length());
            System.out.println("Too bad! The secret word is " + answerWord + ". You have lost.");
        }
        else
        {
            System.out.println("Yes! The secret word is " + answerWord + "! You have won!");
        }

        if(missedLetters.length() < highScore)
        {
            System.out.println("You beat the high score!");
            try
            {
                PrintWriter writer = new PrintWriter("score.txt", "UTF-8");
                writer.print(missedLetters.length() + "_" + name);
                writer.close();
            }
            catch(Exception e)
            {

            }
        }

        System.out.println("Do you want to play again? (yes or no)");
        String input = scan.nextLine();
        input.toLowerCase();
        if(input.equals("yes"))
        {
            missedLetters = "";
            isPlaying = true;
            hangman();
        }
    }

    public static void main(String[] args)
    {
        hangman();
    }
}
