#!/bin/bash

username="yourName"
groupname="FamilyName"

if ! getent group "$groupname" > /dev/null; then
    sudo groupadd "$groupname"
    echo "Group $groupname created."
else
    echo "Group $groupname already exists."
fi

if ! id -u "$username" > /dev/null; then
    sudo useradd -m -g "$groupname" "$username"
    echo "User $username created and added to group $groupname."
else
    echo "User $username already exists."
fi

id "$username"
getent group "$groupname"
