package week8.day2;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyTeamController {

    @RequestMapping(value = "myTeam", produces = "application/json; charset=utf-8")  // text/json
    @ResponseBody
    public TeamDTO getTeamInfo() {
        TeamMemberVO teamMemberVO1 = new TeamMemberVO("김주영", "박주영", "치킨");
        TeamMemberVO teamMemberVO2 = new TeamMemberVO("김태현", "없음", "햄버거");
        TeamMemberVO teamMemberVO3 = new TeamMemberVO("신다인", "프신", "떡볶이");
        TeamMemberVO teamMemberVO4 = new TeamMemberVO("최정우", "하정우", "치킨");
        ArrayList<TeamMemberVO> teamMemberVOS = new ArrayList<>();
        teamMemberVOS.add(teamMemberVO1);
        teamMemberVOS.add(teamMemberVO2);
        teamMemberVOS.add(teamMemberVO3);
        teamMemberVOS.add(teamMemberVO4);
        return new TeamDTO("wish", teamMemberVOS);
    }
}
