package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testRead();
		// testFindByPk();
		testSearch();

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		
		bean.setRoll_no(115);
		bean.setName("dharam");
		bean.setPhysics(10);
		bean.setChemistry(20);
		bean.setMathematics(30);

		MarskheetModel model = new MarskheetModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		
		bean.setRoll_no(113);
		bean.setName("khush");
		bean.setPhysics(10);
		bean.setChemistry(20);
		bean.setMathematics(30);

		MarskheetModel model = new MarskheetModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {

		MarskheetModel model = new MarskheetModel();
		model.delete(13);

	}

	public static void testRead() throws Exception {

		MarskheetModel model = new MarskheetModel();
		model.read();

	}

	public static void testFindByPk() throws Exception {

		MarskheetModel model = new MarskheetModel();
		MarksheetBean bean = model.findByPk(19);

		if (bean != null) {
			
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMathematics());
		} else {
			System.out.println("id not found");
		}

	}

	public static void testSearch() throws Exception {

		MarskheetModel model = new MarskheetModel();

		List list = model.search();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			MarksheetBean bean = (MarksheetBean) it.next();
			
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMathematics());

		}

	}
}
