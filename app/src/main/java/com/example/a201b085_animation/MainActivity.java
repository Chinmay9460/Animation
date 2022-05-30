package com.example.a201b085_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean iswinner = false;
    int image_click = -1;
    int player = 1;//player1 is cross

    int[][] winning_state = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] game_state = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void load(View view) {

            int tag = Integer.parseInt( view.getTag().toString() );
            ImageView v = (ImageView) view;
            image_click=game_state[tag];
        if(iswinner ==false && image_click==-1) {
            if (player == 1) {
                v.setImageResource( R.drawable.cross );
                game_state[tag] = player;
                Toast.makeText( this , tag + " " + "You have pressed cross." , Toast.LENGTH_SHORT ).show();
                player = 0;
            } else {
                v.setImageResource( R.drawable.zero );
                game_state[tag] = player;
                Toast.makeText( this , tag + " " + "You have pressed zero." , Toast.LENGTH_SHORT ).show();
                player = 1;
            }
            for (int i = 0; i < winning_state.length; i++) {
                if (game_state[winning_state[i][0]] == game_state[winning_state[i][1]] && game_state[winning_state[i][1]] == game_state[winning_state[i][2]] && game_state[winning_state[i][0]] > -1) {
                    Toast.makeText( this ,"Winner is"+  (player == 0 ? 1 : 0) ,Toast.LENGTH_SHORT ).show();
                    iswinner=true;
                }

            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout=findViewById( R.id.grid1 );
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v = (ImageView) gridLayout.getChildAt( i );
            v.setImageDrawable( null );
        }
        iswinner = false;
        image_click=-1;


        player=1;
        for(int i=0;i< game_state.length;i++)
            game_state[i]=-1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
}