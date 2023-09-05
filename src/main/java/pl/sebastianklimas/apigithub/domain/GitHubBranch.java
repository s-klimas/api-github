package pl.sebastianklimas.apigithub.domain;

public class GitHubBranch {
    private String name;
    private String lastCommitSha;

    public GitHubBranch() {
    }

    public GitHubBranch(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }

    public void setLastCommitSha(String lastCommitSha) {
        this.lastCommitSha = lastCommitSha;
    }

    @Override
    public String toString() {
        return "GitHubBranch " + name + " sha: " + lastCommitSha;
    }
}
