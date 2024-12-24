@Node("UniversityNode")
public class UniversityNode {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;

    @Relationship(type = "HAS_MAJOR", direction = Relationship.Direction.OUTGOING)
    private List<MajorNode> majors;
}