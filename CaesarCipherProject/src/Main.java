import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main
{
    public static void encrypt(String message, int key)
    {
        char[] newMessage = message.toCharArray();
        for(int i = 0; i < message.length(); i++)
        {
            for(int j = 0; j < key; j++)
            {
                if(newMessage[i] == 'z')
                {
                    newMessage[i] = 'a';
                }
                else if(newMessage[i] == 'Z')
                {
                    newMessage[i] = 'A';
                }
                else if(newMessage[i] == ' ' || newMessage[i] == '.' || newMessage[i] == ',')
                {

                }
                else
                {
                    newMessage[i]++;
                }
            }
        }
        String str = "";
        for(char c : newMessage)
        {
            str += c;
        }
        System.out.println("Your encrypted message is:\n" + str);
        try
        {
            PrintWriter writer = new PrintWriter("message.txt", "UTF-8");
            writer.print(str);
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void decrypt(int key)
    {
        String message = "";
        try
        {
            message = new String(Files.readAllBytes(Paths.get("message.txt")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        char[] newMessage = message.toCharArray();
        for(int i = 0; i < message.length(); i++)
        {
            for(int j = 0; j < key; j++)
            {
                if(newMessage[i] == 'a')
                {
                    newMessage[i] = 'z';
                }
                else if(newMessage[i] == 'A')
                {
                    newMessage[i] = 'Z';
                }
                else if(newMessage[i] == ' ' || newMessage[i] == '.' || newMessage[i] == ',')
                {

                }
                else
                {
                    newMessage[i]--;
                }
            }
        }
        String str = "";
        for(char c : newMessage)
        {
            str += c;
        }
        System.out.println("Your translated text is:\n" + str);
        try
        {
            PrintWriter writer = new PrintWriter("message.txt", "UTF-8");
            writer.print(str);
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Do you wish to encrypt or decrypt a message?");
        String input = scan.nextLine().toLowerCase();
        System.out.println("Enter the key number (1-52)");
        int key = scan.nextInt();
        if(input.equals("encrypt"))
        {
            System.out.println("Enter your message:");
            scan.nextLine();
            String message = scan.nextLine();
            encrypt(message, key);
        }
        else if(input.equals("decrypt"))
        {
            decrypt(key);
        }
        else
        {
            System.out.println("Invalid command");
        }
    }
}
