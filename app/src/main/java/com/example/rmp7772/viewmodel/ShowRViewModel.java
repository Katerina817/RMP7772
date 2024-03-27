package com.example.rmp7772.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rmp7772.model.Rabbit;

import java.util.ArrayList;
import java.util.List;

public class ShowRViewModel extends ViewModel {
    private MutableLiveData<List<Rabbit>> rabbitListLiveData = new MutableLiveData<>();

    public LiveData<List<Rabbit>> getRabbitListLiveData() {
        return rabbitListLiveData;
    }
    public void addRabbitToList(String name,String color,String earlength,String age) {
        List<Rabbit> rabbits = rabbitListLiveData.getValue();
        if (rabbits == null) {
            rabbits = new ArrayList<>();
        }
        Rabbit rabbit = new Rabbit(name,color, earlength, age);
        rabbits.add(rabbit);
        rabbitListLiveData.setValue(rabbits);
    }
    public void deleteRabbitFromList() {
        List<Rabbit> rabbits = rabbitListLiveData.getValue();
        //Log.i("AAAAaaaa", String.valueOf(rabbits.size()));
        if (rabbits != null) {
            rabbits.remove(rabbits.size()-1);
        }
        rabbitListLiveData.setValue(rabbits);
        //Log.i("AAAAaaaa", String.valueOf(rabbits.size()));
    }
}