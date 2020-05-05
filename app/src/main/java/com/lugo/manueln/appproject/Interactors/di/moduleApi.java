package com.lugo.manueln.appproject.Interactors.di;


import com.lugo.manueln.appproject.Interactors.WebService.JsonPostApi;
import com.lugo.manueln.appproject.objects.Post;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class moduleApi {

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(){
       return GsonConverterFactory.create();
    }
    @Provides
    @Singleton
    Retrofit providesRetrofit(GsonConverterFactory gson){

        return new Retrofit.Builder()
                .baseUrl("http://192.168.0.108:4000/")
                .addConverterFactory(gson)
                .build();
    }

    @Provides
    @Singleton
    JsonPostApi providesJsonPostApi(Retrofit retrofit){

        return retrofit.create(JsonPostApi.class);
    }


    @Provides
    @Singleton
    Call <List<Post>> providesGetPost(JsonPostApi jsonPostApi){

        return jsonPostApi.getPosts();
    }





}
