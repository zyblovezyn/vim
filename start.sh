#!/bin/bash
# start nginx
if [ $# -le 0 ]
then
	echo "no arguments"
	exit 127
fi
if [ $1 = "start" ]
then
	./sbin/nginx
	echo "nginx started!"
	exit 0
fi

if [ $1 = "restart" ]
then
	./sbin/nginx -s reopen
	echo "nginx restarted"
	exit 0
fi

if [ $1 = "reload" ]
then
	./sbin/nginx -s reload
	echo "nginx reloaded"
	exit 0
fi

if [ $1 = "stop" ]
then
	./sbin/nginx -s stop
	echo "nginx stoped"
	exit 0
fi
