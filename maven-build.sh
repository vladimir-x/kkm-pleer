mvn install:install-file \
   -Dfile=src/main/assembly/lib/libfptr10.jar \
   -DgroupId=ru.atol \
   -DartifactId=fptr \
   -Dversion=10.4.2 \
   -Dpackaging=jar \
   -DgeneratePom=true

mvn clean package -Dskiptest=true