#!/bin/bash

role=$1

ansible-galaxy --offline init $role
mkdir $role/templates
mkdir $role/files
echo "# " >> $role/templates
echo "# " >> $role/files

