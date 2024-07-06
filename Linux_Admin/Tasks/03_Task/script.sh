#!/bin/bash

# Check if .bashrc file exists
if [ -f ~/.bashrc ]; then
    # Append environment variables to .bashrc
    echo "export HELLO=$HOSTNAME" >> ~/.bashrc
    echo "LOCAL=\$(whoami)" >> ~/.bashrc
    
    # Open another terminal
    gnome-terminal &  

    echo "Environment variables added to .bashrc. Another terminal opened."
else
    echo "Error: .bashrc file not found in the home directory."
fi


