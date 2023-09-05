package pl.sebastianklimas.apigithub.domain.orginal;

public class GitHubOriginalBranch {
    private String name;
    private GitHubOriginalCommit commit;

    public GitHubOriginalBranch() {
    }

    public GitHubOriginalBranch(String name, GitHubOriginalCommit commit) {
        this.name = name;
        this.commit = commit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GitHubOriginalCommit getCommit() {
        return commit;
    }

    public void setCommit(GitHubOriginalCommit commit) {
        this.commit = commit;
    }
}
