package com.douzone.container.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class HighSchoolRapper2Final implements CompactDisc {

	private String artist ="김하온";
	private String title = "붕붕";
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing "+title+" by "+ artist);
	}

}
