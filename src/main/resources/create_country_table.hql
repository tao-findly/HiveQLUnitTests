CREATE EXTERNAL TABLE IF NOT EXISTS country (
    iso_alpha2 STRING,
    name STRING
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/Users/taol/git/HiveQLUnitTests/src/test/resources/country';