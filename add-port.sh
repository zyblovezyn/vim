#!/bin/bash
#add port to firewalld.server

if [ $# -le 0 ]
then
	 echo "no arguments";
	 exit;
fi  
STATUS=`firewall-cmd --state`

function addport()
{
if [ $STATUS = "running" ] 
then
	if [ `firewall-cmd --zone=public --add-port $1/tcp  --permanent`>/dev/null = "success" ]
	then
		echo "success!"
		firewall-cmd --reload >/dev/null
	fi
else
	systemctl start firewalld
	STATUS=`firewall-cmd --state`
	if [ $STATUS = "running" ] 
	then
		if [ `firewall-cmd --zone=public --add-port $1/tcp  --permanent`>/dev/null = "success" ]
		then
			echo "success!"
			firewall-cmd --reload >/dev/null
		else
			echo "faild"
		fi
	else
		echo "can not start firewalld"
	fi

fi
}

for port in $@
do
	addport $port;
done
