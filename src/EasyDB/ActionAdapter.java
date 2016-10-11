package EasyDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/10/11.
 */
public class ActionAdapter implements DataBaseAction {
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    String actionDB;
    int upResult;
    public ActionAdapter(){

    }

    @Override
    public void execute() {

    }

    public void setConnection(Connection connection) {
        this.connection = connection;

    }
}
