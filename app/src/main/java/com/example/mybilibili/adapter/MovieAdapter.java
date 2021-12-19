package com.example.mybilibili.adapter;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybilibili.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Timer timer;
    private TimerTask timerTask;
    private Activity activity;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
    private List<String> list;
    private List<VideoView> videoList = new ArrayList<>();
    private List<Button> buttonList = new ArrayList<>();

    public MovieAdapter(Activity activity, List<String> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_movie2,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        videoList.add(viewHolder.videoView);
        buttonList.add(viewHolder.buttonPlay);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( MovieAdapter.ViewHolder holder, int position) {
        holder.videoView.setVideoPath(list.get(position));
        holder.videoView.requestFocus();
        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.textViewTime.setText(time(holder.videoView.getDuration()));
                holder.buttonPlay.setEnabled(true);

            }
        });

        // 在播放完毕被回调
        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                holder.buttonPlay.setText("▶");
                //Toast.makeText(activity, "播放完成", Toast.LENGTH_SHORT).show();
            }
        });

        holder.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                // 发生错误重新播放
                play(holder,position);
                Toast.makeText(activity, "播放出错", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            // 当进度条停止修改的时候触发
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 取得当前进度条的刻度
                if (!holder.videoView.isPlaying()) {
                    // 设置当前播放的位置
                    play(holder,position);
                }
                holder.videoView.seekTo(seekBar.getProgress());
            }
        };
            // 为进度条添加进度更改事件
        holder.seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        holder.buttonPlay.setEnabled(false);
        holder.buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(holder,position);
            }
        });
        init(holder);


    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private VideoView videoView;
        private SeekBar seekBar;
        private Button buttonPlay;
        private TextView textViewTime;
        private TextView textViewCurrentPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            seekBar = itemView.findViewById(R.id.seekBar);
            buttonPlay = itemView.findViewById(R.id.buttonPlay);
            textViewCurrentPosition = itemView.findViewById(R.id.textViewCurrentPosition);
            textViewTime = itemView.findViewById(R.id.textViewTime);
        }
    }
    private void init(ViewHolder holder) {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (holder.videoView.isPlaying()) {
                    int current = holder.videoView.getCurrentPosition();
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            holder.seekBar.setProgress(current);
                            holder.textViewCurrentPosition.setText(time(holder.videoView.getCurrentPosition()));
                        }
                    });

                }
            }
        };
        timer.schedule(timerTask,500,500);
    }
    protected String time(long millionSeconds) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millionSeconds);
        return simpleDateFormat.format(c.getTime());
    }
    protected void play(ViewHolder holder,int position) {
        if (holder.buttonPlay.getText().equals("▶")) {
            holder.buttonPlay.setText("");

            for(int i = 0;i < videoList.size(); i++){
                if(i != position){
                    videoList.get(i).pause();
                    buttonList.get(i).setText("▶");
                }else{
                    continue;
                }
            }
            init(holder);
            holder.videoView.start();
            holder.seekBar.setMax(holder.videoView.getDuration());

        } else {
            holder.buttonPlay.setText("▶");
            if (holder.videoView.isPlaying()) {
                holder.videoView.pause();
            }
        }
    }
}
