# CMakeLists.txt
cmake_minimum_required(VERSION 3.4.1)

add_library( # Name of the library
        native-lib

        # Library type (shared for .so file)
        SHARED

        # Source file to compile
        native-lib.cpp )

find_library( # Defines the path for the Android NDK log library
        log-lib
        log )

# Link the target library with the log library
target_link_libraries(
        native-lib
        ${log-lib} )
