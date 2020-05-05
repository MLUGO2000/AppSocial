package com.lugo.manueln.appproject.Presenters;

import android.support.v4.app.FragmentActivity;

import com.lugo.manueln.appproject.Interfaces.InterPost;
import com.lugo.manueln.appproject.Interactors.ModulePosts;
import com.lugo.manueln.appproject.objects.Post;

import java.util.List;

public class PresenterPosts implements InterPost.presenter {

    private InterPost.view view;
    private InterPost.interactor model;

    public PresenterPosts(InterPost.view view){
        this.view=view;
        model=new ModulePosts(this);
    }
    @Override
    public void loadRecyclerPostPresenter(FragmentActivity activity) {

        if(model!=null){

            model.getPosts(activity);
        }
    }


    @Override
    public void sendPostPresenter(List<Post> miListaPost) {

        if(view!=null){

            view.showRecycler(miListaPost);
        }

    }

    @Override
    public void sendErrorPostPresenter(String error) {
        if(view!=null){

            view.errorLoadRecyclerPost(error);
        }

    }

    @Override
    public void newPostCompleteFragmentPresenter(int idPost,FragmentActivity fragmentActivity) {

        if(model!=null){

            model.newPostCompleteFragment(idPost,fragmentActivity);
        }

    }
}
