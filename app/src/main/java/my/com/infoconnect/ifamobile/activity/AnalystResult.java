package my.com.infoconnect.ifamobile.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

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



        //CHART
        //DECLARATION
        BarChart mChart = (BarChart) viewGroup.findViewById(R.id.barChart);

        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.setDescription("");
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);
        mChart.setDrawHighlightArrow(false);

        //CONTROL VARIABLE
        String[] arrVariable = new String[]{"Tabungan Pendidikan","Tabungan Berjangka","Tabungan Pensiun"};
        ArrayList<String> controlVariable = new ArrayList<String>();
        for(int i = 0;i<arrVariable.length;i++)
        {
            controlVariable.add(arrVariable[i]);
        }

        //PARTICIPANT
        ArrayList<BarEntry> valPerson1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> valPerson2 = new ArrayList<BarEntry>();
        for(int i = 0;i<arrVariable.length;i++)
        {
            float val1 = (float) (Math.random() * 300) + 250;
            float val2 = (float) (Math.random() * 300) + 250;
            valPerson1.add(new BarEntry(val1, i));
            valPerson2.add(new BarEntry(val2, i));
        }

        //INITIATE
        BarDataSet setPerson1 = new BarDataSet(valPerson1, "Budiman");
        setPerson1.setColor(Color.rgb(255, 253, 156));
        BarDataSet setPerson2 = new BarDataSet(valPerson2, "Suhandi");
        setPerson2.setColor(Color.rgb(255, 182, 117));

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(setPerson1);
        dataSets.add(setPerson2);

        BarData data = new BarData(controlVariable, dataSets);
        data.setGroupSpace(80f);
        mChart.setData(data);
        //END CHART

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
