package in.priya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.priya.binding.Customer;

@RepositoryRestResource(path = "costomer")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findByName(@Param("name") String name);

}
