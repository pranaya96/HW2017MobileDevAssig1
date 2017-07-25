package com.pranayaa.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

import static com.pranayaa.tictactoe.TicTacToeLogic.TTTElement.*;

public class MainActivity extends AppCompatActivity {
    private Button mNewGame;
    TicTacToeLogic.TTTElement[] gameState =
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
    List<Button> mButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNewGame = (Button) findViewById(R.id.new_game_button);

        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set new game button's visibility as invisible after the game has started
                mNewGame.setVisibility(View.INVISIBLE);
                //reset the gameState array to all Empty, text inside button to empty and clickability to true
                for(int i=0; i <mButtons.size(); i++){
                    mButtons.get(i).setText("");
                    gameState[i] = EMPTY;
                    mButtons.get(i).setClickable(true);
                }
            }
        });

        //retreive the id of each button and put all the buttons in a list
        for (int i = 0; i < 9; i++) {
            String button_name = "button" + i;
            int idValue = getResources().getIdentifier(button_name, "id", getPackageName());
            Button myButton = (Button) findViewById(idValue);
            mButtons.add(myButton);
        }

        for (int i=0;i<mButtons.size();i++) {
            Button button = mButtons.get(i);
            final int final_i = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    didPressGameButton(final_i);
                }
            });
        }


    }
    private void didPressGameButton(int index) {
        mButtons.get(index).setText("X");
        gameState[index] = TicTacToeLogic.TTTElement.X;
        mButtons.get(index).setClickable(false);

        //find the best move and update the button and text inside it and make the button unclickable
        if (!TicTacToeLogic.isGameOver(gameState)) {
            int bestMove = TicTacToeLogic.getBestMove(gameState);
            mButtons.get(bestMove).setText("O");
            gameState[bestMove] = TicTacToeLogic.TTTElement.O;
            mButtons.get(bestMove).setClickable(false);
        }
        //make the new game button visible and set the clickability of all the buttons to false
        if(TicTacToeLogic.isGameOver(gameState)){
            for(int i= 0; i < mButtons.size() ; i++){
                mButtons.get(i).setClickable(false);
            }
            mNewGame.setVisibility(View.VISIBLE);
        }
    }
}


