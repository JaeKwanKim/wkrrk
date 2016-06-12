package sample.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by JKKim on 2016. 6. 11..
 */
public class ProjectMain implements Serializable{
    private Long projectId;
    private Long userNum;
    private String projectIntro;
    private ProjectInfo info;
    private List<ProjectMainFigure> figure;
    private List<ProjectContext> context;
    private Map<String, Object> _links;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserNum() {
        return userNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public String getProjectIntro() {
        return projectIntro;
    }

    public void setProjectIntro(String projectIntro) {
        this.projectIntro = projectIntro;
    }

    public ProjectInfo getInfo() {
        return info;
    }

    public void setInfo(ProjectInfo info) {
        this.info = info;
    }

    public List<ProjectMainFigure> getFigure() {
        return figure;
    }

    public void setFigure(List<ProjectMainFigure> figure) {
        this.figure = figure;
    }

    public List<ProjectContext> getContext() {
        return context;
    }

    public void setContext(List<ProjectContext> context) {
        this.context = context;
    }

    public Map<String, Object> get_links() {
        return _links;
    }

    public void set_links(Map<String, Object> _links) {
        this._links = _links;
    }
}
