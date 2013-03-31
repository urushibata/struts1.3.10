package com.urushibata.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

import com.urushibata.struts1.Service.UserAuthentication;
import com.urushibata.struts1.common.MassageGroup;
import com.urushibata.struts1.dto.LoginDTO;
import com.urushibata.struts1.form.LoginFormBean;
import com.urushibata.struts1.form.MenuFormBean;

import java.sql.SQLException;

public class LoginAction extends MappingDispatchAction{
	private LoginFormBean lf;
	private MenuFormBean mf;
	private LoginDTO dto;

	/*
	 * 表示
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
													HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login action init !!");
		return mapping.findForward("success");
	}

	/*
	 * ログイン認証
	 */
	public ActionForward authentication(ActionMapping mapping, ActionForm form,
													HttpServletRequest req, HttpServletResponse res) throws SQLException {
		System.out.println("login action authentication !! START");
		String result ="";
		ActionMessages ams = new ActionMessages();
		ActionMessage msg;

		//ActionFormをDTOにコピーする。
		lf = (LoginFormBean)form;
		dto = new LoginDTO();
		copyDTO();

		//ユーザ認証
		UserAuthentication ut = new UserAuthentication(dto);
		result = ut.authentication();
		if(result == "failure"){
			msg = new ActionMessage("ＩＤまたはパスワードが違います。");
			ams.add(MassageGroup.CORRELATION, msg);
			super.saveErrors(req, ams);
		}

		//ActionFormにユーザ情報をコピーする。
		mf = new MenuFormBean();
		copyActionForm();
		//リクエストに格納
		req.setAttribute("MenuFormBean", mf);

		System.out.println("login action authentication !! END");
		return mapping.findForward(result);
	}

	/*
	 * ActionFormをDTOにコピー
	 */
	private void copyDTO(){
		this.dto.setUserId(lf.getUserId());
		this.dto.setUserPassword(lf.getUserPassword());
	}

	/*
	 * DTOをActionFormにコピー
	 */
	private void copyActionForm(){
		mf = new MenuFormBean();
		this.mf.setUserName(this.dto.getVO().getUserName());
		this.mf.setAddress(this.dto.getVO().getAddress());
		this.mf.setMail(this.dto.getVO().getMail());
		this.mf.setCompanyName(this.dto.getVO().getCompanyName());
		this.mf.setEmployeeNo(this.dto.getVO().getEmployeeNo());
	}
}