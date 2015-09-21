package com.mac.cdp.androidbaidusign.myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.mac.cdp.androidbaidusign.R;

import java.util.List;

/**
 * Created by cdpmac on 15/9/13.
 */
public class ImageAndTextAdapter extends BaseAdapter {
public static class ViewIDAndTextString{
    private int imageView;
    private String text;
    public ViewIDAndTextString(int imageView, String text) {
        super();
        this.imageView = imageView;
        this.text = text;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

//     View private Context context;
    private Context context;
    private ImageView imageView;
    private TextView textView;

    private List<ViewIDAndTextString> list;
    public ImageAndTextAdapter(Context context, List<ViewIDAndTextString> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_cell_imgtext, null);
        }
        imageView=(ImageView) convertView.findViewById(R.id.item_imageview);
        textView=(TextView) convertView.findViewById(R.id.item_textview);
        imageView.setImageResource(list.get(position).getImageView());
        textView.setText(list.get(position).getText());
        return convertView;
    }
}
