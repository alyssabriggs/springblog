package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.message.callback.PrivateKeyCallback;

@Controller
public class StringTransformController {

//    url = "/string/reverse/{string}"
//    returns = the string reversed
    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverse(@PathVariable String string){
        String newString = "";
        for(int i = string.length() - 1; i >= 0; i--)
        {
            newString = newString + (string.charAt(i));
        }
        return newString;
    }

//    url = "/string/uppercase/{string}"
//    returns = string in all uppercase letters
    @GetMapping("/string/uppercase/{string}")
    @ResponseBody
    public String uppercase(@PathVariable String string){
        return string.toUpperCase();
    }

//    url = "/string/both/string"
//    returns = string reversed in all caps (avoid repeating logic)
    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String both(@PathVariable String string){
        return uppercase(reverse(string));
    }



//     url = "/string/{string}" (with a query string)
//     returns = string reversed or in caps or both based on parameters passed to the Query string
    @GetMapping("/string/{string}")
    @ResponseBody
	public String either(@PathVariable String string, @RequestParam boolean reverse, @RequestParam boolean uppercase) {
	    if (reverse && uppercase){
		    return both(string);
		} else if (uppercase){
			return uppercase(string);
		} else if (reverse){
		    return reverse(string);
		} else {
			return string;
		}
    }

	@GetMapping("/{unknown}")
	@ResponseBody
	public String wildcard(@PathVariable String unknown){
		return "We haven't mapped that page out yet.";
	}

    @GetMapping("/wildcard/**")
	@ResponseBody
	public String wildcard(){
    	return "We haven't created a page for that yet.";
    }
}