import UppercaseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class UppercaseClient
{
    public static void main(String args[])
    {
        Uppercase UppercaseImpl = null;

        try
        {
            // initialize the ORB
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Uppercase";
            UppercaseImpl = UppercaseHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Enter String:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            String tempStr = UppercaseImpl.uppercase_string(str);
            System.out.println(tempStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

