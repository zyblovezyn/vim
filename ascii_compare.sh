#!/bin/bash
#
if [ $# -ne 2 ];then
	echo "arguments is not two."
	exit 4
fi
veg1=$1
veg2=$2

if [[ "$veg1" < "$veg2" ]]
then
	echo "$veg1 less than $veg2"
	exit 0
elif [[ "$veg1" > "$veg2" ]]
then 
	echo "$veg1 great than $veg2"
	exit 0
elif [[ "$veg1" == "$veg2" ]]
then
	echo "$veg1 equal $veg2"
	exit 0
fi
