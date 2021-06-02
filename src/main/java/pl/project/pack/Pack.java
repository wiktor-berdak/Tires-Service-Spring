package pl.project.pack;

import org.springframework.lang.Nullable;
import pl.project.user.User;

import javax.persistence.*;

@Entity

public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packId;
    private PackType packType;
    @Nullable
    private int position;
    @Nullable
    private boolean isPackToWarehouse;
    @ManyToOne
    private User user;

    public Pack() {
    }

    public Pack(PackType packType, int position, User user) {
        this.packType = packType;
        this.position = position;
        this.user = user;
    }

    public boolean isPackToWarehouse() {
        return isPackToWarehouse;
    }

    public void setPackToWarehouse(boolean packToWarehouse) {
        isPackToWarehouse = packToWarehouse;
    }

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    public PackType getPackType() {
        return packType;
    }

    public void setPackType(PackType packType) {
        this.packType = packType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }
}
