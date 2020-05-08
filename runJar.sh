#!/bin/bash
mvn clean package

JAVA_OPTS="-Dfile.encoding=UTF8"
echo "---------------------------------------------------------------------------"
echo "Java OPTS: $JAVA_OPTS"
echo "---------------------------------------------------------------------------"
java -jar $JAVA_OPTS target/file-encoding-bcp-1.0.jar
echo ""
JAVA_OPTS="-Dfile.encoding=ISO-8859-1"
echo "---------------------------------------------------------------------------"
echo "Java OPTS: $JAVA_OPTS"
echo "---------------------------------------------------------------------------"
java -jar $JAVA_OPTS target/file-encoding-bcp-1.0.jar
