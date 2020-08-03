package data;

import parser.Pair;
import parser.Utils;
import parser.Pair;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * class representing a data table
 * contains data table and schema
 */
public class Table {

  private String name;
  private int numRows;
  private ArrayList<Pair<String, DataType>> schema;

  /**
   * constructs empty table from table name
   * @param name
   */
  public Table(String name) {
    this.name = name;
    this.numRows = 0;
    this.schema = new ArrayList<Pair<String, DataType>>();
  }

  /**
   * adds column to table
   * @param columnName
   * @param type
   */
  public void addColumn(String columnName, DataType type) {
    this.schema.add(new Pair(columnName, type));
  }

  public ArrayList<Pair<String, DataType>> getSchema() {
    return this.schema;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setNumRows(int numRows) {
    this.numRows = numRows;
  }

  public int getNumRows() {
    return this.numRows;
  }

  /**
   *
   * @return name of random column of schema
   */
  public String getRandomColumn() {
    Pair<String, DataType> p = Utils.getRandomElement(this.schema);
    return p.first;
  }

  /**
   *
   * @param type
   * @return name of random column of given type
   */
  public String getRandomColumn(DataType type) {
    ArrayList<Pair<String, DataType>> columns = new ArrayList<Pair<String, DataType>>();
    for (Pair<String, DataType> col: this.schema) {
      if (col.second == type) columns.add(col);
    }
    Pair<String, DataType> p = Utils.getRandomElement(columns);
    return p.first;
  }

  /**
   *
   * @return sample data with number of rows being number of rows in table
   */
  public ArrayList<Column> generateData() {
    
   * @param numRows number of rows of data to generate
   * @param dataType type of data to generate
   * @return column of data with type dataType and numRows rows
   * @throws IllegalArgumentException
   */
  public ArrayList<?> generateColumn(int numRows, DataType dataType) throws IllegalArgumentException {
    if (dataType.isIntegerType()) {
      ArrayList<Integer> data = new ArrayList<Integer>();
      for (int i = 0; i < numRows; i++) {
        data.add(Utils.generateRandomIntegerData(dataType));
      }
      return data;
    } else if (dataType.isLongType()) {
      ArrayList<Long> data = new ArrayList<Long>();
      for (int i = 0; i < numRows; i++) {
        data.add(Utils.generateRandomLongData(dataType));
      }
      return data;
    } else if (dataType.isDoubleType()) {
      ArrayList<Double> data = new ArrayList<Double>();
      for (int i = 0; i < numRows; i++) {
        data.add(Utils.generateRandomDoubleData(dataType));
      }
      return data;
    } else if (dataType.isBigDecimalType()) {
      ArrayList<BigDecimal> data = new ArrayList<BigDecimal>();
      for (int i = 0; i < numRows; i++) {
        data.add(Utils.generateRandomBigDecimalData(dataType));
      }
      return data;
    } else if (dataType.isStringType()) {
      ArrayList<String> data = new ArrayList<String>();
      for (int i = 0; i < numRows; i++) {
        data.add(Utils.generateRandomStringData(dataType));
      }
      return data;
    } else if (dataType.isBooleanType()) {
      ArrayList<Boolean> data = new ArrayList<Boolean>();
      for (int i = 0; i < numRows; i++) {
        data.add(Utils.generateRandomBooleanData(dataType));
      }
      return data;
    } else {
      throw new IllegalArgumentException("invalid datatype");
    }
  }

  /**
   *
   * @return sample data with number of rows being number of rows in table
   */
  public ArrayList<ArrayList<?>> generateData() {
    return generateData(this.numRows);
  }

  /**
   *
   * @param numRows number of rows to generate
   * @return sample data with number of rows being numRows
   */
  public ArrayList<ArrayList<?>> generateData(int numRows) {
    ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
    for (int i = 0; i < this.schema.size(); i++) {
      ArrayList<?> column = this.generateColumn(numRows, this.schema.get(i).second);
      data.add(column);
    }
    return data;
  }
}
