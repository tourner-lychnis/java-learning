package learning.univocityparsers;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import com.univocity.parsers.fixed.FieldAlignment;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

public class ParseFixedWidthFilesApp {
  public static void main(String[] args) throws UnsupportedEncodingException {
    FixedWidthFields headerRecordFields = new FixedWidthFields();
    headerRecordFields.addField("データ区分", 1);
    headerRecordFields.addField("種別コード", 2);
    headerRecordFields.addField("コード区分", 1);
    headerRecordFields.addField("委託者コード", 10);
    headerRecordFields.addField("ダミー", 106);

    FixedWidthFields dataRecordFields = new FixedWidthFields();
    dataRecordFields.addField("データ区分", 1);
    dataRecordFields.addField("被仕向金融機関番号", 4);
    dataRecordFields.addField("被仕向金融機関名", 15);
    dataRecordFields.addField("被仕向支店番号", 3);
    dataRecordFields.addField("被仕向支店名", 15);
    dataRecordFields.addField("受取人名", 30);
    dataRecordFields.addField("振込金額", 10, FieldAlignment.RIGHT, '0');
    dataRecordFields.addField("ダミー", 42);

    FixedWidthFields trailerRecordFields = new FixedWidthFields();
    trailerRecordFields.addField("データ区分", 1);
    trailerRecordFields.addField("合計件数", 6, FieldAlignment.RIGHT, '0');
    trailerRecordFields.addField("合計金額", 12,FieldAlignment.RIGHT, '0');
    trailerRecordFields.addField("ダミー", 101);

    FixedWidthFields endRecordFields = new FixedWidthFields();
    endRecordFields.addField("データ区分", 1);
    endRecordFields.addField("ダミー", 119);

    FixedWidthParserSettings parserSettings = new FixedWidthParserSettings();
    parserSettings.getFormat().setLineSeparator("\n");
    parserSettings.addFormatForLookahead("1", headerRecordFields);
    parserSettings.addFormatForLookahead("2", dataRecordFields);
    parserSettings.addFormatForLookahead("8", trailerRecordFields);
    parserSettings.addFormatForLookahead("9", endRecordFields);

    FixedWidthParser parser = new FixedWidthParser(parserSettings);
    InputStreamReader reader = new InputStreamReader(
      ParseFixedWidthFilesApp.class.getResourceAsStream("/fixed-width-file.txt"), "UTF-8");

    List<String[]> allRows = parser.parseAll(reader);
    allRows.forEach(row -> {
      System.out.println(Arrays.toString(row));
    });
  }
}
