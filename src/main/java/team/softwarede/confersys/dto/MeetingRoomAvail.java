/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Mity1299
 *
 */
public class MeetingRoomAvail {

    private Integer id;

    private Integer capacity;

    private String roomNumber;
    
    private Integer floor;

    private String building;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    
}
