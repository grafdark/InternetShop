package by.romanov.is.tags;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


@SuppressWarnings("serial")
public class InfoTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		GregorianCalendar gc = new GregorianCalendar();
		String time = "Time : <b> " + gc.getTime() + " </b><br/>";
		String locale = " <b>InternetShop © Евгений Романов </b> ";
		try {
			JspWriter out = pageContext.getOut();
			out.write(time + locale);
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
