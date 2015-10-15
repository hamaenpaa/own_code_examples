using System;
using System.Collections;
using System.Collections.Generic;


public class Expression
{
    public char oper = ' ';
    public string expressionStr = "";
    public double Value;
    public string errorstring = "";

    public override string ToString() { return this.Value + ""; }

    public Expression(double Value)
    {
/*        Console.WriteLine("Creating Expression with value " + Value);*/
        this.Value = Value;
    }

    public Expression(string error)
    {
        this.errorstring = error;
    }

    private static Expression parseExpressionsOfLevel(string expressionStr,
        char[] leveloperators, int level)
    {
        int iNextOperator = -1;
/*        Console.WriteLine("expressionStr = " + expressionStr);*/
        char nextOperator = ' ';
        iNextOperator = expressionStr.IndexOfAny(leveloperators);
        if (iNextOperator != -1) nextOperator = expressionStr[iNextOperator];
/*        Console.WriteLine("iNextOperator " + iNextOperator);*/
        if (iNextOperator == 0)
        {
            Console.WriteLine("iNextOperator == 0");
           string rest = expressionStr.Substring(1);
           Console.WriteLine("rest = " + rest);
           if (expressionStr.Substring(iNextOperator,1) == "-" ||
               expressionStr.Substring(iNextOperator, 1) == "(")
           {
               Console.WriteLine("iNextOperator char was - or (");
              int iFollowingNextLevel = rest.IndexOfAny(leveloperators);
              if (iFollowingNextLevel != -1)
              {
                  char oper = rest[iFollowingNextLevel];
                  string unaryOperand = "", following = "";
                  if (oper == '(')
                  {
                      int iClosing = rest.IndexOf(')');
                      if (iClosing == -1)
                          return new Expression("( did not have corresponding )");
                      unaryOperand = rest.Substring(0, iClosing);
                      if (iClosing == rest.Length - 1)
                          return new UnaryExpression(unaryOperand);
                      following = rest.Substring(iClosing + 2);
                      oper = rest[iClosing + 1];
                  }
                  else
                  {
                      unaryOperand = rest.Substring(0, iFollowingNextLevel);
                      following = rest.Substring(iFollowingNextLevel + 1);
                  }
                 
                 return BinaryExpression.Create(new UnaryExpression(unaryOperand),
                            Expression.Create(following,level), oper);
              }
              else 
                 return new UnaryExpression(expressionStr.Substring(1));
           }
           else return new Expression("tried to use other than -  as unary operator");
         }
         else if (iNextOperator != -1)
         {
             Console.WriteLine("nextOperator = " + nextOperator + "iNextOperator = " + iNextOperator);
             Console.WriteLine("expressionStr = " + expressionStr);

             string restOfExpr = expressionStr.Substring(iNextOperator + 1);
             string operand1 = expressionStr.Substring(0, iNextOperator);
             
             string followingPart = "",nextPart = "";
             char followingOper = ' ';
             bool bracketHandling = false;
             bool isBracket = false;
             int iClosing = -1;
             if (restOfExpr.IndexOf('(') == 0)
             {
                 iClosing = restOfExpr.IndexOf(')');
                 if (iClosing == -1)
                     return new Expression("( did not have corresponding )");
                 string afterClosing = restOfExpr.Substring(iClosing + 1);
                 int iFollowingOper = afterClosing.IndexOfAny(leveloperators);
                 Console.WriteLine("afterClosing = " + afterClosing);
                 isBracket = true;
                 if (iFollowingOper == 0)
                 {
                     followingPart = restOfExpr.Substring(iClosing + 2);
                     followingOper = restOfExpr[iClosing + 1];
                     Console.WriteLine("restOfExpr = " + restOfExpr);
                     nextPart = restOfExpr.Substring(1, iClosing - 1);
                     bracketHandling = true;
                 }
             }
             if (bracketHandling == false)
             {
                 int iStillNextSameLevel = -1;
                 if (isBracket == true)
                 {
                     string seekStr = restOfExpr.Substring(iClosing);
                     iStillNextSameLevel = seekStr.IndexOfAny(leveloperators);
                     if (iStillNextSameLevel != -1) iStillNextSameLevel += iClosing;
                 }
                 else iStillNextSameLevel = restOfExpr.IndexOfAny(leveloperators);
                 if (iStillNextSameLevel != -1)
                 {
                     nextPart = restOfExpr.Substring(0, iStillNextSameLevel);
                     followingOper = restOfExpr[iStillNextSameLevel];
                     followingPart = restOfExpr.Substring(iStillNextSameLevel + 1);
                 }
             }
            Console.WriteLine("operand1 = " + operand1);

            int ilevel;
            if (bracketHandling == true) ilevel = 1; else ilevel = level;
            if (followingOper != ' ')
            {
                BinaryExpression nextExpr =
                        BinaryExpression.Create(Expression.Create(operand1,ilevel), 
                        Expression.Create(nextPart,level),nextOperator);
                return BinaryExpression.Create(nextExpr, 
                          Expression.Create(followingPart, ilevel), followingOper);
            }
            else
            {
                return BinaryExpression.Create(
                   Expression.Create(operand1, level),
                   Expression.Create(restOfExpr, ilevel),
                   nextOperator);
            }
         }
         else if (level == 1)
         {
            return Expression.Create(expressionStr, 2);
         }
         else 
         {
/*             Console.WriteLine("Parsing calculated number from " +
                    expressionStr);*/

             double value = 0.0;
             try 
             {
                 value = double.Parse(expressionStr);
/*                    Console.WriteLine("got " + value);*/
             }
             catch (Exception e)
             {
                    return new Expression(
                        "error in interpreting " + expressionStr + " as numeric");
             }
             return new Expression(value);
         }
    }

