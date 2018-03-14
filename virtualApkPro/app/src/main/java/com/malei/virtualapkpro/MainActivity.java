package com.malei.virtualapkpro;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pluginPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/malei.apk");
                File plugin = new File(pluginPath);
                if(!plugin.exists()){
                    Toast.makeText(MainActivity.this,"no exist",Toast.LENGTH_SHORT).show();
                }
                try {
                    PluginManager.getInstance(MainActivity.this).loadPlugin(plugin);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"cucs",Toast.LENGTH_SHORT).show();
                    Log.e("TAG",e.getMessage());
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClassName("com.malei.virtualsonapk", "com.malei.virtualsonapk.MainActivity");
                startActivity(intent);
            }
        });
    }
}
