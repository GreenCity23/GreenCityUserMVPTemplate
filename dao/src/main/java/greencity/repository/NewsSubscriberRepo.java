package greencity.repository;

import greencity.entity.NewsSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides an interface to manage {@link NewsSubscriber} entity.
 *
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

    /**
     * Method to get all subscribers with unconfirmed emails more than for 3 days. This method use native SQL query.
     *
     * @author Arthur Mkrtchian
     */
    @Modifying
    @Query(nativeQuery = true, value =
            "DELETE FROM news_subscribers " +
                    "WHERE is_confirmed = false " +
                    "AND created_at <= NOW() - INTERVAL '3' DAY")
    List<NewsSubscriber> deleteNotConfirmedEmails();


}