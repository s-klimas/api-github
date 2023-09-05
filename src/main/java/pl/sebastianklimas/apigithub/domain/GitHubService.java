package pl.sebastianklimas.apigithub.domain;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sebastianklimas.apigithub.domain.orginal.GitHubOriginalBranch;
import pl.sebastianklimas.apigithub.domain.orginal.GitHubOriginalObject;
import pl.sebastianklimas.apigithub.domain.orginal.GitHubOriginalObjectMapper;
import pl.sebastianklimas.apigithub.exceptions.CustomException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GitHubService {
    private final RestTemplate restTemplate;

    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubOriginalObject> getUserRepos(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        try {
            ResponseEntity<GitHubOriginalObject[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    GitHubOriginalObject[].class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                return Arrays.asList(response.getBody());
            } else {
                throw new RuntimeException("Failed to fetch user repositories");
            }
        } catch (HttpClientErrorException e) {
            throw new CustomException(HttpStatus.NOT_FOUND.value(), "User does not exist on github");
        }
    }

    private List<GitHubOriginalBranch> getRepoBranches(String url) {
        ResponseEntity<GitHubOriginalBranch[]> response = restTemplate.exchange(
                url + "/branches",
                HttpMethod.GET,
                null,
                GitHubOriginalBranch[].class
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            throw new RuntimeException("Failed to fetch repo's branches");
        }
    }

    public List<GitHubRepo> getFullList(List<GitHubOriginalObject> ghooList) {
        List<GitHubRepo> repoList = new ArrayList<>();

        for (GitHubOriginalObject ghoo : ghooList) {
            if (ghoo.isFork()) {
                continue;
            }
            List<GitHubOriginalBranch> branches = getRepoBranches(ghoo.getUrl());
            repoList.add(GitHubOriginalObjectMapper.map(ghoo, branches));
        }

        return repoList;
    }

}
