package com.example.activityresetlauncher;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnsenddata =findViewById(R.id.buttonsenddata);
        btnsenddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivityForResult();
            }
        });
    }
    private void openSecondActivityForResult(){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("number2",2);
        secondActivityLauncher.launch(intent);
    }
    ActivityResultLauncher<Intent> secondActivityLauncher=
               registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                   @Override
                   public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()== Activity.RESULT_OK){
                        Intent data = result.getData();
                        int operationResult=data.getIntExtra("2x2",0);
                        Toast.makeText(MainActivity.this,operationResult+"",Toast.LENGTH_LONG).show();
                    }
                   }
               }
               );
}