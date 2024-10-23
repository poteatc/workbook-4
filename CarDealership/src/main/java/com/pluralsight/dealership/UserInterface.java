package com.pluralsight.dealership;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {

    }

    private void init() {
        dealership = new DealershipFileManager().getDealership();
    }

    public void display() {
        init();
    }

    public void processGetByPriceRequest() {}
    public void processGetByMakeModelRequest() {}
    public void processGetByYearRequest() {}
    public void processGetByColorRequest() {}
    public void processGetByMileageRequest() {}
    public void processGetByVehicleTypeRequest() {}
    public void processGetAllVehiclesRequest() {}
    public void processAddVehicleRequest() {}
    public void processRemoveVehicleRequest() {}
}
