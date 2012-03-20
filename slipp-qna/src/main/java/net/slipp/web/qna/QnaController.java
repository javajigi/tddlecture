package net.slipp.web.qna;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.slipp.domain.qna.QnaService;
import net.slipp.domain.qna.Question;
import net.slipp.domain.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/qna")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Resource (name = "qnaService")
	private QnaService qnaService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("questions", qnaService.findsQuestion());
		model.addAttribute("tags", qnaService.findsTag());
		return "qna/list";
	}
	
	@RequestMapping("/form")
	public String createForm(HttpServletRequest request, Model model) {
		User user = getLoginUser(request);
		if (user == null) {
			return "redirect:/user/login.jsp";
		}
		model.addAttribute(new Question());
		return "qna/form";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(HttpServletRequest request, Question question) {
		logger.debug("Question : {}", question);
		
		User user = getLoginUser(request);
		if (user == null) {
			return "redirect:/user/login.jsp";
		}
		qnaService.createQuestion(user, question);
		return "redirect:/qna";
	}
	
	@RequestMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, HttpServletRequest request, Model model) {
		User user = getLoginUser(request);
		if (user == null) {
			return "redirect:/user/login.jsp";
		}
		model.addAttribute("question", qnaService.findByQuestionId(id));
		return "qna/form";
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public String update(HttpServletRequest request, Question question) {
		logger.debug("Question : {}", question);
		User user = getLoginUser(request);
		if (user == null) {
			return "redirect:/user/login.jsp";
		}
		qnaService.updateQuestion(user, question);
		return "redirect:/qna";
	}
	
	@RequestMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("question", qnaService.findByQuestionId(id));
		return "qna/show";
	}
	
	private User getLoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (User)session.getAttribute("user");
	}
}
