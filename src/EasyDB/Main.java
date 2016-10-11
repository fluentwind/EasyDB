package EasyDB;


/**
 * Created by Administrator on 2016/10/10.
 */
public class Main {
    public static void main(String arg[]){
        CommonDataBaseControl commonDataBaseControl=new CommonDataBaseControl();
        ActionAdapter actionAdapter =new SimpleReader("test1");
        //SimpleWriter simpleWriter=new SimpleWriter("number",6,"test1");
        MySQL mySQL=new MySQL(actionAdapter);
        //SQLServer sqlServer=new SQLServer(actionAdapter);

        commonDataBaseControl.setDataBase (mySQL);
        commonDataBaseControl.action();
        commonDataBaseControl.close();
    }
}
