package com.example.dev_2.g2mdx.Fragments.AboutFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dev_2.g2mdx.Click;
import com.example.dev_2.g2mdx.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link about2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link about2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class about2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public about2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment about2.
     */
    // TODO: Rename and change types and number of parameters
    public static about2 newInstance(String param1, String param2) {
        about2 fragment = new about2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    ImageView aboat1;
    TextView about2;
    TextView about3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String strtext = getArguments().getString("key");
        View view = inflater.inflate(R.layout.fragment_about2,
                container, false);

        aboat1=  view.findViewById (R.id.imageView8);
        about2=  view.findViewById (R.id.textView12);
        about3= view.findViewById (R.id.textView13);
        if(strtext.equals("1")){
        aboat1.setImageResource(R.drawable.about1);
        }else if (strtext.equals("2")){
            aboat1.setImageResource(R.drawable.about2);
            about2.setText("Our Mission");
            about3.setText("To develop effective, reliable, secure, and innovative information solutions to support our customers in their journey of technologies transformations and leverage their overall strategic and operational efficiencies");
        }else if (strtext.equals("3")){
            aboat1.setImageResource(R.drawable.about3);
            about2.setText("Our values");
            about3.setText("We aspire to five core values that underlie daily work which are respect, integrity, quality, work with purpose and continuous improvements .");
        }


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    Click activityCallback;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            activityCallback = (Click) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
