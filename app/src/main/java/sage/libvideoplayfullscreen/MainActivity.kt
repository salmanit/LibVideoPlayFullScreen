package sage.libvideoplayfullscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import sage.libmediaplayhandle.NiceVideoPlayer
import sage.libmediaplayhandle.NiceVideoPlayerController
import sage.libmediaplayhandle.NiceVideoPlayerManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var player = findViewById(R.id.nvp) as NiceVideoPlayer

        var controller = NiceVideoPlayerController(this)
        player.setController(controller)
        player.setUp("http://10.0.2.53:8380/media/videos/20161108180726.mp4")
        controller.setTitle(".....")//设置视频封面
//        controller.setImage(R.mipmap.ic_launcher)//设置本地封面图片
        var coverImg=controller.coverUI//ImageView 显示封面用的，获取到控件后可以自己使用相应的图片库加载图片。
    }

    override fun onBackPressed() {
        if(NiceVideoPlayerManager.instance().onBackPressd()){
            return
        }
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer()
        super.onBackPressed()
    }
}
