package me.zhang.lab.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.zhang.lab.R;


/**
 * Created by Zhang on 2015/12/24 上午 10:33 .
 */

/**
 * A placeholder fragment containing a simple view.
 */
public class PorterDuffViewFragment extends Fragment {

    public PorterDuffViewFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PorterDuffViewFragment newInstance() {
        return new PorterDuffViewFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_porterduff, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
