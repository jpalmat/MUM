#!/bin/bash
#stripes
hdfs dfs -mkdir stripes
hdfs dfs -put /home/cloudera/input stripes/
hadoop jar /home/cloudera/stripes.jar stripes/input stripes/output
hdfs dfs -cat stripes/output/part-r-00000
hdfs dfs -cat stripes/output/part-r-00001

