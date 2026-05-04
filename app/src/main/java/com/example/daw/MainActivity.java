package com.example.daw;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("daw_jni");
    }

    private native boolean startAudio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.playButton);
        btn.setOnClickListener(v -> {
            boolean ok = startAudio();
            btn.setText(ok ? "Playing" : "Failed");
        });
    }
}
