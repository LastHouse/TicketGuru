package fi.rbmk.ticketguru.postcode;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostcodeRepository extends CrudRepository<Postcode, Long> {

	// List<Postcode> findByPostcode_ID(String postcode_ID);
}