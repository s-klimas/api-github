# Api-github

Application uses GitHub's api, and have only one GET endpoint */github/{username}*. After sending a request endpoints connects to GitHub and downloads data about selected user's repositories and creates collection of it's names, owners login and for each branch: branch name and last commit sha. It requires in request header to have Accept property set as "Application/Json" to work properly, if not application respons with error message. 
