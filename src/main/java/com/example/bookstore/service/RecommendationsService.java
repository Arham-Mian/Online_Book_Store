package com.example.bookstore.service;

import com.example.bookstore.dao.RecommendationsDao;
import com.example.bookstore.model.Recommendation;

import java.util.List;

public class RecommendationsService {

    private final RecommendationsDao dao = new RecommendationsDao();

    public void init() {
        dao.createTableIfNotExists();
    }

    public void seedUser(String userId) {
        dao.seedForUser(userId);
    }

    public List<Recommendation> top5(String userId) {
        return dao.topN(userId, 5);
    }
}
