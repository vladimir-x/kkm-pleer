cd $(dirname $0);

MACHINE_TYPE=`java -version 2>&1 | grep 64-Bit | wc -l`
if (( ${MACHINE_TYPE} =='1' )); then
  # 64-bit stuff here
  echo "select x86_64 native lib64"
  LIB_PATH_SUFFIX=./lib/native/linux-64
else
  # 32-bit stuff here
  echo "select x86 native lib"
  LIB_PATH_SUFFIX=./lib/native/linux-86
fi

java -Djava.library.path=$LIB_PATH_SUFFIX -jar kkm-pleer-1.0-SNAPSHOT.jar \
        -f music/some.txt -v -30 \
        -kkm atol10 -ip 172.0.0.1:5555
