package com.lugo.manueln.appproject.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lugo.manueln.appproject.objects.Comments;
import com.lugo.manueln.appproject.R;

import java.util.List;

public class AdapterComments extends RecyclerView.Adapter<AdapterComments.ViewHolder> {

    List<Comments> comments;
    public AdapterComments(List<Comments> list){
        comments=list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coment_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.nameUser.setText(comments.get(i).getId()+": " );
        viewHolder.bodyComment.setText(comments.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameUser,bodyComment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameUser=itemView.findViewById(R.id.userName);
            bodyComment=itemView.findViewById(R.id.bodyComment);
        }
    }
}
