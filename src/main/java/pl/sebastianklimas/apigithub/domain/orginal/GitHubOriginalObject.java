package pl.sebastianklimas.apigithub.domain.orginal;

import java.util.List;

public class GitHubOriginalObject {
    private String name;
    private boolean fork;

    private GitHubOriginalOwner owner;

    private String url;

    private List<GitHubOriginalBranch> branches;

    public GitHubOriginalObject() {
    }

    public GitHubOriginalObject(String name, boolean fork, GitHubOriginalOwner owner, String url, List<GitHubOriginalBranch> branches) {
        this.name = name;
        this.fork = fork;
        this.owner = owner;
        this.url = url;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public GitHubOriginalOwner getOwner() {
        return owner;
    }

    public void setOwner(GitHubOriginalOwner owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<GitHubOriginalBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<GitHubOriginalBranch> branches) {
        this.branches = branches;
    }
}
