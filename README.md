# Hive SQL Unit Tests


## Requirements

1. Java 7+
2. [HiveQLUnit](https://github.com/FINRAOS/HiveQLUnit)

## How it works

* sparkDriver akka.tcp://sparkDriver@localhost:52652
* MemoryStore
* SparkUI http://localhost:4040
* NettyBlockTransferService localhost:52655
*


## Known Issues

* [Data is not getting cleaned every time when we are using external table](https://github.com/FINRAOS/HiveQLUnit/issues/5)
*