package com.socialmedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.config.NotificationProducer;
import com.socialmedia.model.Post;
import com.socialmedia.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private NotificationProducer notificationProducer;

	public Post createPost(Post post) {
		Post savedPost = postRepository.save(post);

		// Send a notification to followers or related users
		String message = "User " + post.getUser().getUsername() + " has created a new post.";
		notificationProducer.sendNotification(message);

		// Return the saved post
		return savedPost;
	}

	public List<Post> getUserPosts(Long userId) {
		return postRepository.findByUserId(userId);
	}

	public Optional<Post> getPostById(Long id) {
		return postRepository.findById(id);
	}

	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
}
