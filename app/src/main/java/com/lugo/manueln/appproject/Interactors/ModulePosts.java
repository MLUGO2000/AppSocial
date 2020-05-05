package com.lugo.manueln.appproject.Interactors;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.lugo.manueln.appproject.Interfaces.InterPost;
import com.lugo.manueln.appproject.Interactors.WebService.JsonPostApi;
import com.lugo.manueln.appproject.objects.Post;
import com.lugo.manueln.appproject.Interactors.di.BaseApplication;
import com.lugo.manueln.appproject.R;
import com.lugo.manueln.appproject.Views.PostCompleteFragment;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModulePosts implements InterPost.interactor {

    @Inject
    JsonPostApi jsonPostApi;



    InterPost.presenter miPresenter;


    public ModulePosts(InterPost.presenter miPresenter){
        this.miPresenter=miPresenter;
    }




    @Override
    public void getPosts(final FragmentActivity main) {


        setupDagger(main);


            Call<List<Post>> call=jsonPostApi.getPosts();

            call.enqueue(new Callback<List<Post>>() {
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if(!response.isSuccessful()){
                        Log.e("Error","Error Code " + response.code());

                        sendErrorPost("Error Code : " + response.code());
                    }else {

                        List<Post> postList = response.body();



                        sendPosts(postList);


                    }

                }
                public void onFailure(Call<List<Post>> call, Throwable t) {

                    Log.e("Falla",t.getMessage());

                    sendErrorPost(t.getMessage());
                }
            });
        }


    @Override
    public void sendPosts(List<Post> miListaPost) {

        miPresenter.sendPostPresenter(miListaPost);
    }

    @Override
    public void sendErrorPost(String error) {
        if(miPresenter!=null){

            miPresenter.sendErrorPostPresenter(error);
        }
    }

    @Override
    public void newPostCompleteFragment(int idPost,FragmentActivity miActivity) {
               PostCompleteFragment fragment=PostCompleteFragment.newInstance(idPost);

                miActivity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contenedorFragment,fragment).commit();

    }

    void setupDagger(Activity activity){

         ((BaseApplication)activity.getApplication()).getComponentApi().inject(this);


    }
}
