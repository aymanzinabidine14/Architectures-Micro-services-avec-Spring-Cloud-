package org.sid.costumerservice.repositories;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.sid.costumerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
