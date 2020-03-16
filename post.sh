#!/bin/bash

PATH=$1

if [ $# -ne 1 ]
then
    echo "Usage: $0 [path]"
    exit 0
fi

markdown-tistory write "$PATH"