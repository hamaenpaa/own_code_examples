using System;

/// <summary>
/// Summary description for Class1
/// </summary>
public class ADO_ex1
{
    static private void GetSqlTypesAW(string connectionString)
    {
        // Create a DataTable and specify a SqlType
        // for each column.
        DataTable table = new DataTable();
        DataColumn icolumnolumn =
            table.Columns.Add("SalesOrderID", typeof(SqlInt32));
        DataColumn priceColumn =
            table.Columns.Add("UnitPrice", typeof(SqlMoney));
        DataColumn totalColumn =
            table.Columns.Add("LineTotal", typeof(SqlDecimal));
        DataColumn columnModifiedDate =
            table.Columns.Add("ModifiedDate", typeof(SqlDateTime));

        // Open a connection to SQL Server and fill the DataTable
        // with data from the Sales.SalesOrderDetail table
        // in the AdventureWorks sample database.
        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            string queryString =
                "SELECT TOP 5 SalesOrderID, UnitPrice, LineTotal, ModifiedDate "
                + "FROM Sales.SalesOrderDetail WHERE LineTotal < @LineTotal";

            // Create the SqlCommand.
            SqlCommand command = new SqlCommand(queryString, connection);

            // Create the SqlParameter and assign a value.
            SqlParameter parameter =
                new SqlParameter("@LineTotal", SqlDbType.Decimal);
            parameter.Value = 1.5;
            command.Parameters.Add(parameter);

            // Open the connection and load the data.
            connection.Open();
            SqlDataReader reader =
                command.ExecuteReader(CommandBehavior.CloseConnection);
            table.Load(reader);

            // Close the SqlDataReader.
            reader.Close();
        }

        // Display the SqlType of each column.
        Console.WriteLine("Data Types:");
        foreach (DataColumn column in table.Columns)
        {
            Console.WriteLine(" {0} -- {1}",
                column.ColumnName, column.DataType.UnderlyingSystemType);
        }

        // Display the value for each row.
        Console.WriteLine("Values:");
        foreach (DataRow row in table.Rows)
        {
            Console.Write(" {0}, ", row["SalesOrderID"]);
            Console.Write(" {0}, ", row["UnitPrice"]);
            Console.Write(" {0}, ", row["LineTotal"]);
            Console.Write(" {0} ", row["ModifiedDate"]);
            Console.WriteLine();
        }
    }
    
    public ADO_ex1()
	{
		//
		// TODO: Add constructor logic here
		//
	}
}
