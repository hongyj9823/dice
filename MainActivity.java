package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random =new Random();

        final ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        final int[] imageList = new int[]{R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        final RadioGroup RG=(RadioGroup)findViewById(R.id.radioGroup);
        Button btn = (Button) findViewById(R.id.button);

	imageView1.setVisibility(View.GONE);
	imageView2.setVisibility(View.GONE);

	RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
		@Override
		public void onCheckedChanged(RadioGroup radioGroup, int id ){
			switch(id){
				case R.id.radioButton1:{
					imageView1.setVisibility(View.VISIBLE);
					imageView2.setVisibility(View.GONE);
					break;
				}
				case R.id.radioButton2:{
					imageView1.setVisibility(View.VISIBLE);
					imageView2.setVisibility(View.VISIBLE);
					break;
				}
			
			}
		}
	});
       
	btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int  rd;
                switch (RG.getCheckedRadioButtonId())
                {
                    case R.id.radioButton1: //주사위 1개 굴렸을 때
                    {
                        rd = random.nextInt(7);
                       //범위 0-6 까지
                        imageView1.setImageResource(imageList[rd]);
                        imageView2.setVisibility(View.GONE);
			break;
                    }

                    case R.id.radioButton2:// 주사위 2개 굴렸을 때
                    {
                        rd = random.nextInt(7);
                        //범위 0-6 까지
                        imageView1.setImageResource(imageList[rd]);
                        rd = random.nextInt(7);
                        //범위 0-6 까지
                        imageView2.setImageResource(imageList[rd]);
                        break;
                    }
               }
            }
        });
    }
}
