#!/bin/bash

# the destination port on your VM
dport=$1
# the destination @IP of your VM
dip=$2
# the destination network (in this foramt IP/NE_TMASK)
dnet=$3

echo "CREATING RULE ...."
iptables -t nat -I PREROUTING -p tcp -d 193.70.44.143 --dport $dport -j DNAT --to-destination $dip:22
echo "ESTABLISHING RULE ...."
iptables -I FORWARD -m state -d $dnet --state NEW,RELATED,ESTABLISHED -j ACCEPT

echo "done !"
