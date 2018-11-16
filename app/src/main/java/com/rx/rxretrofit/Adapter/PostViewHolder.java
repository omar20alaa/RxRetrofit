package com.rx.rxretrofit.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rx.rxretrofit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostViewHolder extends RecyclerView.ViewHolder {


    // bind views
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_content)
    TextView tv_content;

    @BindView(R.id.tv_author)
    TextView tv_author;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
