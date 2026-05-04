cmake_minimum_required(VERSION 3.10)
project(daw)

# Set C++ standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Find Oboe - use absolute path from project root
add_subdirectory(${CMAKE_SOURCE_DIR}/libs/Oboe oboe)

add_library(daw_jni SHARED
    native-lib.cpp
)

target_link_libraries(daw_jni
    oboe
    log
)