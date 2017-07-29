package sage.libvideoplayfullscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_simple.*
import sage.libmediaplayhandle.NiceVideoPlayer
import sage.libmediaplayhandle.NiceVideoPlayerController
import sage.libmediaplayhandle.NiceVideoPlayerManager
import sage.libmediaplayhandle.audio.NiceAudioPlayer
import sage.libmediaplayhandle.audio.NiceAudioPlayerManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var player = findViewById(R.id.nvp) as NiceVideoPlayer

        var controller = NiceVideoPlayerController(this)
        player.setController(controller)
        player.setUp("http://10.0.2.53:8380/media/videos/20161108180726.mp4")
        controller.setTitle("")//设置视频封面
//        controller.setImage(R.mipmap.ic_launcher)//设置本地封面图片
        var coverImg = controller.coverUI//ImageView 显示封面用的，获取到控件后可以自己使用相应的图片库加载图片。
        rv.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=object :RecyclerView.Adapter<MyHolder>(){
                override fun getItemCount(): Int {
                    return 20
                }

                override fun onBindViewHolder(holder: MyHolder, position: Int) {
                    holder.tv_position.text="p$position"
                    if(position%2==0){
                        holder.videoPlayer.visibility=View.GONE
                        holder.audioPlayer.visibility=View.VISIBLE
                        holder.audioPlayer.setUrl("http://sunroam.imgup.cn/aerospace/videos/20170710165508.mp3")

                    }else{
                        holder.videoPlayer.visibility=View.VISIBLE
                        holder.audioPlayer.visibility=View.GONE
                        var control=holder.videoPlayer.getmController()
                        if(control==null){
                            control=NiceVideoPlayerController(this@MainActivity)
                            holder.videoPlayer.setController(control)
                        }
                        holder.videoPlayer.setUp("http://10.0.2.53:8380/media/videos/20161108180726.mp4")
                    }
                }

                override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
                    var view=layoutInflater.inflate(R.layout.item_simple,rv,false)
                    return MyHolder(view)
                }
            }
        }

    }

    class MyHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tv_position=itemView.findViewById(R.id.tv_position) as TextView
        var audioPlayer=itemView.findViewById(R.id.audio_item) as NiceAudioPlayer
        var videoPlayer=itemView.findViewById(R.id.nvp) as NiceVideoPlayer
    }
    override fun onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) {
            return
        }
//        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer()

//        NiceAudioPlayerManager.instance().onBackPressd()
        super.onBackPressed()
    }
}
