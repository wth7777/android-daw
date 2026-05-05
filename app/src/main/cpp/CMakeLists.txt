cmake_minimum_required(VERSION 3.10)
project(daw)

# Set C++ standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Oboe setup - relative path from app/src/main/cpp to libs/Oboe
set(OBOE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../../libs/Oboe")

# Print the path so we can debug
message(STATUS "=== Oboe directory set to: ${OBOE_DIR} ===")

# Add Oboe
add_subdirectory(${OBOE_DIR} oboe-bin)

# Create the JNI library
add_library(daw_jni SHARED
    native-lib.cpp
)

# Include Oboe headers
target_include_directories(daw_jni PRIVATE ${OBOE_DIR}/include)

# Link against Oboe and Android log library
target_link_libraries(daw_jni
    oboe
    log
)
