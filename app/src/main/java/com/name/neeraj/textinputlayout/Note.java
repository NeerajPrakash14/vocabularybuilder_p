package com.name.neeraj.textinputlayout;

/**
 * Created by MADHU on 04-12-2018.
 */

public class Note {

    private String Username;
    private String Password;
    private String Email_id;
    private String documentId;

    public Note()
    {
    }

    public String getDocumentId(){
        return documentId;
    }

    public void setDocumentId(String documentId){
        this.documentId=documentId;
    }

    public Note(String password,String emailId,String username)
    {
        this.Password=password;
        this.Email_id=emailId;
        this.Username=username;
    }

    public String getPassword(){
        return Password;
    }

    public String getEmailId(){
        return Email_id;
    }

    public String getUsername(){
        return Username;
    }

}
