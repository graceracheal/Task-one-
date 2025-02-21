package com.example.taskone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "UltimateMusicApp";
    private TextView songTitleTextView;
    private TextView artistTextView;
    private TextView currentTimeTextView;
    private TextView totalTimeTextView;
    private ImageButton playPauseButton;
    private SeekBar seekBar;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setupClickListeners();

        Log.d(TAG, "onCreate: Ultimate Music App is being created");
    }

    private void initializeViews() {
        songTitleTextView = findViewById(R.id.songTitleTextView);
        artistTextView = findViewById(R.id.artistTextView);
        currentTimeTextView = findViewById(R.id.currentTimeTextView);
        totalTimeTextView = findViewById(R.id.totalTimeTextView);
        playPauseButton = findViewById(R.id.playPauseButton);
        seekBar = findViewById(R.id.seekBar);

        songTitleTextView.setText("Song Title");
        artistTextView.setText("Artist Name");
        currentTimeTextView.setText("0:00");
        totalTimeTextView.setText("3:45");
        seekBar.setProgress(0);
    }

    private void setupClickListeners() {

        findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        playPauseButton.setOnClickListener(v -> togglePlayPause());
        findViewById(R.id.previousButton).setOnClickListener(v -> previousTrack());
        findViewById(R.id.nextButton).setOnClickListener(v -> nextTrack());

        findViewById(R.id.shuffleButton).setOnClickListener(v -> toggleShuffle());
        findViewById(R.id.repeatButton).setOnClickListener(v -> toggleRepeat());
        findViewById(R.id.playlistButton).setOnClickListener(v -> showPlaylist());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    updateTimeDisplay(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void togglePlayPause() {
        isPlaying = !isPlaying;
        playPauseButton.setImageResource(
                isPlaying ? R.drawable.pause : R.drawable.play
        );
        Log.d(TAG, "togglePlayPause: " + (isPlaying ? "Playing" : "Paused"));
    }

    private void previousTrack() {
        Log.d(TAG, "previousTrack: Switching to previous track");
    }

    private void nextTrack() {
        Log.d(TAG, "nextTrack: Switching to next track");
    }

    private void toggleShuffle() {
        Log.d(TAG, "toggleShuffle: Toggling shuffle mode");
    }

    private void toggleRepeat() {
        Log.d(TAG, "toggleRepeat: Toggling repeat mode");
    }

    private void showPlaylist() {
        Log.d(TAG, "showPlaylist: Showing playlist");
    }

    private void updateTimeDisplay(int progress) {
        String currentTime = String.format("%d:%02d", progress / 60, progress % 60);
        currentTimeTextView.setText(currentTime);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Ultimate Music Player is starting");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Ultimate Music Player is now active");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Ultimate Music Player is paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Ultimate Music Player is stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: Ultimate Music Player is restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Ultimate Music Player is being destroyed");
    }
}