package tw.com.noel.demotwowayscrollview.model;

/**
 * Created by noel on 2018/1/4.
 */

public class Box {
    private String name;
    private String position;
    private String time;
    private String grades;
    private String rebound;
    private String assits;
    private String steals;
    private String block;
    private String blocked;
    private String shootingSuccess;
    private String shootingTotal;
    private String shootingPercentage;
    private String threeGradesSuccess;
    private String threeGradesTotal;
    private String threeGradesPercentage;
    private String penaltyShotSuccess;
    private String penaltyShotTotal;
    private String penaltyShotPercentage;


    public Box(String name, String position, String time, String grades, String rebound, String assits, String steals, String block, String blocked, String shootingSuccess
    , String shootingTotal, String shootingPercentage, String threeGradesSuccess, String threeGradesTotal, String threeGradesPercentage, String penaltyShotSuccess, String penaltyShotTotal
    , String penaltyShotPercentage) {
        this.name = name;
        this.position = position;
        this.time = time;
        this.grades = grades;
        this.rebound = rebound;
        this.assits = assits;
        this.steals = steals;
        this.block = block;
        this.blocked = blocked;
        this.shootingSuccess = shootingSuccess;
        this.shootingTotal = shootingTotal;
        this.shootingPercentage = shootingPercentage;
        this.threeGradesSuccess = threeGradesSuccess;
        this.threeGradesTotal = threeGradesTotal;
        this.threeGradesPercentage = threeGradesPercentage;
        this.penaltyShotSuccess = penaltyShotSuccess;
        this.penaltyShotTotal = penaltyShotTotal;
        this.penaltyShotPercentage = penaltyShotPercentage;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getRebound() {
        return rebound;
    }

    public void setRebound(String rebound) {
        this.rebound = rebound;
    }

    public String getAssits() {
        return assits;
    }

    public void setAssits(String assits) {
        this.assits = assits;
    }

    public String getSteals() {
        return steals;
    }

    public void setSteals(String steals) {
        this.steals = steals;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public String getShootingSuccess() {
        return shootingSuccess;
    }

    public void setShootingSuccess(String shootingSuccess) {
        this.shootingSuccess = shootingSuccess;
    }

    public String getShootingTotal() {
        return shootingTotal;
    }

    public void setShootingTotal(String shootingTotal) {
        this.shootingTotal = shootingTotal;
    }

    public String getShootingPercentage() {
        return shootingPercentage;
    }

    public void setShootingPercentage(String shootingPercentage) {
        this.shootingPercentage = shootingPercentage;
    }

    public String getThreeGradesSuccess() {
        return threeGradesSuccess;
    }

    public void setThreeGradesSuccess(String threeGradesSuccess) {
        this.threeGradesSuccess = threeGradesSuccess;
    }

    public String getThreeGradesTotal() {
        return threeGradesTotal;
    }

    public void setThreeGradesTotal(String threeGradesTotal) {
        this.threeGradesTotal = threeGradesTotal;
    }

    public String getThreeGradesPercentage() {
        return threeGradesPercentage;
    }

    public void setThreeGradesPercentage(String threeGradesPercentage) {
        this.threeGradesPercentage = threeGradesPercentage;
    }

    public String getPenaltyShotSuccess() {
        return penaltyShotSuccess;
    }

    public void setPenaltyShotSuccess(String penaltyShotSuccess) {
        this.penaltyShotSuccess = penaltyShotSuccess;
    }

    public String getPenaltyShotTotal() {
        return penaltyShotTotal;
    }

    public void setPenaltyShotTotal(String penaltyShotTotal) {
        this.penaltyShotTotal = penaltyShotTotal;
    }

    public String getPenaltyShotPercentage() {
        return penaltyShotPercentage;
    }

    public void setPenaltyShotPercentage(String penaltyShotPercentage) {
        this.penaltyShotPercentage = penaltyShotPercentage;
    }
}
