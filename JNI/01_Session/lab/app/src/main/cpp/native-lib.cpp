// native-lib.cpp
#include <jni.h>
#include <string>

// C++ recursive function to compute factorial
int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_lab_FactorialCalculator_factorial(JNIEnv *env, jobject instance, jint n) {
    int result = factorial(n);

    // Call Java logResult method
    jclass cls = env->GetObjectClass(instance);
    jmethodID logMethod = env->GetMethodID(cls, "logResult", "(I)V");
    if (logMethod != nullptr) {
        env->CallVoidMethod(instance, logMethod, result);
    }

    return result;
}
