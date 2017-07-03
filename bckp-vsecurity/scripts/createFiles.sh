#!/bin/bash

file=$1
message=$2

touch $file
echo "# $message " >> $file
