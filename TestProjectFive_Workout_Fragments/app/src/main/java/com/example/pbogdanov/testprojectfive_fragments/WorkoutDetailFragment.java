package com.example.pbogdanov.testprojectfive_fragments;



import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null){
            workoutId = savedInstanceState.getLong("workoutId");
        }
        else {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            ft.replace(R.id.stopwatch_container, stopwatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    public void setWorkout(long id) {
        this.workoutId = id;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            title.setText(Workout.workouts[(int) workoutId].getName());
            TextView description = (TextView) view.findViewById((R.id.textDescription));
            description.setText(Workout.workouts[(int) workoutId].getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putLong("workoutId", workoutId);
    }
}
