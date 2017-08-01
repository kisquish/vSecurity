#!/bin/bash

var_password_pam_lcredit="-1"
if grep -q "lcredit=" /etc/pam.d/system-auth; then   
	sed -i --follow-symlinks "s/\(lcredit *= *\).*/\1$var_password_pam_lcredit/" /etc/pam.d/system-auth
else
	sed -i --follow-symlinks "/pam_cracklib.so/ s/$/ lcredit=$var_password_pam_lcredit/" /etc/pam.d/system-auth
fi