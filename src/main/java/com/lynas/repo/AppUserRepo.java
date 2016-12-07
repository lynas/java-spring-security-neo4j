package com.lynas.repo;

import com.lynas.model.AppUser;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lynas on 12/6/2016
 */
public interface AppUserRepo extends GraphRepository<AppUser> {
    AppUser findByUsername(String username);
}
