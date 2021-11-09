package com.satyam.json_volly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {
Context context;
User[] data;
    public GithubAdapter(Context context,User[] data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_user_layout,parent,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder( GithubAdapter.GithubViewHolder holder, int position) {
        User user=data[position];
        holder.txt_user.setText(user.getLogin());
        Glide.with(holder.img_user.getContext()).load(user.getAvatarUrl()).into(holder.img_user);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{
        ImageView img_user;
        TextView txt_user;

        public GithubViewHolder(View itemView) {
            super(itemView);
            img_user=itemView.findViewById(R.id.img_user);
            txt_user=itemView.findViewById(R.id.txt_user);

        }
    }
}
