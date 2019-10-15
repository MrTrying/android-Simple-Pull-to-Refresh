package com.mrtrying.ptr.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final PtrClassicFrameLayout ptrClassicFrameLayout = findViewById(R.id.rotate_header_grid_view_frame);
		ptrClassicFrameLayout.setLastUpdateTimeKey("lastRefreshTime");
		ptrClassicFrameLayout.disableWhenHorizontalMove(true);
		ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
			@Override
			public void onRefreshBegin(PtrFrameLayout frame) {
				frame.postDelayed(new Runnable() {
					@Override
					public void run() {
						ptrClassicFrameLayout.refreshComplete();
					}
				},3000);
			}
		});
	}
}
