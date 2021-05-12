package spring.boot.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import spring.boot.webservice.domain.posts.PostsRepository;
import spring.boot.webservice.domain.posts.PostsSaveRequestDto;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsRepository postsRepository;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld"; 
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity()); 
	}
}
