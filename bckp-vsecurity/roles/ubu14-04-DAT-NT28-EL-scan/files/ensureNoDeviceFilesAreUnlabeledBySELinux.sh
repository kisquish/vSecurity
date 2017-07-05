#!/bin/bash

sudo find /dev -context *:device_t:* \( -type c -o -type b \) -printf "%p %Z\n"
