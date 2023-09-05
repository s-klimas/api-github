package pl.sebastianklimas.apigithub.domain.orginal;

import pl.sebastianklimas.apigithub.domain.GitHubBranch;
import pl.sebastianklimas.apigithub.domain.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

public class GitHubOriginalObjectMapper {
    public static GitHubRepo map(GitHubOriginalObject ghoo, List<GitHubOriginalBranch> ghobList) {
        GitHubRepo gitHubRepo = new GitHubRepo();
        gitHubRepo.setName(ghoo.getName());
        gitHubRepo.setOwnerLogin(ghoo.getOwner().getLogin());

        List<GitHubBranch> branches = new ArrayList<>();

        for (GitHubOriginalBranch ghob : ghobList) {
            branches.add(new GitHubBranch(ghob.getName(), ghob.getCommit().getSha()));
        }

        gitHubRepo.setBranches(branches);

        return gitHubRepo;
    }
}
