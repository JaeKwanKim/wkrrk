package sample.model;

import java.io.Serializable;

/**
 * Created by JKKim on 2016. 6. 11..
 */
public class ProjectMainFigure implements Serializable{
    private Long figureNum;
    private Long projectId;
    private String figureName;
    private String figureConfig;
    private String figureColor;
    private String figureDiagram;

    public Long getFigureNum() {
        return figureNum;
    }

    public void setFigureNum(Long figureNum) {
        this.figureNum = figureNum;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public String getFigureConfig() {
        return figureConfig;
    }

    public void setFigureConfig(String figureConfig) {
        this.figureConfig = figureConfig;
    }

    public String getFigureColor() {
        return figureColor;
    }

    public void setFigureColor(String figureColor) {
        this.figureColor = figureColor;
    }

    public String getFigureDiagram() {
        return figureDiagram;
    }

    public void setFigureDiagram(String figureDiagram) {
        this.figureDiagram = figureDiagram;
    }
}
