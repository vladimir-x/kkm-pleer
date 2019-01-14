setlocal

set pathToJre=%JAVA_HOME%
echo Using JRE from: %pathToJre%
rem ---- Launch with JRE ----

if not "%pathToJre%"=="" (
   set bindir=\bin\
)

set pathToJavaExe="%pathToJre%%bindir%java"

FOR /F "tokens=*" %%i in ('%pathToJavaExe% -version 2^>^&1 ^| findstr 64-Bit') do SET JavaVer=%%i
IF "%JavaVer%"=="" (
    set libPath=.\lib\native\windows-86
)else (
    set libPath=.\lib\native\windows-64
)

%pathToJavawExe% -Djava.library.path=%libPath% -jar kkm-pleer-1.0-SNAPSHOT.jar \
        -f music/some.txt -v -30 \
        -kkm atol10 -ip 172.0.0.1:5555
