package com.lugo.manueln.appproject.Presenters;

import android.support.v4.app.FragmentActivity;

import com.lugo.manueln.appproject.Interfaces.interPostComplete;
import com.lugo.manueln.appproject.Interactors.ModulePostComplete;
import com.lugo.manueln.appproject.objects.Comments;
import com.lugo.manueln.appproject.objects.Post;

import java.util.List;

public class PresenterPostComplete implements interPostComplete.presenter {

    interPostComplete.view view;
    interPostComplete.interactor interactor;

    public PresenterPostComplete(interPostComplete.view view) {
        this.view = view;
        interactor=new ModulePostComplete(this);
    }

    @Override
    public void loadPostCompleteWithComments(int id, FragmentActivity fragmentActivity) {

        if(interactor!=null){
            interactor.retrofitGetPostCompleteWithComments(id,fragmentActivity);
        }
    }

    @Override
    public void PostCompleteWithCommentsPresenter(Post miPost, List<Comments> commentsList) {

        if(view!=null){
            view.showPostComplete(miPost);
            view.showCommentsPost(commentsList);
        }
    }

    @Override
    public void sendErrorLoadPost(String error) {

        if(view!=null){

            view.showErrorLoadPost(error);
        }
    }


}
