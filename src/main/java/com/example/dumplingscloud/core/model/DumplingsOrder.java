package com.example.dumplingscloud.core.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DumplingsOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Dumplings> dumplings = new ArrayList<>();

    public void addDumplings(Dumplings dumplings) {
        this.dumplings.add(dumplings);
    }
}
