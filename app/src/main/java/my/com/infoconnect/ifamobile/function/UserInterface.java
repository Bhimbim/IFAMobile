package my.com.infoconnect.ifamobile.function;

/**
 * Created by ibrahimaziztejokusumo on 2/1/16.
 */


// IMPORT

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.variable.Public;
import id.co.jne.jnemobile.courier.variable.object.FormModifier;
import id.co.jne.jnemobile.courier.variable.object.Order;
import id.co.jne.jnemobile.courier.widget.ListOrderAdapter;


// CLASS

public class UserInterface
{
    // CLASS DECLARATION

    private Public PublicPublic = new Public();


    // CLASS INITIALIZATION

    private Activity UserInterfaceActivity;
    private Context UserInterfaceContext;
    private Boolean booleanFormModifier = false;

    public UserInterface(Activity CallerActivity, Context CallerContext)
    {
        this.UserInterfaceActivity = CallerActivity;
        this.UserInterfaceContext = CallerContext;
    }


    // SCREEN

    public int PXtoDP(int PX)
    {
        return (int) (PX / UserInterfaceContext.getResources().getDisplayMetrics().density);
    }

    public int DPtoPX(int DP)
    {
        return (int) (DP * UserInterfaceContext.getResources().getDisplayMetrics().density);
    }


    // NAVIGATION

    public void buttonNavigation(final LinearLayout
            linearLayoutPageContainer)
    {
        int slideRange = Math.round(UserInterfaceActivity.getResources().getDimension(R.dimen.navigation_slide_width));

        final ObjectAnimator SlideIn= ObjectAnimator.ofFloat(linearLayoutPageContainer,
                "translationX", 0, slideRange);
        SlideIn.setDuration(id.co.jne.jnemobile.courier.variable.constant.UserInterface.NavigationAnimationDuration);

        final ObjectAnimator SlideOut= ObjectAnimator.ofFloat(linearLayoutPageContainer,
                "translationX", slideRange, 0);
        SlideOut.setDuration(id.co.jne.jnemobile.courier.variable.constant.UserInterface.NavigationAnimationDuration);

        if(PublicPublic.NavigationState == 0)
        {
            SlideIn.start();
            PublicPublic.NavigationState = 1;
            Log.i("Navigation Slide In", String.valueOf(PublicPublic.NavigationState));
        }
        else
        {
            SlideOut.start();
            PublicPublic.NavigationState = 0;
            Log.i("Navigation Slide Out", String.valueOf(PublicPublic.NavigationState));
        }
    };

    public void replaceFragment(int fragmentContainer, Fragment fragment)
    {

    }

    // FORM

    public void formModify
    (
        List<Integer> listEditText, List<Integer> listSpinner,
        List<Integer> listCheckBox, List<Integer> listRadioButton,
        boolean booleanResetState
    )
    {
        if(listEditText.size() > 0)
        {
            for (int i = 0; i < listEditText.size(); i++)
            {
                EditText editTextForm = (EditText) UserInterfaceActivity.findViewById(listEditText.get(i));

                if (editTextForm.isEnabled())
                {
                    if (booleanResetState)
                    {
                        editTextForm.setText("");
                    }
                    else
                    {
                        editTextForm.setEnabled(false);
                    }
                }
                else
                {
                    editTextForm.setEnabled(true);
                }
            }
        }
        else
        {

        }

        if(listSpinner.size() > 0)
        {
            for (int i = 0; i < listSpinner.size(); i++)
            {
                Spinner spinnerForm = (Spinner) UserInterfaceActivity.findViewById(listSpinner
                        .get(i));

                if (spinnerForm.isEnabled())
                {
                    if (booleanResetState)
                    {
                        spinnerForm.setSelection(0);
                    }
                    else
                    {
                        spinnerForm.setEnabled(false);
                    }
                }
                else
                {
                    spinnerForm.setEnabled(true);
                }
            }
        }
        else
        {

        }

        if(listCheckBox.size() > 0)
        {
            for (int i = 0; i < listCheckBox.size(); i++)
            {
                CheckBox checkBoxForm = (CheckBox) UserInterfaceActivity.findViewById(listCheckBox
                        .get(i));

                if (checkBoxForm.isEnabled())
                {
                    if (booleanResetState)
                    {
                        checkBoxForm.setChecked(false);
                    }
                    else
                    {
                        checkBoxForm.setEnabled(false);
                    }
                }
                else
                {
                    checkBoxForm.setEnabled(true);
                }
            }
        }
        else
        {

        }

        if(listRadioButton.size() > 0)
        {
            for (int i = 0; i < listRadioButton.size(); i++)
            {
                RadioButton radioButtonForm = (RadioButton) UserInterfaceActivity.findViewById
                        (listRadioButton.get(i));

                if (radioButtonForm.isEnabled())
                {
                    if (booleanResetState)
                    {
                        radioButtonForm.setChecked(false);
                    }
                    else
                    {
                        radioButtonForm.setEnabled(false);
                    }
                }
                else
                {
                    radioButtonForm.setEnabled(true);
                }
            }
        }
        else
        {

        }
    }

