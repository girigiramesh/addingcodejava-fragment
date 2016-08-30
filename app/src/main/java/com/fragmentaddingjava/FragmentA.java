package com.fragmentaddingjava;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ramesh on 8/27/16.
 */
public class FragmentA extends Fragment {
    private static final String TAG = " LifeCycle Of Fragment";

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttach: Fragment");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Fragment");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Fragment");
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated: Fragment");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart: Fragment");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume: Fragment");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause: Fragment");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: Fragment");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop: Fragment");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: Fragment");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: Fragment");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach: Fragment");
        super.onDetach();
    }
}
