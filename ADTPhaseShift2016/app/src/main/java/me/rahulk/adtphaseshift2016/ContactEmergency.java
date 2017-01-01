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

import me.rahulk.adtphaseshift2016.adapter.ContactCoreAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactEmergency.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactEmergency#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactEmergency extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ContactEmergency() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactEmergency.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactEmergency newInstance(String param1, String param2) {
        ContactEmergency fragment = new ContactEmergency();
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
        View rootView = inflater.inflate(R.layout.fragment_contact_emergency, container, false);

        ArrayList<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("Fire", "101"));
        contactList.add(new Contact("Ambulance", "108"));
        contactList.add(new Contact("Police Control Room", "100"));

//        contactList.add(new Contact("Food", "8867996744"));
//        contactList.add(new Contact("Water", "8792467114"));
//        contactList.add(new Contact("Logistics", "9481310600"));
//        contactList.add(new Contact("Prize", "7259825389"));
//        contactList.add(new Contact("Finance", "9448905422"));
//        contactList.add(new Contact("Onspot", "9035769575"));
//        contactList.add(new Contact("Security", "8147688713"));
//        contactList.add(new Contact("Hospitality", "9686499765"));
//        contactList.add(new Contact("Database", "8553118957"));
//        contactList.add(new Contact("Helpdesk", "7829888663"));


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
