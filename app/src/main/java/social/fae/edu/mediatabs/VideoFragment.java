package social.fae.edu.mediatabs;


import android.widget.Button;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);

        Button cmdPlayVideo = (Button) view.findViewById(R.id.cmdPlayVideo);
        cmdPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(v);
            }
        });



        return view;
    }

    private void playVideo(View v) {
        VideoView videoView = (VideoView) getView().findViewById(R.id.videoView);
        //Mantém a tela ativa
        videoView.setKeepScreenOn(true);

        //Pegando o vídeo do cartao SD
        //String sdcard = Environment.getExternalStorageDirectory().getPath();
        //videoView.setVideoPath(sdcard+"/DCIM/Camera/VID_20130116_143238.mp4");

        //Video da URL
        //Para funcionar tem que adicionar a permissao de acesso a Internet no APP
        videoView.setVideoURI(Uri.parse("http://www.html5rocks.com/en/tutorials/video/basics/Chrome_ImF.mp4"));

        MediaController mediaController = new MediaController(this.getActivity());
        videoView.setMediaController(mediaController);
    }


}
