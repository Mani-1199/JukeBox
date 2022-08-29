package com.JukeBox.Model;
import java.util.List;
import java.util.stream.Collectors;

public class PodcastCollection {
    public List<Podcast> filterByNamePodcast(List<Podcast> list, String podcastName) {
        List<Podcast> podCasts1 = list.stream().filter(a -> a.getPodcastName().equalsIgnoreCase(podcastName)).collect(Collectors.toList());
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.printf("%20s %s %20s %s %20s %s %20s %s", "PODCASTNAME", "|", "PODCAST_RELEASE_DATE", "|", "DURATION", "|", "CELIBRITY_NAME", "|\n");
        for (Podcast podcast : podCasts1) {
            System.out.format("%20s %s %20s %s %20s %s %20s %s", podcast.getPodcastName(), "|", podcast.getPodcastReleaseDate(), "|", podcast.getDuration(), "|", podcast.getPodcastCelebrity(), "|");
            System.out.println();
        }
        return podCasts1;
    }

    public  List<Podcast> filterByCelebrity(List<Podcast> list1, String podcast_Celebrity) {
        List<Podcast> podCasts2 = list1.stream().filter(a -> a.getPodcastCelebrity().equalsIgnoreCase(podcast_Celebrity)).collect(Collectors.toList());
        System.out.printf("%20s %s %20s %s %20s %s %20s %s", "PODCASTNAME", "|", "PODCAST_RELEASE_DATE", "|", "DURATION", "|", "CELIBRITY_NAME", "|\n");
        for (Podcast podcast : podCasts2) {
            System.out.format("%20s %s %20s %s %20s %s %20s %s", podcast.getPodcastName(), "|", podcast.getPodcastReleaseDate(), "|", podcast.getDuration(), "|", podcast.getPodcastCelebrity(), "|");
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________________________");
        return podCasts2;
    }

    public  List<Podcast> filterByPodcastDuration(List<Podcast> list1, String podcast_Duration) {
        List<Podcast> podCasts3 = list1.stream().filter(a -> a.getDuration().equalsIgnoreCase(podcast_Duration)).collect(Collectors.toList());
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.printf("%20s %s %20s %s %20s %s %20s %s", "PODCASTNAME", "|", "PODCAST_RELEASE_DATE", "|", "DURATION", "|", "CELIBRITY_NAME", "|\n");
        for (Podcast podcast : podCasts3) {
            System.out.format("%20s %s %20s %s %20s %s %20s %s", podcast.getPodcastName(), "|", podcast.getPodcastReleaseDate(), "|", podcast.getDuration(), "|", podcast.getPodcastCelebrity(), "|");
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________________________");
        return podCasts3;
    }

    public  List<Podcast> filterByPodcastReleaseDate(List<Podcast> list1, String podcast_Release_Date) {
        List<Podcast> podCasts2 = list1.stream().filter(a -> a.getPodcastReleaseDate().equalsIgnoreCase(podcast_Release_Date)).collect(Collectors.toList());
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.printf("%20s %s %20s %s %20s %s %20s %s", "PODCASTNAME", "|", "PODCAST_RELEASE_DATE", "|", "DURATION", "|", "CELIBRITY_NAME", "|\n");
        for (Podcast podcast : podCasts2) {
            System.out.format("%20s %s %20s %s %20s %s %20s %s", podcast.getPodcastName(), "|", podcast.getPodcastReleaseDate(), "|", podcast.getDuration(), "|", podcast.getPodcastCelebrity(), "|");
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________________________");
        return podCasts2;
    }

    public void displayAllPodcast(List<Podcast> podcastList) {
        if (podcastList.isEmpty()) {
            System.out.println("LIST IS EMPTY");
        } else {
            System.out.println("__________________________________________________________________________________________________________________");
            System.out.printf("%20s %s %20s %s %20s %s %20s %s", "PODCASTNAME", "|", "PODCAST_RELEASE_DATE", "|", "DURATION", "|", "CELIBRITY_NAME", "|\n");

            System.out.println("==================================================================================================================");
            for (Podcast podcast : podcastList) {
                System.out.format("%20s %s %20s %s %20s %s %20s %s", podcast.getPodcastName(), "|",podcast.getPodcastReleaseDate(), "|", podcast.getDuration(), "|", podcast.getPodcastCelebrity(), "|");
                System.out.println();
            }
            System.out.println("__________________________________________________________________________________________________________________");
        }
    }
}
