package pl.sebastianklimas.apigithub.domain.orginal;

public class GitHubOriginalCommit {
    private String sha;

    public GitHubOriginalCommit() {
    }

    public GitHubOriginalCommit(String sha) {
        this.sha = sha;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
