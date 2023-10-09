package greencity.mapping;

import greencity.dto.econews.EcoNewsDto;
import greencity.entity.EcoNews;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


/**
 * Class that used by {@link ModelMapper} to map {@link EcoNews} into
 * {@link EcoNewsDto}.
 */
@Component
public class EcoNewsDtoMapper extends AbstractConverter<EcoNews, EcoNewsDto> {
    /**
     * Method for converting {@link EcoNews} into {@link EcoNewsDto}.
     *
     * @param ecoNews object ot convert.
     * @return converted object.
     */
    @Override
    public EcoNewsDto convert(EcoNews ecoNews) {
        return EcoNewsDto.builder()
                .id(ecoNews.getId())
                .creationDate(ecoNews.getCreationDate())
                .imagePath(ecoNews.getImagePath())
                .shortInfo(ecoNews.getShortInfo())
                .title(ecoNews.getTitle())
                .build();
    }
}
