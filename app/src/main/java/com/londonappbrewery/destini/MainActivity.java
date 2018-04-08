package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTV;
    private Button ans1, ans2;
    private int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTV = (TextView) findViewById(R.id.storyTextView);
        ans1 = (Button) findViewById(R.id.buttonTop);
        ans2 = (Button) findViewById(R.id.buttonBottom);
        mStoryIndex = 1;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theStory(1);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theStory(2);
            }
        });
    }

    private void theStory(int choice) {
        switch (mStoryIndex) {
            case 1:
                if (choice == 1) {
                    storyTV.setText(R.string.T3_Story);
                    ans1.setText(R.string.T3_Ans1);
                    ans2.setText(R.string.T3_Ans2);
                    mStoryIndex = 3;
                } else if (choice == 2) {
                    storyTV.setText(R.string.T2_Story);
                    ans1.setText(R.string.T2_Ans1);
                    ans2.setText(R.string.T2_Ans2);
                    mStoryIndex = 2;
                }
                break;

            case 2:
                if (choice == 1) {
                    mStoryIndex = 1;
                    theStory(1);
                } else if (choice == 2) {
                    storyTV.setText(R.string.T4_End);
                    noButtons();
                }
                break;
            case 3:
                if (choice == 1) {
                    storyTV.setText(R.string.T6_End);
                    noButtons();
                } else if (choice == 2) {
                    storyTV.setText(R.string.T5_End);
                    noButtons();
                }
                break;

        }
    }

    private void noButtons() {
        ans1.setVisibility(View.INVISIBLE);
        ans2.setVisibility(View.INVISIBLE);
    }
}
