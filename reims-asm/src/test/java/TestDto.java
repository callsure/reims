import java.util.List;

/**
 * 2021/6/11
 * Created by runshu.lin
 */
public class TestDto {
    private int id;
    private String name;
    private long exp;
    private List<Boolean> flags;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getExp() {
        return exp;
    }

    public List<Boolean> getFlags() {
        return flags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public void setFlags(List<Boolean> flags) {
        this.flags = flags;
    }
}
