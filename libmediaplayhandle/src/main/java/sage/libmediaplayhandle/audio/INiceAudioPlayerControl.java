package sage.libmediaplayhandle.audio;

/**
 * Created by XiaoJianjun on 2017/5/5.
 */

public interface INiceAudioPlayerControl {

    void start();
    void restart();
    void pause();
    void seekTo(int pos);

    boolean isIdle();
    boolean isPreparing();
    boolean isPrepared();
    boolean isBufferingPlaying();
    boolean isBufferingPaused();
    boolean isPlaying();
    boolean isPaused();
    boolean isError();
    boolean isCompleted();

    int getDuration();
    int getCurrentPosition();
    int getBufferPercentage();


    void release();
}
