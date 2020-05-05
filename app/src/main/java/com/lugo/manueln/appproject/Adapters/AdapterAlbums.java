package com.lugo.manueln.appproject.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lugo.manueln.appproject.Interfaces.InterAlbums;
import com.lugo.manueln.appproject.Presenters.AlbumsPresenter;
import com.lugo.manueln.appproject.Views.AlbumsFragment;
import com.lugo.manueln.appproject.Views.PhotosFragment;
import com.lugo.manueln.appproject.objects.Album;
import com.lugo.manueln.appproject.R;

import java.util.List;

public class AdapterAlbums extends RecyclerView.Adapter<AdapterAlbums.ViewHolderAlbum> {

    List<Album> myListAlbum;
    InterAlbums.Presenter myPresenterAlbum;
    AlbumsFragment albumsFragment;


    public AdapterAlbums(List<Album> myListAlbum, AlbumsFragment fragment) {
        this.myListAlbum = myListAlbum;
        albumsFragment=fragment;
        myPresenterAlbum=new AlbumsPresenter(fragment);
    }

    @NonNull
    @Override
    public ViewHolderAlbum onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View viewAlbum=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_item,viewGroup,false);

        return new ViewHolderAlbum(viewAlbum);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlbum holderAlbum, final int i) {

        holderAlbum.titleAlbum.setText(myListAlbum.get(i).getTitle().toString());

        holderAlbum.cardAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myPresenterAlbum.newPhotosFragmentPresenter(myListAlbum.get(i).getId(),albumsFragment.getActivity());

            }
        });

    }

    @Override
    public int getItemCount() {
        return myListAlbum.size();
    }

    public class ViewHolderAlbum extends RecyclerView.ViewHolder {

        TextView titleAlbum;
        CardView cardAlbum;
        public ViewHolderAlbum(@NonNull View itemView) {
            super(itemView);

            titleAlbum=itemView.findViewById(R.id.titleAlbum);
            cardAlbum=itemView.findViewById(R.id.cardAlbum);

        }
    }
}
