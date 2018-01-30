#!/bin/bash

virsh start com-dash
virsh start keystone
virsh start glan-cin
virsh start neutron

virsh list

