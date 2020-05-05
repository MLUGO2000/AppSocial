package com.lugo.manueln.appproject.Interfaces;

import android.support.v4.app.FragmentActivity;

import com.lugo.manueln.appproject.objects.Photo;

import java.util.List;

public interface InterPhotos {


    interface View{

        void loadPhotosRecycler();
        void showPhotosRecycler(List<Photo> photoList);

    }

    interface Presenter{

        void loadPhotosRecyclerPresenter(int idAlbum,FragmentActivity activity);
        void showPhotosRecycelerPresenter(List<Photo> photoList);

    }

    interface Interactor{

        void loadPhotosRecyclerInteractor(int idAlbum,FragmentActivity activity);

    }


}
