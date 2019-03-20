package algorithmbook.chapterone;

/**
 * Created by yangw on 2019/3/19.
 */
public class Item {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;
    public Item(String name){
        this.name = name;
    }

}
