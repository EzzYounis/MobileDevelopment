package com.example.moviebrowser;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Movie}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Movie> mValues;
    private final MovieFragment.OnMovieSelected mListener;
    private int selectedIndex;
    public MyItemRecyclerViewAdapter(List<Movie> items, MovieFragment.OnMovieSelected listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_movie,parent,false);
        return new ViewHolder (view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(Integer.toString(position));
        holder.mContentView.setText(mValues.get(position).getName());
        holder.mView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (null!= mListener){
                    mListener.movieSelected(holder.mItem);
                    notifyItemChanged(selectedIndex);
                    selectedIndex=holder.getLayoutPosition();
                    notifyItemChanged(selectedIndex);
                }
            }
        });
        holder.itemView.setBackgroundColor(selectedIndex==position ? Color.GREEN:Color.TRANSPARENT);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public  Movie mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView= (TextView) view.findViewById(R.id.item_number);
            mContentView=(TextView) view.findViewById(R.id.content);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}