package Service;

import Repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpdeskTicketService {
    @Autowired
    TicketingRepository ticketingRepository;


}
