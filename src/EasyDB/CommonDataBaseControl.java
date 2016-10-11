package EasyDB;

/**
 * Created by Administrator on 2016/10/11.
 */
public class CommonDataBaseControl {
    DataBase dataBase;

    public CommonDataBaseControl(){

    }
    public void setDataBase (DataBase dataBase ){
        this.dataBase =dataBase ;

    }

    public void action(){
        dataBase.execute();

    }
    public void close(){
        dataBase.closeDB();

    }
}
