package com.example.electircalchargestations.StationDetail;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.electircalchargestations.Model.MediaItem;
import com.example.electircalchargestations.Model.User;
import com.example.electircalchargestations.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class RecyclerPhotosAdapter extends RecyclerView.Adapter<RecyclerPhotosAdapter.ViewHolder>{

    private ArrayList<MediaItem>  mediaItemList;

    public RecyclerPhotosAdapter(ArrayList<MediaItem> mArrayList ) {
        this.mediaItemList = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater  = LayoutInflater.from(parent.getContext());
        View itemView                   = mLayoutInflater.inflate(R.layout.recycler_item_detail_photo, parent, false);
        ViewHolder mViewHolder          = new ViewHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerPhotosAdapter.ViewHolder holder, int i) {

        if(!mediaItemList.isEmpty()) {
            MediaItem mediaItem = mediaItemList.get(i);
            User user           = mediaItem.getUser();

            holder.userName.setText(user.getUsername());
            holder.dateCreated.setText(mediaItem.getDateCreated().substring(0,10));

            Picasso.get()
                    .load(user.getProfileImageURL())
                    .error(R.drawable.ic_error_outline_black_24dp)
                    .into(holder.userPhoto);

            Picasso.get()
                    .load(mediaItem.getItemURL())
                    .error(R.drawable.ic_error_outline_black_24dp)
                    .into(holder.mediaItem, new Callback() {
                        @Override
                        public void onSuccess() {
                            holder.progressBar.setVisibility(View.GONE);
                        }
                        @Override
                        public void onError(Exception e) {
                        }
                    });
        }
    }

    @Override
    public int getItemCount() {
        return mediaItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView   userPhoto;
        TextView    userName;
        TextView    dateCreated;
        ImageView   mediaItem;
        ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            userPhoto   = itemView.findViewById(R.id.imageView);
            dateCreated = itemView.findViewById(R.id.dateCreated);
            userName    = itemView.findViewById(R.id.userName);
            mediaItem   = itemView.findViewById(R.id.mediaItemImage);
            progressBar = itemView.findViewById(R.id.picasso_progress);
        }
    }

}
