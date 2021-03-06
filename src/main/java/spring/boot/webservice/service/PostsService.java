package spring.boot.webservice.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import spring.boot.webservice.domain.posts.PostsRepository;
import spring.boot.webservice.domain.posts.PostsSaveRequestDto;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
}
