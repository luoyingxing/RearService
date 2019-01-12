package com.lxx.rear.entity;

import com.lxx.rear.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project
 * <p/>
 * Created by luoyingxing on 2019/1/11.
 */
public class Project implements Serializable {
    private String title;
    private int icon;

    private String title1;
    private String title2;
    private boolean enable;
    private String name;
    private String introduce;

    public static List<Project> getMainProjects() {
        List<Project> list = new ArrayList<>();
        list.add(new Project("医疗服务", R.mipmap.ic_main_1));
        list.add(new Project("汽车服务", R.mipmap.ic_main_2));
        list.add(new Project("招待所", R.mipmap.ic_main_3));
        list.add(new Project("维修服务", R.mipmap.ic_main_4));
        list.add(new Project("停车卡申请", R.mipmap.ic_main_5));
        list.add(new Project("物业服务", R.mipmap.ic_main_6));
        list.add(new Project("餐饮服务", R.mipmap.ic_main_7));
        list.add(new Project("综合服务", R.mipmap.ic_main_8));
        return list;
    }

    public static List<Project> getMedicalProjects() {
        List<Project> list = new ArrayList<>();
        list.add(new Project("挂号预约", R.mipmap.ic_medical_order));
        list.add(new Project("我的预约", R.mipmap.ic_medical_mine));
        list.add(new Project("医疗保险", R.mipmap.ic_medical_insurance));
        return list;
    }

    public static List<Project> getOrderProjects() {
        List<Project> list = new ArrayList<>();
        list.add(new Project("", "周五", "01-11", false, "", ""));
        list.add(new Project("", "周六", "01-12", false, "", ""));
        list.add(new Project("", "周日", "01-13", false, "", ""));
        list.add(new Project("", "周一", "01-14", false, "", ""));
        list.add(new Project("", "周二", "01-15", false, "", ""));
        list.add(new Project("", "周三", "01-16", false, "", ""));
        list.add(new Project("", "周四", "01-17", false, "", ""));
        list.add(new Project("上午", "", "", false, "", ""));
        list.add(new Project("上午", "", "01-12", true, "房秀兰", "东南大学医学院本科毕业，主治医生，从事临床工作19年。"));
        list.add(new Project("上午", "", "01-13", true, "孔润萍", "衡阳医学院疗系毕业，副主任医师，从事临床工作44年。"));
        list.add(new Project("上午", "", "01-14", true, "李桂春", "第一军医大学毕业，住院医师，从事临床工作25年。"));
        list.add(new Project("上午", "", "", false, "", ""));
        list.add(new Project("上午", "", "", false, "", ""));
        list.add(new Project("上午", "", "", false, "", ""));
        list.add(new Project("下午", "", "", false, "", ""));
        list.add(new Project("下午", "", "01-12", true, "李桂春", "第一军医大学毕业，住院医师，从事临床工作25年。"));
        list.add(new Project("下午", "", "01-13", true, "房秀兰", "东南大学医学院本科毕业，主治医生，从事临床工作19年。"));
        list.add(new Project("下午", "", "01-14", true, "孔润萍", "衡阳医学院疗系毕业，副主任医师，从事临床工作44年。"));
        list.add(new Project("下午", "", "", false, "", ""));
        list.add(new Project("下午", "", "", false, "", ""));
        list.add(new Project("下午", "", "", false, "", ""));

        return list;
    }

    public Project() {
    }

    public Project(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public Project(String title, String title1, String title2, boolean enable, String name, String introduce) {
        this.title = title;
        this.title1 = title1;
        this.title2 = title2;
        this.enable = enable;
        this.name = name;
        this.introduce = introduce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
