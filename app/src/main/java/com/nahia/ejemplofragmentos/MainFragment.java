package com.nahia.ejemplofragmentos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    // A partir de aqui puedo acceder a los view del XML
    @Override
    public void onStart() {
        super.onStart();
        Button btFragmento2 = getView().findViewById(R.id.bt_loadFragment2);
        btFragmento2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loadFragment();
                loadFragment2(new SecondFragment());
            }
        });

        Button btLlamar = getView().findViewById(R.id.bt_llamar);
        btLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamarTelefono("555445543");
                mostrarMapa();
            }
        });
    }

    private void loadFragment(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.fragment_container, secondFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void loadFragment2(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }

    private void llamarTelefono(String telefono){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: " + telefono));
        startActivity(intent);
    }

    private void mostrarMapa(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=ies+castelar+badajoz"));
        startActivity(intent);
    }
}
