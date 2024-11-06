package com.example.product.respone;

public class ResponseMessage {
	
	private String message;
    private boolean success;

    public ResponseMessage(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public static ResponseMessage success() {
        return new ResponseMessage("Operation completed successfully", true);
    }

    public static ResponseMessage failure() {
        return new ResponseMessage("Operation failed", false);
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

}