    static public Expression Create(string expressionStr, int level)
    {
        char[] additiveopers = {'+', '-', '(' };
        char[] multiplicativeopers = { '*', '/', '(' };
        switch(level)
        {
            case 1:
                return parseExpressionsOfLevel(expressionStr, additiveopers, 1);
            case 2:
                return parseExpressionsOfLevel(expressionStr, multiplicativeopers, 2);
        }
        return new Expression(0.0);
    }

    virtual public double calculate() 
    { /* Console.WriteLine("returning simple value " + this.Value); */ return this.Value; }
}

public class BinaryExpression : Expression
{
    public Expression LeftExpr;
    public Expression RightExpr;

    public BinaryExpression(Expression left, Expression right, char oper) : base(0.0)
    {
        this.LeftExpr = left;
        this.RightExpr = right;
        this.oper = oper;
    }
       
    public static BinaryExpression Create(Expression left, Expression right, char oper)
    {
        BinaryExpression expr = null;
        switch(oper)
        {
            case '+' : expr = new AdditiveExpression(left,right); break;
            case '-': expr = new SubstractExpression(left, right); break;
            case '*' : expr = new MultiplicativeExpression(left,right); break;
            case '/' : expr = new DivisionExpression(left,right); break;
        }
        expr.oper = oper;
        return expr;
    }

     
}



public class UnaryExpression : Expression
{
    public Expression Expr = null;

    public UnaryExpression(string expression) : base(0.0)
    {
        this.oper = '-';
        this.Expr = Expression.Create(expression,2);
    }

    public override double calculate()
    {
        if (Expr.errorstring != "") return 0.0;
        this.Value = -Expr.calculate();
        /*Console.WriteLine("Returning unaryExpr value " + this.Value);*/
        return this.Value;
    }

    public override string ToString() { return "-" + this.Expr; }
}

public class AdditiveExpression : BinaryExpression
{
    public AdditiveExpression(Expression left, Expression right) :
          base(left,right,'+')
    {
    }

