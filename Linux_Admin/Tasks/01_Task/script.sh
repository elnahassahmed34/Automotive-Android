#!/bin/bash

# Create a directory called "myDirectory" in your home folder.
mkdir ~/myDirectory

# Inside "myDirectory," create another directory named "secondDirectory."
mkdir ~/myDirectory/secondDirectory

# Within "secondDirectory," create a file named "myNotePaper."
touch ~/myDirectory/secondDirectory/myNotePaper

# Copy "myNotePaper" from "secondDirectory" to "myDirectory."
cp ~/myDirectory/secondDirectory/myNotePaper ~/myDirectory/

# Rename the copied file in "myDirectory" to "myOldNotePaper."
mv ~/myDirectory/myNotePaper ~/myDirectory/myOldNotePaper