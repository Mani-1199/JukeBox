package com.JukeBox.Model;

import java.util.Date;

public class Podcast {

    private String podcastName;
    private String podcastReleaseDate;
    private String duration;
    private String podcastCelebrity;

    public Podcast(String podcastName, String podcastReleaseDate, String duration, String podcastCelebrity) {
        this.podcastName = podcastName;
        this.podcastReleaseDate = podcastReleaseDate;
        this.duration = duration;
        this.podcastCelebrity = podcastCelebrity;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getPodcastReleaseDate() {
        return podcastReleaseDate;
    }

    public void setPodcastReleaseDate(String podcastReleaseDate) {
        this.podcastReleaseDate = podcastReleaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPodcastCelebrity() {
        return podcastCelebrity;
    }

    public void setPodcastCelebrity(String podcastCelebrity) {
        this.podcastCelebrity = podcastCelebrity;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "podcastName='" + podcastName + '\'' +
                ", podcastReleaseDate='" + podcastReleaseDate + '\'' +
                ", duration='" + duration + '\'' +
                ", podcastCelebrity='" + podcastCelebrity + '\'' +
                '}';
    }
}
