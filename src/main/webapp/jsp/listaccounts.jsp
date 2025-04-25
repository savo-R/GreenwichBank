<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Accounts</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 800px; margin: 0 auto; padding: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>Student Accounts</h1>
    <table id="accountsTable">
        <thead>
            <tr>
                <th>ID</th>
                <th>Alias</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody id="accountsBody">
 
        </tbody>
    </table>

    <script>
        // Fetch accounts from the REST API
        //This is not displaying the data in the json file
        fetch('http://localhost:8080/GreenwichBank/api/bank/accounts')
            .then(response => response.json())
            .then(accounts => {
                const tbody = document.getElementById('accountsBody');
                accounts.forEach(account => {
                    const row = `
                        <tr>
                            <td>${account.id}</td>
                            <td>${account.alias}</td>
                            <td>${account.balance}</td>
                        </tr>
                    `;
                    tbody.innerHTML += row;
                });
            })
            .catch(error => {
                console.error('Error fetching accounts:', error);
                document.getElementById('accountsBody').innerHTML = 
                    `<tr><td colspan="3">Error loading accounts</td></tr>`;
            });
    </script>
</body>
</html>
