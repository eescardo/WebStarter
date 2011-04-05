<!DOCTYPE html>
<html>
<!-- Copyright © 2011 Eduardo Escardo-Raffo. All rights reserved. -->
<head>
<meta charset="UTF-8">
<title>${message('home.title')}</title>
</head>
<body>
<h1>${message('home.heading')}</h1>
<p>${message('home.message')}</p>
<p>Users:</p>
<ol>
[#list users as user]
<li>${user.lastname}, ${user.firstname}</li>
[/#list]
</ol>
</body>
</html>
