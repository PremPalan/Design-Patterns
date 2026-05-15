package com.ram.Facade.example;

interface Menu{
    void content();
}

class VegMenu implements Menu{

    @Override
    public void content() {
        System.out.println("Veg Menu");
    }
}

class NonVegMenu implements Menu{

    @Override
    public void content() {
        System.out.println("NonVeg Menu");
    }
}

class VegNonBothMenu implements Menu{

    @Override
    public void content() {
        System.out.println("Veg and Non Veg Menu");
    }
}

interface Hotel{
    Menu getMenus();
}

class VegRestaurant implements Hotel{
    @Override
    public Menu getMenus() {
        return new VegMenu();
    }
}

class NonVegRestaurant implements Hotel{
    @Override
    public Menu getMenus() {
        return new NonVegMenu();
    }
}

class VegNonBothRestaurant implements Hotel{
    @Override
    public Menu getMenus() {
        return new VegNonBothMenu();
    }
}

interface HotelKeeper{
    VegMenu getVegMenu();
    NonVegMenu getNonVegMenu();
    VegNonBothMenu getVegNonMenu();
}

class HotelKeeperImplementation implements HotelKeeper {

    public VegMenu getVegMenu()
    {
        VegRestaurant v = new VegRestaurant();
        return (VegMenu)v.getMenus();
    }

    public NonVegMenu getNonVegMenu()
    {
        NonVegRestaurant v = new NonVegRestaurant();
        return (NonVegMenu)v.getMenus();
    }

    public VegNonBothMenu getVegNonMenu()
    {
        VegNonBothRestaurant v = new VegNonBothRestaurant();
        return (VegNonBothMenu)v.getMenus();
    }
}

public class Main {
    public static void main (String[] args)
    {
        HotelKeeper keeper = new HotelKeeperImplementation();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        VegNonBothMenu both = keeper.getVegNonMenu();
        v.content();
        nv.content();
        both.content();
    }
}
