package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddGroupeValidationForm;
import org.lip6.struts.service.GroupeService;

public class AddGroupeAction extends Action
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,
			final HttpServletRequest pRequest,final HttpServletResponse pResponse)
	{
		final AddGroupeValidationForm lForm=(AddGroupeValidationForm)pForm;
		final String name = lForm.getName();

        // create a new Groupe
		final GroupeService groupeService = new GroupeService();
		final String lError = groupeService.addGroupe(name);
		if(lError == null)
		{
			// if no exception is raised, forward "success" return pMapping.findForward("success");
			return pMapping.findForward("success");
		}
		else
		{
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
