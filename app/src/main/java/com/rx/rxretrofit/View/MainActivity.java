package com.rx.rxretrofit.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rx.rxretrofit.Adapter.PostAdapter;
import com.rx.rxretrofit.Model.Post;
import com.rx.rxretrofit.R;
import com.rx.rxretrofit.ViewModel.PostViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // bind views
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    // vars
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
        initViewModel();
    }

    private void initViewModel() {
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.fetchData().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                displayData(posts);
            }
        });
    } // initialize view model


    private void initRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
    } // initialize api

    private void displayData(List<Post> posts) {
        PostAdapter postAdapter = new PostAdapter(this, posts);
        recycler_view.setAdapter(postAdapter);
    } // display data

}
