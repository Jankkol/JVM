#include<jni.h>
#include "com_jankkol_jni_HelloWorld.h"

JNIEXPORT void JNICALL Java_com_jankkol_jni_HelloWorld_sayHello (JNIEnv *env, jobject obj){
	printf("Hello World!");
	return;
}
