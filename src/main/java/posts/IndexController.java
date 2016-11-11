package posts;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import posts.models.Post;
import posts.services.PostsService;

    @Controller
    public class IndexController {
   
    	
    	@Autowired
        private PostsService postsService;
    	
    	
        @RequestMapping(value = "/post", method = RequestMethod.POST)
        public String createPost(@RequestParam("text") String postText) {
            postsService.addPost(new Post("Unknown", postText, new Date()));
            return "redirect:home";
        }
    	
        /*@RequestMapping("/home")
           public String index() {
               return "index";
           }
           */
        
        @RequestMapping("/home")
        public String index(Model model) {
            model.addAttribute("posts", postsService.getRecentPosts());
            return "index";
        }  
        

    }