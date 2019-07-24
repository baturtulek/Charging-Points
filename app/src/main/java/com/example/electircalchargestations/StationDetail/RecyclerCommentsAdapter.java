package com.example.electircalchargestations.StationDetail;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.electircalchargestations.Model.User;
import com.example.electircalchargestations.Model.UserComment;
import com.example.electircalchargestations.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class RecyclerCommentsAdapter extends RecyclerView.Adapter<RecyclerCommentsAdapter.ViewHolder>{

    private ArrayList<UserComment>  commentList;

    public RecyclerCommentsAdapter(ArrayList<UserComment> mArrayList ) {
        this.commentList = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater  = LayoutInflater.from(parent.getContext());
        View itemView                   = mLayoutInflater.inflate(R.layout.recycler_item_detail_comment, parent, false);
        ViewHolder mViewHolder          = new ViewHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        if(!commentList.isEmpty()) {
            UserComment comment = commentList.get(i);

            holder.dateCreated.setText(comment.getDateCreated().substring(0, 10));
            holder.userName.setText(comment.getUserName());
            holder.rating.setText(String.valueOf(comment.getRating()) + " / 5");
            holder.comment.setText(comment.getComment());

            User user = comment.getUser();
            String userProfileURL = user.getProfileImageURL();
            Picasso.get()
                    .load(userProfileURL)
                    .error(R.drawable.ic_error_outline_black_24dp)
                    .into(holder.userPhoto);
        }
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userPhoto;
        TextView userName;
        TextView dateCreated;
        TextView rating;
        TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            userPhoto   = itemView.findViewById(R.id.imageView);
            dateCreated = itemView.findViewById(R.id.dateCreated);
            userName    = itemView.findViewById(R.id.userName);
            rating      = itemView.findViewById(R.id.rating);
            comment     = itemView.findViewById(R.id.comment);
        }
    }

}
