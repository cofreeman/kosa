package week8.day2;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TeamDTO {
    private String teamName;
    private List<TeamMemberVO> teamMember;
}
