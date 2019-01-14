cd $(dirname $0);

java -Djava.library.path=lib/native/linux-64 -jar kkm-pleer-1.0-SNAPSHOT.jar \
        -f music/some.txt
        #-kkm atol10 -ip 172.0.1.:5555
