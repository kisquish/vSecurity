#!/bin/bash

# the hostname of your VM
hostName=$1

# WARNING: if you try to create a VM using the existing one, it will be destroyed
#sudo virsh destroy $hostName
#sudo virsh undefine $hostName

# the RAM size of your VM
ramSize=$2
# the virtual CPU number of your VM
cpuNumber=$3
# the DISK size of your VM
diskSize=$4
# the bridge attached to the vm
vmEthernet=$5
# if creating ubuntu host, use "ubuntu" as value of argument 6
os_familly=$6
# create your VM using the above arguments

if [ $os_familly = ubuntu ]; then
	virt-install \
	--name $hostName \
	--ram $ramSize \
	--disk path=/home/ptcadm/vmDisks/$hostName.img,size=$diskSize \
	--vcpus $cpuNumber \
	--os-type linux \
	--os-variant ubuntu16.04 \
	--network bridge=$vmEthernet \
	--graphics none \
	--console pty,target_type=serial \
	--location=/var/lib/libvirt/images/ubuntu-16.04.2-server-amd64.iso \
	--extra-args 'console=ttyS0,115200n8 serial'
else
	sudo virt-install --network bridge:$vmEthernet \
	--name $hostName \
	--ram=$ramSize \
	--vcpus=$cpuNumber \
	--disk path=/var/lib/libvirt/images/$hostName.img,size=$diskSize \
	--graphics none \
	--location=/var/lib/libvirt/images/CentOS-7-x86_64-Minimal-1611.iso \
	--extra-args="console=tty0 console=ttyS0,115200"
fi
