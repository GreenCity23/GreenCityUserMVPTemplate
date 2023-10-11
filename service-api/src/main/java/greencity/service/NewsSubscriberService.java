package greencity.service;

import greencity.dto.newssubscriber.NewsSubscriberResponseDto;

import java.util.List;

/**
 * @author Arthur Mkrtchian
 */
public interface NewsSubscriberService {
    List<NewsSubscriberResponseDto> getAllSubscribers();
    void deleteNotConfirmedEmails();
}
