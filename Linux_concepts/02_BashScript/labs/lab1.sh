#!/bin/bash

#script req :
#declare index array 5 elements , name of cities
#print entire array
#print lenth of array
#use loop to itrate array and print


cities=("pasris" "cairo" "iran" "germany" "usa")

echo ${cities[*]}

echo ${#cities[@]}

for city in "${cities[@]}" ;do
    echo $city
done

