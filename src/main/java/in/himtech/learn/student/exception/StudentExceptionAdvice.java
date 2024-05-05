package in.himtech.learn.student.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class StudentExceptionAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView resourceNotFoundExp(ResourceNotFoundException exp, WebRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("excep", exp.getMessage());
		mv.setViewName("error");
		return mv;
	}

}
