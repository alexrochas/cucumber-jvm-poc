FROM node:6.11.0

RUN mkdir /usr/src/app
WORKDIR /usr/src/app
USER root

RUN npm install -g canned

COPY . /usr/src/app

EXPOSE 8082

CMD canned -p 8082 /usr/src/app/app
