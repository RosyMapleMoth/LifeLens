package seaney.humbolt.lifelens.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import seaney.humbolt.lifelens.Models.Post;
import seaney.humbolt.lifelens.R;

public class PostAdaptor extends RecyclerView.Adapter<PostAdaptor.ViewHolder>
{
    public List<Post> Posts;


    @Override
    public PostAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.postitem, parent, false);

        // Return a new holder instance
        PostAdaptor.ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {

    }

// Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return Posts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {


        public ViewHolder(View itemView)
        {
            super(itemView);

        }


    }
}