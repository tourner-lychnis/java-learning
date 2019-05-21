package learning.standardapi;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Hex;

public class PrintHexBinaryApp {
    public static void main( String[] args ) {

      byte[] bytes = "あいうえお".getBytes();

      // String.formatで出力 - 英字は小文字
      for (byte b : bytes) {
        System.out.print(String.format("%02x", b));
      }
      System.out.print("\n");

      // String.formatで出力 - 英字は大文字
      for (byte b : bytes) {
        System.out.print(String.format("%02X", b));
      }
      System.out.print("\n");

      // DatatypeConverterで出力
      System.out.println(DatatypeConverter.printHexBinary(bytes));

      // Apache Commons CodecのHexクラスで出力
      System.out.println(Hex.encodeHex(bytes));
    }
}
