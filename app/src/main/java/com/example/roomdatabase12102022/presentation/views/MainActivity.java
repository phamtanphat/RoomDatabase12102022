package com.example.roomdatabase12102022.presentation.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdatabase12102022.R;
import com.example.roomdatabase12102022.data.local.entities.UserEntity;
import com.example.roomdatabase12102022.data.repositories.UserRepository;
import com.example.roomdatabase12102022.presentation.viewmodels.MainViewModel;
import com.example.roomdatabase12102022.utils.Resource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(MainActivity.this);
            }
        }).get(MainViewModel.class);

        mainViewModel.getResourceUser().observe(this, new Observer<Resource<List<UserEntity>>>() {
            @Override
            public void onChanged(Resource<List<UserEntity>> listResource) {
                if (listResource != null) {
                    switch (listResource.status) {
                        case SUCCESS:
                            for (UserEntity e: listResource.data) {
                                Log.d("BBB", e.toString());
                            }
                            break;
                        case ERROR:
                            Log.d("BBB", listResource.message);
                            break;
                        case LOADING:
                            Log.d("BBB", "Loading");
                            break;
                    }
                }
            }
        });

        mainViewModel.getResultInsert().observe(this, new Observer<Resource<String>>() {
            @Override
            public void onChanged(Resource<String> stringResource) {
                if (stringResource != null) {
                    switch (stringResource.status) {
                        case SUCCESS:
                            Log.d("BBB", stringResource.data);
                            break;
                        case ERROR:
                            Log.d("BBB", stringResource.message);
                            break;
                        case LOADING:
                            Log.d("BBB", "Loading");
                            break;
                    }
                }
            }
        });

        mainViewModel.getUsers();
        mainViewModel.addUser(new UserEntity("Nguyễn Văn A", "0123456789"));
    }
}
