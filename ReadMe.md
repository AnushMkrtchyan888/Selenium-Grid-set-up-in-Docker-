Description
Run Selenium Tests in Docker

Requirements
1. Linux operating system
2. Make sure Docker is installed
3. Pull the Selenium/hub, Selenium/node-chrome-debug and Selenium/node-firefox-debug images from DockerHub
4. VNC Viewer 
5. Selenium Tests


To run the the selenium tests in Docker you need.

$. run the Selenium/hub docker image in terminal with this command
   docker run -d -p 4444:4444 --name selenium-hub selenium/hub

$ run the Selenium/node-chrome-debug docker image in terminal with this command
   docker run -d -p 5900:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome-debug

$ run the Selenium/node-chrome-debug docker image in terminal with this command
   docker run -d -p 5901:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-firefox-debug

$  open the VNC viewer for chrome and firefox tests 
        vncviewer 127.0.0.1:5900
	vncviewer 127.0.0.1:5901

$ run the selenium tests

The tests running you can see by vncviwers.
