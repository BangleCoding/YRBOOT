package spring.boot.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.webservice.domain.posts.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long>{

}
