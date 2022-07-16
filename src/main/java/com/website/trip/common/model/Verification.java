package com.website.trip.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Verification {

    private boolean result;
    private String message;

    public static Verification success() {
        return new Verification(true, "");
    }

    public static Verification fail(String message) {
        return new Verification(false, message);
    }

    public boolean isSuccess() {
        return result;
    }

    public boolean isFail() {
        return !result;
    }


}
