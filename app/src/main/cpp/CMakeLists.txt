cmake_minimum_required(VERSION 3.10)
project(daw)

# Set C++ standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Find Oboe - use absolute path from project root
# === Oboe Setup ===
# Path from: app/src/main/cpp/ → libs/Oboe (at project root)
set(OBOE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../../libs/Oboe")

# Print the path so we can see what CMake actually sees
message(STATUS "=== Oboe directory set to: ${OBOE_DIR} ===")

# Add Oboe
add_subdirectory(${OBOE_DIR} oboe-bin)

add_library(daw_jni SHARED
    native-lib.cpp
)

target_link_libraries(daw_jni
    oboe
    log
)