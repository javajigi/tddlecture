package net.slipp.domain.qna;

import java.util.Date;

import javax.annotation.Resource;

import net.slipp.domain.user.User;
import net.slipp.repository.qna.QuestionRepository;
import net.slipp.repository.qna.TagRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("qnaService")
@Transactional
public class QnaService {
	@Resource (name = "tagRepository")
	private TagRepository tagRepository;
	
	@Resource (name = "questionRepository")
	private QuestionRepository questionRepository;
	
	public void createQuestion(User user, Question question) {
		question.setWriterId(user.getUserId());
		question.setWriterName(user.getName());
		question.setCreatedDate(new Date());
		question.initializeTags(tagRepository);
		questionRepository.save(question);
	}
	
	public Iterable<Question> findsQuestion() {
		return questionRepository.findAll();
	}
	
	public Iterable<Tag> findsTag() {
		return tagRepository.findAll();
	}
}
