package com.hussain.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hussain.demo.dao.AlienRepo;
import com.hussain.demo.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("hey");
		return "home.jsp";
	}
	
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien){
		//saving to h2
		repo.save(alien);
		System.out.println(alien+" added");
		
		
		//saving to myfile.txt
		FileWriter writer=null;
		try {
			writer=new FileWriter("myfile.txt",true);
			writer.write(alien.toString()+"\r\n");
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
			writer.close();
			}catch(Exception e) {	e.printStackTrace();	}
		}
		
		
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int id){
		ModelAndView mv=new ModelAndView();
		Alien alien=repo.findById(id).orElse(new Alien());
		mv.setViewName("showAlien.jsp");
		mv.addObject("alien", alien);
		
		
		FileReader reader=null;
		BufferedReader bufferedReader=null;
		try {
			reader=new FileReader("myfile.txt");
			bufferedReader = new BufferedReader(reader);
			String line,data="";
			line=bufferedReader.readLine();
			while(line!=null && line.length()!=0) {
				data+=line+"<br>";
				line=bufferedReader.readLine();
			}
			mv.addObject("data", data);
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				reader.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		
		return mv;
	}
	
}
