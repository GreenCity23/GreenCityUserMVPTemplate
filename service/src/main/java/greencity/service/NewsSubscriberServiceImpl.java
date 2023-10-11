package greencity.service;

import greencity.dto.newssubscriber.NewsSubscriberResponseDto;
import greencity.mapping.NewsSubscriberDtoResponseMapper;
import greencity.repository.NewsSubscriberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arthur Mkrtchian
 */
@Service
public class NewsSubscriberServiceImpl implements NewsSubscriberService {
    private final NewsSubscriberRepo newsSubscriberRepo;
    private final NewsSubscriberDtoResponseMapper mapper;

    public NewsSubscriberServiceImpl(NewsSubscriberRepo newsSubscriberRepo, NewsSubscriberDtoResponseMapper mapper) {
        this.newsSubscriberRepo = newsSubscriberRepo;
        this.mapper = mapper;
    }

    @Override
    public List<NewsSubscriberResponseDto> getAllSubscribers() {
        return newsSubscriberRepo.getAllConfirmed().stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNotConfirmedEmails() {
        newsSubscriberRepo.deleteNotConfirmedEmails();
    }


}
