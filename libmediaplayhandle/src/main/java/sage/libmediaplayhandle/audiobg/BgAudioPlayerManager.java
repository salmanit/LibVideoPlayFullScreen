package sage.libmediaplayhandle.audiobg;

import android.text.TextUtils;

/**
 * Created by Sage on 2017/7/20.
 */

public class BgAudioPlayerManager {

    private BgAudioPlayerManager() {
    }

    private static BgAudioPlayerManager sInstance;

    public static synchronized BgAudioPlayerManager instance() {
        synchronized (BgAudioPlayerManager.class) {
            if (sInstance == null) {
                sInstance = new BgAudioPlayerManager();
            }
        }
        return sInstance;
    }

    private BgAudioPlayer mBgAudioPlayer;
    private String tagOld;//音频tag，用来区分是否是同一个控件，主要是列表页滑动的时候可能item会重复利用，也可能音频地址一样，可却不是同一个item
    private String mUrlOld;//音频地址
    public void setmBgAudioPlayer(BgAudioPlayer bgAudioPlayer){
        mBgAudioPlayer=bgAudioPlayer;
    }

    public void playOrStop(BgAudioPlayer bgAudioPlayer){
        String tag=bgAudioPlayer.getTag();
        if(TextUtils.isEmpty(tagOld)){
            //老的tag没有，说明这是第一次播放
            tagOld=tag;
        }else{
            if(TextUtils.equals(tagOld,tag)){
                //是同一个。
            }else{

            }
        }
    }
}
