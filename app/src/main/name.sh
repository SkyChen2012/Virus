#!/bin/bash

#1.变量定义
#directory 目录文件夹
#nameEx 名字扩展
#directory="/Users/Benson/Desktop/drawable"
#nameEx="game_agilebuddy_"
#2.遍历子目录
for file in `ls $directory`
do
	if [ -d $directory/$file ]
	then
		echo $file is dir
       	else
		echo $file is file
		mv $directory/$file $directory/$nameEx$file	
	fi
done
