package com.yztc.retrofitdemo.apiservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by My on 2016/12/12.
 */

public interface LitchiapiService {
	//get请求固定请求路径
	@GET("GetFeeds?column=0&PageSize=10&pageIndex=1")
	Call<ResponseBody> getLitchCall();
	//动态的url
	@GET("{path}?column=0&PageSize=10&pageIndex=1")
	Call<ResponseBody> getLitchCall(@Path("path")String path);
	//查询参数
	//查询参数集合
	//动态url + 查询参数
}
