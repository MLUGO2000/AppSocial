package com.lugo.manueln.appproject.Interactors;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;


import com.lugo.manueln.appproject.Interfaces.interPostComplete;
import com.lugo.manueln.appproject.objects.Comments;
import com.lugo.manueln.appproject.Interactors.WebService.JsonPostApi;
import com.lugo.manueln.appproject.objects.Post;
import com.lugo.manueln.appproject.Interactors.di.BaseApplication;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModulePostComplete implements interPostComplete.interactor {

    @Inject
    JsonPostApi jsonPostApi;

    interPostComplete.presenter myPresenter;

    public ModulePostComplete(interPostComplete.presenter myPresenter) {
        this.myPresenter = myPresenter;
    }

    @Override
    public void retrofitGetPostCompleteWithComments(int idPost, FragmentActivity fragmentActivity) {

        setupDagger(fragmentActivity);

        getPostComplete(idPost);


    }



    private void getPostComplete(int id) {

        Call<Post> callPost=jsonPostApi.getPostComplete(id);

        callPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){

                    Log.e("Error","Error Code " + response.code());

                    sendErrorLoadPost("Error Code " + response.code());
                }else{

                   Post miPost=response.body();

                   getComments(miPost);

                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Log.e("Falla",t.getMessage());

                sendErrorLoadPost("Falla: " + t.getMessage());

            }
        });


    }

    private void getComments(@NonNull final Post miPostComplete) {

        Call<List<Comments>> listCallComments=jsonPostApi.getCommentsFilter(miPostComplete.getId());

        listCallComments.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if(!response.isSuccessful()){

                    Log.e("Error","Error Code " + response.code());

                    sendErrorLoadPost("Error Code " + response.code());

                }else{

                    List<Comments> commentsList=response.body();

                    myPresenter.PostCompleteWithCommentsPresenter(miPostComplete,commentsList);


                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

                Log.e("ErrorOnFailure","Error: " + t.getMessage());

                sendErrorLoadPost("Error: " + t.getMessage());
            }
        });

    }

    @Override
    public void sendErrorLoadPost(String error) {

        if(myPresenter!=null){

            myPresenter.sendErrorLoadPost(error);
        }

    }
    private void setupDagger(FragmentActivity activity) {
        ((BaseApplication)activity.getApplication()).getComponentApi().inject(this);
    }
}
