package seaney.humbolt.lifelens.Models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Comment")
public class Comment extends ParseObject {

    public Comment(){
        super();
    }

    public Comment(String Content, ParseUser Owner)
    {
        setOwner(Owner);
        setBody(Content);
    }

    public void setBody(String body) {
        put("body", body);
    }
    public String getBody() {
        //return getParseFile()
        return getString("body");
    }

    // Associate each comment with a user
    public void setOwner(ParseUser user) {
        put("owner", user);
    }

    // Get the user for this comment
    public ParseUser getOwner()  {
        return getParseUser("owner");
    }

    // Associate each comment with a post
    public void setPost(Post post) {
        put("post", post);
    }

    // Get the post for this item
    public Post getPost()  {
        return (Post) getParseObject("post");
    }
}
