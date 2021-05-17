#!/bin/bash
#
hdfs dfs -mkdir hybrid
hdfs dfs -put /home/cloudera/input hybrid/
hadoop jar /home/cloudera/hybrid.jar hybrid/input hybrid/output
hdfs dfs -cat hybrid/output/part-r-00000
hdfs dfs -cat hybrid/output/part-r-00001

