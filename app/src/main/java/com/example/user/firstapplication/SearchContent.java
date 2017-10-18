package com.example.user.firstapplication;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.user.firstapplication.R.id.musicSeekBar;
import static com.example.user.firstapplication.R.id.playPauseButton;

/**
 * Created by User on 13-10-2017.
 */

public class SearchContent extends AppCompatActivity {

    Toolbar toolbar;
    NotificationManager mNotificationManager;
    SeekBar musicSeekBar;
    private static final String TAG = SearchContent.class.getSimpleName();
    private RecyclerView searchRV;
    private List<PodCastModel> podCastList = new ArrayList<>();

    private static String path = "podcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchcontent);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchRV = (RecyclerView) findViewById(R.id.list_rv);
        searchRV.setLayoutManager(new LinearLayoutManager(this));
        final PodCastAdapter adapter = new PodCastAdapter(podCastList, R.layout.podcastcontent, this);
        searchRV.setAdapter(adapter);

        if (path.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Invalid URL", Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        String country = "us";
        Call<PodCastResponse> call = apiService.getPodcastContent(path, country);
        call.enqueue(new Callback<PodCastResponse>() {
            @Override
            public void onResponse(Call<PodCastResponse>call, Response<PodCastResponse> response) {
                System.out.println("response = " + response);
                List<PodCastModel> podCasts = response.body().getResults();
                podCastList.addAll(podCasts);
                adapter.notifyDataSetChanged();
                //Log.d(TAG, "https://rss.itunes.apple.com/api/v1/us/podcasts/top-podcasts/all/50/explicit.json");
                Log.d(TAG, "Number of podcasts received: " + podCastList.size());
            }

            @Override
            public void onFailure(Call<PodCastResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

        musicSeekBar = (SeekBar) musicSeekBar.findViewById(musicSeekBar);
        musicSeekBar.setOnSeekBarChangeListener(this);
        playPauseButton = (ToggleButton) playPauseButton.findViewById(playPauseButton);

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on clicks
                if (playPauseButton.isChecked()) { // Checked - Pause icon visible
                    mMediaPlayer.start();
                } else { // Unchecked - Play icon visible
                    mMediaPlayer.pause();
                }
            }
        });
        mInstance = this;
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem search_item = menu.findItem(R.id.mi_search);

        SearchView searchView = (SearchView) search_item.getActionView();
        searchView.setFocusable(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}

