package com.chuizi.wensente.api;

import com.chuizi.healthJS.model.repo.Classify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author: 蜡笔小新
 * @date: 2016-05-31 14:15
 * @GitHub: https://github.com/meikoz
 */
public interface BaseHttpService {

    @GET("shuaiche/phone/carCategory_list.action")
    Call<Classify> getImageClassify(@Query("parentId") String parentId, @Query("name") String name);

}
