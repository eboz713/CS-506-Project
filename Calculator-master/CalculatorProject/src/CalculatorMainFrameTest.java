import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CalculatorMainFrameTest {
	
	//equateOperations ISP test 1
	@Test public void ISPBCC1()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		assertEquals(2, calc.equateOperations(1, 1, "+"));
	}
	
	//equateOperations ISP test 2
	@Test public void ISPBCC2()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		Long x = null;
		assertThrows(NullPointerException.class,() -> {calc.equateOperations(x, 1, "+");});
	}
	
	//equateOperations ISP test 3
	@Test public void ISPBCC3()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		Long x = null;
		assertThrows(NullPointerException.class,() -> {calc.equateOperations(x, 1, "+");});
	}
	
	//equateOperations ISP test 4
	@Test public void ISPBCC4()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		assertEquals(0, calc.equateOperations(1, 1, ""));
	}	
	
	//Equals button p1 row 2 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,46
	@Test public void eRACCp1r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("Can't divide by zero");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertFalse(calc.varSolved);
	}

	
	//Equals button RACC p1 row 3 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,46
	@Test public void eRACCp1r3() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("Error");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertFalse(calc.varSolved);
	}
	
		
	//Equals button RACC p1 row 4 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,64
	@Test public void eRACCp1r4() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.varSolved = false;
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertTrue(calc.varSolved);
	}	
	
		
	//Equals button RACC p2 row 1 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,48
	@Test public void eRACCp2r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertFalse(calc.varSolved);
	}		
		
	//Equals button RACC p2 row 2 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,64
	@Test public void eRACCp2r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.operator = "";
		calc.varPushed = false;
		calc.varSolved = false;
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		calc.actionPerformed(e);
		assertTrue(calc.varSolved);
	}	
		
	
	//Equals button RACC p2 row 3 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,64
	@Test public void eRACCp2r3() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertTrue(calc.varSolved);
	}
	
	
	//Equals button RACC p3 row 1 test
	//matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp3r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.varPushed = true;
		calc.varSolved = false;
		calc.leftValue = 1;
		calc.operator = "+";
		ButtonsPanel.resultField.setText("1");//sets rightValue = 1
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		calc.actionPerformed(e);
		assertEquals(2, calc.leftValue);
	}	
		
		
	//Equals button RACC p3 row 2 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,64
	@Test public void eRACCp3r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.rightValue = 1;
		calc.operator = "";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(1, calc.leftValue);
	}			
	
	
	//Equals button RACC p4 row 1 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,51,64
	@Test public void eRACCp4r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "/";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("0");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertTrue(ButtonsPanel.resultField.getText().equals("Can't divide by zero"));
	}
	
	
	//Equals button RACC p4 row 2 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp4r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "/";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(1, calc.leftValue);
	}
	
	
	//Equals button RACC p4 row 3 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp4r3() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("0");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(1, calc.leftValue);
	}
	
	
	
	//Equals button RACC p5 row 1 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,53,64
	@Test public void eRACCp5r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "%";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("0");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertTrue(ButtonsPanel.resultField.getText().equals("Error"));
	}
	
	
	//Equals button RACC p5 row 2 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp5r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "%";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(0, calc.leftValue);
	}
	
	
	//Equals button RACC p5 row 3 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp5r3() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("0");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(1, calc.leftValue);
	}
	
	
	//Equals button RACC p6 row 1 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp6r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.decimalButton.setSelected(true);
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(2, calc.leftValue);
	}	
	
	
	//Equals button RACC p6 row 2 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,61,62,63,64
	@Test public void eRACCp6r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.hexadecimalButton.setSelected(true);
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(2, calc.leftValue);
	}	
	

	//Equals button RACC p7 row 1 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,57,58,63,64
	@Test public void eRACCp7r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.binaryButton.setSelected(true);
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(2, calc.leftValue);
		assertTrue(ButtonsPanel.resultField.getText().equals("10"));
	}	
	
	
	//Equals button RACC p7 row 2 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp7r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.decimalButton.setSelected(true);
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(2, calc.leftValue);
	}	
	
	
	//Equals button RACC p8 row 1 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,59,60,63,64
	@Test public void eRACCp8r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.octalButton.setSelected(true);
		calc.leftValue = 5;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("5");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(10, calc.leftValue);
		assertTrue(ButtonsPanel.resultField.getText().equals("12"));
	}	
	
	
	//Equals button RACC p8 row 2 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp8r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.decimalButton.setSelected(true);
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(2, calc.leftValue);
	}


	//Equals button RACC p9 row 1 test	
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,61,62,63,64
	@Test public void eRACCp9r1() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.hexadecimalButton.setSelected(true);
		calc.leftValue = 10;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("10");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(20, calc.leftValue);
		assertTrue(ButtonsPanel.resultField.getText().contentEquals("14"));
	}	
	
	
	//Equals button RACC p9 row 2 test
	//Matches test path 1,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,45,47,49,50,52,54,55,56,63,64
	@Test public void eRACCp9r2() 
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		BaseGroupPanel.decimalButton.setSelected(true);
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = true;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		ActionEvent e = new ActionEvent(ButtonsPanel.equalButton, 0, null);
		e.setSource(ButtonsPanel.equalButton);
		calc.actionPerformed(e);
		assertEquals(2, calc.leftValue);
	}


	//numberCheck method RACC p1 row 1 test
	@Test public void nRACCp1r1()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = true;
		ButtonsPanel.resultField.setText("1");
		calc.numberChecking();
		assertTrue(ButtonsPanel.resultField.getText().contentEquals(""));
		assertFalse(calc.varSolved);
		assertEquals("", calc.varString);
		assertTrue(calc.varPushed);
	}
	
	//numberCheck method RACC p1 row 2 test
	@Test public void nRACCp1r2()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		ButtonsPanel.resultField.setText("1");
		calc.numberChecking();
		assertTrue(calc.varPushed);
	}
	
	//numberCheck method RACC p2 row 1 test
	@Test public void nRACCp2r1()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = "1";
		ButtonsPanel.resultField.setText("1");
		calc.numberChecking();
		assertTrue(ButtonsPanel.resultField.getText().contentEquals(""));
		assertTrue(calc.varPushed);
		assertEquals(" ", calc.varSaved);
	}	
	
	//numberCheck method RACC p2 row 2 test
	@Test public void nRACCp2r2()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = " ";
		ButtonsPanel.resultField.setText("1");
		calc.numberChecking();
		assertTrue(calc.varPushed);
	}	
	
	//numberCheck method RACC p2 row 5 test
	@Test public void nRACCp2r5()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = "1";
		ButtonsPanel.resultField.setText("1");
		calc.numberChecking();
		assertTrue(calc.varPushed);
	}	
	
	//numberCheck method RACC p3 row 1 test
	@Test public void nRACCp3r1()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = " ";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = "1";
		ButtonsPanel.resultField.setText("0");
		calc.numberChecking();
		assertTrue(ButtonsPanel.resultField.getText().contentEquals(""));
		assertTrue(calc.varPushed);
	}	
	
	//numberCheck method RACC p3 row 2 test
	@Test public void nRACCp3r2()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = " ";
		ButtonsPanel.resultField.setText("1");
		calc.numberChecking();
		assertTrue(ButtonsPanel.resultField.getText().contentEquals("1"));
		assertTrue(calc.varPushed);
	}	
	
	//numberCheck method RACC p4 row 2 test
	@Test public void nRACCp4r2()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = "1";
		ButtonsPanel.resultField.setText("Error");
		calc.numberChecking();
		assertTrue(ButtonsPanel.resultField.getText().contentEquals(""));
		assertTrue(calc.varPushed);
	}	

	//numberCheck method RACC p4 row 3 test
	@Test public void nRACCp4r3()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = "1";
		ButtonsPanel.resultField.setText("Can't divide by zero");
		calc.numberChecking();
		assertTrue(ButtonsPanel.resultField.getText().contentEquals(""));
		assertTrue(calc.varPushed);
	}	
	
	//numberCheck method RACC p4 row 4 test
	@Test public void nRACCp4r4()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 1;
		calc.operator = "+";
		calc.varPushed = false;
		calc.varSolved = false;
		calc.varSaved = " ";
		ButtonsPanel.resultField.setText("1");
		calc.numberChecking();
		assertTrue(ButtonsPanel.resultField.getText().contentEquals("1"));
		assertTrue(calc.varPushed);
	}
	
	
	//equateOperations syntax test 1
	@Test public void Syntax1()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		assertEquals(38, calc.equateOperations(32, 6, "+"));
	}
	
	//equateOperations syntax test 2
	@Test public void Syntax2()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		assertEquals(13, calc.equateOperations(107, 94, "-"));
	}	
	
	//equateOperations syntax test 3
	@Test public void Syntax3()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		assertEquals(100500, calc.equateOperations(125, 804, "*"));
	}	
	
	//equateOperations syntax test 4
	@Test public void Syntax4()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		assertEquals(3, calc.equateOperations(21, 7, "/"));
	}	
	
	//equateOperations syntax test 5
	@Test public void Syntax5()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		assertEquals(3, calc.equateOperations(15, 6, "%"));
	}	
	
	//equateOperations Mutant test
	@Test public void Mutant()
	{
		CalculatorMainFrame calc = new CalculatorMainFrame();
		calc.leftValue = 18;
		calc.rightValue = 6;
		calc.operator = "6";
		boolean mutantKilled;
		if(calc.equateOperations(calc.leftValue, calc.rightValue, calc.operator) == 24)
		{
			mutantKilled = false;
		}
		else
		{
			mutantKilled = true;
		}
		
		assertTrue(mutantKilled);
	}
	
}
