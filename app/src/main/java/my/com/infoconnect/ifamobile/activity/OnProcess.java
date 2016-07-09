// PACKAGE

package my.com.infoconnect.ifamobile.activity;


// IMPORT

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

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;


// CLASS

public class OnProcess extends android.support.v4.app.Fragment
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

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_onprocess, container, false);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.textViewSenderTitle);
        listTypefaceSecondary.add(R.id.textViewRecipientTitle);
        listTypefaceSecondary.add(R.id.textViewPackageTitle);
        listTypefaceSecondary.add(R.id.textViewPaymentTitle);

        listTypefaceSecondary.add(R.id.textViewSenderIcon);
        listTypefaceSecondary.add(R.id.textViewRecipientIcon);
        listTypefaceSecondary.add(R.id.textViewPackageIcon);
        listTypefaceSecondary.add(R.id.textViewPaymentIcon);

        listTypefaceSecondary.add(R.id.textViewTitle);
        listTypefaceSecondary.add(R.id.textViewContent);

        ((Home)getActivity()).functionTypefaceGenerator.typefaceFragment
        (listTypefaceSecondary, ((Home)getActivity()).functionTypefaceGenerator.typefaceSecondary(), UserInterface.FONT_SECONDARY_NAME, viewGroup);


        // LAYOUT

            // LAYOUT DECLARATION

            FrameLayout frameLayoutGuide = (FrameLayout) viewGroup.findViewById(R.id
                    .includeGuide);
            linearLayoutAlert = (LinearLayout) viewGroup.findViewById(R.id
                    .includeOnProcessAlertList);

            TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.textViewTitle);
            TextView textViewContent = (TextView) viewGroup.findViewById(R.id.textViewContent);

            // LAYOUT SETTING

            textViewTitle.setText(getActivity().getResources().getString(R.string
                    .alert_list_onProcessTitle));
            textViewContent.setText(getActivity().getResources().getString(R.string
                    .alert_list_onProcessContent));

            linearLayoutAlert.setVisibility(View.VISIBLE);
            frameLayoutGuide.setVisibility(View.GONE);


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

        TextView textViewSenderIcon = (TextView) viewGroup.findViewById(R.id.textViewSenderIcon);
        TextView textViewRecipientIcon = (TextView) viewGroup.findViewById(R.id.textViewRecipientIcon);
        TextView textViewPackageIcon = (TextView) viewGroup.findViewById(R.id.textViewPackageIcon);
        TextView textViewPaymentIcon = (TextView) viewGroup.findViewById(R.id.textViewPaymentIcon);

        View viewLineLeft = (View) viewGroup.findViewById(R.id.viewLineLeft);
        View viewLineMiddle = (View) viewGroup.findViewById(R.id.viewLineMiddle);
        View viewLineRight = (View) viewGroup.findViewById(R.id.viewLineRight);

        if(stringOnProcessGuide.equals(getResources().getString(R.string.guide_sender)))
        {
            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineMiddle.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_recipient)))
        {
            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddle.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_package)))
        {
            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddle.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_payment)))
        {
            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddle.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
        }
        else if (stringOnProcessGuide.equals(getResources().getString(R.string.guide_done)))
        {
            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_done);
            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_done);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineMiddle.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_secondary));
        }
        else
        {
            textViewSenderIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewRecipientIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewPackageIcon.setBackgroundResource(R.drawable.guide_icon_start);
            textViewPaymentIcon.setBackgroundResource(R.drawable.guide_icon_start);

            viewLineLeft.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineMiddle.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
            viewLineRight.setBackgroundColor(getResources().getColor(R.color.theme_quaternary));
        }
    }
}