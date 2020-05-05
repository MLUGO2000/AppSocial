package com.lugo.manueln.appproject.Interfaces;

import android.support.v4.app.FragmentActivity;

import com.lugo.manueln.appproject.objects.Post;

import java.util.List;

public interface InterPost {

    interface view {

        void loadRecyclerPost();
        void showRecycler(List<Post> miListaPost);
        void errorLoadRecyclerPost(String error);


    }
    interface presenter {

        void loadRecyclerPostPresenter(FragmentActivity main);
        void sendPostPresenter(List<Post> miListaPost);
        void sendErrorPostPresenter(String error);
        void newPostCompleteFragmentPresenter(int idPost,FragmentActivity fragmentActivity);
    }

    interface interactor {

        void getPosts(FragmentActivity main);

        void sendPosts(List<Post> miListaPost);

        void sendErrorPost(String error);

        void newPostCompleteFragment(int idPost,FragmentActivity fragmentActivity);
    }
}
