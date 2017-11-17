package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    Article pirates = new Article("Pirates", 3000);
    Article wanted = new Article("Fast Cars", 3004);
    Article trees = new Article("Trees", 3001);
    Article ocean = new Article("Undersea", 3001);
    Article mount = new Article("Mount and Horses", 3002);

    Writer johny = new Writer("Johny", Arrays.asList(pirates, wanted));
    Writer sam = new Writer("Sam",  Arrays.asList(ocean));
    Writer elvis = new Writer("Elvis",  Arrays.asList(pirates));
    Writer ana = new Writer("Ana",  Arrays.asList(mount));
    Writer michaliv = new Writer("Michaliv",  Arrays.asList(pirates));
    Writer olecia = new Writer("Olecia",  Arrays.asList(wanted));
    Writer reksio = new Writer("Reksio",  Arrays.asList(trees, mount));
    Writer kogijaszi = new Writer("Kogijaszi",  Arrays.asList(pirates, wanted, mount, trees));
    Writer enzo = new Writer("Enzo",  Arrays.asList(mount));

    public List<Writer> getWriters(String articleName){
        List<Writer> writers = createWriterList();
        List<Writer> resultList = new ArrayList<>();
        for (int i = 0; i < writers.size(); i++) {
            for (int j = 0; j < writers.get(i).getArticles().size(); j++) {
                if (articleName.equals(writers.get(i).getArticles().get(j).getName())){
                    resultList.add(writers.get(i));
                    break;
                }
            }
        }
        return resultList;
    }

    public List<Article> getArticles(String writerName){
        List<Article> articleList = new ArrayList<>();
        List<Writer> writers = new ArrayList<>();
        writers = createWriterList();
        for (Writer writer : writers) {
            if (writerName.equals(writer.getName())){
                articleList = writer.getArticles();
                break;
            }
        }
        return articleList;
    }

    public List<Article>createArticleList(){
        List<Article> articles = new ArrayList<>();
        articles.add(pirates);
        articles.add(wanted);
        articles.add(trees);
        articles.add(ocean);
        articles.add(mount);
        return articles;
    }

    public List<Writer>createWriterList(){
        List<Writer> writers = new ArrayList<>();
        writers.add(johny);
        writers.add(sam);
        writers.add(elvis);
        writers.add(ana);
        writers.add(michaliv);
        writers.add(olecia);
        writers.add(reksio);
        writers.add(kogijaszi);
        writers.add(enzo);
        return writers;
    }

    public boolean isWriter(String userInput){
        List<Writer> writers = createWriterList();
        for (Writer writer : writers) {
           if (writer.getName().equals(userInput)){
               return true;
           }
        }
        return false;
    }

    public boolean isArticle(String userInput){
        List<Article> articles = createArticleList();
        for (Article articl : articles) {
            if (articl.getName().equals(userInput)){
                return true;
            }
        }
        return false;
    }

    public String showWriters(){
        StringBuilder sb = new StringBuilder();
        List<Writer> writers = createWriterList();
        for (Writer writer : writers) {
            sb.append("Writer: " + writer.getName() + ", Articles: ");
            writer.getArticles().forEach(article -> sb.append(article.getName() + ", "));
            sb.append(" *** ");
        }
        return sb.toString();
    }

    public String showArticles(){
        StringBuilder sb = new StringBuilder();
        List<Article> articles = createArticleList();
        for (Article articl : articles) {
            sb.append("Article: " + articl.getName() + ", Year: " + articl.getProductionYear() + " *** ");
        }
        return sb.toString();
    }

    public String generateResult(String userInput){
        StringBuilder sb = new StringBuilder();
        if (isArticle(userInput)){
            for (Writer writer : getWriters(userInput)) {
                sb.append("Writer: " + writer.getName() + ", Articles: ");
                writer.getArticles().forEach(article -> sb.append(article.getName() + ", "));
                sb.append(" *** ");
            }
            return sb.toString();
        } else if (isWriter(userInput)){
            sb.append("Article: ");
            for (Article arti : getArticles(userInput)) {
                sb.append(arti.getName() + ", ");
            }
            return sb.toString();
        } else {
            return "Your input is incorrect";
        }
    }
}


