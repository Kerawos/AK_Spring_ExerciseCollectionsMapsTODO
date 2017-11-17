package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

public class Article {

    private String name;
    private int productionYear;

    public Article(String name, int productionYear) {
        this.name = name;
        this.productionYear = productionYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}
