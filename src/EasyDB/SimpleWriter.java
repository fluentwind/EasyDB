package EasyDB;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/11.
 */
public class SimpleWriter extends ActionAdapter {
    public SimpleWriter(String field,Object value,String TABLE){
        if(value instanceof String){
            actionDB = "INSERT INTO " + TABLE + "(" + field + ")" + " VALUES " + "('" + value.toString() + "')";
        }else {
            actionDB = "INSERT INTO " + TABLE + "(" + field + ")" + " VALUES " + "(" + value.toString() + ")";
        }
    }


    @Override
    public void execute() {

        try {
            statement=this.connection.createStatement();
            upResult=statement.executeUpdate(actionDB);

            if(upResult==1) {
                System.out.println("Action succeed!");
            }else{
                System.out.println("Action Failed!");
            }


        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("Action Failed!");

        }

    }
}
