package com.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDates {

    private String checkin;
    private  String checkout;

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

}
