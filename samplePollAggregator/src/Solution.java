import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Properties;

public class Solution
{


    public static void main(String[] args)
    {
        String filePathName = "pols.csv";
        String headers;
        String row;
        HashMap<String, Integer> candidateVotes = new HashMap<>();


        try
        {
            BufferedReader bReader = new BufferedReader(new FileReader(filePathName));
            headers = bReader.readLine();

            while (( row = bReader.readLine()) != null )
            {
                String [] temp_arr = row.split(",");
                String fullName = temp_arr[1] + " " + temp_arr[0];
                int voteCount = Integer.parseInt(temp_arr[3]);

                if (candidateVotes.containsKey(fullName))
                {
                    int increment = candidateVotes.get(fullName);
                    candidateVotes.put(fullName, voteCount + increment);
                }
                else
                {
                    candidateVotes.put(fullName, voteCount);
                }
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("This file, " + filePathName + " Does not Exist!!");
        }catch (IOException f)
        {
            System.out.println(" IO EXCEPTION");
        }
        candidateVotes.forEach( (k,v) -> System.out.println("(" + k + ", " + v + ")"));

    }
}
