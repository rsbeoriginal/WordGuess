package com.rsp.rishi;

public class Info {
	
	static boolean startcareer=true;
	static boolean car = false;
	static String car_name = "NIL";
	static int car_scene=0;
	static int car_level = 0;
	static int level_1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int err_no = 0;
	static boolean name_dialog = false;
	static boolean word_dialog = false;
	static boolean play = false, challenge = false, career = false;
	static String fpuzzle, lpuzzle, description, puzzle;
	static int gateway;
	static String[] word = { "Sprint", "Original", "Trick", "Villain",
			"Adventure", "Minister", "Brave", "Martyr", "Camera", "Camcorder",
			"Hospital", "Generator", "Manager", "Dance", "Orator", "Planet",
			"Plant", "Phobia", "Zoology", "Botany", "Poverty", "Powder",
			"Servant", "Slave", "Sleep", "Slide", "Slip", "Mob", "Sky",
			"Surplus", "Surrender", "Terror", "Rules", "Rugby", "Tactic",
			"Transport", "Theology" };
	static String[] des = {
			"Running very fast",
			"the earliest form of something, from which copies may be made",
			"to deceive or outwit someone",
			"(in a film, novel, or play) a character whose evil actions or motives are important to the plot",
			"an unusual and exciting or daring experience",
			"person who is in charge of a particular government department",
			"willing to do things which are dangerous, and does not show fear in difficult or dangerous situations",
			"someone who is killed or made to suffer greatly because of their religious or political beliefs, and is admired and respected by people who share those beliefs",
			"equipment that is used for taking photographs",
			"portable video camera which records both pictures and sound",
			"place where people who are ill are looked after by nurses and doctors",
			"a machine which produces electricity",
			"a person who is responsible for running part of or the whole of a business organization",
			"moving body and feet in a way which follows a rhythm, usually in time to music",
			"someone who is skilled at making formal speeches, especially ones which affect people's feelings and beliefs",
			"large, round object in space that moves around a star",
			"living thing that grows in the earth and has a stem, leaves, and roots",
			"very strong irrational fear or hatred of something",
			"scientific study of animals",
			"scientific study of plants",
			"state of being extremely poor",
			"consists of many tiny particles of a solid substance",
			"someone who is employed to work at another person's home",
			"someone who is the property of another person and has to work for that person",
			"natural state of rest in which your eyes are closed, your body is inactive, and your mind does not think",
			"moveing smoothly over or against something",
			"accidentally slide and lose your balance",
			"large, disorganized, and often violent crowd of people",
			"space around the earth which you can see when you stand outside and look upwards",
			"used to describe something that is extra or that is more than is needed",
			"to give up during fight",
			"very great fear",
			"instructions that tell you what you are allowed to do and what you are not allowed to do",
			"game played by two teams using an oval ball",
			"method that you choose to use in order to achieve what you want in a particular situation",
			"system for taking people or goods from one place to another",
			"the study of the nature of God and religious belief" };

	static String[] fname = { "Steve", "Abraham", "Bill", "Mahatma", "Mother",
			"Charles", "Albert", "Nelson", "Pablo", "Walt", "Oscar", "Lionel",
			"Babe", "Usain", "Roger", "Anne", "Larry", "Sergey", "Marie" };
	static String[] lname = { "Jobs", "Lincoln", "Gates", "Gandhi", "Teresa",
			"Darwin", "Einstein", "Mandela", "Picasso", "Disney", "Wilde",
			"Messi", "Ruth", "Bolt", "Federer", "Frank", "Page", "Brin",
			"Curie" };
	static String[] des_name = { "former CEO of Apple Inc.",
			"US President during American civil war",
			"American businessman, founder of Microsoft",
			"Leader of Indian independence",
			"Catholic missionary nun / charity worker",
			"British scientist proposed theory of evolution",
			"German scientist proposed theory of relativity",
			"South African President anti-apartheid campaigner",
			"Spanish modern artist", "American film producer",
			"Irish author, poet, playwright", "Argentinian footballer",
			"American baseball player",
			"Jamaican athlete. Record holder at 100m and 200m",
			"Swiss Tennis player", "Dutch Jewish author who died in Holocaust",
			"American co-founder of Google", "Russian co-founder of Google",
			"Polish / French scientist" };

	static String[] correct_comments = { "Great Going ...",
			"Your Guessing is Great!", "Yeah! you Got it!", "You're AWESOME!" };
	static String[] wrong_comments = { "Better Luck Next Time!", "Hard Luck!",
			"Wrong Guess.." };

}
