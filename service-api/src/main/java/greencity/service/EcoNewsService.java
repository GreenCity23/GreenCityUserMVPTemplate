package greencity.service;

import greencity.dto.econews.EcoNewsDto;

import java.util.List;

public interface EcoNewsService {

  List<EcoNewsDto> getLastFiveInterestingEcoNews();
}
