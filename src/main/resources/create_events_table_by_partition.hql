ADD JAR ${resources}/jars/json-serde.jar;

CREATE EXTERNAL TABLE IF NOT EXISTS events (
  sgAccountName STRING,
  orgId INT,
  event STRING,
  sgEventId STRING,
  sgMessageId STRING,
  emailSubject STRING,
  emailEvent STRING,
  emailSendTimestamp TIMESTAMP,
  emailSenderId STRING
)
PARTITIONED BY (date STRING)
ROW FORMAT SERDE 'org.openx.data.jsonserde.JsonSerDe'
STORED AS TEXTFILE
LOCATION '${resources}/events/';

MSCK REPAIR TABLE events;