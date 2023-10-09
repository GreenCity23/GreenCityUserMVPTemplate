package greencity.repository;

import greencity.entity.EcoNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcoNewsRepo extends JpaRepository<EcoNews, Long>, JpaSpecificationExecutor<EcoNews> {
    @Query(nativeQuery = true, value =
            "SELECT e.* " +
                    "FROM eco_news e " +
                    "LEFT JOIN eco_news_users_likes l ON e.id = l.eco_news_id " +
                    "WHERE e.creation_date >= NOW() - INTERVAL '1 DAY' " +
                    "GROUP BY e.id " +
                    "ORDER BY COUNT(l.users_id) DESC " +
                    "LIMIT 5")
    List<EcoNews> getLastFiveInterestingEcoNews();
}
