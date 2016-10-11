package EasyDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/11.
 */
public abstract class DataBase implements DataBaseAction {
    ActionAdapter actionAdapter;
    Connection connection;
    String DBURL;
    String USERNAME="root",PASSWORD="root";
    String DBname;

    public void setDATABASE() {
        this.DBname = this.getClass().getSimpleName();
    }

    public DataBase(ActionAdapter actionAdapter){
        this.actionAdapter = actionAdapter;
        setDATABASE();

    }

    final void closeDB() {
        try {

            if (!connection.isClosed()) {
                connection.close();

                System.out.println(DBname+" Closed!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Close failed!");
        }
    }
    final void initDB(){
        initDriver();
        try {

            connection= DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
            actionAdapter.setConnection(this.connection);
            System.out.println(DBname+" Connection succeed!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(DBname+" Connection failed!");

        }

    }
    abstract void initDriver();
    @Override
    public void execute() {
        actionAdapter.execute();

    }
}
