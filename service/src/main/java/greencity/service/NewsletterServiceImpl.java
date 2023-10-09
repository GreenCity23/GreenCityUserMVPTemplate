package greencity.service;

import greencity.dto.econews.EcoNewsDto;
import greencity.dto.newssubscriber.NewsSubscriberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsletterServiceImpl implements NewsletterService {
    private final EmailService emailService;
    private final EcoNewsService ecoNewsService;
    private final NewsSubscriberService newsSubscriberService;

    @Autowired
    public NewsletterServiceImpl(EmailService emailService,
                                 EcoNewsService ecoNewsService,
                                 NewsSubscriberService newsSubscriberService) {
        this.emailService = emailService;
        this.ecoNewsService = ecoNewsService;
        this.newsSubscriberService = newsSubscriberService;
    }

    // @Scheduled(cron = "0 0 10 * * ?")
    @Scheduled(cron = "0 30 23 * * ?")
    @Override
    public void sendLatestNewsToSubscribers() {
        List<NewsSubscriberResponseDto> subscribers = newsSubscriberService.getAllSubscribers();
        List<EcoNewsDto> ecoNewsList = ecoNewsService.getLastFiveInterestingEcoNews();
        emailService.sendNewNewsForSubscriber(subscribers, ecoNewsList);
    }
}
