package com.yztc.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yztc.retrofitdemo.R;
import com.yztc.retrofitdemo.apiservice.LitchiapiService;
import com.yztc.retrofitdemo.contants.UrlConstants;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button guding;
	private Button dongurl;
	private Button chacanlist;
	private Button chacan;
	private Button dongtaitotal;
	private Retrofit retrofit;
	private LitchiapiService litchiapiService;
	private Call<ResponseBody> call;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}

	private void initData() {
	}

	private void initView() {
		guding = (Button) findViewById(R.id.guding);
		dongurl = (Button) findViewById(R.id.dongurl);
		chacanlist = (Button) findViewById(R.id.chacanlist);
		chacan = (Button) findViewById(R.id.chacan);
		dongtaitotal = (Button) findViewById(R.id.dongtaitotal);
		guding.setOnClickListener(this);
		dongurl.setOnClickListener(this);
		chacanlist.setOnClickListener(this);
		chacan.setOnClickListener(this);
		dongtaitotal.setOnClickListener(this);
		retrofit=new Retrofit.Builder()
				.baseUrl(UrlConstants.BASE_URL)
				.build();
		litchiapiService = retrofit.create(LitchiapiService.class);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.guding:
				call= litchiapiService.getLitchCall();
				call.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						try {
							Log.e("Tag",response.body().string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {

					}
				});
				break;
			case R.id.dongurl:
				call= litchiapiService.getLitchCall("");
				call.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						try {
							Log.e("Tag",response.body().string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {

					}
				});
				break;
			case R.id.chacanlist:
				call= litchiapiService.getLitchCall(1,10,1);
				call.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						try {
							Log.e("Tag",response.body().string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						Log.e("Tag",t.getMessage());
					}
				});
				break;
			case R.id.chacan:
					HashMap<String,Integer> hamap=new HashMap<>();
					hamap.put("column",0);
					hamap.put("PageSize",10);
					hamap.put("pageIndex",1);
				call= litchiapiService.getLitchCall(hamap);
				call.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						try {
							Log.e("Tag",response.body().string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						Log.e("Tag",t.getMessage());
					}
				});
				break;
			case R.id.dongtaitotal:
				call= litchiapiService.getLitchCall("GetFeeds",1,10,1);
				call.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						try {
							Log.e("Tag",response.body().string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						Log.e("Tag",t.getMessage());
					}
				});
				break;
		}
	}
}
