import ReverseModule.ReversePOA;
import UppercaseModule.UppercasePOA;  
import java.lang.String; 

class ReverseImpl extends ReversePOA{
	ReverseImpl(){
		super();
		System.out.println("Reverse Object Created");
	}

	public String reverse_string(String name) {
		StringBuffer str=new StringBuffer(name); 
		str.reverse(); 
		return "Server Sent "+str;
	}
}
