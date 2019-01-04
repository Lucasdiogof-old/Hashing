
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/*
 * SHA-1 produz um valor de dispersão de 160 bits (20 bytes) conhecido como resumo da mensagem, esse valor de dispersão
 * é normalmente tratado como um número hexadecimal de 40 dígitos.
 * Lucas Diogo França
 */

public class SHA1 {

  public static void main(String[] args) {

    // Passo um texto por parâmetro para o método que vai encripta-lo e depois o imprimo.
    System.out.println("SHA-1: " + encriptarSenha("lucasdiogo123"));

  }

  private static String encriptarSenha(String senha) {
    String sha1 = "";
    try {
      MessageDigest criptografia = MessageDigest.getInstance("SHA-1");
      criptografia.reset();
      // Seto para a codificação binária UTF-8 para o texto ficar sem caracteres especiais ilegíveis.
      criptografia.update(senha.getBytes("UTF-8"));
      sha1 = byteToHex(criptografia.digest());

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace(); //Tratamento de erro.
    }
    return sha1;
  }

  // Converto um byte array para uma string de hexadecimal
  private static String byteToHex(final byte[] hash) {
    Formatter formatter = new Formatter();
    for (byte b : hash) {
      formatter.format("%02x", b);
    }
    String retorno = formatter.toString();
    formatter.close();
    return retorno;
  }

}
