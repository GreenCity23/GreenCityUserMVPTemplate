package greencity.service;

import greencity.dto.econews.EcoNewsDto;
import greencity.dto.newssubscriber.NewsSubscriberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsletterServiceImpl implements NewsletterService {

    private final RestTemplate restTemplate;
    private final EmailService emailService;
    @Value("${greencity.server.address}")
    private String greenCityServerLink;

    @Autowired
    public NewsletterServiceImpl(RestTemplate restTemplate, EmailService emailService) {
        this.restTemplate = restTemplate;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 10 * * ?")
    @Override
    public void sendLatestNewsToSubscribers() {
        List<NewsSubscriberResponseDto> subscribers = fetchNewsSubscribers();
        List<EcoNewsDto> ecoNewsList = fetchLatestEcoNews();

        if (ecoNewsList.isEmpty()) {
            return;
        }

        emailService.sendNewNewsForSubscriber(subscribers, ecoNewsList);
    }

    private List<NewsSubscriberResponseDto> fetchNewsSubscribers() {
        String subscribersEndpoint = greenCityServerLink + "/subscribers";

        ResponseEntity<List<NewsSubscriberResponseDto>> response = restTemplate.exchange(
                subscribersEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<NewsSubscriberResponseDto>>() {
                }
        );

        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            throw new RuntimeException("Failed to fetch subscribers");
        }

        return response.getBody();
    }

    private List<EcoNewsDto> fetchLatestEcoNews() {
        String newsEndpoint = greenCityServerLink + "/econews";

        ResponseEntity<List<EcoNewsDto>> response = restTemplate.exchange(
                newsEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EcoNewsDto>>() {
                }
        );

        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            throw new RuntimeException("Failed to fetch EcoNews");
        }

        return response.getBody().stream()
                .filter(news -> news.getCreationDate().isAfter(ZonedDateTime.now().minusDays(1)))
                .sorted((news1, news2) -> {
                    int likesComparison = Integer.compare(news2.getUsersLikedNewsIds().size(), news1.getUsersLikedNewsIds().size());
                    return likesComparison != 0 ? likesComparison : news2.getCreationDate().compareTo(news1.getCreationDate());
                })
                .limit(5)
                .collect(Collectors.toList());
    }
}
