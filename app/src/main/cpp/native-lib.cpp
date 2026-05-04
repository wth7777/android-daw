#include <jni.h>
#include <string>
#include <oboe/Oboe.h>
#include <vector>
#include <cmath>

#ifndef M_PI
#define M_PI 3.14159265358979323846
#endif

class AudioCallback : public oboe::AudioStreamCallback {
 public:
  oboe::Result onAudioReady(oboe::AudioStream *stream, void *audioData, int32_t numFrames) override {
    // Simple sine wave generation
    float *audio = static_cast<float*>(audioData);
    float freq = 440.0f;
    static double phase = 0.0;
    double phaseInc = 2.0 * M_PI * freq / stream->getSampleRate();
    for (int i = 0; i < numFrames; ++i) {
      float sample = 0.25f * sin(phase);
      audio[2*i] = sample; // left
      audio[2*i+1] = sample; // right
      phase += phaseInc;
      if (phase >= 2.0 * M_PI) phase -= 2.0 * M_PI;
    }
    return oboe::Result::OK;
  }
};

static AudioCallback callback;
static oboe::AudioStream *stream = nullptr;

static oboe::Result startStream() {
  oboe::AudioStreamBuilder builder;
  builder.setCallback(&callback);
  builder.setFormat(oboe::AudioFormat::Float32);
  builder.setSampleRate(48000);
  builder.setChannelCount(2);
  builder.setPerformanceMode(oboe::PerformanceMode::LowLatency);
  oboe::Result result = builder.openStream(&stream);
  if (result != oboe::Result::OK) return result;
  result = stream->requestStart();
  return result;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_daw_MainActivity_startAudio(JNIEnv *env, jobject /* this */) {
  if (stream == nullptr) {
    oboe::Result r = startStream();
    return r == oboe::Result::OK;
  }
  return true;
}
