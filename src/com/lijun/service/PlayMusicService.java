package com.lijun.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public  class PlayMusicService extends Activity  implements OnClickListener {
	private Button playBtn;  
    private Button stopBtn;  
    private Button pauseBtn;  
    private Button exitBtn;  
    private Button closeBtn;  
    private Intent intent;  
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_service);
		playBtn = (Button) findViewById(R.id.play);  
        stopBtn = (Button) findViewById(R.id.stop);  
        pauseBtn = (Button) findViewById(R.id.pause);  
        exitBtn = (Button) findViewById(R.id.exit);  
        closeBtn = (Button) findViewById(R.id.close); 
        
        playBtn.setOnClickListener(this);  
        stopBtn.setOnClickListener(this);  
        pauseBtn.setOnClickListener(this);  
        exitBtn.setOnClickListener(this);  
        closeBtn.setOnClickListener(this);  
	}
	
	
	
	  @Override  
	    public void onClick(View v) {  
	        int op = -1;  
	        intent = new Intent(PlayMusicService.this,MusicService.class);  
	  
	        switch (v.getId()) {  
	        case R.id.play:                             // play music  
	            op = 1;  
	            break;  
	        case R.id.stop:                             // stop music  
	            op = 2;  
	            break;  
	        case R.id.pause:                            // pause music  
	            op = 3;  
	            break;  
	        case R.id.close:                            // close activity  
	            this.finish();  
	            break;  
	        case R.id.exit:                             // stopService  
	            op = 4;  
	            stopService(intent);  
	            this.finish();  
	            break;  
	        }  
	  
	        
	        intent.putExtra("op",op);  
	          
	        startService(intent);                           // startService  
	    }  
	  
	  
	  @Override  
	    public void onDestroy(){  
	        super.onDestroy();  
	  
	       
	    }  

}
