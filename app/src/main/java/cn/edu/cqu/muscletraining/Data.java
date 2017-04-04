package cn.edu.cqu.muscletraining;

import org.litepal.crud.DataSupport;

public class Data extends DataSupport {
    private String id_Item;
    private String strDate;
    private String strText;

    public String getId_Item() {
        return id_Item;
    }

    public void setId_Item(String id_Item) {
        this.id_Item = id_Item;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrText() {
        return strText;
    }

    public void setStrText(String strText) {
        this.strText = strText;
    }
}

