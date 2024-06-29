package com.planner.wedding.wedding.domain.ports.out;

import com.planner.wedding.wedding.domain.model.UserSystem;

public interface UserRepository {
    UserSystem create(UserSystem userSystem);

    Boolean existUser(String userName);
}
