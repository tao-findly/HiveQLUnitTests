CREATE TABLE profile_interest (
	id STRING,
  type STRING,
  created TIMESTAMP,
  active BOOLEAN,
	interestTitle STRING
)

INSERT OVERWRITE TABLE profile_interest
SELECT
  p.id,
  p.type,
  p.created,
  p.active,
  i.title
FROM profile
INNER JOIN interest i ON i.profileId = p.id;