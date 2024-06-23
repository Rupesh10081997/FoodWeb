package com.main.dto.request;

import com.main.entities.Employee;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
public class EmployeeSpecification {

    public static Specification<Employee> getEmployeesByFilters(String name, String contactNo, String status ,String startDate,String endDate) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (StringUtils.hasText(name)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            if (StringUtils.hasText(contactNo)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("contactNo"), "%" + contactNo + "%"));
            }

            if (StringUtils.hasText(status)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
            }
          /*
            if (startDate != null && endDate != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.between(root.get("created_at"), startDate, endDate));
            }
         */
            return predicate;
        };
    }
}
