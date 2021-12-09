ip=$1
lib=$2

if [ -z $ip ]
then
  echo "ERROR: No IP address was provided"
  exit 1
fi

touch Constants.java

cat << EOF > Constants.java
package com;

public final class Constants {
  private Constants() {
  }

  public static final String IP = "$ip";
  public static final String URL = "rmi://" + IP + "/lib$lib";
}
EOF

cp Constants.java server$lib/src/com
rm -f Constants.java

echo "Constants files created with IP $1"

cd server$lib
bash compile.sh
echo "Server $lib compiled successfully"
