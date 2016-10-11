package EasyDB;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/11.
 */
public class SimpleReader extends ActionAdapter {
    ResultSetMetaData resultSetMetaData;
    int isall=0;
    boolean checkall=false;
    public SimpleReader(String TABLE){
        actionDB="select *"+" from "+TABLE;
        checkall=true;
    }
    public SimpleReader(String COLUMN, String TABLE){

        actionDB="select "+COLUMN+" from "+TABLE;

    }

    public void setIsall(){

        try {
            resultSetMetaData=resultSet.getMetaData();
            isall=resultSetMetaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void execute() {

        try {
            statement=this.connection.createStatement();
            resultSet=statement.executeQuery(actionDB);
            if (checkall) {
                setIsall();
            }
            System.out.println("----------");
            while (resultSet.next()){
                if(isall>0){
                    for(int i=1;i<=isall;i++){
                        System.out.print(resultSet.getString(i));
                        System.out.print(" | ");
                    }
                    System.out.println("");
                }else {
                    System.out.println(resultSet.getString(1));
                }
            }
            System.out.println("----------");
            System.out.println("Action succeed!");


            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("Action Failed!");

        }

    }
}
