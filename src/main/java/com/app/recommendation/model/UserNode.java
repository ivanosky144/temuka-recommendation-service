@Node("UserNode")
public class UserNode {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private List<UserNode> friends;

    @Relationship(type = "LIKES", direction = Relationship.Direction.OUTGOING)
    private List<UniversityNode> likedUniversities;

    @Relationship(type = "INTERESTED_IN", direction = Relationship.Direction.OUTGOING)
    private List<MajorNode> interestedMajor;
}