#!/bin/bash

options=("Display date and time" "List files in current directory" "Display current disk usage" "Exit")

select opt in "${options[@]}"
do
    case $opt in
        "Display date and time")
            date ;;
        "List files in current directory")
            ls ;;
        "Display current disk usage")
            df -h ;;
        "Exit")
            echo "Goodbye!"
            break ;;
        *)
            echo "Invalid option";;
    esac
done
