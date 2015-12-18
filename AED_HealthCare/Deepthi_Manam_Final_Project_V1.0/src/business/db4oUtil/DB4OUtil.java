package business.db4oUtil;


import business.ConfigureSystem;
import business.HealthCareSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author raunak
 */
public class DB4OUtil {

    private static final String FILENAME = "C:\\Users\\Deepthi\\Documents\\AED\\Deepthi_Manam_Final\\Deepthi_Manam_Final_Project_V1.0\\\\DataBank.db4o"; // path to the data store
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(HealthCareSystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(HealthCareSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    public HealthCareSystem retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<HealthCareSystem> systems = conn.query(HealthCareSystem.class); // Change to the object you want to save
        HealthCareSystem system;
        if (systems.size() == 0){
            system = ConfigureSystem.configure();  // If there's no HealthCareSystem in the record, create a new one systems.size() - 1
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }
}
