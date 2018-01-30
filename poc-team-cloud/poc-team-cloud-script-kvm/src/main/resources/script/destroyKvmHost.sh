#!/bin/bash
hot=$1
virsh destroy $hot
virsh undefine $hot
rm -rf /home/vmDisks/$hot.img

