javac -d out $(find ./src | grep .java)
cd out && java com.Main