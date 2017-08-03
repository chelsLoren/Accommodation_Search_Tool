package uk.co.lincoln.c14541565students.accommodationsearchtool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chelsey on 28/03/2016.
 */
public class Adapter extends BaseAdapter implements Filterable{

    Context c;
    ArrayList<Accommodation_Info> information;
    CustomFilter filter;
    ArrayList<Accommodation_Info> filterList;

    public Adapter(Context ctx, ArrayList<Accommodation_Info> information){
        this.c = ctx;
        this.information = information;
        this.filterList = information;
    }

    @Override
    public int getCount() {
        return information.size();
    }

    @Override
    public Object getItem(int position) {
        return information.get(position);
    }

    @Override
    public long getItemId(int position) {
        return information.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.accommodation_details, null);
        }

        TextView nameTextview = (TextView) convertView.findViewById(R.id.Accommodation_Name);
        ImageView imgImageview = (ImageView) convertView.findViewById(R.id.Img);

        nameTextview.setText(information.get(position).getName());
        imgImageview.setImageResource(information.get(position).getImg());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter();
        }
        return filter;
    }

    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length()>0){
                constraint = constraint.toString().toLowerCase();
                ArrayList<Accommodation_Info> filters = new ArrayList<Accommodation_Info>();
                for(int i=0; i<filterList.size();i++){
                    if(filterList.get(i).getName().toLowerCase().contains(constraint)){
                        Accommodation_Info I = new Accommodation_Info(filterList.get(i).getName(), filterList.get(i).getImg());
                        filters.add(I);
                    }
                }

                results.count = filters.size();
                results.values = filters;
            }else{
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            information = (ArrayList<Accommodation_Info>) results.values;
            notifyDataSetChanged();
        }
    }
}
