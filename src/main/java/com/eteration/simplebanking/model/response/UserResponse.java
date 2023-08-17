package com.eteration.simplebanking.model.response;

import com.eteration.simplebanking.model.User;

public class UserResponse {
    private String message;
    private Boolean success;
    private User data;
    public UserResponse(String message, boolean success,User data) {
        this.message=message;
        this.success=success;
        this.data=data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
