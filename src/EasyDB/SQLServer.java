package EasyDB;

/**
 * Created by Administrator on 2016/10/11.
 */
public class SQLServer extends DataBase {
    public SQLServer(ActionAdapter actionAdapter) {
        super(actionAdapter);
        DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=userinfo";
        USERNAME="user123";
        PASSWORD="user123";
        initDB();
    }

    @Override
    void initDriver() {

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
        }catch(ClassNotFoundException e){
            System.out.println("Add driver failed!");
            e.printStackTrace() ;
        }
    }
}
