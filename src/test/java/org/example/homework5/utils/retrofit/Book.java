package org.example.homework5.utils.retrofit;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Book implements Serializable {

    @SerializedName("isbn")
    private String isBn;

    @SerializedName("title")
    private String title;

    @SerializedName("subTitle")
    private String subTitle;

    @SerializedName("author")
    private String author;

    @SerializedName("publish_date")
    private String publishDate;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("pages")
    private String pages;

    @SerializedName("description")
    private String description;

    @SerializedName("website")
    private String website;

    @Override
    public String toString() {
        String publishDateString = publishDate;
        if (publishDate != null) {
            publishDateString = convertPublishDate(publishDate);
        }
        return "\nisBn [" + isBn + "],\ntitle [" + title + "],\nsubTitle [" + subTitle + "],\nauthor [" + author + "],\npublishDate [" + publishDateString + "],\npublisher, [" + publisher + "],\npages [" + pages + "]\n";
    }

    private String convertPublishDate(String publishDate) {
        if (publishDate == null) {
            return null;
        }
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        dateFormatter.withZone(ZoneId.of("GMT"));
        LocalDateTime latest = LocalDateTime.parse(publishDate, dateFormatter);

        return outputFormatter.format(latest);
    }
}
