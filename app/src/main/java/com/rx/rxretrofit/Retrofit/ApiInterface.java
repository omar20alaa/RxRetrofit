package com.rx.rxretrofit.Retrofit;


import com.rx.rxretrofit.Model.Post;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Observable<List<Post>> getPosts();
}
