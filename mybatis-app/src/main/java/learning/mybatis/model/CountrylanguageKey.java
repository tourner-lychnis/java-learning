package learning.mybatis.model;

public class CountrylanguageKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column countrylanguage.CountryCode
     *
     * @mbg.generated Mon Apr 22 21:47:17 JST 2019
     */
    private String countrycode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column countrylanguage.Language
     *
     * @mbg.generated Mon Apr 22 21:47:17 JST 2019
     */
    private String language;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column countrylanguage.CountryCode
     *
     * @return the value of countrylanguage.CountryCode
     *
     * @mbg.generated Mon Apr 22 21:47:17 JST 2019
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column countrylanguage.CountryCode
     *
     * @param countrycode the value for countrylanguage.CountryCode
     *
     * @mbg.generated Mon Apr 22 21:47:17 JST 2019
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column countrylanguage.Language
     *
     * @return the value of countrylanguage.Language
     *
     * @mbg.generated Mon Apr 22 21:47:17 JST 2019
     */
    public String getLanguage() {
        return language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column countrylanguage.Language
     *
     * @param language the value for countrylanguage.Language
     *
     * @mbg.generated Mon Apr 22 21:47:17 JST 2019
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }
}