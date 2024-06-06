package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StartGameActivity extends AppCompatActivity {

    private int activePlayer = 1;
    private ArrayList<Integer> player1 = new ArrayList<>();
    private ArrayList<Integer> player2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

    }

    public void Click(View view) {
        int id = 0;
        AppCompatButton button = (AppCompatButton) view;

        if (view.getId() == R.id.btn1) {
            id = 1;
        } else if (view.getId() == R.id.btn2) {
            id = 2;
        } else if (view.getId() == R.id.btn3) {
            id = 3;
        } else if (view.getId() == R.id.btn4) {
            id = 4;
        } else if (view.getId() == R.id.btn5) {
            id = 5;
        } else if (view.getId() == R.id.btn6) {
            id = 6;
        } else if (view.getId() == R.id.btn7) {
            id = 7;
        } else if (view.getId() == R.id.btn8) {
            id = 8;
        } else if (view.getId() == R.id.btn9) {
            id = 9;
        } else {
            id = 0;
        }

        playGame(id, button);
    }


    private void playGame(int id, AppCompatButton button) {
        if(activePlayer == 1){
            button.setText("X");
            player1.add(id);
            button.setBackgroundResource(R.drawable.playerone);
            activePlayer = 2;
        }else{
            button.setText("0");
            player2.add(id);
            button.setBackgroundResource(R.drawable.playertwo);
            activePlayer = 1;
        }
        button.setEnabled(false);
        checkWinner();
    }

    private void checkWinner() {
        int winner = -1;


        //for player 1
        if(player1.contains(1) && player1.contains(2)&& player1.contains(3) ||
                player1.contains(4) && player1.contains(5) && player1.contains(6) ||
                player1.contains(7) && player1.contains(8)&& player1.contains(9) ||
                player1.contains(1) && player1.contains(4)&& player1.contains(7) ||
                player1.contains(2) && player1.contains(5)&& player1.contains(8) ||
                player1.contains(3) && player1.contains(6)&& player1.contains(9) ||
                player1.contains(1) && player1.contains(5)&& player1.contains(9) ||
                player1.contains(3) && player1.contains(5)&& player1.contains(7))
            winner = 1;




        // player 2
        if(player2.contains(1) && player2.contains(2)&&player2.contains(3) ||
                player2.contains(4) && player2.contains(5) && player2.contains(6) ||
                player2.contains(7) && player2.contains(8) && player2.contains(9) ||
                player2.contains(1) && player2.contains(4) && player2.contains(7) ||
                player2.contains(2) && player2.contains(5) && player2.contains(8) ||
                player2.contains(3) && player2.contains(6) && player2.contains(9) ||
                player2.contains(1) && player2.contains(5) && player2.contains(9) ||
                player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2;

        if(winner == -1 && player1.size() + player2.size() == 9){
            showDrawDialog();
        }
        if(winner == 1 || winner == 2){
            showWinnerDialog(winner);
        }


    }

    private void showDrawDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_result);
        dialog.setCanceledOnTouchOutside(false);

        Button play = dialog.findViewById(R.id.plyBtn);
        Button cancel = dialog.findViewById(R.id.exitBtn);
        TextView result = dialog.findViewById(R.id.result);
        result.setText("It's Draw");
        dialog.show();
        play.setOnClickListener(v->{
            startActivity(new Intent(StartGameActivity.this,StartGameActivity.class));
            finish();
        });
        cancel.setOnClickListener(v->{
            startActivity(new Intent(StartGameActivity.this,MainActivity.class));
            finish();
        });


    }

    private void showWinnerDialog(final int winner) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog_result);
        String resultText = (winner ==1 ) ? "Player 1 wins the game":"Player 2 wins the game";

        Button play = dialog.findViewById(R.id.plyBtn);
        Button cancel = dialog.findViewById(R.id.exitBtn);
        TextView result = dialog.findViewById(R.id.result);

        result.setText(resultText);
        dialog.show();
        play.setOnClickListener(v->{
            startActivity(new Intent(StartGameActivity.this,StartGameActivity.class));
            finish();
        });
        cancel.setOnClickListener(v->{
            startActivity(new Intent(StartGameActivity.this,MainActivity.class));
            finish();
        });
    }
}