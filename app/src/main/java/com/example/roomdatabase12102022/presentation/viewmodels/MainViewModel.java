package com.example.roomdatabase12102022.presentation.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase12102022.data.local.entities.UserEntity;
import com.example.roomdatabase12102022.data.repositories.UserRepository;
import com.example.roomdatabase12102022.utils.Resource;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by pphat on 1/6/2023.
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<Resource<List<UserEntity>>> resourceUser = new MutableLiveData<>();
    private UserRepository repository;

    public MainViewModel(Context context) {
        repository = new UserRepository(context);
    }

    public LiveData<Resource<List<UserEntity>>> getResourceUser() {
        return resourceUser;
    }

    public void getUsers() {
        resourceUser.setValue(new Resource.Loading<>(null));
        repository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<UserEntity> userEntities) {
                        resourceUser.setValue(new Resource.Success<>(userEntities));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        resourceUser.setValue(new Resource.Error<>(e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
