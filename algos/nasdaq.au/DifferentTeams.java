package com.nasdaq.au;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentTeams {

	public static void main(String[] args) throws IOException {
		System.out.println(differentTeams("pcmpcmbbbzz"));
	}

	static int differentTeams(String skills) {
		if (skills != null) {
			if (skills.length() >= 5 && skills.length() <= 500000) {
				
				char[] skillChars = skills.toCharArray();
				Teams teams = new Teams();
				for (char skill: skillChars) {
					teams.addSkill(skill);
				}
				return teams.getNoOfTeams();
			}
		}
		return 0;
    }
	
	public static class Teams {
		private List < Team > teams = new ArrayList<>();
		
		public int getNoOfTeams() {
			int fullTeams = 0;
			for (Team team : this.teams) {
				if (team.isTeamFull()) {
					fullTeams++;
				}
			}
			return fullTeams;
		}
		
		public void addSkill(Character skill) {
			Team team = this.getCandidateTeam(skill);
			team.addSkill(skill);
		}
		
		private Team getCandidateTeam(Character skill) {
			Team candidateTeam = null;
			if (this.teams.isEmpty()) {
				candidateTeam = new Team();
				this.teams.add(candidateTeam);
			} else {
				for (Team team : this.teams) {
					if (!team.isTeamFull()) {
						if (!team.hasSkill(skill)) {
							return team;
						}
					}
				}
			}
			if (candidateTeam == null) {
				candidateTeam = new Team();
				this.teams.add(candidateTeam);
			}
			return candidateTeam;
		}
	}

	public static class Team {
		private boolean isFull;
		private Map < Character, Integer > skills = new HashMap<>();
		
		public boolean isTeamFull() {
			return this.isFull;
		}

		public boolean hasSkill(Character skill) {
			return skills.get(skill) != null;
		}
		
		public void addSkill(Character skill) {
			skills.put(skill, 1);
			this.isFull = (skills.size() == 5);
		}
	}
}
