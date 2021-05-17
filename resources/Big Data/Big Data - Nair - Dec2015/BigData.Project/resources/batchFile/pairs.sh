#!/bin/bash
#pair
hdfs dfs -mkdir pairs
hdfs dfs -put /home/cloudera/input pairs/
hadoop jar /home/cloudera/pair.jar pairs/input pairs/output
hdfs dfs -cat pairs/output/part-r-00000
hdfs dfs -cat pairs/output/part-r-00001

