package com.example.tae.myufc_app.data.network.model;

/**
 * Created by TAE on 09-Mar-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventsDetails {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fighter1reach")
    @Expose
    private Object fighter1reach;
    @SerializedName("fighter2weight")
    @Expose
    private Integer fighter2weight;
    @SerializedName("fighter2height")
    @Expose
    private Integer fighter2height;
    @SerializedName("fighter2record")
    @Expose
    private String fighter2record;
    @SerializedName("fighter2reach")
    @Expose
    private Object fighter2reach;
    @SerializedName("event_id")
    @Expose
    private Integer eventId;
    @SerializedName("fighter1height")
    @Expose
    private Integer fighter1height;
    @SerializedName("fighter1weight")
    @Expose
    private Integer fighter1weight;
    @SerializedName("fightcard_order")
    @Expose
    private Integer fightcardOrder;
    @SerializedName("statid")
    @Expose
    private Object statid;
    @SerializedName("fighter1record")
    @Expose
    private String fighter1record;
    @SerializedName("is_title_fight")
    @Expose
    private Boolean isTitleFight;
    @SerializedName("fighter1_id")
    @Expose
    private Integer fighter1Id;
    @SerializedName("fighter2_id")
    @Expose
    private Integer fighter2Id;
    @SerializedName("is_main_event")
    @Expose
    private Boolean isMainEvent;
    @SerializedName("fight_description")
    @Expose
    private Object fightDescription;
    @SerializedName("is_prelim")
    @Expose
    private Boolean isPrelim;
    @SerializedName("fighter1odds")
    @Expose
    private Object fighter1odds;
    @SerializedName("fighter2odds")
    @Expose
    private Object fighter2odds;
    @SerializedName("fighter1_nickname")
    @Expose
    private Object fighter1Nickname;
    @SerializedName("fighter1_wins")
    @Expose
    private Object fighter1Wins;
    @SerializedName("fighter1_statid")
    @Expose
    private Object fighter1Statid;
    @SerializedName("fighter1_losses")
    @Expose
    private Object fighter1Losses;
    @SerializedName("fighter1_last_name")
    @Expose
    private String fighter1LastName;
    @SerializedName("fighter1_weight_class")
    @Expose
    private Object fighter1WeightClass;
    @SerializedName("fighter1_draws")
    @Expose
    private Object fighter1Draws;
    @SerializedName("fighter1_first_name")
    @Expose
    private String fighter1FirstName;
    @SerializedName("fighter1_rank")
    @Expose
    private Object fighter1Rank;
    @SerializedName("fighter2_nickname")
    @Expose
    private Object fighter2Nickname;
    @SerializedName("fighter2_wins")
    @Expose
    private Object fighter2Wins;
    @SerializedName("fighter2_statid")
    @Expose
    private Object fighter2Statid;
    @SerializedName("fighter2_losses")
    @Expose
    private Object fighter2Losses;
    @SerializedName("fighter2_last_name")
    @Expose
    private String fighter2LastName;
    @SerializedName("fighter2_weight_class")
    @Expose
    private String fighter2WeightClass;
    @SerializedName("fighter2_draws")
    @Expose
    private Object fighter2Draws;
    @SerializedName("fighter2_first_name")
    @Expose
    private String fighter2FirstName;
    @SerializedName("fighter2_rank")
    @Expose
    private Object fighter2Rank;
    @SerializedName("fighter2_full_body_image")
    @Expose
    private String fighter2FullBodyImage;
    @SerializedName("fighter1_profile_image")
    @Expose
    private String fighter1ProfileImage;
    @SerializedName("fighter2_profile_image")
    @Expose
    private String fighter2ProfileImage;
    @SerializedName("ending_time")
    @Expose
    private String endingTime;
    @SerializedName("fm_stats_feed_url")
    @Expose
    private String fmStatsFeedUrl;
    @SerializedName("fm_fight_rhythm_feed_url")
    @Expose
    private String fmFightRhythmFeedUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getFighter1reach() {
        return fighter1reach;
    }

    public void setFighter1reach(Object fighter1reach) {
        this.fighter1reach = fighter1reach;
    }

    public Integer getFighter2weight() {
        return fighter2weight;
    }

    public void setFighter2weight(Integer fighter2weight) {
        this.fighter2weight = fighter2weight;
    }

    public Integer getFighter2height() {
        return fighter2height;
    }

    public void setFighter2height(Integer fighter2height) {
        this.fighter2height = fighter2height;
    }

    public String getFighter2record() {
        return fighter2record;
    }

    public void setFighter2record(String fighter2record) {
        this.fighter2record = fighter2record;
    }

    public Object getFighter2reach() {
        return fighter2reach;
    }

    public void setFighter2reach(Object fighter2reach) {
        this.fighter2reach = fighter2reach;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getFighter1height() {
        return fighter1height;
    }

    public void setFighter1height(Integer fighter1height) {
        this.fighter1height = fighter1height;
    }

    public Integer getFighter1weight() {
        return fighter1weight;
    }

    public void setFighter1weight(Integer fighter1weight) {
        this.fighter1weight = fighter1weight;
    }

    public Integer getFightcardOrder() {
        return fightcardOrder;
    }

    public void setFightcardOrder(Integer fightcardOrder) {
        this.fightcardOrder = fightcardOrder;
    }

    public Object getStatid() {
        return statid;
    }

    public void setStatid(Object statid) {
        this.statid = statid;
    }

    public String getFighter1record() {
        return fighter1record;
    }

    public void setFighter1record(String fighter1record) {
        this.fighter1record = fighter1record;
    }

    public Boolean getIsTitleFight() {
        return isTitleFight;
    }

    public void setIsTitleFight(Boolean isTitleFight) {
        this.isTitleFight = isTitleFight;
    }

    public Integer getFighter1Id() {
        return fighter1Id;
    }

    public void setFighter1Id(Integer fighter1Id) {
        this.fighter1Id = fighter1Id;
    }

    public Integer getFighter2Id() {
        return fighter2Id;
    }

    public void setFighter2Id(Integer fighter2Id) {
        this.fighter2Id = fighter2Id;
    }

    public Boolean getIsMainEvent() {
        return isMainEvent;
    }

    public void setIsMainEvent(Boolean isMainEvent) {
        this.isMainEvent = isMainEvent;
    }

    public Object getFightDescription() {
        return fightDescription;
    }

    public void setFightDescription(Object fightDescription) {
        this.fightDescription = fightDescription;
    }

    public Boolean getIsPrelim() {
        return isPrelim;
    }

    public void setIsPrelim(Boolean isPrelim) {
        this.isPrelim = isPrelim;
    }

    public Object getFighter1odds() {
        return fighter1odds;
    }

    public void setFighter1odds(Object fighter1odds) {
        this.fighter1odds = fighter1odds;
    }

    public Object getFighter2odds() {
        return fighter2odds;
    }

    public void setFighter2odds(Object fighter2odds) {
        this.fighter2odds = fighter2odds;
    }

    public Object getFighter1Nickname() {
        return fighter1Nickname;
    }

    public void setFighter1Nickname(Object fighter1Nickname) {
        this.fighter1Nickname = fighter1Nickname;
    }

    public Object getFighter1Wins() {
        return fighter1Wins;
    }

    public void setFighter1Wins(Object fighter1Wins) {
        this.fighter1Wins = fighter1Wins;
    }

    public Object getFighter1Statid() {
        return fighter1Statid;
    }

    public void setFighter1Statid(Object fighter1Statid) {
        this.fighter1Statid = fighter1Statid;
    }

    public Object getFighter1Losses() {
        return fighter1Losses;
    }

    public void setFighter1Losses(Object fighter1Losses) {
        this.fighter1Losses = fighter1Losses;
    }

    public String getFighter1LastName() {
        return fighter1LastName;
    }

    public void setFighter1LastName(String fighter1LastName) {
        this.fighter1LastName = fighter1LastName;
    }

    public Object getFighter1WeightClass() {
        return fighter1WeightClass;
    }

    public void setFighter1WeightClass(Object fighter1WeightClass) {
        this.fighter1WeightClass = fighter1WeightClass;
    }

    public Object getFighter1Draws() {
        return fighter1Draws;
    }

    public void setFighter1Draws(Object fighter1Draws) {
        this.fighter1Draws = fighter1Draws;
    }

    public String getFighter1FirstName() {
        return fighter1FirstName;
    }

    public void setFighter1FirstName(String fighter1FirstName) {
        this.fighter1FirstName = fighter1FirstName;
    }

    public Object getFighter1Rank() {
        return fighter1Rank;
    }

    public void setFighter1Rank(Object fighter1Rank) {
        this.fighter1Rank = fighter1Rank;
    }

    public Object getFighter2Nickname() {
        return fighter2Nickname;
    }

    public void setFighter2Nickname(Object fighter2Nickname) {
        this.fighter2Nickname = fighter2Nickname;
    }

    public Object getFighter2Wins() {
        return fighter2Wins;
    }

    public void setFighter2Wins(Object fighter2Wins) {
        this.fighter2Wins = fighter2Wins;
    }

    public Object getFighter2Statid() {
        return fighter2Statid;
    }

    public void setFighter2Statid(Object fighter2Statid) {
        this.fighter2Statid = fighter2Statid;
    }

    public Object getFighter2Losses() {
        return fighter2Losses;
    }

    public void setFighter2Losses(Object fighter2Losses) {
        this.fighter2Losses = fighter2Losses;
    }

    public String getFighter2LastName() {
        return fighter2LastName;
    }

    public void setFighter2LastName(String fighter2LastName) {
        this.fighter2LastName = fighter2LastName;
    }

    public String getFighter2WeightClass() {
        return fighter2WeightClass;
    }

    public void setFighter2WeightClass(String fighter2WeightClass) {
        this.fighter2WeightClass = fighter2WeightClass;
    }

    public Object getFighter2Draws() {
        return fighter2Draws;
    }

    public void setFighter2Draws(Object fighter2Draws) {
        this.fighter2Draws = fighter2Draws;
    }

    public String getFighter2FirstName() {
        return fighter2FirstName;
    }

    public void setFighter2FirstName(String fighter2FirstName) {
        this.fighter2FirstName = fighter2FirstName;
    }

    public Object getFighter2Rank() {
        return fighter2Rank;
    }

    public void setFighter2Rank(Object fighter2Rank) {
        this.fighter2Rank = fighter2Rank;
    }

    public String getFighter2FullBodyImage() {
        return fighter2FullBodyImage;
    }

    public void setFighter2FullBodyImage(String fighter2FullBodyImage) {
        this.fighter2FullBodyImage = fighter2FullBodyImage;
    }

    public String getFighter1ProfileImage() {
        return fighter1ProfileImage;
    }

    public void setFighter1ProfileImage(String fighter1ProfileImage) {
        this.fighter1ProfileImage = fighter1ProfileImage;
    }

    public String getFighter2ProfileImage() {
        return fighter2ProfileImage;
    }

    public void setFighter2ProfileImage(String fighter2ProfileImage) {
        this.fighter2ProfileImage = fighter2ProfileImage;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public String getFmStatsFeedUrl() {
        return fmStatsFeedUrl;
    }

    public void setFmStatsFeedUrl(String fmStatsFeedUrl) {
        this.fmStatsFeedUrl = fmStatsFeedUrl;
    }

    public String getFmFightRhythmFeedUrl() {
        return fmFightRhythmFeedUrl;
    }

    public void setFmFightRhythmFeedUrl(String fmFightRhythmFeedUrl) {
        this.fmFightRhythmFeedUrl = fmFightRhythmFeedUrl;
    }

}