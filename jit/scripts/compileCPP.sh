#!/bin/bash
cd /home/jan/workspace/JVM/jit/CPP
g++ -o lib$1.so -I/opt/java/jdk1.8.0_65/include/ -fPIC -shared -lc $1.cpp 
cp lib$1.so /home/jan/workspace/JVM/jit/jni/lib
