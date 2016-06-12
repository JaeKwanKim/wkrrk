package sample.model;

import java.util.List;

/**
 * Created by JKKim on 2016. 6. 11..
 */
public class ProjectContext {
    private Long contextNum;
    private String contextSubject;
    private Long projectId;
    private Long figureNum;
    private String contextText;
    private String contextDiagram;
    private String contextColor;
    private Long before;
    private Long next;
    private List<ProjectMainFigure> figures;

    public Long getContextNum() {
        return contextNum;
    }

    public void setContextNum(Long contextNum) {
        this.contextNum = contextNum;
    }

    public String getContextSubject() {
        return contextSubject;
    }

    public void setContextSubject(String contextSubject) {
        this.contextSubject = contextSubject;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getFigureNum() {
        return figureNum;
    }

    public void setFigureNum(Long figureNum) {
        this.figureNum = figureNum;
    }

    public String getContextText() {
        return contextText;
    }

    public void setContextText(String contextText) {
        this.contextText = contextText;
    }

    public String getContextDiagram() {
        return contextDiagram;
    }

    public void setContextDiagram(String contextDiagram) {
        this.contextDiagram = contextDiagram;
    }

    public String getContextColor() {
        return contextColor;
    }

    public void setContextColor(String contextColor) {
        this.contextColor = contextColor;
    }

    public Long getBefore() {
        return before;
    }

    public void setBefore(Long before) {
        this.before = before;
    }

    public Long getNext() {
        return next;
    }

    public void setNext(Long next) {
        this.next = next;
    }

    public List<ProjectMainFigure> getFigures() {
        return figures;
    }

    public void setFigures(List<ProjectMainFigure> figures) {
        this.figures = figures;
    }
}
