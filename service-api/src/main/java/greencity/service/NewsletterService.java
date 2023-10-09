package greencity.service;

import greencity.dto.econews.AddEcoNewsDtoResponse;
import greencity.dto.newssubscriber.NewsSubscriberResponseDto;

import java.util.List;

public interface NewsletterService {
    void sendLatestNewsToSubscribers();
}
