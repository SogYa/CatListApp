package com.example.catlistapp.screen.catScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.catlistapp.R;
import com.example.catlistapp.databinding.NewCatFragmentBinding;
import com.example.catlistapp.instruments.CropActivityResultContract;

public class NewCatFragment extends Fragment {

    private NewCatVM mViewModel;
    private NewCatFragmentBinding binding;
    //Лаунчер для ActivityResultContract
    private final ActivityResultLauncher<Object> cropActivityResultLauncher = registerForActivityResult(
            new CropActivityResultContract(),
            result -> mViewModel.setImage(binding.catImage, result.toString())
    );


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = NewCatFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewCatVM.class);

        binding.addCat.setOnClickListener(view1 -> mViewModel.addNewCat(binding.editTextName.getText().toString(),
                binding.editTextAge.getText().toString(), aBoolean -> {
                    if (aBoolean) {
                        binding.statusView.setText("Котик успешно добавлен!");
                        binding.statusView.setTextColor(getResources().getColor(R.color.green_light));
                    } else {
                        binding.statusView.setText("Кажется Вы что-то забыли!!");
                        binding.statusView.setTextColor(getResources().getColor(R.color.error_red));
                    }
                }));

        binding.catImage.setOnClickListener(view12 -> cropActivityResultLauncher.launch(null));
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}