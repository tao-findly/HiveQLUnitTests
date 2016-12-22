CREATE TABLE profile (
  id STRING,
  type STRING,
  created TIMESTAMP,
  score INT,
  active BOOLEAN
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

CREATE TABLE interest (
    profileId STRING,
    interestId INT,
    title STRING
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

CREATE TABLE profile_interest (
  id STRING,
  type STRING,
  created TIMESTAMP,
  active BOOLEAN,
  interestTitle STRING
);