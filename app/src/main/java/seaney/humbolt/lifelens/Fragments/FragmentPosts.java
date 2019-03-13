package seaney.humbolt.lifelens.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import seaney.humbolt.lifelens.Models.Post;
import seaney.humbolt.lifelens.R;
import seaney.humbolt.lifelens.adaptor.PostAdaptor;

public class FragmentPosts extends Fragment {

    RecyclerView rvPosts;
    List<Post> mposts = new ArrayList<>();
    PostAdaptor adaptor;
    private SwipeRefreshLayout swipeContainer;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPosts = view.findViewById(R.id.rvPostsview);

        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                queryPosts();

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adaptor = new PostAdaptor(mposts, getContext());

        rvPosts.setLayoutManager(linearLayoutManager);
        rvPosts.setAdapter(adaptor);

        queryPosts();
    }


    private void queryPosts()
    {
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_USER);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if (e != null)
                {
                    return;
                }
                mposts.clear();
                mposts.addAll(objects);
                Collections.reverse(mposts);
                adaptor.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        });
    }
}
