import java.io.*;
public class UserInputInteger
{
        public static void main(String args[])throws IOException
        {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        int number;
                System.out.println("Enter the number");
                number = Integer.parseInt(in.readLine());
    }
}