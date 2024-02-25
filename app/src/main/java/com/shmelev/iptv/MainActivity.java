package com.shmelev.iptv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterInterface {

    ArrayList<Channel> channels = new ArrayList<>();

    FrameLayout frameLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createPlaylist();
        frameLayout = findViewById(R.id.frame_layout);
        recyclerView = findViewById(R.id.recycler_view);
        ChannelsAdapter adapter = new ChannelsAdapter(channels, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    void createPlaylist() {
        channels.add(new Channel("Ibiza Global TV", "https://img.freepik.com/free-photo/beautiful-kitten-with-colorful-clouds_23-2150752964.jpg", "https://qcpdqumitwf.a.trbcdn.net/livemastersrt/pr4mw_lvie-vmesterf-srt.smil/playlist.m3u8"));
        channels.add(new Channel("Ibiza Global TV", "https://ekzot.ucoz.net/ch_icons/i/ibiza_global_tv.png", "https://server10.streaming-pro.com:1937/live/ibgtvlive/playlist.m3u8"));
        channels.add(new Channel("Ibiza Global TV", "https://ekzot.ucoz.net/ch_icons/i/ibiza_global_tv.png", "https://server10.streaming-pro.com:1937/live/ibgtvlive/playlist.m3u8"));
        channels.add(new Channel("Ibiza Global TV", "https://ekzot.ucoz.net/ch_icons/i/ibiza_global_tv.png", "https://server10.streaming-pro.com:1937/live/ibgtvlive/playlist.m3u8"));
        channels.add(new Channel("Ibiza Global TV", "https://ekzot.ucoz.net/ch_icons/i/ibiza_global_tv.png", "https://server10.streaming-pro.com:1937/live/ibgtvlive/playlist.m3u8"));
        channels.add(new Channel("Ibiza Global TV", "https://ekzot.ucoz.net/ch_icons/i/ibiza_global_tv.png", "https://server10.streaming-pro.com:1937/live/ibgtvlive/playlist.m3u8"));
        channels.add(new Channel("Ibiza Global TV", "https://ekzot.ucoz.net/ch_icons/i/ibiza_global_tv.png", "https://server10.streaming-pro.com:1937/live/ibgtvlive/playlist.m3u8"));
        channels.add(new Channel("Ibiza Global TV", "https://ekzot.ucoz.net/ch_icons/i/ibiza_global_tv.png", "https://server10.streaming-pro.com:1937/live/ibgtvlive/playlist.m3u8"));
    }

    @Override
    public void onClick(Channel channel) {
        recyclerView.setVisibility(View.GONE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Bundle bundle = new Bundle();
        bundle.putSerializable("channel", channel);
        PlayerFragment playerFragment = new PlayerFragment();
        playerFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(frameLayout.getId(), playerFragment)
                .addToBackStack("player")
                .commitAllowingStateLoss();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recyclerView.setVisibility(View.VISIBLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}