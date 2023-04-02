serviceName="chatweb-1.0.jar"

ps -efww|grep -w "$serviceName"|grep -v grep|cut -c 9-15|xargs kill -9|| exit 0
