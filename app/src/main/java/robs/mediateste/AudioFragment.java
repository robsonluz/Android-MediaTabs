package robs.mediateste;


import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AudioFragment extends Fragment {

    private MediaPlayer ringtonePlayer;
    private MediaPlayer mp3Player;

    public AudioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);

        //Capturando o onClick do botão via programação
        Button cmdPlayRingTone = (Button) view.findViewById(R.id.cmdPlayRingTone);
        cmdPlayRingTone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRingTone(v);
            }
        });

        Button cmdPlayMP3 = (Button) view.findViewById(R.id.cmdPlayMP3);
        cmdPlayMP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMP3(v);
            }
        });

        return view;
    }

    public void playMP3(View view) {
        try {
            if (mp3Player == null) {
                //Cria o player na primeira vez que o usuario clicou
                mp3Player = new MediaPlayer();

                //Referencia para o arquivo MP3
                AssetFileDescriptor descriptor = getActivity().getAssets().openFd(
                        "audio/jingle_bells.mp3");

                //Adiciona o arquivo jingle_bells.mp3 no Player através do descriptor
                mp3Player.setDataSource(descriptor.getFileDescriptor(),
                        descriptor.getStartOffset(),
                        descriptor.getLength());

                descriptor.close();
                mp3Player.prepare();

            }

            if (mp3Player.isPlaying()) {
                mp3Player.pause();
            } else {
                mp3Player.start();
            }
        }catch(Exception ex) {
            Toast.makeText(this.getActivity(), "Não foi possível reproduzir o MP3", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    //Método chamado quando o botão Play/Pause RingTone for clicado
    public void playRingTone(View view) {
        if(ringtonePlayer==null) {
            //Cria o player na primeira vez que o usuario clicou
            ringtonePlayer = MediaPlayer.create(this.getActivity(), R.raw.pegasus);
        }

        if(ringtonePlayer.isPlaying()) {
            ringtonePlayer.pause();
        }else{
            ringtonePlayer.start();
        }
    }

}
