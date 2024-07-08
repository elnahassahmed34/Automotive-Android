#!/bin/bash

SOURCE_DIR=$1

mkdir -p "$SOURCE_DIR/images" "$SOURCE_DIR/documents" "$SOURCE_DIR/others"

for file in "$SOURCE_DIR"/*; do
    if [ -f "$file" ]; then
        case "$file" in
            *.jpg|*.png|*.gif) mv "$file" "$SOURCE_DIR/images/" ;;
            *.txt|*.doc|*.pdf) mv "$file" "$SOURCE_DIR/documents/" ;;
            *) mv "$file" "$SOURCE_DIR/others/" ;;
        esac
    fi
done

echo "Files have been organized."
