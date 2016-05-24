package mabroid.prof_folio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mabroid.prof_folio.R;

/**
 * Created by root on 5/24/16.
 */
public class CustomAdapter extends BaseAdapter {
    private ArrayList<String> data;
    private Context Mcontext;
    private static LayoutInflater inflater = null;
    public CustomAdapter(Context mcontext, ArrayList<String> mList){
        this.Mcontext = mcontext;
        this.data = mList;
        inflater = (LayoutInflater)mcontext.getSystemService(mcontext.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        final Holder holder = new Holder();
        rowView = inflater.inflate(R.layout.listrow, null);
        holder.textView = (TextView)rowView.findViewById(R.id.year);
        holder.textView.setText(data.get(position));
        notifyDataSetChanged();
        return rowView;
    }
    private class Holder{
        TextView textView;
    }
}
