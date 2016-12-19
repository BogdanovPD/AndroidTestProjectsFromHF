package com.example.pbogdanov.testprojectsix_bitsandpizzas_panels;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;


/**
 * A simple {@link Fragment} subclass.
 */
public class PastaMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta_material, container, false);

        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < Pasta.pastas.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < Pasta.pastas.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pastaRecycler.setLayoutManager(layoutManager);
        return pastaRecycler;
    }

}
