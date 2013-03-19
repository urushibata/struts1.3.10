package com.urushibata.struts1.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.*;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.urushibata.struts1.businessLogic.UserAuthentication;
import com.urushibata.struts1.dto.LoginDTO;
import com.urushibata.struts1.form.LoginFormBean;

public class LoginAction extends MappingDispatchAction{
	private LoginFormBean lf;
	public LoginDTO dto = new LoginDTO();
	/*
	 * デフォルト
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
													HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login action init !!");
		return mapping.findForward("success");
	}

	/*
	 * ログイン
	 */
	public ActionForward authentication(ActionMapping mapping, ActionForm form,
													HttpServletRequest req, HttpServletResponse res) throws SQLException {
		/*
		 * 認証ビジネスロジック
		 */
		System.out.println("login action authentication !!");
		String result ="";
		ActionMessages ams = new ActionMessages();
		ActionMessage msg;

		lf = (LoginFormBean)form;
		copyActionForm(lf);
		UserAuthentication ut = new UserAuthentication(dto);
		result = ut.authentication();
		if(result == "failure"){
			msg = new ActionMessage("ＩＤまたはパスワードが違います。");
			ams.add(ActionMessages.GLOBAL_MESSAGE, msg);
			super.saveErrors(req, ams);
		}

		return mapping.findForward(result);
	}

	/*
	 * ActionFormをDTOにセット
	 */
	private void copyActionForm(LoginFormBean lf){
		this.dto.setUserId(lf.getUserId());
		this.dto.setUserPassword(lf.getUserPassword());
	}
}
