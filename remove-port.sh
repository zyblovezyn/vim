#!/bin/bash

if [ $# -le 0 ]
then
	echo "no arguments";
	exit;
fi

if [ `firewall-cmd --state` = "running" ]
then
	echo "started firewalld"
else
	systemctl start firewalld >/dev/null
fi

for port in $@
do
		firewall-cmd --zone=public --remove-port ${port}/tcp --permanent >/dev/null
done

firewall-cmd --reload >/dev/null
