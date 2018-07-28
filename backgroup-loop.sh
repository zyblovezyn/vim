#!/bin/bash
# 
for i in $(seq 1 10)
do
  echo  "$i"
done&

for i in $(seq 11 20)
do 
  echo "$i"
done
exit 0
