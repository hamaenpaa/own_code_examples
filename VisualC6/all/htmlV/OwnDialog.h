// OwnDialog.h : Declaration of the COwnDialog

#ifndef __OWNDIALOG_H_
#define __OWNDIALOG_H_

#include "resource.h"       // main symbols
#include <atlhost.h>

/////////////////////////////////////////////////////////////////////////////
// COwnDialog
class COwnDialog : 
	public CAxDialogImpl<COwnDialog>
{
public:
	COwnDialog()
	{
	}

	~COwnDialog()
	{
	}

	enum { IDD = IDD_OWNDIALOG };

BEGIN_MSG_MAP(COwnDialog)
	MESSAGE_HANDLER(WM_INITDIALOG, OnInitDialog)
	COMMAND_ID_HANDLER(IDOK, OnOK)
	COMMAND_ID_HANDLER(IDCANCEL, OnCancel)
END_MSG_MAP()
// Handler prototypes:
//  LRESULT MessageHandler(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled);
//  LRESULT CommandHandler(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled);
//  LRESULT NotifyHandler(int idCtrl, LPNMHDR pnmh, BOOL& bHandled);

	LRESULT OnInitDialog(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled)
	{
		return 1;  // Let the system set the focus
	}

	LRESULT OnOK(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled)
	{
		EndDialog(GetDlgItemInt(IDC_LUKU1)*GetDlgItemInt(IDC_LUKU2));
		return 0;
	}

	LRESULT OnCancel(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled)
	{
		EndDialog(wID);
		return 0;
	}
};

#endif //__OWNDIALOG_H_
