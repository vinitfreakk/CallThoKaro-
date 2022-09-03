package com.accidentaldeveloper.callthokaro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DashBoardActivity extends AppCompatActivity {
   EditText screctCodeBox;
   Button joinbtn,sharebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        screctCodeBox = findViewById(R.id.codeBox);
        joinbtn = findViewById(R.id.JoinBtn);
        sharebtn = findViewById(R.id.ShareBtn);
        URL serverURL ;
       /* try {
            serverURl = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions defaultoption = new JitsiMeetConferenceOptions.Builder().setServerURL(serverURl).build();
            JitsiMeet.setDefaultConferenceOptions(defaultoption);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        joinbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                         .setRoom(screctCodeBox.getText().toString())
                         .build();
                 JitsiMeetActivity.launch(DashBoardActivity.this,options);

             }
         });


    }
}*/
        try {
            serverURL  = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions defaultOptions =
                    new JitsiMeetConferenceOptions.Builder()
                            .setServerURL(serverURL)
                            .build();
            JitsiMeet.setDefaultConferenceOptions(defaultOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }





        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(screctCodeBox.getText().toString())
                        .build();

                JitsiMeetActivity.launch(DashBoardActivity.this, options);
            }
        });
    }
}

