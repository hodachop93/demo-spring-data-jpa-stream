package com.benjamintanone.springdatajpademojava.repositories;

import com.benjamintanone.springdatajpademojava.domain.Campaign;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "campaigns")
public interface CampaignRepository extends PagingAndSortingRepository<Campaign, Long> {
}
