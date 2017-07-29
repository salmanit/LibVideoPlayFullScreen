package sage.libmediaplayhandle.audiobg;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import sage.libmediaplayhandle.NiceUtil;
import sage.libmediaplayhandle.NiceVideoPlayer;
import sage.libmediaplayhandle.R;

/**
 * Created by Sage on 2017/7/20.
 * 还没开始写。。。。
 */

public class BgAudioPlayer extends FrameLayout
        implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener  {

    private ImageView iv_start_stop;
    private TextView tv_position;
    private TextView tv_duration;
    private SeekBar sb_audio;
    private ProgressBar pb_loading;
    private Timer mUpdateProgressTimer;
    private TimerTask mUpdateProgressTimerTask;

    private String tag;
    private String mUrl;

    public void setTagUrl(String tag,String mUrl) {
        this.tag = tag;
        this.mUrl = mUrl;
    }

    @Override
    public String getTag() {
        return tag;
    }

    public String getmUrl() {
        return mUrl;
    }

    public BgAudioPlayer(@NonNull Context context) {
        super(context);
        init();
    }

    public BgAudioPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BgAudioPlayer(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.nice_audio_player_controller, this, true);
        iv_start_stop = (ImageView) findViewById(R.id.iv_restart_or_pause);
        tv_position = (TextView) findViewById(R.id.tv_audio_position);
        tv_duration = (TextView) findViewById(R.id.tv_audio_duration);
        sb_audio = (SeekBar) findViewById(R.id.sb_audio);
        pb_loading = (ProgressBar) findViewById(R.id.pb_loading);
        iv_start_stop.setOnClickListener(this);
        sb_audio.setOnSeekBarChangeListener(this);
        this.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == iv_start_stop) {
//            if (mNiceAudioPlayer.isIdle()) {
//                mNiceAudioPlayer.start();
//            } else if (mNiceAudioPlayer.isPlaying() || mNiceAudioPlayer.isBufferingPlaying()) {
//                mNiceAudioPlayer.pause();
//            } else if (mNiceAudioPlayer.isPaused() || mNiceAudioPlayer.isBufferingPaused()) {
//                mNiceAudioPlayer.restart();
//            }
        }
    }


    public void setControllerState(int playState) {
        pb_loading.setVisibility(View.GONE);
        switch (playState) {
            case NiceVideoPlayer.STATE_IDLE:

                break;
            case NiceVideoPlayer.STATE_PREPARING:
                // 只显示准备中动画，其他不显示
                pb_loading.setVisibility(VISIBLE);
                break;
            case NiceVideoPlayer.STATE_PREPARED:
//                startUpdateProgressTimer();
                iv_start_stop.setImageResource(R.drawable.vpf_ic_player_pause);
                break;
            case NiceVideoPlayer.STATE_PLAYING:
                iv_start_stop.setImageResource(R.drawable.vpf_ic_player_pause);
                break;
            case NiceVideoPlayer.STATE_PAUSED:
                iv_start_stop.setImageResource(R.drawable.vpf_ic_player_start);
                break;
            case NiceVideoPlayer.STATE_BUFFERING_PLAYING:
                pb_loading.setVisibility(View.VISIBLE);
                iv_start_stop.setImageResource(R.drawable.vpf_ic_player_pause);
                pb_loading.setVisibility(VISIBLE);
                break;
            case NiceVideoPlayer.STATE_BUFFERING_PAUSED:
                pb_loading.setVisibility(View.VISIBLE);
                iv_start_stop.setImageResource(R.drawable.vpf_ic_player_start);
                pb_loading.setVisibility(VISIBLE);
            case NiceVideoPlayer.STATE_COMPLETED:
//                cancelUpdateProgressTimer();
                iv_start_stop.setImageResource(R.drawable.vpf_ic_player_start);
                break;
            case NiceVideoPlayer.STATE_ERROR:
//                cancelUpdateProgressTimer();
                iv_start_stop.setImageResource(R.drawable.vpf_ic_player_start);
                break;
        }
    }

    private void updateProgress() {
//        int position = mNiceAudioPlayer.getCurrentPosition();
//        int duration = mNiceAudioPlayer.getDuration();
//        int bufferPercentage = mNiceAudioPlayer.getBufferPercentage();
//        sb_audio.setSecondaryProgress(bufferPercentage);
//        int progress = (int) (100f * position / duration);
//        sb_audio.setProgress(progress);
//        tv_position.setText(NiceUtil.formatTime(position));
//        tv_duration.setText(NiceUtil.formatTime(duration));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
//        if (mNiceAudioPlayer.isBufferingPaused() || mNiceAudioPlayer.isPaused()) {
//            mNiceAudioPlayer.restart();
//        }
//        int position = (int) (mNiceAudioPlayer.getDuration() * seekBar.getProgress() / 100f);
//        mNiceAudioPlayer.seekTo(position);
    }

    /**
     * 控制器恢复到初始状态
     */
    public void reset() {
        sb_audio.setProgress(0);
        sb_audio.setSecondaryProgress(0);
        iv_start_stop.setImageResource(R.drawable.vpf_ic_player_start);
        pb_loading.setVisibility(View.GONE);
    }
}
