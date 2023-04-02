#!/bin/sh

echo "--- begin start server ---"

# start server
nohup java -server -Xms512m -Xmx512m -Xss512K -jar chatweb-1.0.jar>/dev/null 2>&1&
