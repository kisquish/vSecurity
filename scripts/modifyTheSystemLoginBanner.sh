#!/bin/bash

role=$1

mkdir $role
mkdir $role/tasks
mkdir $role/files
mkdir $role/templates
mkdir $role/handlers
mkdir $role/defaults

echo "---" >> $role/tasks/main.yml
echo "" >> $role/tasks/main.yml
echo "" >> $role/tasks/main.yml
