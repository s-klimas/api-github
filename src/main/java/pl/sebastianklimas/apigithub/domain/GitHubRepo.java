package pl.sebastianklimas.apigithub.domain;

import java.util.List;

public class GitHubRepo {
    private String name;
    private String ownerLogin;
    private List<GitHubBranch> branches;

    public GitHubRepo() {
    }

    public GitHubRepo(String name, String ownerLogin, List<GitHubBranch> branches) {
        this.name = name;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public List<GitHubBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<GitHubBranch> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "GitHubRepo " + name + " owner: " + ownerLogin + " branches:" + branches;
    }
}
