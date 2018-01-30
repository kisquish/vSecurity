#!/bin/bash

virsh destroy common
virsh undefine common
rm -rf /home/vm_imgs/common.img

virsh destroy keystone
virsh undefine keystone
rm -rf /home/vm_imgs/keystone.img

virsh destroy compute
virsh undefine compute
rm -rf /home/vm_imgs/compute.img

virsh destroy controller
virsh undefine controller
rm -rf /home/vm_imgs/controller.img

virsh destroy glance
virsh undefine glance
rm -rf /home/vm_imgs/glance.img

