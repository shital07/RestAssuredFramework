package com.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;



@Builder
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private String firstname;
    private String lastname;
    private int totalprice;

    private boolean depositpaid;

    private BookingDates bookingdates;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }


    public static class BookingBuilder{

        private String firstname;
        private String lastname;
        private int totalprice;

        private boolean depositpaid;

        private BookingDates bookingdates;
        private String additionalneeds;

        public BookingBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public BookingBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public BookingBuilder setTotalprice(int totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public BookingBuilder setDepositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }

        public BookingBuilder setBookingdates(BookingDates bookingdates) {
            this.bookingdates = bookingdates;
            return this;
        }

        public BookingBuilder setAdditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
            return this;
        }


        public static BookingBuilder builder(){
            return new BookingBuilder();
        }

        public Booking build(){

            return new Booking(firstname,lastname,totalprice,depositpaid,bookingdates,additionalneeds);
        }
    }



}
