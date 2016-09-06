package me.rahulk.adtphaseshift2016;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.rahulk.adtphaseshift2016.adapter.ContactCoreAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactCore.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactCore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactCore extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ContactCore() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactCore.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactCore newInstance(String param1, String param2) {
        ContactCore fragment = new ContactCore();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact_core, container, false);

        ArrayList<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("Anup R Kamath", "ph@gmail.com", "+91 9740280791"));
        contactList.add(new Contact("Vibhu A Bharadwaj", "ph@gmail.com", "+91 8197918549"));
        contactList.add(new Contact("Chinmayi Mohan", "ph@gmail.com", "+91 9986736096"));
        contactList.add(new Contact("Shreyas Kamath", "ph@gmail.com", "+91 9482927682"));
        contactList.add(new Contact("K Karan Prasad", "ph@gmail.com", "+91 9663155356"));
        contactList.add(new Contact("Shrenik Parakh", "ph@gmail.com", "+91 8951487023"));

        ListView listView = (ListView) rootView.findViewById(R.id.coreList);

        ContactCoreAdapter contactCoreAdapter = new ContactCoreAdapter(getContext(), contactList);

        listView.setAdapter(contactCoreAdapter);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
