package com.example.pbogdanov.testprojectsix_bitsandpizzas_panels;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_top, container, false);
        RecyclerView pizzaRecycler = (RecyclerView) layout.findViewById(R.id.top_fragment_recycler);

        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < Pizza.pizzas.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImageIds = new int[Pizza.pizzas.length];
        for (int i = 0; i < Pizza.pizzas.length; i++) {
            pizzaImageIds[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImageIds);
        pizzaRecycler.setAdapter(adapter);

        GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(gridLayout);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO, position);
                startActivity(intent);
            }
        });
        return layout;
    }

}
