import java.rmi.*;
import java.util.*;

public interface ServerIntf extends Remote {
    String Larger(String str1, String str2) throws RemoteException;
}
