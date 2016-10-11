package EasyDB;


/**
 * Created by Administrator on 2016/10/11.
 */
public class MySQL extends DataBase  {


    public MySQL(ActionAdapter actionAdapter) {
        super(actionAdapter);

        DBURL="jdbc:mysql://localhost:3306/test1?characterEncoding=utf8&useSSL=false";
        initDB();
    }

    @Override
    void initDriver() {

        try{
            Class.forName("com.mysql.jdbc.Driver") ;
        }catch(ClassNotFoundException e){
            System.out.println("Add driver failed!");
            e.printStackTrace() ;
        }
    }
}
