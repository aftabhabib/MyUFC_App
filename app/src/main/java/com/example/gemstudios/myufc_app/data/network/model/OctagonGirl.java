package com.example.gemstudios.myufc_app.data.network.model;

/**
 * Created by TAE on 06-Mar-18.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OctagonGirl {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("twitter_feed_file_name")
    @Expose
    private String twitterFeedFileName;
    @SerializedName("biography2")
    @Expose
    private String biography2;
    @SerializedName("biography1")
    @Expose
    private String biography1;
    @SerializedName("turn_ons")
    @Expose
    private String turnOns;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("country_residing")
    @Expose
    private String countryResiding;
    @SerializedName("banner_background_image")
    @Expose
    private String bannerBackgroundImage;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("favorite_foods")
    @Expose
    private String favoriteFoods;
    @SerializedName("hobbies")
    @Expose
    private String hobbies;
    @SerializedName("state_residing")
    @Expose
    private String stateResiding;
    @SerializedName("ways_to_pick_up")
    @Expose
    private String waysToPickUp;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("large_profile_picture")
    @Expose
    private String largeProfilePicture;
    @SerializedName("large_body_picture")
    @Expose
    private String largeBodyPicture;
    @SerializedName("octagon_girl_media_id")
    @Expose
    private Object octagonGirlMediaId;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("city_residing")
    @Expose
    private String cityResiding;
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("twitter_hashtag")
    @Expose
    private String twitterHashtag;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;
    @SerializedName("biography_header")
    @Expose
    private String biographyHeader;
    @SerializedName("websiteurl")
    @Expose
    private String websiteurl;
    @SerializedName("medium_profile_picture")
    @Expose
    private String mediumProfilePicture;
    @SerializedName("career_goals")
    @Expose
    private String careerGoals;
    @SerializedName("storeurl")
    @Expose
    private String storeurl;
    @SerializedName("youtube_channelurl")
    @Expose
    private String youtubeChannelurl;
    @SerializedName("favoritetvshows")
    @Expose
    private String favoritetvshows;
    @SerializedName("gallery")
    @Expose
    private List<Object> gallery = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTwitterFeedFileName() {
        return twitterFeedFileName;
    }

    public void setTwitterFeedFileName(String twitterFeedFileName) {
        this.twitterFeedFileName = twitterFeedFileName;
    }

    public String getBiography2() {
        return biography2;
    }

    public void setBiography2(String biography2) {
        this.biography2 = biography2;
    }

    public String getBiography1() {
        return biography1;
    }

    public void setBiography1(String biography1) {
        this.biography1 = biography1;
    }

    public String getTurnOns() {
        return turnOns;
    }

    public void setTurnOns(String turnOns) {
        this.turnOns = turnOns;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getCountryResiding() {
        return countryResiding;
    }

    public void setCountryResiding(String countryResiding) {
        this.countryResiding = countryResiding;
    }

    public String getBannerBackgroundImage() {
        return bannerBackgroundImage;
    }

    public void setBannerBackgroundImage(String bannerBackgroundImage) {
        this.bannerBackgroundImage = bannerBackgroundImage;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(String favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getStateResiding() {
        return stateResiding;
    }

    public void setStateResiding(String stateResiding) {
        this.stateResiding = stateResiding;
    }

    public String getWaysToPickUp() {
        return waysToPickUp;
    }

    public void setWaysToPickUp(String waysToPickUp) {
        this.waysToPickUp = waysToPickUp;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLargeProfilePicture() {
        return largeProfilePicture;
    }

    public void setLargeProfilePicture(String largeProfilePicture) {
        this.largeProfilePicture = largeProfilePicture;
    }

    public String getLargeBodyPicture() {
        return largeBodyPicture;
    }

    public void setLargeBodyPicture(String largeBodyPicture) {
        this.largeBodyPicture = largeBodyPicture;
    }

    public Object getOctagonGirlMediaId() {
        return octagonGirlMediaId;
    }

    public void setOctagonGirlMediaId(Object octagonGirlMediaId) {
        this.octagonGirlMediaId = octagonGirlMediaId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCityResiding() {
        return cityResiding;
    }

    public void setCityResiding(String cityResiding) {
        this.cityResiding = cityResiding;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getTwitterHashtag() {
        return twitterHashtag;
    }

    public void setTwitterHashtag(String twitterHashtag) {
        this.twitterHashtag = twitterHashtag;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getBiographyHeader() {
        return biographyHeader;
    }

    public void setBiographyHeader(String biographyHeader) {
        this.biographyHeader = biographyHeader;
    }

    public String getWebsiteurl() {
        return websiteurl;
    }

    public void setWebsiteurl(String websiteurl) {
        this.websiteurl = websiteurl;
    }

    public String getMediumProfilePicture() {
        return mediumProfilePicture;
    }

    public void setMediumProfilePicture(String mediumProfilePicture) {
        this.mediumProfilePicture = mediumProfilePicture;
    }

    public String getCareerGoals() {
        return careerGoals;
    }

    public void setCareerGoals(String careerGoals) {
        this.careerGoals = careerGoals;
    }

    public String getStoreurl() {
        return storeurl;
    }

    public void setStoreurl(String storeurl) {
        this.storeurl = storeurl;
    }

    public String getYoutubeChannelurl() {
        return youtubeChannelurl;
    }

    public void setYoutubeChannelurl(String youtubeChannelurl) {
        this.youtubeChannelurl = youtubeChannelurl;
    }

    public String getFavoritetvshows() {
        return favoritetvshows;
    }

    public void setFavoritetvshows(String favoritetvshows) {
        this.favoritetvshows = favoritetvshows;
    }

    public List<Object> getGallery() {
        return gallery;
    }

    public void setGallery(List<Object> gallery) {
        this.gallery = gallery;
    }

}