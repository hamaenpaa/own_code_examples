using System;
using System.Windows.Forms;
using System.Drawing;


public class win:Form {

	Button[] b = new Button[10];
	Button bDot,bPlus,bSub,bMul,bDiv,bEqu,bClr;
	Panel panCalc;
	TextBox txtCalc;
	
	Double dblAcc;
	Double dblSec;
	bool blnClear,blnFrstOpen;
	String strOper;
	
	public win() {
	   try {
		this.Text="Calculator";
		panCalc=new Panel();
		txtCalc = new TextBox();

		txtCalc.Location = new Point(10,10);
		txtCalc.Size=new Size(150,10);
		txtCalc.ReadOnly=true;
		txtCalc.RightToLeft=RightToLeft.Yes;
		panCalc.Size=new Size(200,200);
		panCalc.BackColor=Color.Aqua;
		panCalc.Controls.Add(txtCalc);
		addButtons(panCalc);
		this.Size=new Size(200,225);
		this.Controls.Add(panCalc);
		
		dblAcc=0;
		dblSec=0;
		blnFrstOpen=true;
		blnClear=false;
		strOper=new String('=',1);
	    }
	    catch (Exception e) {
		Console.WriteLine("error ......  " + e.StackTrace);
	    }
	}
	
	private void addButtons(Panel p) {
		for (int i=0;i<=9;i++) {
			b[i]=new Button();
			b[i].Text=Convert.ToString(i);
			b[i].Size=new Size(25,25);
			b[i].BackColor=Color.White;
			b[i].Click+=new EventHandler(btn_clk);
			p.Controls.Add(b[i]);	
		}
		b[0].Location=new Point(10,160);
		b[1].Location=new Point(10,120);
		b[4].Location=new Point(10,80);
		b[7].Location=new Point(10,40);
		
		b[2].Location=new Point(50,120);
		b[5].Location=new Point(50,80);
		b[8].Location=new Point(50,40);
		
		b[3].Location=new Point(90,120);
		b[6].Location=new Point(90,80);
		b[9].Location=new Point(90,40);
		
		bDot=new Button();
		bDot.Size=new Size(25,25);
		bDot.Location=new Point(50,160);
		bDot.BackColor=Color.White;
		bDot.Text=".";
		bDot.Click+=new EventHandler(btn_clk);
		
		bPlus=new Button();
		bPlus.Size=new Size(25,25);
		bPlus.Location=new Point(130,160);
		bPlus.BackColor=Color.White;
		bPlus.Text="+";
		bPlus.Click+=new EventHandler(btn_Oper);
		
		bSub=new Button();
		bSub.Size=new Size(25,25);
		bSub.Location=new Point(130,120);
		bSub.BackColor=Color.White;
		bSub.Text="-";
		bSub.Click+=new EventHandler(btn_Oper);
		
		bMul=new Button();
		bMul.Size=new Size(25,25);
		bMul.Location=new Point(130,80);
		bMul.BackColor=Color.White;
		bMul.Text="*";
		bMul.Click+=new EventHandler(btn_Oper);
		
		bDiv=new Button();
		bDiv.Size=new Size(25,25);
		bDiv.Location=new Point(130,40);
		bDiv.BackColor=Color.White;
		bDiv.Text="/";
		bDiv.Click+=new EventHandler(btn_Oper);
		
		bEqu=new Button();
		bEqu.Size=new Size(25,25);
		bEqu.Location=new Point(90,160);
		bEqu.BackColor=Color.White;
		bEqu.Text="=";
		bEqu.Click+=new EventHandler(btn_equ);
		
		bClr=new Button();
		bClr.Size=new Size(20,45);
		bClr.Location=new Point(170,40);
		bClr.BackColor=Color.Orange;
		bClr.Text="AC";
		bClr.Click+=new EventHandler(btn_clr);

		p.Controls.Add(bDot);
		p.Controls.Add(bPlus);
		p.Controls.Add(bSub);
		p.Controls.Add(bMul);
		p.Controls.Add(bDiv);
		p.Controls.Add(bEqu);
		p.Controls.Add(bClr);
	}
	
	private void btn_clk(object obj,EventArgs ea) {
		if(blnClear)
			txtCalc.Text="";
		
		Button b3=(Button)obj;
		
		txtCalc.Text+=b3.Text;	
		
		if (txtCalc.Text==".")
			txtCalc.Text="0.";
		dblSec=Convert.ToDouble(txtCalc.Text);
		
		blnClear=false;
	}
	
	private static void Main() {
		Application.Run(new win());
	}
	
	private void btn_Oper(object obj,EventArgs ea) {
		Button tmp=(Button)obj;
		strOper=tmp.Text;
		if (blnFrstOpen)
			dblAcc=dblSec;
		else
			calc();

		blnFrstOpen=false;
		blnClear=true;
	}

	private void btn_clr(object obj,EventArgs ea) {
		clear();
	}

	private void btn_equ(object obj,EventArgs ea) {
		calc();
		
	}
	
	private void calc() {

		switch(strOper) {
		
			case "+":
				dblAcc+=dblSec;
				break;
			case "-":
				dblAcc-=dblSec;
				break;
			case "*":
				dblAcc*=dblSec;
				break;
			case "/":
				dblAcc/=dblSec;
				break;
		}
	
		strOper="=";
		blnFrstOpen=true;
		txtCalc.Text=Convert.ToString(dblAcc);
		dblSec=dblAcc;
	}
	
	private void clear() {
		dblAcc=0;
		dblSec=0;
		blnFrstOpen=true;
		txtCalc.Text="";
		txtCalc.Focus();

	}
}