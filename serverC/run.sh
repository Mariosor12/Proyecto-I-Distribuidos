# Compile files
javac -d out $(find ./src | grep .java)

# Change directory to out folder and run rmiregistry
cd out/
rmiregistry & 
java com.Main