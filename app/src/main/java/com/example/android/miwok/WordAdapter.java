package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thiago on 13/09/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if the existing view is being reused, othewise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID specified.
        TextView miwok_text_view = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView default_text_view = (TextView) listItemView.findViewById(R.id.default_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //Get the words from the object and set on the TextView
        miwok_text_view.setText(currentWord.getmMiwokTranslation());
        default_text_view.setText(currentWord.getmDefaultTranslation());

        if (currentWord.hasImage()) {
            //if an image is avaiable, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            //Make sure the image view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //Otherwise hide the ImageView.
            imageView.setVisibility(View.GONE);
        }



        return listItemView;
    }
}
