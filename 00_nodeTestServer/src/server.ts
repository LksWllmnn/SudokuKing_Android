import * as Http from "http";
import * as Url from "url";
import * as Mongo from "mongodb";

namespace testServerApp {
    let port: number = Number(process.env.PORT);
    if (!port)
        port = 8101;

    startServer(port);

    function startServer (_port: number | string): void {
        let server: Http.Server = Http.createServer();
        console.log("i'm alive!");
        server.addListener("request", handleRequest);
        server.listen(port);
    }

    function handleRequest(_request: Http.IncomingMessage, _response: Http.ServerResponse): void {
        _response.setHeader("content-type", "text/html; charset=utf-8");
        _response.setHeader("Access-Control-Allow-Origin", "*");

        console.log("i hear voices");

        
        if (_request.url) {
            let url: Url.UrlWithParsedQuery = Url.parse(_request.url, true);
            let path: string | null = url.pathname;
            console.log("////");
            console.log("Request Method: " + _request.method);
            console.log("Path: " + path);
            console.log("////");

            switch (path) {
                case "/v1/signInUser":
                    console.log("trys to sign in");
                    break;
                case "/v1/logInUser":
                    console.log("trys to log in");
                    break;
                case "/v1/statistics/":
                    console.log("trys get Stats");
                    break;
                case "/v1/statistic/":
                    console.log("trys to set Sat");
                    break;
            }
        }

        _response.write("Fuck off cunt!");
        _response.end();
    }
}

// Server Init
//1. npm install @types/node
//2. npm init
//3. package.json "start": "node Relativer/Pfad/Zu/Datei.js"

//Database Init
//1. npm install @types/mongodb
//2. npm install mongodb 
//3. Copied MongoDB Folder in project
//4. in folder MongoDB/bin cmd: mongod --dbpath ../../X_Database

/*
if (_request.method == "POST") {
  let body = "";
  _request.on("data", data => {
    body += data;
  });
  _request.on("end", async () => {
    let post: any = JSON.parse(body);
  });
}
*/
