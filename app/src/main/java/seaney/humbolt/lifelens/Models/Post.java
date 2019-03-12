package seaney.humbolt.lifelens.Models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";


    public Post(ParseFile image, ParseUser Owner, String Body)
    {
        setDescription(Body);
        setImage(image);
        setOwner(Owner);
    }
    public Post( )
    {
        super();
    }
    public void setDescription(String body) {
        put(KEY_DESCRIPTION, body);
    }
    public String getDescription() {
        //return getParseFile()
        return getString(KEY_DESCRIPTION);
    }
    public void setOwner(ParseUser user) {
        put(KEY_USER, user);
    }
    // Get the user for this comment
    public ParseUser getOwner()  {
        return getParseUser(KEY_USER);
    }

    public void setImage(ParseFile Image) {
        put(KEY_IMAGE, Image);
    }
    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

}