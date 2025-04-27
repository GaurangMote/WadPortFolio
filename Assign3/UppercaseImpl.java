import UppercaseModule.UppercasePOA;

class UppercaseImpl extends UppercasePOA
{
    UppercaseImpl()
    {
        super();
        System.out.println("Uppercase Object Created");
    }

    public String uppercase_string(String name)
    {
        return "Server Send " + name.toUpperCase();
    }
}

