package spring.boot.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.boot.webservice.domain.posts.Posts;
import spring.boot.webservice.domain.posts.PostsRepository;
import spring.boot.webservice.domain.posts.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
	

	@Autowired
	private PostsService postService;
	
	@Autowired
	private PostsRepository postsRepository;

	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void dto_save_into_posts_table() {
		//given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
            .author("jojoldu@gmail.com")
            .content("테스트")
            .title("테스트 타이틀")
            .build();
        
        //when
        postService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
 
		
	}
}
