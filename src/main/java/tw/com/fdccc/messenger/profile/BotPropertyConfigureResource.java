package tw.com.fdccc.messenger.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import tw.com.fdccc.messenger.profile.dto.BotPropertyDTO;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping(value = "/property")
public class BotPropertyConfigureResource {

    @Value("${page.access_token}")
    private String pageAccessToken;

    private RestTemplate restTemplate;
    private final String MESSENGER_PROFILE_URI
        = "https://graph.facebook.com/v3.0/me/messenger_profile";

    public BotPropertyConfigureResource(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @PostMapping(value = "/set")
    public ResponseEntity createGetStartButton(
        @RequestBody BotPropertyDTO botProperties) {

        final URI profileUri = UriComponentsBuilder.fromHttpUrl(MESSENGER_PROFILE_URI)
                .queryParam("access_token", pageAccessToken)
                .build()
                .toUri();

        log.info("[Fdccc][Messenger][Update Properties] Url - [{}].", profileUri);

        final ResponseEntity<String> botPropertiesStatus
                = restTemplate.postForEntity(profileUri, botProperties, String.class);

        log.info("[Messenger][Update Properties] Result - [{}].", botPropertiesStatus.getHeaders());

        return ResponseEntity.accepted().build();
    }
}
