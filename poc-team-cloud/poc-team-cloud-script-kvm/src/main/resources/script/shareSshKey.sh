#!/bin/bash
remoteUser=$1
for ip in `cat listOfHosts`; do
    ssh-copy-id -i /home/ptcadm/.ssh/id_rsa.pub $remoteUser@$ip
done
