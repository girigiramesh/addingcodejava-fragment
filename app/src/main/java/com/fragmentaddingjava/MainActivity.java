package com.fragmentaddingjava;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentManager.OnBackStackChangedListener {
    FragmentManager manager;
    FragmentTransaction transaction;
    FragmentA fragmentA;
    FragmentB fragmentB;
    Button btn_addA, btn_removeA, btn_ab, btn_addB, btn_removeB, btn_ba, btn_attach, btn_detach, btn_pop, btn_back;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        btn_addA = (Button) findViewById(R.id.btn_addA);
        btn_addA.setOnClickListener(this);
        btn_addB = (Button) findViewById(R.id.btn_addB);
        btn_addB.setOnClickListener(this);
        btn_removeA = (Button) findViewById(R.id.btn_removeA);
        btn_removeA.setOnClickListener(this);
        btn_removeB = (Button) findViewById(R.id.btn_removeB);
        btn_removeB.setOnClickListener(this);
        btn_ab = (Button) findViewById(R.id.btn_ab);
        btn_ab.setOnClickListener(this);
        btn_ba = (Button) findViewById(R.id.btn_ba);
        btn_ba.setOnClickListener(this);
        btn_attach = (Button) findViewById(R.id.btn_attach);
        btn_attach.setOnClickListener(this);
        btn_detach = (Button) findViewById(R.id.btn_detach);
        btn_detach.setOnClickListener(this);
        btn_pop = (Button) findViewById(R.id.btn_pop);
        btn_pop.setOnClickListener(this);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        message = (TextView) findViewById(R.id.message);
        manager.addOnBackStackChangedListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_addA:
                fragmentA = new FragmentA();
                transaction = manager.beginTransaction();
                transaction.add(R.id.group, fragmentA, "Add A");
                transaction.addToBackStack("Add A");
                transaction.commit();
                break;

            case R.id.btn_addB:
                fragmentB = new FragmentB();
                transaction = manager.beginTransaction();
                transaction.add(R.id.group, fragmentB, "Add B");
                transaction.addToBackStack("Add B");
                transaction.commit();
                break;

            case R.id.btn_removeA:
                fragmentA = (FragmentA) manager.findFragmentByTag("Add A");
                transaction = manager.beginTransaction();
                if (fragmentA != null) {
                    transaction.remove(fragmentA);
                    transaction.addToBackStack("Remove A");
                    transaction.commit();
                } else {
                    Toast.makeText(this, "The Fragment A was not Added Before", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_removeB:
                fragmentB = (FragmentB) manager.findFragmentByTag("Add B");
                transaction = manager.beginTransaction();
                if (fragmentB != null) {
                    transaction.remove(fragmentB);
                    transaction.addToBackStack("Remove B");
                    transaction.commit();
                } else {
                    Toast.makeText(this, "The Fragment B was not Added Before", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_ab:
                fragmentB = new FragmentB();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.group, fragmentB, "Add B");
                transaction.addToBackStack("Replace B");
                transaction.commit();
                break;

            case R.id.btn_ba:
                fragmentA = new FragmentA();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.group, fragmentA, "Add A");
                transaction.addToBackStack("Replace A");
                transaction.commit();
                break;

            case R.id.btn_attach:
                fragmentA = (FragmentA) manager.findFragmentByTag("Add A");
                transaction = manager.beginTransaction();
                if (fragmentA != null) {
                    transaction.attach(fragmentA);
                    transaction.addToBackStack("Attach A");
                    transaction.commit();
                } else {
                    Toast.makeText(this, "The FragmentA is not Attached", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.btn_detach:
                fragmentA = (FragmentA) manager.findFragmentByTag("Add A");
                transaction = manager.beginTransaction();
                if (fragmentA != null) {
                    transaction.detach(fragmentA);
                    transaction.addToBackStack("Detach A");
                    transaction.commit();
                } else {
                    Toast.makeText(this, "The FragmentA is not Detached", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_pop:
                manager.popBackStack();
                break;
            case R.id.btn_back:
                manager.popBackStack("Add B", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            default:Toast.makeText(this, "The Fragment is Default", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onBackStackChanged() {
        message.setText(message.getText() + "\n");
        message.setText(message.getText() + "The Status of Back Stack");

        int count = manager.getBackStackEntryCount();
        for (int i = count - 1; i >= 0; i--) {
            FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(i);
            message.setText(message.getText() + " " + entry.getName() + " \n");
        }
        message.setText(message.getText() + "\n");
    }
}
