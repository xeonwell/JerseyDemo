package com.xeonwell.JerseyDemo.dao;


import java.util.List;

/**
 * Created by xeonwell on 2017-04-26.
 */
public interface PodcastDao {
    public List<com.xeonwell.JerseyDemo.Model.Podcast> getPodcasts();

    /**
     * Returns a podcast given its id
     *
     * @param id
     * @return
     */
    public com.xeonwell.JerseyDemo.Model.Podcast getPodcastById(Long id);

    public Long deletePodcastById(Long id);

    public Long createPodcast(com.xeonwell.JerseyDemo.Model.Podcast podcast);

    public int updatePodcast(com.xeonwell.JerseyDemo.Model.Podcast podcast);

    /** removes all podcasts */
    public void deletePodcasts();
}

