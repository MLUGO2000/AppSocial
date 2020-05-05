package com.lugo.manueln.appproject.Interfaces;

import android.support.v4.app.FragmentActivity;

import com.lugo.manueln.appproject.objects.Comments;
import com.lugo.manueln.appproject.objects.Post;

import java.util.List;

public interface interPostComplete {

    interface view{

        void loadPostComplete();
        void showPostComplete(Post miPost);
        void showCommentsPost(List<Comments>commentsList);
        void showErrorLoadPost(String error);

    }

    interface presenter{

        void loadPostCompleteWithComments(int id, FragmentActivity fragmentActivity);
        void PostCompleteWithCommentsPresenter(Post miPost, List<Comments> commentsList);
        void sendErrorLoadPost(String error);



    }

    interface interactor{

        void retrofitGetPostCompleteWithComments(int idPost,FragmentActivity fragmentActivity);
        void sendErrorLoadPost(String error);

    }
}
