# Android DAW - Basic Audio Playback

This project demonstrates a simple Android DAW using Oboe (open-source) for low-latency audio playback.

## Features
- Generates a 440Hz sine wave when "Play Sine" button is pressed.
- Uses Oboe for audio output.

## Prerequisites
- Android Studio (latest)
- Android NDK (Side by side) installed via SDK Manager
- CMake 3.22+

## Build Instructions
1. Open Android Studio.
2. Select "Open an Existing Project" and choose the `android-daw` directory.
3. Let Gradle sync.
4. Ensure you have an Android device or emulator with audio output.
5. Click Run.

## Project Structure
- `app/src/main/cpp/` - Native C++ code using Oboe.
- `app/src/main/java/` - Java activity.
- `libs/Oboe` - Oboe library (cloned from GitHub).

## Notes
- This is a minimal example. Expand with multi-track, MIDI, effects, etc.
- JUCE was omitted for simplicity; Oboe is sufficient for low-level audio.

## License
Oboe: Apache 2.0.
Sample code: MIT.

## Progress Log
- [x] Project structure created
- [x] Oboe integrated
- [x] Basic sine playback
- [ ] Multi-track support
- [ ] Save/load project
