package seaney.humbolt.lifelens.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

import seaney.humbolt.lifelens.Models.Post;
import seaney.humbolt.lifelens.R;

public class PostAdaptor extends RecyclerView.Adapter<PostAdaptor.ViewHolder>
{
    public List<Post> Posts;
    public Context con;

    public PostAdaptor (List<Post> PostsIn, Context conIn)
    {
        Posts = PostsIn;
        con = conIn;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(con);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.postitem, parent, false);

        return new ViewHolder(contactView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        Post post = Posts.get(position);

        viewHolder.handle.setText(post.getOwner().getUsername());
        viewHolder.discript.setText(post.getDescription());

        ParseFile imge = post.getImage();

        if (imge != null )
            Glide.with(con).load(imge.getUrl().replace("http","https")).into(viewHolder.image);
    }

// Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return Posts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView handle, discript;
        ImageView image;

        public ViewHolder(View itemView)
        {
            super(itemView);
            handle = itemView.findViewById(R.id.tvHandal);
            discript = itemView.findViewById(R.id.tvDiscript);
            image = itemView.findViewById(R.id.ivPost);
        }


    }
}