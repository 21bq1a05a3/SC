import java.util.*;

public class OTP{
    public static void main(String[] args){ 
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter plain text: ");
    String pt= sc.nextLine();
    System.out.println("Enter key: ");
    String key = sc.nextLine();
    if(pt.length()!= key.length()){
        System.out.println("Key length must be equal to plain text length");
        return;
    }

    StringBuilder ct = new StringBuilder();
    for(int i=0 ;i<pt.length();i++){
        char c= (char)(pt.charAt(i)^key.charAt(i));
        ct.append(c);
    }
    System.out.println("Encrypted Text: ");
    for(int i=0;i<ct.length();i++){
        System.out.print(Integer.toBinaryString((int)ct.charAt(i))+" ");
    }
        StringBuilder dt= new StringBuilder();
        for(int j=0;j<ct.length();j++){
            char dc=(char)(ct.charAt(j)^key.charAt(j));
            dt.append(dc);
        }
        System.out.println("Decrypted text "+dt.toString());
    }
}