    public void layoutModifyForm(final FormModifier objectFormModifier)
    {
        Log.i("layoutModifyForm", "imageButtonEdit : " + objectFormModifier.getImageButtonEdit());
        Log.i("layoutModifyForm", "ButtonDone : " + objectFormModifier.getButtonDone());

        objectFormModifier.getImageButtonEdit().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                booleanFormModifier = true;

                objectFormModifier.getLinearLayoutFormDefaultControl().setVisibility(View.GONE);
                objectFormModifier.getLinearLayoutFormModifyControl().setVisibility(View.VISIBLE);

                Log.i("layoutModifyForm", "linearLayoutFormDefault : " + objectFormModifier
                        .getLinearLayoutFormDefaultControl());
                Log.i("layoutModifyForm", "linearLayoutFormModify : " + objectFormModifier
                        .getLinearLayoutFormModifyControl());

                if (objectFormModifier.getLinearLayoutMapDefaultControl() == null)
                {

                }
                else
                {
                    objectFormModifier.getLinearLayoutMapDefaultControl().setVisibility(View.GONE);
                    objectFormModifier.getLinearLayoutMapModifyControl().setVisibility(View.VISIBLE);

                }

                formModify
                (
                    objectFormModifier.getListEditText(), objectFormModifier.getListSpinner(),
                    objectFormModifier.getListRadioButton(), objectFormModifier.getListCheckBox(),
                    false
                );
            }
        });

        objectFormModifier.getButtonDone().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                booleanFormModifier = false;

                objectFormModifier.getLinearLayoutFormDefaultControl().setVisibility(View.VISIBLE);
                objectFormModifier.getLinearLayoutFormModifyControl().setVisibility(View.GONE);

                if (objectFormModifier.getLinearLayoutMapDefaultControl() == null)
                {

                }
                else
                {
                    objectFormModifier.getLinearLayoutMapDefaultControl().setVisibility(View.VISIBLE);
                    objectFormModifier.getLinearLayoutMapModifyControl().setVisibility(View.GONE);
                }

                formModify
                (
                    objectFormModifier.getListEditText(), objectFormModifier.getListSpinner(),
                    objectFormModifier.getListRadioButton(), objectFormModifier.getListCheckBox(),
                    false
                );
            }
        });

        objectFormModifier.getImageButtonReset().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                formModify
                (
                    objectFormModifier.getListEditText(), objectFormModifier.getListSpinner(),
                    objectFormModifier.getListRadioButton(), objectFormModifier.getListCheckBox(),
                    true
                );
            }
        });
    }

    public ListOrderAdapter setListViewSetting(ListView listViewSetting, List<Order> objectDelivery,
                                TypefaceGenerator typefaceGenerator, Boolean booleanHistoryState)
    {
        ListOrderAdapter listOrderAdapter;

        if (booleanHistoryState == false)
        {
            listOrderAdapter = new ListOrderAdapter
            (UserInterfaceContext, R.layout.list_order, objectDelivery, typefaceGenerator, booleanHistoryState);

        }
        else
        {
            listOrderAdapter = new ListOrderAdapter
            (UserInterfaceContext, R.layout.list_history, objectDelivery, typefaceGenerator,
                    booleanHistoryState);
        }

        listViewSetting.setAdapter(listOrderAdapter);

        listViewSetting.setOnTouchListener(new ListView.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                v.onTouchEvent(event);
                return true;
            }
        });

        return listOrderAdapter;
    }

    public String compressAddress (String stringAddress)
    {
        String stringResult = "";

        if(stringAddress.length() > 50)
        {
            stringResult = stringAddress.substring(0, 50);
        }
        else
        {
            stringResult = stringAddress;
        }

        return stringResult + "...";
    }


    // ANIMATION

    public void animationRotate360(int idImageView)
    {
        android.view.animation.Animation animationRotate360 = AnimationUtils.loadAnimation(UserInterfaceContext, R
                .anim.animation_rotate360);
        ImageView imageviewProgressCircle = (ImageView) UserInterfaceActivity.findViewById(idImageView);
        imageviewProgressCircle.setAnimation(animationRotate360);
    }

    public void paperExpand(ImageButton imageButtonExpand, LinearLayout linearLayoutPaper)
    {
        imageButtonExpand.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }


    // SETTER GETTER


    public Boolean getBooleanFormModifier()
    {
        return booleanFormModifier;
    }

    public void setBooleanFormModifier(Boolean booleanFormModifier)
    {
        this.booleanFormModifier = booleanFormModifier;
    }
}