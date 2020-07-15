import com.google.common.collect.ImmutableMap;

public class KeywordsMapping {

  private final String filePathDDL = "./src/main/resources/dialect_config/ddl_mapping.json";
  private final String filePathDML = "./src/main/resources/dialect_config/dml_mapping.json";
  private final String filePathDQL = "./src/main/resources/dialect_config/dql_mapping.json";

  private final ImmutableMap<String, String> mapPostgreDDL;
  private final ImmutableMap<String, String> mapPostgreDML;
  private final ImmutableMap<String, String> mapPostgreDQL;
  private final ImmutableMap<String, String> mapBigQueryDDL;
  private final ImmutableMap<String, String> mapBigQueryDML;
  private final ImmutableMap<String, String> mapBigQueryDQL;

  private final Keywords keywords = new Keywords();

  /**
   * Constructor of keywords mapping, parsed from the config file
   */
  public KeywordsMapping() {
    // TODO (spoiledhua): determine new return structure for keywords mappings

  }

  /**
   * Returns the PostgreSQL mapping to a DDL word
   *
   * @param word the DDL word to be translated
   * @return the PostgreSQL mapping to the word
   * @throws IllegalArgumentException if the DDL set does not contain the word
   */
  public String getMappingPostgreDDL(String word) throws IllegalArgumentException {
    if (!keywords.inKeywordsDDL(word)) {
      throw new IllegalArgumentException("The word is not in the DDL set");
    }

    return mapPostgreDDL.get(word);
  }

  /**
   * Returns the PostgreSQL mapping to a DML word
   *
   * @param word the DML word to be translated
   * @return the PostgreSQL mapping to the word
   * @throws IllegalArgumentException if the DML set does not contain the word
   */
  public String getMappingPostgreDML(String word) throws IllegalArgumentException {
    if (!keywords.inKeywordsDML(word)) {
      throw new IllegalArgumentException("The word is not in the DML set");
    }

    return mapPostgreDML.get(word);
  }

  /**
   * Returns the PostgreSQL mapping to a DQL word
   *
   * @param word the DQL word to be translated
   * @return the PostgreSQL mapping to the word
   * @throws IllegalArgumentException if the DQL set does not contain the word
   */
  public String getMappingPostgreDQL(String word) throws IllegalArgumentException {
    if (!keywords.inKeywordsDQL(word)) {
      throw new IllegalArgumentException("The word is not in the DQL set");
    }

    return mapPostgreDQL.get(word);
  }

  /**
   * Returns the BigQuery mapping to a DDL word
   *
   * @param word the DDL word to be translated
   * @return the BigQuery mapping to the keyword
   * @throws IllegalArgumentException if the DDL set does not contain the word
   */
  public String getMappingBigQueryDDL(String word) throws IllegalArgumentException {
    if (!keywords.inKeywordsDDL(word)) {
      throw new IllegalArgumentException("The word is not in the DDL set");
    }

    return mapBigQueryDDL.get(word);
  }

  /**
   * Returns the BigQuery mapping to a DML word
   *
   * @param word the DML word to be translated
   * @return the BigQuery mapping to the keyword
   * @throws IllegalArgumentException if the DML set does not contain the word
   */
  public String getMappingBigQueryDML(String word) throws IllegalArgumentException {
    if (!keywords.inKeywordsDML(word)) {
      throw new IllegalArgumentException("The word is not in the DML set");
    }

    return mapBigQueryDML.get(word);
  }

  /**
   * Returns the BigQuery mapping to a DQL word
   *
   * @param word the DQL word to be translated
   * @return the BigQuery mapping to the keyword
   * @throws IllegalArgumentException if the DQL set does not contain the word
   */
  public String getMappingBigQueryDQL(String word) throws IllegalArgumentException {
    if (!keywords.inKeywordsDQL(word)) {
      throw new IllegalArgumentException("The word is not in the DQL set");
    }

    return mapBigQueryDQL.get(word);
  }

  // TODO (spoiledhua): add tokens function that returns necessary tokens given keyword
}
