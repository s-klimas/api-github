package pl.sebastianklimas.apigithub.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.sebastianklimas.apigithub.domain.GitHubRepo;
import pl.sebastianklimas.apigithub.domain.GitHubResponseBody;
import pl.sebastianklimas.apigithub.domain.GitHubService;
import pl.sebastianklimas.apigithub.domain.orginal.GitHubOriginalObject;

import java.util.List;

@RestController
public class HomeController {

    private final GitHubService gitHubService;

    public HomeController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(
            value = "/github/{username}"
    )
    @ResponseBody
    public ResponseEntity<?> home(
            @PathVariable String username,
            @RequestHeader(value="Accept") String acceptHeader
    ) {
        if (acceptHeader.equals(MediaType.APPLICATION_XML_VALUE)) {
            String message = "Application returns only Application/JSON not Application/XML";
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, message);
        }

        if (!acceptHeader.equals(MediaType.APPLICATION_JSON_VALUE)) {
            String message = "Unsupported media type";
            throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, message);
        }

        List<GitHubOriginalObject> orginalList = gitHubService.getUserRepos(username);

        List<GitHubRepo> gitHubRepoList = gitHubService.getFullList(orginalList);

        return new ResponseEntity<>(new GitHubResponseBody(gitHubRepoList), HttpStatus.OK);
    }
}
