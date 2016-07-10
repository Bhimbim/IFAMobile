package my.com.infoconnect.ifamobile.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.R;
import my.com.infoconnect.ifamobile.variable.constant.UserInterface;

/**
 * Created by ibrahimaziztejokusumo on 7/10/16.
 */
public class AnalystResult extends Fragment
{
    // INIITLIAZATION

    // LAYOUT

    private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
    private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
    private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_analystresult, container, false);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.textViewGuideInformationTitle);

        listTypefaceSecondary.add(R.id.buttonNext);
        listTypefaceSecondary.add(R.id.buttonDone);

        ((Prospect)getActivity()).functionTypefaceGenerator.typefaceFragment
                (listTypefaceSecondary, ((Prospect)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

        // LAYOUT DECLARATION

        FrameLayout frameLayoutGuide = (FrameLayout) getActivity().findViewById(R.id.includeGuide);

        Button buttonNext = (Button) viewGroup.findViewById(R.id.buttonNext);

        // LAYOUT SETTING


        Fragment fragmentOnProcess = ((Prospect)getActivity()).pagerAdapter.getItem(1);
        ((ProspectAdd)fragmentOnProcess).setOnProcessGuide(getResources().getString(R.string
                .guide_analyst));


        // EVENT

        final android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.setCustomAnimations(R.anim.transition_fly_in, R.anim
        //   .transition_fly_out);


        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Fragment fragmentTarget = new PdfResult();

                fragmentTransaction.replace(R.id.relativeLayoutProspectAddFragmentcontainer,
                        fragmentTarget).commit();
            }
        });

        return viewGroup;
    }
}
