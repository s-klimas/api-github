package pl.sebastianklimas.apigithub.domain;

import java.util.List;

public class GitHubResponseBody {
    private List<GitHubRepo> gitHubRepoList;

    public GitHubResponseBody() {
    }

    public GitHubResponseBody(List<GitHubRepo> gitHubRepoList) {
        this.gitHubRepoList = gitHubRepoList;
    }

    public List<GitHubRepo> getGitHubRepoList() {
        return gitHubRepoList;
    }

    public void setGitHubRepoList(List<GitHubRepo> gitHubRepoList) {
        this.gitHubRepoList = gitHubRepoList;
    }
}
