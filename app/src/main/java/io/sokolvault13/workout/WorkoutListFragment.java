package io.sokolvault13.workout;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {

//    public WorkoutListFragment() {
//        // Required empty public constructor
//    }

    interface WorkoutListListener{
        void itemClicked(long id);
    }

    private WorkoutListListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++){
            names[i] = Workout.workouts[i].getName();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mListener = (WorkoutListListener) activity;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        this.mListener = (WorkoutListListener)context;
//    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (mListener != null){
            mListener.itemClicked(id);
        }
    }
}
