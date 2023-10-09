package greencity.service;

import greencity.dto.newssubscriber.NewsSubscriberResponseDto;

import java.util.List;

public interface NewsSubscriberService {
    List<NewsSubscriberResponseDto> getAllSubscribers();
}
