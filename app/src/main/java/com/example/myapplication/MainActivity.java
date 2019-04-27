package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import com.example.myapplication.lib;

public class MainActivity extends AppCompatActivity {
    ImageView hahaha;
    public boolean returnTrue(boolean a) {
        if (a == true) {
            return true;
        }
        return false;
    }
    boolean trueResult;
    boolean answer;
    double distance = 5;
    double jeffStep = 0.5;
    double chuchuStep = 0.8;
    boolean lose = false;
       public String question(){
            int first = (int) (Math.random() * 50);
            int second = (int) (Math.random() * 50);
            int result = first + second;
            int judge;
            double prob = Math.random();
            if (prob < 0.5) {
                judge = result;
                trueResult = true;
            } else {
                judge = result + (int) (Math.random() * 10);
                trueResult = false;
            }
            String sentence = Integer.toString(first) + " + " + Integer.toString(second) + " = " + Integer.toString(judge) + "?";
            return sentence;
        }
        public boolean resultTrue(boolean input) {
            answer = input;
            return input == trueResult;
        }
        public void jeffMove(boolean answer) {
            if (answer) {
                distance += jeffStep;
            }  else {
                distance -= chuchuStep;
            }
        }
        /*public void loss(){
            if (distance <= 0) {
                lose = true;
            }
        }*/
        public boolean loss() {
           ImageView spongegeroff = findViewById(R.id.imageView5);
           ImageView boss = findViewById(R.id.imageView4);
           if (spongegeroff.getX() - boss.getX() < 300) {
               return true;
           }
           return false;
        }


    Button button;
    Button button2;
    Button button3;
    ImageView imageView;
    TextView textview;
    ImageView imageView2;
    ImageView imageView3;
    //imageView2 = findViewById(R.id.imageView6);
    public void move() {
        imageView2 = findViewById(R.id.imageView4);
        imageView2.setX(imageView2.getX() + 5);
    }
    public void timer() {
        final Handler handler = new Handler();
        Timer timer = new Timer(false);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        move();
                        ImageView spongegeroff = findViewById(R.id.imageView5);
                        ImageView boss = findViewById(R.id.imageView4);
                        TextView word = findViewById(R.id.word);
                        if (spongegeroff.getX() - boss.getX() > 1000) {
                            word.setVisibility(View.VISIBLE);
                            word.setText("乁( ◔ ౪◔)「");
                        }
                        float a = spongegeroff.getX() - boss.getX();
                        if (a < 500 && a > 300) {
                            word.setVisibility(View.VISIBLE);
                            word.setText("ヾ(°д°)ノ゛");
                        }
                        if (a > 500 && a < 1000) {
                            word.setVisibility(View.INVISIBLE);
                        }
                        if (loss() == true) {
                            //System.out.println(loss());
                            hahaha.setVisibility(View.VISIBLE);
                            button.setClickable(false);
                            button.setTextColor(Color.GRAY);
                            button2.setClickable(false);
                            button2.setTextColor(Color.GRAY);
                            textview.setText("Hahahahahaha");
                        }
                        /*System.out.println("bob" + spongegeroff.getX());
                        System.out.println("boss" + boss.getX());
                        System.out.println(loss());*/
                        // Do whatever you want
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 50, 50);
        //timer();
    }

    public boolean start = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //URL url = getClass().'head\\\\getResource("head.JPG");
        //File file = new File("res/drawable/head.JPG");
       // imageView.setImageURI(Uri.fromFile(file));
        //imageView = findViewById(R.id.imageView);
        //imageView.setImageResource(R.drawable.head);
        //myImage.setImageURI(Uri.fromFile(imgFile));

        //timer();
        hahaha = findViewById(R.id.hahahaha);
        /*if (start == false) {
            hahaha.setVisibility(View.INVISIBLE);
        }*/

        /*if (!loss()) {
            hahaha.setVisibility(View.INVISIBLE);
        } */

        //int i;
        //TextView text2 = findViewById(R.id.textView2);
        imageView3 = findViewById(R.id.imageView6);
        textview = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultTrue(true)) {
                    imageView2.setX(imageView2.getX() - 200);
                    //button.setBackgroundColor(Color.RED);
                    //textview.setText(question());
                }
                if (start == false) {
                    timer();
                    start = true;
                    imageView3.setVisibility(View.INVISIBLE);
                }
                textview.setText(question());
                //timer();
                //videoView.setVideoPath("app/res/drawable/matchman.jpg");
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultTrue(false)) {
                    imageView2.setX(imageView2.getX() - 200);
                    //button2.setBackgroundColor(Color.RED);
                    //CharSequence a = "question";
                }
                textview.setText(question());
                if (start == false) {
                    timer();
                    start = true;
                    imageView3.setVisibility(View.INVISIBLE);
                }
                //timer();
            }
        });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        //((Button) findViewById(R.id.button)).setOnClickListener();
    }
}
