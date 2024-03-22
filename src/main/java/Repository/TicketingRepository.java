package Repository;

import entity.ticketing.HelpdeskTicket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketingRepository extends PagingAndSortingRepository<HelpdeskTicket, Integer> {

    HelpdeskTicket save(HelpdeskTicket helpdeskTicket);
}
