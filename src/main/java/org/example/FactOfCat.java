package org.example;

import com.google.gson.annotations.SerializedName;

public class FactOfCat {

    @SerializedName("id")
    private String id; // - уникальный идентификатор записи
    @SerializedName("text")
    private String text; // - сообщение
    @SerializedName("type")
    private String type; // - тип животного
    @SerializedName("user")
    private String user; // - имя пользователя
    @SerializedName("upvotes")
    private int upvotes; // - голоса


    public FactOfCat(
            String id,
            String text,
            String type,
            String user,
            Integer upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }


    @Override
    public String toString() {
        return "\n id = " + id +
                "\n text = " + text +
                "\n type = " + type +
                "\n user = " + user +
                "\n upvotes = " + upvotes + "\n";
    }

    public Integer getUpvotes() {
        return upvotes;
    }
}
