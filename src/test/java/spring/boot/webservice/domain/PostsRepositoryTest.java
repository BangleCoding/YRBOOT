package spring.boot.webservice.domain;

import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.boot.webservice.domain.posts.Posts;
import spring.boot.webservice.domain.posts.PostsRepository;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postRepo; 
	
	@After
    public void cleanup() {
        /** 
        이후 테스트 코드에 영향을 끼치지 않기 위해 
        테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
        **/
		postRepo.deleteAll();
    }

	@Test
	public void board_load(){
	
		postRepo.save(Posts.builder()
				.title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postRepo.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
	}
	
	@Test
	public void BaseTimeEntity_register() {
		//given
		LocalDateTime now = LocalDateTime.now(); 
		postRepo.save(Posts.builder()
				.title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());
		
		//when
        List<Posts> postsList = postRepo.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
        
	}

}
