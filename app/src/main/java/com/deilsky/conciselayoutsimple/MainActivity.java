package com.deilsky.conciselayoutsimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.deilsky.awakening.widget.AwakeningView;
import com.deilsky.conciselayout.ConciseLayout;
import com.deilsky.conciselayout.ConciseLayoutListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConciseLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.concise);
        TextView point = layout.findPointText();
        AwakeningView.CircleBuilder.create().fillColor(R.color.colorAccent).strokeColor(R.color.colorPrimary).strokeSize(1).build().target(point).build();
        layout.centerClickable(true)
                .leftClickable(true)
                .rightClickable(true)
                .setOnClickListener(new ConciseLayoutListener() {
                    @Override
                    public void onLeftClick() {
                        Toast.makeText(getApplicationContext(), "左", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onRightClick() {
                        Toast.makeText(getApplicationContext(), "右", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCenterClick() {
                        Toast.makeText(getApplicationContext(), "中", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View view) {

    }
}
