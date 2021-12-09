ip_a=$1
ip_b=$2
ip_c=$3

if [ -z $ip_a ]
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

  public static final String IP_A = "$ip_a";
  public static final String IP_B = "$ip_b";
  public static final String IP_C = "$ip_c";

  public static final String URL_A = "rmi://" + IP_A + "/libA";
  public static final String URL_B = "rmi://" + IP_B + "/libB";
  public static final String URL_C = "rmi://" + IP_C + "/libC";
}
EOF

cp Constants.java clientA/src/com
cp Constants.java clientB/src/com
cp Constants.java clientC/src/com
rm -f Constants.java

echo "Constants files created with IPs $ip_a, $ip_b, $ip_c"

cd clientA
bash compile.sh
echo "Client A compiled successfully"

cd ../clientB
bash compile.sh
echo "Client B compiled successfully"

cd ../clientC
bash compile.sh
echo "Client C compiled successfully"
