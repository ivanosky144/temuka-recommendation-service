@Node("UniversityNode")
public class UniversityNode {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;

    @Relationship()
    private List<MajorNode> majors;
}