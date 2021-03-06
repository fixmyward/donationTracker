package edu.gatech.cs2340.donationtracker;

class Item {

    private String timestamp;
    private Location location;
    private String shortDesc;
    private String fullDesc;
    private double dollarValue;
    private Category category;
    private String comment;

    /**
     * This method creates an item with the given parameters
     *
     * @param timestamp the timestamp of the item's creation
     * @param location the location of the item's availability
     * @param shortDesc the short description of the item
     * @param fullDesc the full description of the item
     * @param dollarValue the dollar value of the item
     * @param category the category the item falls under
     */
    public Item (String timestamp, Location location, String shortDesc, String fullDesc, Double dollarValue, Category category, String comment) {
        this.timestamp = timestamp;
        this.location = location;
        this.shortDesc = shortDesc;
        this.fullDesc = fullDesc;
        this.dollarValue = dollarValue;
        this.category = category;
        this.comment = comment;
    }

    public Item() {}

    /**
     * This method gets and returns the timestamp for
     * the item's creation.
     *
     * @return the timestamp for the item's creation.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * This method sets the timestamp for the item's
     * creation.
     *
     * @param timestamp a time in which the item was created
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * The method gets and returns the location
     * for this item.
     *
     * @return the location at which the item is available
     */
    public Location getLocation() {
        return location;
    }

    /**
     * This method sets the location for the item.
     *
     * @param location a location at which the item
     *                 is available
     */
    public void setLocation(Location location) { this.location = location; }

    /**
     * This method gets and returns the short
     * description about the item.
     *
     * @return the shortDesc about the item
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * This method sets the short description about an item
     *
     * @param shortDesc a short description about an item
     */
    public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

    /**
     * This method gets and returns a full description
     * about the item.
     *
     * @return the fullDesc about the item
     */
    public String getFullDesc() {
        return fullDesc;
    }

    /**
     * This method sets the full description about
     * an item.
     *
     * @param fullDesc a full description about an item
     */
    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    /**
     * This method gets and returns the dollar
     * value of the item.
     *
     * @return dollarValue the dollar value of the item
     */
    public Double getDollarValue() {
        return dollarValue;
    }

    /**
     * This method returns sets the dollar value of the item
     *
     * @param dollarValue a dollar value for the item
     */
    public void setDollarValue(double dollarValue) {
        this.dollarValue = dollarValue;
    }

    /**
     * This method gets and returns the category the item
     * falls under
     *
     * @return category the category that an item falls under
     */
    public Category getCategory() {
        return category;
    }

    /**
     * This method returns the comment
     *
     * @return comment
     */
    public String getComment() {return comment;}

    /**
     * This method represent the item in the form
     * of a String using the short description
     *
     * @return shortDesc the short description of an item
     */
    @Override
    public String toString() {
        return shortDesc;
    }
}