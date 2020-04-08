import javax.swing.*;
import java.sql.*;
import java.util.Properties;

public class SolutionTwo
{
    public static void main(String[] args) throws SQLException
    {

        String url = "jdbc:postgresql://localhost:5432/dvdrental";

        Properties props = new Properties();
        props.setProperty("user", "postgres");


        JPanel panel = new JPanel();
        final JPasswordField passwordField = new JPasswordField(10);
        passwordField.setEchoChar('\u26AB');
        panel.add(new JLabel("Password"));
        panel.add(passwordField);


        JOptionPane pane = new JOptionPane(panel, JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION)
        {
            @Override
            public void selectInitialValue()
            {
                passwordField.requestFocusInWindow();

            }
        };

        String myPass = "";



//        pane.createDialog(null, "Your Postgres Pass...")

        JDialog d = pane.createDialog(null, "Your Postgres Pass...");
        d.setVisible(true);
        myPass = new String(passwordField.getPassword());
        d.dispose();


        Connection conn = null;
        Statement statement = null;

        props.setProperty("password", myPass);
        try
        {
            conn = DriverManager.getConnection(url, props);

            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from film limit 10;");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            for (int i = 1; i <= columnsNumber; i++)
            {
                if (i > 1) System.out.print(",  ");
                System.out.print(rsmd.getColumnName(i) +  " ");
            }



            while (resultSet.next())
            {

                for (int i = 1; i <= columnsNumber; i++)
                {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " ");
                }
                System.out.println("");
            }
            resultSet.close();


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            if (conn != null) conn.close();
        }

        System.exit(0);
    }
}

