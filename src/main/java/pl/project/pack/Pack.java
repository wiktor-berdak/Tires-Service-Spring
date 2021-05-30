package pl.project.pack;

import pl.project.user.User;

import javax.persistence.*;

@Entity

public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pack_id;
    private PackType pack_type;
    private int position;

    @ManyToOne

    private User user_id;

    public Pack() {
    }

    public Pack(PackType pack_type, int position, User user_id) {
        this.pack_type = pack_type;
        this.position = position;
        this.user_id = user_id;
    }

}
