<html ng-app="myApp">
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
        <script src="//unpkg.com/@uirouter/angularjs/release/angular-ui-router.min.js"></script>
        <script src="router.js"></script>
        <script src="app.js"></script>
        
    </head>
     <body ng-controller="MainController">
        <h2>Jersey RESTful Web Application!</h2>
        <p><a href="webapi/myresource">Jersey resource</a>
        <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
        for more information on Jersey!
        <div ng-view></div>
        <p>{{ 8843 / 42 }}</p>
        <p>{{message}}</p>
        <div>{{user.name.length > 0 ? "Username: " + user.name + " Id: " + user.id : "Not Found" }}</div>
        
        <input type="search" placeholder="Username to find" ng-model="username" ng-change="change(username)"/>
        <input type="submit" value="search"/>
        <div ng-controller="TestController">{{message}}</div>
        <div ng-controller="ApiController">
            <div>{{response[0].description}}</div>
            <div ng-repeat="res in response">
                <div>Activity: {{res.description}} Duration: {{res.duration}}</div>     
            </div>
        </div> 
    </body>
</html>
