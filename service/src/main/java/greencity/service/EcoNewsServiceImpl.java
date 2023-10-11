package greencity.service;

import greencity.dto.econews.EcoNewsDto;
import greencity.mapping.EcoNewsDtoMapper;
import greencity.repository.EcoNewsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arthur Mkrtchian
 */
@Service
public class EcoNewsServiceImpl implements EcoNewsService{

    private final EcoNewsRepo ecoNewsRepo;
    private final EcoNewsDtoMapper mapper;

    public EcoNewsServiceImpl(EcoNewsRepo ecoNewsRepo, EcoNewsDtoMapper mapper) {
        this.ecoNewsRepo = ecoNewsRepo;
        this.mapper = mapper;
    }

    @Override
    public List<EcoNewsDto> getLastFiveInterestingEcoNews() {
        return ecoNewsRepo.getLastFiveInterestingEcoNews().stream().map(mapper::convert)
                .collect(Collectors.toList());
    }

}
