package GenshinHelper;

import java.sql.*;

public class DatabaseHandler {

    private static Stats stats = new Stats();
    public int getPity(){
        try {
            Connection connected = DriverManager.getConnection("");
            Statement statement = connected.createStatement();
            statement.execute("SELECT * FROM Genshin ORDER BY ID DESC LIMIT 1;)");
            ResultSet result = statement.getResultSet();
            int temp = result.getInt("PityCount");
            result.close();
            statement.close();
            connected.close();
            return temp;
        }catch (SQLException e){
            System.out.println("getPity SQL error: " +e);
            return 0;
        }
    }

    public void itemInitialisation(){
        try {
            Connection connected = DriverManager.getConnection("");
            Statement statement = connected.createStatement();
            statement.execute("SELECT * FROM Genshin ; ");
            ResultSet result = statement.getResultSet();
            result.close();
            statement.close();
            connected.close();

        }catch (SQLException e){
            System.out.println("itemInitialisation SQL error: "+e);
        }
    }


    public int dbMaxID() {
        try{
            Connection connected = DriverManager.getConnection("");
            Statement statement = connected.createStatement();
            statement.execute("SELECT * FROM Genshin ORDER BY ID DESC LIMIT 1;");
            ResultSet result = statement.getResultSet();
            int temp =  result.getInt("ID");
            result.close();
            statement.close();
            connected.close();
            return temp;
        }catch (SQLException e){
            System.out.println("dbMaxID SQL error: "+e);
            return 0;
        }
    }

    public WishItems initialiseObject(int i){
        try{
            Connection connected = DriverManager.getConnection("");
            Statement statement = connected.createStatement();
            statement.execute(("SELECT * FROM Genshin Where ID = "+ i));
            ResultSet result = statement.getResultSet();
            WishItems temp = new WishItems(result.getString("RewardName"), result.getString("RewardType"), result.getInt("Rarity"));
            result.close();
            statement.close();
            connected.close();
            return temp;

        }catch (SQLException e){
            System.out.println("InitialiseObject SQL error: "+e);
            return null;
        }
    }

}
