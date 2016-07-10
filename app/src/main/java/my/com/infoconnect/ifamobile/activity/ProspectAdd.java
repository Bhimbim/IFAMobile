package my.com.infoconnect.ifamobile.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import my.com.infoconnect.ifamobile.R;
import my.com.infoconnect.ifamobile.variable.constant.UserInterface;

/**
 * Created by ibrahimaziztejokusumo on 7/10/16.
 */
public class ProspectAdd extends android.support.v4.app.Fragment
{
    // INITIALIZATION

    // LAYOUT

    private ViewGroup viewGroup;
    private List<Integer> listTypefacePrimary = new ArrayList<Integer>();
    private List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
    private List<Integer> listTypefaceTertiary = new ArrayList<Integer>();
    private LinearLayout linearLayoutAlert;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // INITIALIZATION

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_prospect_add, container, false);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.textViewInformationTitle);
        listTypefaceSecondary.add(R.id.textViewFinancialTitle);
        listTypefaceSecondary.add(R.id.textViewDetailTitle);
        listTypefaceSecondary.add(R.id.textViewAnalystTitle);
        listTypefaceSecondary.add(R.id.textViewPdfTitle);

        listTypefaceSecondary.add(R.id.textViewInformationIcon);
        listTypefaceSecondary.add(R.id.textViewFinancialIcon);
        listTypefaceSecondary.add(R.id.textViewDetailIcon);
        listTypefaceSecondary.add(R.id.textViewAnalystIcon);
        listTypefaceSecondary.add(R.id.textViewPdfIcon);

        ((Prospect)getActivity()).functionTypefaceGenerator.typefaceFragment
                (listTypefaceSecondary, ((Prospect)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

        // LAYOUT DECLARATION


        return viewGroup;
    }

    public void setOnProcessGuide(String stringOnProcessGuide)
    {
        Log.i("setOnProcessGuide", "stringOnProcessGuide = " + stringOnProcessGuide + ", " +
                viewGroup);

        if(viewGroup == null)
        {
            return;
        }
        TextView textViewInformationIcon = (TextView) viewGroup.findViewById(R.id.textViewInformationIcon);
        TextView textViewFinancialIcon = (TextView) viewGroup.findViewById(R.id.textViewFinancialIcon);
        TextView textViewDetailIcon = (TextView) viewGroup.findViewById(R.id.textViewDetailIcon);
        TextView textViewAnalystIcon = (TextView) viewGroup.findViewById(R.id.textViewAnalystIcon);
        TextView textViewPdfIcon = (TextView) viewGroup.findViewById(R.id.textViewPdfIcon);

        View viewLineLeft = (View) viewGroup.findViewById(R.id.viewLineLeft);
        View viewLineMiddleSt = (View) viewGroup.findViewById(R.id.viewLineMiddleSt);
        View viewLineMiddleNd = (View) viewGroup.findViewById(R.id.viewLineMiddleNd);
        View viewLineRight = (View) viewGroup.findViewById(R.id.viewLineRight);
        Log.d("PROCESS","GUIDE : " + stringOnProcessGuide);
        if(stringOnProcessGuide.equals(getResources().getString(R.string.guide_information)))
        {
//            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineMiddleSt.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineMiddleNd.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_financial)))
        {
//            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddleSt.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineMiddleNd.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_detail)))
        {
//            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddleSt.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddleNd.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_analyst)))
        {
//            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddleSt.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddleNd.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_pdf)))
        {
//            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_done);
//            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_done);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddleSt.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddleNd.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
        }
        else
        {
//            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
//            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineMiddleSt.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineMiddleNd.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
    }
}
