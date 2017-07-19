#!/bin/bash

var_password_pam_ocredit="-1"
if grep -q "ocredit=" /etc/pam.d/system-auth; then   
	sed -i --follow-symlinks "s/\(ocredit *= *\).*/\1$var_password_pam_ocredit/" /etc/pam.d/system-auth
else
	sed -i --follow-symlinks "/pam_cracklib.so/ s/$/ ocredit=$var_password_pam_ocredit/" /etc/pam.d/system-auth
fi