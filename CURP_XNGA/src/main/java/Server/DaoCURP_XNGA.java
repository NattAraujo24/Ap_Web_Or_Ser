package Server;
import com.mysql.cj.MysqlConnection;
import com.mysql.cj.Session;
import com.mysql.cj.conf.PropertySet;
import com.mysql.cj.exceptions.ExceptionInterceptor;

import java.sql.*;
import java.util.Properties;
public class DaoCURP_XNGA {
    PreparedStatement pstm;
    CallableStatement cstm;
    Connection conn;
    ResultSet rs;


    public boolean crear (String nombre, String primerApellido, String segundoApellido, String sexo,String estadodenacimiento, String fechadeNacimiento) throws SQLException {
        BeanCURP_XNGA curp= new BeanCURP_XNGA();
        try {
            conn = new MysqlConnection() {
                public Connection getConnection() {
                    return null;
                }

                @Override
                public PropertySet getPropertySet() {
                    return null;
                }

                @Override
                public void createNewIO(boolean b) {

                }

                @Override
                public long getId() {
                    return 0;
                }

                @Override
                public Properties getProperties() {
                    return null;
                }

                @Override
                public Object getConnectionMutex() {
                    return null;
                }

                @Override
                public Session getSession() {
                    return null;
                }

                @Override
                public String getURL() {
                    return null;
                }

                @Override
                public String getUser() {
                    return null;
                }

                @Override
                public ExceptionInterceptor getExceptionInterceptor() {
                    return null;
                }

                @Override
                public void checkClosed() {

                }

                @Override
                public void normalClose() {

                }

                @Override
                public void cleanup(Throwable throwable) {

                }
            }.getConnection();
            pstm = conn.prepareStatement("",PreparedStatement.RETURN_GENERATED_KEYS);
            rs = pstm.executeQuery();
            while (rs.next()){
                curp.add(curp);
            }
            pstm.execute();
            pstm = conn.prepareStatement("");
            pstm.executeUpdate();//Error
            conn.commit();
            return pstm.executeUpdate() ==1;
        }catch (SQLException e){
            conn.rollback();
        }
        return false;
    }
    public void closeConnections(){
        try {
            if (conn !=null)
                conn.close();
            if (pstm !=null)
                pstm.close();
            if (cstm !=null)
                cstm.close();
            if (rs !=null)
                rs.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
