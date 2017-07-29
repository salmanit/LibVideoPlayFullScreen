package sage.libmediaplayhandle.audio;


/**
 * Created by sage on 2017/7/19.
 * 音频播放器管理器.
 */
public class NiceAudioPlayerManager {

    private NiceAudioPlayer mAudioPlayer;

    private NiceAudioPlayerManager() {
    }

    private static NiceAudioPlayerManager sInstance;

    public static synchronized NiceAudioPlayerManager instance() {
        synchronized (NiceAudioPlayerManager.class){
            if (sInstance == null) {
                sInstance = new NiceAudioPlayerManager();
            }
        }
        return sInstance;
    }

    public void setCurrentNiceAudioPlayer(NiceAudioPlayer audioPlayer) {
        mAudioPlayer = audioPlayer;
    }

    public void releaseNiceAudioPlayer() {
        if (mAudioPlayer != null) {
            mAudioPlayer.release();
            mAudioPlayer = null;
        }
    }

    public boolean onBackPressd() {
        if (mAudioPlayer != null) {
            mAudioPlayer.release();
        }
        return false;
    }
}
