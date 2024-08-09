package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

@WebServlet("/MarksheetListCtl")
public class MarksheetListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pageNo = 1;

		int pageSize = 5;

		MarksheetModel model = new MarksheetModel();

		try {
			List list = model.search(null, pageNo, pageSize);
			List nextList = model.search(null, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("MarksheetListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		String name = req.getParameter("name");
		String rollNo = req.getParameter("rollNo");

		int pageNo = 1;

		pageNo = Integer.parseInt(req.getParameter("pageNo"));

		int pageSize = 5;

		MarksheetBean bean = null;

		MarksheetModel model = new MarksheetModel();

		if (op.equals("search")) {
			bean = new MarksheetBean();
			bean.setName(name);
			if (rollNo != "") {
				System.out.println("roll = " + rollNo);
				bean.setRollNo(Integer.parseInt(rollNo));
			}
		}

		if (op.equals("previous")) {
			pageNo--;
		}

		if (op.equals("next")) {
			pageNo++;
		}

		if (op.equals("add")) {
			resp.sendRedirect("MarksheetCtl");
		}

		if (op.equals("delete")) {
			pageNo = 1;
			String[] ids = req.getParameterValues("ids");

			if (ids != null && ids.length > 0) {
				for (String id : ids) {

					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				req.setAttribute("msg", "select atleast one marksheet..!!");
			}
		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("MarksheetListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}