package com.example.rmp7772.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rmp7772.R;
import com.example.rmp7772.model.Item;
import com.example.rmp7772.model.Rabbit;
import com.example.rmp7772.viewmodel.ShowRViewModel;

import java.util.ArrayList;
import java.util.List;

public class FifthFragment extends Fragment {
    public FifthFragment(){
        super(R.layout.fifthfragment);
    }
    private ShowRViewModel showRViewModel;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int pos=getArguments().getInt("position");
        showRViewModel = new ViewModelProvider(requireActivity()).get(ShowRViewModel.class);
        showRViewModel.getRabbitListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Rabbit>>() {
            @Override
            public void onChanged(List<Rabbit> rabbits) {
                TextView infa=view.findViewById(R.id.infa);
                Rabbit rabbit = rabbits.get(pos);
                infa.setText("Name: " + rabbit.getName() + "\nColor: " + rabbit.getColor() + "\nEar Length: " + rabbit.getEarlength() + "\nAge: " + rabbit.getAge());
            }
        });
    }
}
