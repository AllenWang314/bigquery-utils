package data;

import parser.Utils;
import parser.Pair;

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
    return generateData(this.numRows);
  }

  /**
   *
   * @param numRows number of rows to generate
   * @return sample data with number of rows being numRows
   */
  public ArrayList<Column> generateData(int numRows) {
    ArrayList<Column> data = new ArrayList<Column>();
    for (int i = 0; i < this.schema.size(); i++) {
      Column col = new Column(this.schema.get(i).second);
      col.fillRandomData(numRows);
      data.add(col);
    }
    return data;
  }

}
