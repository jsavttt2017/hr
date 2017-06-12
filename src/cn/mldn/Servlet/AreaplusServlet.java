package cn.mldn.Servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import cn.mldn.service.Factory.ServiceFactory;
import cn.mldn.vo.Areaplus;

@WebServlet(urlPatterns = "/AreaplusServlet")
public class AreaplusServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		int aid  = Integer.parseInt(request.getParameter("aid"));
		try {
			List<Areaplus> all = ServiceFactory.getIAreaplusServiceInstance().listByArea(aid);
			Iterator<Areaplus> iter = all.iterator();
			Document document = DocumentHelper.createDocument();
			Element allAreaplusesElement = document.addElement("allAreapluses");
			while(iter.hasNext()){
				Areaplus area = iter.next();
				Element areaplusElement = allAreaplusesElement.addElement("areaplus");
				Element apidElement = areaplusElement.addElement("apid");
				Element titleElement = areaplusElement.addElement("title");
				apidElement.setText(String.valueOf(area.getApid()));
				titleElement.setText(area.getTitle());
			}
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter out = new XMLWriter(response.getWriter(), format);
			out.write(document);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
