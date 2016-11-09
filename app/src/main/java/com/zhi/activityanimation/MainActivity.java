package com.zhi.activityanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button mBtnJump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mBtnJump.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jump:
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
                this.overridePendingTransition(R.anim.out_main, R.anim.in_other);
                break;
        }
    }
}
