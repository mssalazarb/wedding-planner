package com.planner.wedding.wedding.domain.ports.in;

import com.planner.wedding.wedding.domain.model.UserSystem;

public interface UserService {
    UserSystem create(UserSystem userSystem);
}
