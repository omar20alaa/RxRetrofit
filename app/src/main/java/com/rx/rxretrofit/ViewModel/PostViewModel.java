package com.rx.rxretrofit.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.rx.rxretrofit.Model.Post;
import com.rx.rxretrofit.Retrofit.ApiInterface;
import com.rx.rxretrofit.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PostViewModel extends ViewModel {

    //vars
    ApiInterface apiInterface;
    MutableLiveData<List<Post>> mutableLiveData = new MutableLiveData<>();

    private void initApi() {
        Retrofit retrofit = RetrofitClient.getInstance();
        apiInterface = retrofit.create(ApiInterface.class);
    } // initialize api

    public LiveData<List<Post>> fetchData() {
        initApi();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(apiInterface.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {
                        Log.e("QP","VM : "+posts);
                        mutableLiveData.setValue(posts);
                    }
                }));
        return mutableLiveData;

    } // fetch data to recyclerview

}
