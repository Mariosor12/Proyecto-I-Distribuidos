# Comando de ejecución local (todo en una pc)

java -Djava.security.policy=server.policy Server &

# Setup de server

En Server.java y en Client.java cambiar el String url por

rmi://[IP]:1099/[NOMBRE]

IP es tu IP de VBox
NOMBRE es cualquier nombre arbitrario que le quieras poner a la cuestión (que debe ser el mismo pal cliente)

# En la carpeta server ejecutas

java -Djava.rmi.server.hostname=[IP] -Djava.security.policy=server.policy Server &
