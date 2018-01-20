# Cucumber JVM POC
> 3 strategies to mock your dependencies

## 1 — Fake it!

The idea of having something outside my dependencies only responding what I want is great. For that I use the traditional (at least for me) [Canned](https://github.com/sideshowcoder/canned) or more recently I made one [lib](https://github.com/alexrochas/static-response-server) myself.
I don’t will teach how to use Canned but was basically create a folder with the structure:

```
./mocked-dependency 
├── app 
│ └── _whatsyourage.get.txt 
├── docker-compose.yml 
└── Dockerfile
```

The Dockerfile and the docker-compose.yml:

```
# Dockerfile
FROM gradle:alpine
USER root 
WORKDIR /usr/src/app 
COPY . /usr/src/app 
CMD ./gradlew bootRun
```
```
# docker-compose.yml
canned: 
  build: . 
  ports: 
    — “8082:8082”
```

Just that will start an server on port 8082 and respond the content of **_whatsyourage.txt**.

## 2 — Containerize it!

Your service maybe more complex and you maybe want to test against something more failure susceptible than a static file server. For that my suggestion is “containerize it”! Use Docker again, off course. 

Another Dockerfile:

```
# Dockerfile
FROM gradle:alpine 
USER root 
WORKDIR /usr/src/app 
COPY . /usr/src/app 
CMD ./gradlew bootRun
```

My application is an SpringBoot so this Dockerfile will do the trick. After that just push to your account on docker hub.
Again, I will not teach how to do that. [Here](https://www.techrepublic.com/article/how-to-create-a-docker-image-and-push-it-to-docker-hub/) a quick tutorial.

## 3 — Mock it!
The last but probably your first idea is to mock it. Not extending about how you should test behavior prior implementation but..you should. Thinking about a more BDD approach (and my project still in Java) I use [WireMock](http://wiremock.org/).

```
WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8081));
wireMockServer.start(); 
wireMockServer.stubFor(get(WireMock.urlMatching(“.*whatsyourmiddlename.*”)) 
  .willReturn(aResponse() 
  .withHeader(“Content-Type”, “text/plain”) 
  .withStatus(200) 
  .withBody(“Rocha”)));
```

This is not self-explanatory, or maybe it is..but whit WireMock I will be able to mock any response from inside my application. We can talk discourse if this is really a “black-box” test but that’s not the case.

## How-to-run

You can allways start the docker containers one-by-one but the main project *docker-compose.yml*
extends all the other projects and run a gradle task called "cucumber" to run the tests.

## Meta

Alex Rocha - [about.me](http://about.me/alex.rochas)
