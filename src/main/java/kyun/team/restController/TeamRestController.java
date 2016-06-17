package kyun.team.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kyun.team.model.Team;
import kyun.team.service.TeamService;

@Controller
@RequestMapping(value="/api")
public class TeamRestController {

	@Autowired
	TeamService teamService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Team> getTeams(){
		List<Team> teams = teamService.getTeams();
		
		return teams;
	}
}
