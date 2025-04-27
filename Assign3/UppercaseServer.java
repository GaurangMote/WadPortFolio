import UppercaseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class UppercaseServer
{
    public static void main(String[] args)
    {
        try
        {
            // initialize the ORB
            ORB orb = ORB.init(args, null);

            // initialize the POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // create and register servant
            UppercaseImpl upc = new UppercaseImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(upc);
            Uppercase h_ref = UppercaseHelper.narrow(ref);

            // get Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the object reference in Naming
            String name = "Uppercase";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, h_ref);

            System.out.println("Uppercase Server ready and waiting...");
            orb.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

