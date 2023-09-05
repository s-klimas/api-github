package pl.sebastianklimas.apigithub.domain.orginal;

public class GitHubOriginalOwner {
    private String login;

    public GitHubOriginalOwner() {
    }

    public GitHubOriginalOwner(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
