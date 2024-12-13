# dai-lab-http-infrastructure
# Step 1: Static Web Site
# Authors: Gabriel Barros Fernandez - Dylan Stegmuller
# Date: 13.12.2024

# Getting image
FROM nginx:latest

# Copying nginx conf to image
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copying website source to image
COPY html /usr/share/nginx/html
