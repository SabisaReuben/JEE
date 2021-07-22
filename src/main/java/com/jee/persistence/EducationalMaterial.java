package com.jee.persistence;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EducationalMaterial")
@Inheritance(strategy = InheritanceType.JOINED)
@Access(AccessType.FIELD)
public abstract class EducationalMaterial extends Product{
    private String author;



    private String preview;

    public EducationalMaterial() {
    }

    public EducationalMaterial(Valuation value, Date manufacture_date, String productName,
                               String author,  String preview) {
        super(value, manufacture_date, productName);
        this.author = author;
        this.preview = preview;
    }



    @Override
    public Category getCategory() {
        return Category.EDUCATION;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "EducationalMaterial{" +
                "author='" + author + '\'' +
                ", preview='" + preview + '\'' +
                '}';
    }
}
