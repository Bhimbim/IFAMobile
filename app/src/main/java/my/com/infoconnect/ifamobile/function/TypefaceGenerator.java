// PACKAGE

package my.com.infoconnect.ifamobile.function;


// IMPORT

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import my.com.infoconnect.ifamobile.variable.constant.Character;
import my.com.infoconnect.ifamobile.variable.constant.UserInterface;


// CLASS

public class TypefaceGenerator
{
	// INITIALIZATION
	
	private Activity activity;
	private Context context;
	
	public TypefaceGenerator(Activity activity, Context context)
	{
		this.activity = activity;
		this.context = context;
	}


	// GENERATOR

	public Typeface typefaceTertiary()
	{
		return Typeface.createFromAsset
		(
			activity.getAssets(),
			UserInterface.FONT_GENERAL_URL + UserInterface.FONT_TERTIARY_NAME
		);
	}
	
	public Typeface typefaceSecondary()
	{
		return Typeface.createFromAsset
		(
			activity.getAssets(),
			UserInterface.FONT_GENERAL_URL +
			UserInterface.FONT_SECONDARY_NAME);
	}
	
	public Typeface typefacePrimary()
	{
		return Typeface.createFromAsset
		(
			activity.getAssets(),
			UserInterface.FONT_GENERAL_URL +
			UserInterface.FONT_PRIMARY_NAME
		);
	}


	// IMPLEMENTATOR

	@SuppressLint("LongLogTag")
	public void typefaceImplementor(List<Integer> listTypeface, Typeface typefaceGenerator, String typefaceName)
	{
		if(listTypeface.size() > 0)
		{
			for (int i = 0; i < listTypeface.size(); i++)
			{
				TextView textView = (TextView) activity.findViewById(listTypeface.get(i));
				textView.setTypeface(typefaceGenerator);
			}
		}
		else
		{
			Log.d
			(
				activity.getClass().getSimpleName().toString() +
				Character.CHARACTER_LOG_SEPARATOR + "typefaceImplementator",
				typefaceName + "list length is " +
				String.valueOf(listTypeface.size())
			);
		}
	}

	public void typefaceFragment(List<Integer> listTypeface, Typeface typefaceGenerator, String typefaceName, ViewGroup viewGroup)
	{
		if(listTypeface.size() > 0)
		{
			for (int i = 0; i < listTypeface.size(); i++)
			{
				TextView textView = (TextView) viewGroup.findViewById(listTypeface.get(i));
				textView.setTypeface(typefaceGenerator);
			}
		}
		else
		{
			Log.d
			(
				activity.getClass().getSimpleName().toString() +
				Character.CHARACTER_LOG_SEPARATOR + "typefaceFragment",
				typefaceName + "list length is " + String.valueOf(listTypeface.size())
			);
		}
	}

	public void typefaceTabLayout(ViewGroup viewGroupTabLayout, Typeface typeface, int intColor)
	{
		int tabsCount = viewGroupTabLayout.getChildCount();
		for (int j = 0; j < tabsCount; j++)
		{
			ViewGroup vgTab = (ViewGroup) viewGroupTabLayout.getChildAt(j);
			int tabChildsCount = vgTab.getChildCount();

			for (int i = 0; i < tabChildsCount; i++)
			{
				View viewChild = vgTab.getChildAt(i);

				if (viewChild instanceof TextView)
				{
					((TextView) viewChild).setTypeface(typeface);
					((TextView) viewChild).setTextColor(activity.getResources().getColor(intColor));
				}
			}
		}
	}
}