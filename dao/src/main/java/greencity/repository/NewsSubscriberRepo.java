package greencity.repository;

import greencity.entity.NewsSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides an interface to manage {@link NewsSubscriber} entity.
 * @author Arthur Mkrtchian
 */
@Repository
public interface NewsSubscriberRepo extends JpaRepository<NewsSubscriber, Long> {

    /**
     * Method to get all subscribers with confirmed emails. This method use native SQL query.
     *
     * @author Arthur Mkrtchian
     */
    @Query(nativeQuery = true, value = "SELECT * FROM news_subscribers WHERE is_confirmed = true")
    List<NewsSubscriber> getAllConfirmed();

}