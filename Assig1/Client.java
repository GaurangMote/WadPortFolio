import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String serverURL = "rmi://localhost/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
            
            System.out.println("Enter Number 1:");
            String str1 = sc.nextLine();
            
            System.out.println("Enter Number 2:");
            String str2 = sc.nextLine();
            
            System.out.println("SUM - " + serverIntf.Larger(str1, str2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

