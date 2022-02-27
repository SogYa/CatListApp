package com.example.catlistapp.screen.listScreen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catlistapp.R;
import com.example.catlistapp.databinding.MainFragmentBinding;
import com.example.catlistapp.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private MainFragmentVM mViewModel;
    private final List<Cat> cats = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Инициализвция вью модели для главного фрагмента
        mViewModel = new ViewModelProvider(this).get(MainFragmentVM.class);
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Инициализация ресайкл вью
        recyclerView = view.findViewById(R.id.catRecyclerView);

        binding.addButton.setOnClickListener(view1 ->
                Navigation.findNavController(view).navigate(R.id.newCatFragment));
    }

    @Override
    public void onResume() {
        super.onResume();
        //обновление списка
        mViewModel.updateList();
        mViewModel.getMutableLiveData().observe(getViewLifecycleOwner(), cats1 -> {
            cats.addAll(cats1);
            Log.d("CatsList1", cats1.toString());
            CatAdapter adapter = new CatAdapter(getLayoutInflater(), cats);
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        cats.clear();
    }
}