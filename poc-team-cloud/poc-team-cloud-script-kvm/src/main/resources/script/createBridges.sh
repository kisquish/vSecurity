#!/bin/bash

virsh net-define virbr-dev.xml 
virsh net-start virbr-dev
virsh net-autostart virbr-dev

virsh net-define virbr-db-sync.xml 
virsh net-start virbr-db-sync 
virsh net-autostart virbr-db-sync 

virsh net-define virbr-db-drdb.xml
virsh net-start virbr-db-drdb 
virsh net-autostart virbr-db-drdb 

virsh net-define virbr-prod.xml 
virsh net-start virbr-prod
virsh net-autostart virbr-prod 

virsh net-define virbr-admin.xml 
virsh net-start virbr-admin
virsh net-autostart virbr-admin 