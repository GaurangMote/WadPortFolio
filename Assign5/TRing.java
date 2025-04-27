import java.util.*;

public class TRing{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number of Nodes:");
		int n = sc.nextInt();
		
		System.out.println("Ring : ");
		for(int i=0;i<n;i++){
			System.out.print(i+" ");
		}
		
		System.out.println("0");
		int ch = 0;
		
		try{
			do{
				System.out.print("Enter Sender");
				int sender = sc.nextInt();
				
				System.out.print("Enter Receiver");
				int receiver = sc.nextInt();	
				
				System.out.print("Enter Data");
				int data = sc.nextInt();
				
				System.out.println("Token Passing : ");
				
				int token = 0;
				
				for(int i=token;i<sender;i++){
					System.out.print(" "+i+"->");
				}
				
				System.out.println(" "+sender);
				System.out.println("Sender "+sender+" sending data: "+data);
				
				
				for(int i=sender;i!=receiver;i = (i+1)%n){
					System.out.println("Data: "+data+" forwarded by "+i);
				}
				
				System.out.println("Receiver "+receiver+" received data: "+data);
				token = sender;
				System.out.println("Do want to send data again?(Yes:1,No:0)");
				ch = sc.nextInt();
			}while(ch==1);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
