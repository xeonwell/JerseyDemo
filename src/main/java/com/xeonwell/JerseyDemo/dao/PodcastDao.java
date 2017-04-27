package com.xeonwell.JerseyDemo.dao;


import com.xeonwell.JerseyDemo.model.Podcast;

import java.util.List;

/**
 * Created by xeonwell on 2017-04-26.
 */
public interface PodcastDao {
    public List<Podcast> getPodcasts();

    /**
     * Returns a podcast given its id
     *
     * @param id
     * @return
     */
    public Podcast getPodcastById(Long id);

    public Long deletePodcastById(Long id);

    public Long createPodcast(Podcast podcast);

    public int updatePodcast(Podcast podcast);

    /** removes all podcasts */
    public void deletePodcasts();
}

