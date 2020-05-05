package com.lugo.manueln.appproject.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lugo.manueln.appproject.Interfaces.InterPost;
import com.lugo.manueln.appproject.objects.Post;
import com.lugo.manueln.appproject.Presenters.PresenterPosts;
import com.lugo.manueln.appproject.R;
import com.lugo.manueln.appproject.Views.PostsFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.ViewHolderPost>{


    List<Post>miListPosts;
    PostsFragment miActividadPost;
    InterPost.presenter myPresenter;


    public AdapterPosts(List<Post> miListPosts, PostsFragment activity) {

        myPresenter=new PresenterPosts(activity);
        this.miListPosts = miListPosts;
        miActividadPost=activity;


    }

    @NonNull
    @Override
    public ViewHolderPost onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View vista=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item,viewGroup,false);

        return new ViewHolderPost(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPost holderPost, final int i) {

        holderPost.txtTitle.setText(miListPosts.get(i).getTitle().toString());
        holderPost.txtBody.setText(miListPosts.get(i).getBody().toString());

        Picasso.get()
                .load(miListPosts.get(i).getImage())
                .resize(960,960)
                .into(holderPost.image);

        holderPost.bMas.setId(miListPosts.get(i).getId());
        holderPost.bMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myPresenter.newPostCompleteFragmentPresenter(miListPosts.get(i).getId(),miActividadPost.getActivity());

            }
        });

    }


    @Override
    public int getItemCount() {
        return miListPosts.size();
    }




    public class ViewHolderPost extends RecyclerView.ViewHolder{
        TextView txtTitle,txtBody;
        ImageView image;
        Button bMas;
        public ViewHolderPost(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.imagePost);
            txtTitle=itemView.findViewById(R.id.textTitle);
            txtBody=itemView.findViewById(R.id.textBody);
            bMas=itemView.findViewById(R.id.bMas);

        }
    }
}
