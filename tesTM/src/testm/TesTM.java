/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testm;

/**
 *
 * @author jibby
 */
 
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
 
import com.opencsv.CSVReader;
 
public class TesTM
{
    public static void main(String[] args)
    {       
            String query_1="LOAD DATA LOCAL INFILE '" + "C:\\task.csv" + "' INTO TABLE task_table FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (task_id, skill) ";
            String query_2="LOAD DATA LOCAL INFILE '" + "C:\\team.csv" + "' INTO TABLE team_table FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (team_id) ";
            String query_3="LOAD DATA LOCAL INFILE '" + "C:\\team_skill.csv" + "' INTO TABLE team_skill_table FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (team_id, skill) ";
            readCsv(query_1);
            readCsv(query_2);
            readCsv(query_3);
            
    }
 
    private static void readCsv(String query)
    {
        try (Connection connection = DBConnection.getConnection())
        {
 
                String loadQuery = query;
                System.out.println(loadQuery);
                Statement stmt = connection.createStatement();
                stmt.execute(loadQuery);
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }
    }
 
 
}
