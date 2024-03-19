import java.security.*;

public class DigitalSignature{

   public static void main(String[] args) throws Exception {
       // Generate a key pair
       KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
       SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
       keyGen.initialize(1024, random);
       KeyPair pair = keyGen.generateKeyPair();
       PrivateKey priv = pair.getPrivate();
       PublicKey pub = pair.getPublic();

       // Sign the data
       Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
       dsa.initSign(priv);
       String str = "This is a string to sign";
       byte[] strByte = str.getBytes("UTF8");
       dsa.update(strByte);
       byte[] realSig = dsa.sign();

       // Verify the signature
       dsa.initVerify(pub);
       dsa.update(strByte);
       boolean verifies = dsa.verify(realSig);
       System.out.println("Signature verifies: " + verifies);
   }
}
