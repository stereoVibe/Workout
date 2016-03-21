package io.sokolvault13.workout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        WorkoutDetailFragment fragmentDetails = new WorkoutDetailFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentDetails.setWorkout(id);
        fragmentTransaction.replace(R.id.fragment_container, fragmentDetails);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}
