
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * MD5 � uma fun��o de dispers�o criptogr�fica de 128 bits unidirecional desenvolvido para a verifica��o
 * de integridade de arquivos e logins.
 * Lucas Diogo Fran�a
 * 2016.2.0120.0023-5
 */

public class MD5 {

  public static void main(String[] args) throws NoSuchAlgorithmException {

    try {

      // Texto puro
      String s = "lucasdiogo123";
      MessageDigest msg = MessageDigest.getInstance("MD5");
      msg.update(s.getBytes(), 0, s.length());
      System.out.println("MD5: " + new BigInteger(1, msg.digest()).toString(16));

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

}
