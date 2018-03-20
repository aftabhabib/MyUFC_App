package com.example.gemstudios.myufc_app.data.network.model;

/**
 * Created by TAE on 12-Mar-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {
    @SerializedName("WinnerScore")
    @Expose
    private Object winnerScore;
    @SerializedName("LoserScore")
    @Expose
    private Object loserScore;
    @SerializedName("JudgeID")
    @Expose
    private Object judgeID;
    @SerializedName("JudgeFirstName")
    @Expose
    private Object judgeFirstName;
    @SerializedName("JudgeLastName")
    @Expose
    private Object judgeLastName;

    public Object getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(Object winnerScore) {
        this.winnerScore = winnerScore;
    }

    public Object getLoserScore() {
        return loserScore;
    }

    public void setLoserScore(Object loserScore) {
        this.loserScore = loserScore;
    }

    public Object getJudgeID() {
        return judgeID;
    }

    public void setJudgeID(Object judgeID) {
        this.judgeID = judgeID;
    }

    public Object getJudgeFirstName() {
        return judgeFirstName;
    }

    public void setJudgeFirstName(Object judgeFirstName) {
        this.judgeFirstName = judgeFirstName;
    }

    public Object getJudgeLastName() {
        return judgeLastName;
    }

    public void setJudgeLastName(Object judgeLastName) {
        this.judgeLastName = judgeLastName;
    }

}

