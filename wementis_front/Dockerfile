FROM node:14

WORKDIR /usr/src/app

COPY . .

RUN npm install

CMD ["npm", "run", "serve"]

# FROM node:14

# LABEL maintainer="rubentxogg@hotmail.com"

# RUN npm install -g http-server

# WORKDIR /app

# COPY package*.json ./

# RUN npm install

# COPY . .

# RUN npm run build

# EXPOSE 8080

# CMD ["http-server", "dist"]