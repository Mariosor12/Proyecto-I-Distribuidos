lib=A

cd server$lib
bash compile.sh
echo "Server $lib compiled successfully"

cd ../client$lib
bash compile.sh
echo "Client $lib compiled successfully"