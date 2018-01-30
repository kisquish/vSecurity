#!/bin/bash

os_familly=$1

if [ $os_familly = ubuntu ]; then
	#statements
	sudo apt-get -y wget net-tools
	sudo apt-get -y update
	sudo apt-get -y install qemu-kvm libvirt-bin virtinst bridge-utils cpu-checker
else
	# this is a short procedure for installing KVM hypervosor on CEntOS
	sudo yum -y install epel-release wget net-tools
	sudo yum -y update
	sudo yum -y install qemu-kvm libvirt libvirt-python libguestfs-tools virt-install

fi

sudo systemctl enable libvirtd && sudo systemctl start libvirtd
