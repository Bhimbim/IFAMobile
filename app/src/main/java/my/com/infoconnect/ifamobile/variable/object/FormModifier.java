package my.com.infoconnect.ifamobile.variable.object;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;


/**
 * Created by ibrahimaziztejokusumo on 2/16/16.
 */

public class FormModifier
{
    // VARIABLE

    private Activity activity;
    private Context context;
    private ViewGroup viewGroup;

    private ImageButton imageButtonEdit;
    private Button buttonDone;
    private ImageButton imageButtonReset;

    private Button buttonViewLocation;
    private Button buttonPickLocation;

    private LinearLayout linearLayoutFormDefaultControl;
    private LinearLayout linearLayoutFormModifyControl;
    private LinearLayout linearLayoutMapDefaultControl;
    private LinearLayout linearLayoutMapModifyControl;

    private List<Integer> listEditText = new ArrayList<Integer>();
    private List<Integer> listSpinner = new ArrayList<Integer>();
    private List<Integer> listRadioButton = new ArrayList<Integer>();
    private List<Integer> listCheckBox = new ArrayList<Integer>();

    public FormModifier(Activity activity, Context context, ViewGroup viewGroup)
    {
        this.activity = activity;
        this.context = context;
        this.viewGroup = viewGroup;

        imageButtonEdit = (ImageButton) viewGroup.findViewById(R.id.imageButtonEdit);
        buttonDone = (Button) viewGroup.findViewById(R.id.buttonDone);
        imageButtonReset = (ImageButton) viewGroup.findViewById(R.id.imageButtonReset);

        buttonViewLocation = new Button(this.activity);
        buttonPickLocation = new Button(this.activity);

        linearLayoutFormDefaultControl = (LinearLayout) viewGroup.findViewById(R.id.linearLayoutFormDefaultControl);
        linearLayoutFormModifyControl = (LinearLayout) viewGroup.findViewById(R.id.linearLayoutFormModifyControl);
        linearLayoutMapDefaultControl = null;
        linearLayoutMapModifyControl = null;
    }

    public ImageButton getImageButtonEdit()
    {
        return imageButtonEdit;
    }

    public void setImageButtonEdit(int intImageButtonEdit)
    {
        this.imageButtonEdit  = (ImageButton) viewGroup.findViewById(intImageButtonEdit);
    }

    public Button getButtonDone()
    {
        return buttonDone;
    }

    public void setButtonDone(int intButtonDone)
    {
        this.buttonDone = (Button) viewGroup.findViewById(intButtonDone);
    }

    public ImageButton getImageButtonReset()
    {
        return imageButtonReset;
    }

    public void setImageButtonReset(int intImageButtonReset)
    {
        this.imageButtonReset = (ImageButton) viewGroup.findViewById(intImageButtonReset);
    }

    public LinearLayout getLinearLayoutFormDefaultControl()
    {
        return linearLayoutFormDefaultControl;
    }

    public void setLinearLayoutFormDefaultControl(int intLinearLayoutFormDefaultControl)
    {
        this.linearLayoutFormDefaultControl  = (LinearLayout) viewGroup.findViewById
                (intLinearLayoutFormDefaultControl);
    }

    public LinearLayout getLinearLayoutFormModifyControl()
    {
        return linearLayoutFormModifyControl;
    }

    public void setLinearLayoutFormModifyControl(int intLinearLayoutFormModifyControl)
    {
        this.linearLayoutFormModifyControl = (LinearLayout) viewGroup.findViewById(intLinearLayoutFormModifyControl);
    }

    public LinearLayout getLinearLayoutMapDefaultControl()
    {
        return linearLayoutMapDefaultControl;
    }

    public void setLinearLayoutMapDefaultControl(int intLinearLayoutMapDefaultControl)
    {
        this.linearLayoutMapDefaultControl = (LinearLayout) viewGroup.findViewById
                (intLinearLayoutMapDefaultControl);
    }

    public LinearLayout getLinearLayoutMapModifyControl()
    {
        return linearLayoutMapModifyControl;
    }

    public void setLinearLayoutMapModifyControl(int intLinearLayoutMapModifyControl)
    {
        this.linearLayoutMapModifyControl = (LinearLayout) viewGroup.findViewById(intLinearLayoutMapModifyControl);
    }

    public List<Integer> getListEditText()
    {
        return listEditText;
    }

    public void setListEditText(List<Integer> listEditText)
    {
        this.listEditText = listEditText;
    }

    public void addListEditText(int intEditText)
    {
        this.listEditText.add(intEditText);
    }

    public List<Integer> getListSpinner()
    {
        return listSpinner;
    }

    public void setListSpinner(List<Integer> listSpinner)
    {
        this.listSpinner = listSpinner;
    }

    public void addListSpinner(int intSpinner)
    {
        this.listSpinner.add(intSpinner);
    }

    public List<Integer> getListRadioButton()
    {
        return listRadioButton;
    }

    public void setListRadioButton(List<Integer> listRadioButton)
    {
        this.listRadioButton = listRadioButton;
    }

    public void addListRadioButton(int intRadioButton)
    {
        this.listRadioButton.add(intRadioButton);
    }

    public List<Integer> getListCheckBox()
    {
        return listCheckBox;
    }

    public void setListCheckBox(List<Integer> listCheckBox)
    {
        this.listCheckBox = listCheckBox;
    }

    public void addListCheckBox(int intCheckBox)
    {
        this.listCheckBox.add(intCheckBox);
    }

    public Button getButtonViewLocation()
    {
        return buttonViewLocation;
    }

    public void setButtonViewLocation(int intButtonViewLocation)
    {
        this.buttonViewLocation = (Button) viewGroup.findViewById(intButtonViewLocation);
    }

    public Button getButtonPickLocation()
    {
        return buttonPickLocation;
    }

    public void setButtonPickLocation(int intButtonPickLocation)
    {
        this.buttonPickLocation = (Button) viewGroup.findViewById(intButtonPickLocation);
    }
}