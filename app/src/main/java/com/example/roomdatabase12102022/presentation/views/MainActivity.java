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
                            Log.d("BBB", listResource.data.toString());
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

        mainViewModel.getUsers();
    }
}
