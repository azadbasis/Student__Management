package me.azhar.student__management;

/**
 * Created by azharul on 5/9/2016.
 */
public class ResultModel {

    private int resultId;
    private String examinationLevel;
    private String universityBoard;
    private String Institute;
    private String subjectGroup;
    private String result;
    private String passingYear;
    private String extraId;


    public ResultModel(int resultId, String examinationLevel, String universityBoard, String institute, String subjectGroup, String result, String passingYear, String extraId) {
        this.resultId = resultId;
        this.examinationLevel = examinationLevel;
        this.universityBoard = universityBoard;
        Institute = institute;
        this.subjectGroup = subjectGroup;
        this.result = result;
        this.passingYear = passingYear;
        this.extraId = extraId;
    }


    public ResultModel(String examinationLevel, String universityBoard, String institute, String subjectGroup, String result, String passingYear, String extraId) {
        this.examinationLevel = examinationLevel;
        this.universityBoard = universityBoard;
        Institute = institute;
        this.subjectGroup = subjectGroup;
        this.result = result;
        this.passingYear = passingYear;
        this.extraId = extraId;
    }

    public int getResultId() {
        return resultId;
    }

    public String getExaminationLevel() {
        return examinationLevel;
    }

    public String getUniversityBoard() {
        return universityBoard;
    }

    public String getInstitute() {
        return Institute;
    }

    public String getSubjectGroup() {
        return subjectGroup;
    }

    public String getResult() {
        return result;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public String getExtraId() {
        return extraId;
    }
}
