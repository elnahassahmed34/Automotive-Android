#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapp_MainActivity_stringFromJNI(JNIEnv* env , jobject /* this */) {

    //env -> FindClass(com/example/myapp/Complex);

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}