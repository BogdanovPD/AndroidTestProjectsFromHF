package com.example.pbogdanov.testprojectfive_fragments;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WorkoutListFragment extends ListFragment {

    static interface WorkoutListListener{
        void itemClicked(long id);
    }

    private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = (Activity) context;

        if (context instanceof Activity){
            this.listener = (WorkoutListListener) a;
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null)
            listener.itemClicked(id);
    }
}
