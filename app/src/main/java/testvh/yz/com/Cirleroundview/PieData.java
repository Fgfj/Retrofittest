package testvh.yz.com.Cirleroundview;

/**
 * Created by yuzhou on 2016/10/18.
 */
public class PieData {
    private String type;

    private float value;

    private int colorId;

    public PieData(String type, float value, int colorId) {
        this.type = type;
        this.value = value;
        this.colorId = colorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
