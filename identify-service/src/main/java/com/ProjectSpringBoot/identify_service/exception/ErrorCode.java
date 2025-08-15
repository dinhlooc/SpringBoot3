package com.ProjectSpringBoot.identify_service.exception;

public enum ErrorCode {
    UNCATEGORiZED_EXCEPTION(1002, "uncategoied_exception"),
    INVALID_KEY(1000, "Invalid key"),
    USER_EXIST(1001, "User_existed"),
    USER_NOT_FOND(1002, "Not Fond"),
    USERNAME_INVALID(1003, "Username must be at least 3 character"),
    PASSWORD_INVALID(1004, "Password must be at least 8 character")

    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
