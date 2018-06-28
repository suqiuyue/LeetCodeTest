package com.leaning;

/**
 * Created by sqy on 2018/5/3.
 */
public class TreeLinkNode {

    private String type;
    private String create_time;
    private String create_by;
    private String object;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String toString( ) {
        StringBuilder sb = new StringBuilder();

        toString(sb);

        return sb.toString();
    }

    public StringBuilder toString(StringBuilder sb) {
        sb.append("serviceAttribute={");
        sb.append(type).append(",");
        sb.append(object).append(",");
        sb.append(create_by).append(",");
        sb.append(create_time).append("}");
        return sb;
    }

    public static void main(String[] args){
        TreeLinkNode test = new TreeLinkNode();
        test.setType("hdfs");
        test.setObject("file");
        test.setCreate_by("admin");
        test.setCreate_time("2018-02-15");

        System.out.println(test.toString());

    }
}
