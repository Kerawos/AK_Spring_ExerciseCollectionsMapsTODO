package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

import java.util.List;

public class Writer {

    private String name;
    private List<Article> articles;

    public Writer(String name, List<Article> articles) {
        this.name = name;
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
