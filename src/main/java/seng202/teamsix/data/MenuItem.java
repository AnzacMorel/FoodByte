package seng202.teamsix.data;

import javax.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class MenuItem {
    @XmlElement
    private Item_Ref item;
    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement
    private double price;

    /**
     * Sets the price of item
     * @param price the price of the item to be displaued to the menu
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the price of the item in the menu
     * @return the price of the item in the menu
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the name of the menu item.
     * @return String name of the item to be added to the menu.
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the name of the menu item.
     * @param name String name of the item to be added to the menu.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the menu item.
     * @return String description of the item to be added to the menu.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the menu item.
     * @param description String description of the item to be added to the menu.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the item reference
     * @param item item reference to be added to the menu
     */
    public void setItem(Item_Ref item) {
        this.item = item;
    }

    /**
     * Gets the item reference
     * @return Item_Ref item, which is the reference of the item
     */
    public Item_Ref getItem() {
        return item;
    }

}

