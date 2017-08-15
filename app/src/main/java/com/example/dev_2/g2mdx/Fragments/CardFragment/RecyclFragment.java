package com.example.dev_2.g2mdx.Fragments.CardFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dev_2.g2mdx.DB.Helper;
import com.example.dev_2.g2mdx.DB.InternalStorage;
import com.example.dev_2.g2mdx.Home;
import com.example.dev_2.g2mdx.R;
import com.example.dev_2.g2mdx.Retrofit.Models.ListEX;
import com.example.dev_2.g2mdx.Retrofit.Models.Shaleh;
import com.example.dev_2.g2mdx.Retrofit.NetworkResponse;
import com.example.dev_2.g2mdx.Retrofit.callRetrofitSh;
import com.example.dev_2.g2mdx.dummy.DummyContent.DummyItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */

public class RecyclFragment extends Fragment {
    static String[] titels;
    static String[] detals;
    static String[] imag;
    static  ListEX l;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecyclFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RecyclFragment newInstance(int columnCount) {
        RecyclFragment fragment = new RecyclFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


    }

    RecyclerView recyclerView;


    RecyclerView.LayoutManager layoutManager;

    RecyclerView.Adapter adapter;
ProgressBar firstBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_card_demo1, container, false);
        firstBar = (ProgressBar)view.findViewById(R.id.progressBar2);
        firstBar.setVisibility(View.VISIBLE);
        recyclerView =
                (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        titels = new String[0];
        detals = new String[0];
        imag = new String[0];
        if (Helper.internetConnectionAvailable(100)) {
            callRetrofitSh retrofitMovies = callRetrofitSh.getInstance(getContext());
            retrofitMovies.retrofitCall(new NetworkResponse<ListEX>() {
                @Override
                public void onSucess(ListEX result) {
                    firstBar.setVisibility(View.GONE);
                    fillAdapt(result);
                    List<Shaleh> newList = new ArrayList<Shaleh>(result.getShaleh());
                    try {
                        InternalStorage.writeObject(getContext().getApplicationContext(), "cach_data", newList);
                    } catch (IOException e) {

                        e.printStackTrace();
                    }


                }


                @Override
                public void onFailure() {
                    Toast.makeText(getContext().getApplicationContext(), "Not_success", Toast.LENGTH_LONG).show();
                }
            });



            adapter = new RecyclerAdapter1(titels, detals, imag, getContext());
            recyclerView.setAdapter(adapter);
//       Toast.makeText(getContext(),imag[0], Toast.LENGTH_LONG).show();
    }else

    {
        Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
        ReadFromLocal();
    }

                    return view;
}

    public void fillAdapt(ListEX result){
        List<String> list = new ArrayList<String>();
        List<String> d = new ArrayList<String>();
        List<String> im = new ArrayList<String>();
        list.clear();
        d.clear();
        im.clear();
        for (int i = 0; i < result.getShaleh().size(); i++) {


            list.add(result.getShaleh().get(i).getTitle().toString());
            d.add(result.getShaleh().get(i).getHeader().toString());
            im.add(result.getShaleh().get(i).getPicLink().toString());


        }
        titels = list.toArray(new String[0]);
        detals = d.toArray(new String[0]);
        imag = im.toArray(new String[0]);

        adapter = new RecyclerAdapter1(titels, detals, imag, getContext());
        recyclerView.setAdapter(adapter);



    }


    public void ReadFromLocal()
    {
        ListEX l=new ListEX();
        try {
            // Retrieve the list from internal storage :OSAMA ELMADAH
         l.setShaleh( (ArrayList<Shaleh>) InternalStorage.readObject(getContext(), "cach_data"));
            fillAdapt(l);

        } catch (IOException e) {
            Log.e("Error1", e.getMessage());
          Toast.makeText(getContext(),"e1",Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException e) {
            Log.e("Error2", e.getMessage());
            Toast.makeText(getContext(),"e2",Toast.LENGTH_LONG).show();
        }
        firstBar.setVisibility(View.GONE);
    }
Home activityCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
            activityCallback= (Home) context;



        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }





    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
