package com.example.instgramsample2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {
    List<Post> posts;
    private LayoutInflater inflater;

    public PostAdapter(Activity activity, List<Post> posts) {
        this.posts = posts;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowview;
        rowview= inflater.inflate(R.layout.row,null);
        EditText txtmessage = (EditText) rowview.findViewById(R.id.rowmsg);
        TextView txtlocation= (TextView) rowview.findViewById(R.id.rowlocation);
        ImageView imageView= (ImageView) rowview.findViewById(R.id.rowimg);
        Post post=posts.get(position);
        txtmessage.setText(post.getMesasge());
        imageView.setImageBitmap(post.getImage());
        if (post.getLocation()!=null){
            txtlocation.setText(post.getLocation().getLatitude()+""+post.getLocation().getLongitude());

        }
        return rowview;
    }
}
