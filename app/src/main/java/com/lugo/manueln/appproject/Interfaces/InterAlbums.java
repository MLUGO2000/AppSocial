package com.lugo.manueln.appproject.Interfaces;

import android.support.v4.app.FragmentActivity;

import com.lugo.manueln.appproject.objects.Album;

import java.util.List;

public interface InterAlbums {

    interface View{

        void loadRecyclerAlbums();

        void  showRecyclerAlbums(List<Album> albumList);

        void showErrorLoadAlbum(String error);
    }

    interface Presenter{

        void loadRecyclerAlbumsPresenter(FragmentActivity activity);

        void resultRecyclerAlbumsPresenter(List<Album> albumList);

        void newPhotosFragmentPresenter(int idAlbum,FragmentActivity fragmentActivity);

        void sendErrorLoadAlbumPresenter(String error);
    }


    interface Interactor{

        void loadRecyclerAlbumsInteractor(FragmentActivity activity);

        void newPhotosFragmentInteractor(int albumId,FragmentActivity fragmentActivity);

        void sendErrorLoadAlbum(String error);

    }
}
