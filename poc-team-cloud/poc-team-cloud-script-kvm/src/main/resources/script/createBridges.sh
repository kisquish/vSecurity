#!/bin/bash

virsh net-define virbr-dev.xml 
virsh net-start virbr-dev
virsh net-autostart virbr-dev

virsh net-define virbr-test.xml 
virsh net-start virbr-test 
virsh net-autostart virbr-test 

virsh net-define virbr-pprd.xml
virsh net-start virbr-pprd 
virsh net-autostart virbr-pprd 

virsh net-define virbr-prod.xml 
virsh net-start virbr-prod
virsh net-autostart virbr-prod 