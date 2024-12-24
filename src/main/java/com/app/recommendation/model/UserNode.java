@Node("UserNode")
public class UserNode {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship()
    private List<UserNode> friends;

    @Relationship()
    private List<UniversityNode> likedUniversities;

    @Relationship()
    private List<MajorNode> interestedMajor;
}