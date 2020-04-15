package com.example.pfuternik.vidyoiodemo;

import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vidyo.VidyoClient.Connector.ConnectorPkg;
import com.vidyo.VidyoClient.Connector.Connector;

public class Doctor4 extends AppCompatActivity implements Connector.IConnect {

    private Connector vc;
    private FrameLayout videoFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor4);

        ConnectorPkg.setApplicationUIContext(this);
        ConnectorPkg.initialize();
        videoFrame = (FrameLayout)findViewById(R.id.videoFrame);

    }

    public void Connect(View v) {
        vc = new Connector(videoFrame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 1, "warning info@VidyoClient info@VidyoConnector", "", 0);
        vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());
        String token = "cHJvdmlzaW9uAHVzZXIyQGIyZTg5Ni52aWR5by5pbwA2Mzc1Mzg2MTU2OAAAYzI3NTQ4YTU4MjU4ODYwNGVlZjBlYThmYjI3Nzc2Nzg3YWZiZmE0ZTgyZDNlODAyM2VkY2VhYmY5MTlmNDczYTExNzU4Mjk1YjVmNDZjZWRmOGYxYzZmZDBiZTg2MDYx";
        vc.connect("prod.vidyo.io", token, "Patient", "Doctor4", this);
    }

    public void Disconnect(View v) {
        vc.disconnect();
        final Context context = this;
        Intent intent = new Intent(context, menu4.class);
        startActivity(intent);
    }

    public void onSuccess() {}

    public void onFailure(Connector.ConnectorFailReason reason) {}

    public void onDisconnected(Connector.ConnectorDisconnectReason reason) {}

}