    public override double calculate()
    {
        /* Console.WriteLine("AdditiveExpression.calculate");*/
        if (LeftExpr.errorstring != "" || RightExpr.errorstring != "")
        {
            this.errorstring = LeftExpr.errorstring + RightExpr.errorstring;
            return 0.0;
        }
        /* Console.WriteLine("no errorstring");*/
        double left = this.LeftExpr.calculate(); 
        double right = this.RightExpr.calculate();
        /* Console.WriteLine("add " + left + " and " + right + " to result " + (left + right));*/
        this.Value = left + right;
        return this.Value;
    }

    public override string ToString() { return this.LeftExpr + "+" + this.RightExpr; }   
}


public class SubstractExpression : BinaryExpression
{
    public SubstractExpression(Expression left, Expression right) :
        base(left,right,'-')
    {
    }

    public override double calculate()
    {
        /* Console.WriteLine("SubstractExpression.calculate");*/
        if (LeftExpr.errorstring != "" || RightExpr.errorstring != "")
        {
            this.errorstring = LeftExpr.errorstring + RightExpr.errorstring;
            return 0.0;
        }
        /* Console.WriteLine("no errorstring");*/
        double left = this.LeftExpr.calculate(); 
        double right = this.RightExpr.calculate();
        this.Value =  left - right;
        /* Console.WriteLine("substract " + left + " and " + right + " to result " + this.Value);*/
        return this.Value;
    }

    public override string ToString() { return this.LeftExpr + "-" + this.RightExpr; }
}


public class MultiplicativeExpression : BinaryExpression
{
    public MultiplicativeExpression(Expression left, Expression right) :
        base(left,right,'*')
    {
    }

    public override double calculate() 
    {
        /*Console.WriteLine("MultiplicativeExpression.calculate");*/
        if (LeftExpr.errorstring != "" || RightExpr.errorstring != "")
        {
            this.errorstring = LeftExpr.errorstring + RightExpr.errorstring;
            return 0.0;
        }
        /* Console.WriteLine("no errorstring -> calculate");*/
        double left = this.LeftExpr.calculate();
        double right = this.RightExpr.calculate();
        this.Value = left * right;
        /* Console.WriteLine("multiply " + left + " and " + right + " to result " + this.Value);*/
        return this.Value;
    }

    public override string ToString() { return this.LeftExpr + "*" + this.RightExpr; }
}


public class DivisionExpression : BinaryExpression
{
    public DivisionExpression(Expression left, Expression right) :
        base(left,right,'/')
    {
    }

    public override double calculate()
    {
        if (LeftExpr.errorstring != "" || RightExpr.errorstring != "")
        {
            this.errorstring = LeftExpr.errorstring + RightExpr.errorstring;
            return 0.0;
        }
        double right = this.RightExpr.calculate();
        double left = this.LeftExpr.calculate();
        if (right > -00000000.1 && right < 0.00000001)
        {
            this.errorstring = "Division by zero";
            return 0.0;
        }
        this.Value = left / right;
        /* Console.WriteLine("Divide " + left + " and " + right + " to result " + this.Value);*/
        return this.Value;
    }

    public override string ToString() { return this.LeftExpr + "/" + this.RightExpr; }
}



/// <summary>
/// Summary description for Class1
/// </summary>
public class Calculator
{

    static void calculate(string input)
    {
        try
        {
            Expression e = Expression.Create(input,1);
            /* Console.WriteLine("expression formed " + e);
            Console.WriteLine("TO CALCULATE");*/
            double value = 0.0;
            if (e.errorstring == "")
               value = e.calculate();
            if (e.errorstring != "")
                Console.WriteLine("Error " + e.errorstring + " occured in calculation");
            else 
               Console.WriteLine("Calculation result is :" + value);
        }
        catch (Exception ex)
        {
            Console.WriteLine("Input was not correct kind of expression or led to some other problem");
        }
    }

    static void Main(string[] args)
    {
        string input = "";
        Console.WriteLine("Give basic calculation with +,-,* and / and integer operands");
        input = Console.ReadLine();
        if (input != "")
        {
                Calculator.calculate(input);
        }
        Console.ReadLine();
    }
}
