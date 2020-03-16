#!/bin/bash

PATH=$1
POST_ID=$2

if [ $# -ne 2 ]
then
    echo "Usage: $0 [path] [postId]"
    exit 0
fi

markdown-tistory update "$PATH" "$POST_ID"