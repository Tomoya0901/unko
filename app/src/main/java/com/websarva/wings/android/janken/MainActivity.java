package com.websarva.wings.android.janken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   TextView tvOpponent,tvResult;
   Button rock,scissors,paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       tvOpponent = findViewById(R.id.tvOpponent);
       tvResult = findViewById(R.id.tvResult);
       rock = findViewById(R.id.rock);
       scissors = findViewById(R.id.scissors);
       paper = findViewById(R.id.paper);

       //相手の手1"rock"2"scissors"3"paper"

        //グーを出したとき
       rock.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int opponentHand = decideOpponentHand();//敵の手を数値化してdecideOpponentHand();という名前をつける
               String opponentHandText = changeTextOpponentHand(opponentHand);//相手の出した手の文字列をchangeTextOpponentHand(opponentHand);という名前に
               tvOpponent.setText(opponentHandText);//相手の手を表示(opponentHandText)
               decideGame(1,opponentHand,tvResult); //decideGame(1,opponentHand,tvsub)に勝敗（自分の出す手(グー１)(相手の手)(結果の文字列)）の引数
           }
       });
       scissors.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int opponentHand = decideOpponentHand();
               String opponentHandText = changeTextOpponentHand(opponentHand);
               tvOpponent.setText(opponentHandText);
               decideGame(2,opponentHand,tvResult);
           }
       });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                tvOpponent.setText(opponentHandText);
                decideGame(3,opponentHand,tvResult);
            }
        });
    }
    String changeTextOpponentHand(int hand){
        String handText = "";
        if (hand == 1) handText = "グー";
        else if (hand == 2) handText = "チョキ";
        else if (hand == 3) handText = "パー";
        return handText;
    }
    int decideOpponentHand(){
        Random rnd = new Random();
        int hand = rnd.nextInt(3+1);
        return hand;
    }
    void decideGame(int playerHand,int opponentHand,TextView decidetext){
        String decision;
        if (playerHand == opponentHand)decision = "あいこ";
        else if ((playerHand == 3 && opponentHand ==1)||(playerHand+1 == opponentHand))
            decision ="勝ち";
        else decision ="負け";
        decidetext.setText(decision);
    }
}
