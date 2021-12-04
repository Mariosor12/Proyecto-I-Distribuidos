# Compile files
javac -d out $(find ./src | grep .java)

# Change directory to out folder and run rmiregistry
cd out/
rmiregistry 2> /dev/null
java com.Main