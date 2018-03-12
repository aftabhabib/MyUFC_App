package com.example.tae.myufc_app.data.network.model;

/**
 * Created by TAE on 12-Mar-18.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
    public class Result {

        @SerializedName("Method")
        @Expose
        private Object method;
        @SerializedName("EndingRound")
        @Expose
        private Object endingRound;
        @SerializedName("EndingTime")
        @Expose
        private String endingTime;
        @SerializedName("Submission")
        @Expose
        private Object submission;
        @SerializedName("EndStrike")
        @Expose
        private Object endStrike;
        @SerializedName("EndTarget")
        @Expose
        private Object endTarget;
        @SerializedName("EndPosition")
        @Expose
        private Object endPosition;
        @SerializedName("EndNotes")
        @Expose
        private Object endNotes;
        @SerializedName("FightOfTheNight")
        @Expose
        private Object fightOfTheNight;
        @SerializedName("Scores")
        @Expose
        private List<Score> scores = null;

        public Object getMethod() {
            return method;
        }

        public void setMethod(Object method) {
            this.method = method;
        }

        public Object getEndingRound() {
            return endingRound;
        }

        public void setEndingRound(Object endingRound) {
            this.endingRound = endingRound;
        }

        public String getEndingTime() {
            return endingTime;
        }

        public void setEndingTime(String endingTime) {
            this.endingTime = endingTime;
        }

        public Object getSubmission() {
            return submission;
        }

        public void setSubmission(Object submission) {
            this.submission = submission;
        }

        public Object getEndStrike() {
            return endStrike;
        }

        public void setEndStrike(Object endStrike) {
            this.endStrike = endStrike;
        }

        public Object getEndTarget() {
            return endTarget;
        }

        public void setEndTarget(Object endTarget) {
            this.endTarget = endTarget;
        }

        public Object getEndPosition() {
            return endPosition;
        }

        public void setEndPosition(Object endPosition) {
            this.endPosition = endPosition;
        }

        public Object getEndNotes() {
            return endNotes;
        }

        public void setEndNotes(Object endNotes) {
            this.endNotes = endNotes;
        }

        public Object getFightOfTheNight() {
            return fightOfTheNight;
        }

        public void setFightOfTheNight(Object fightOfTheNight) {
            this.fightOfTheNight = fightOfTheNight;
        }

        public List<Score> getScores() {
            return scores;
        }

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }

    }
