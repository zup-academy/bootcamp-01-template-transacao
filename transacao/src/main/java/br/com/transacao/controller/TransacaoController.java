package br.com.transacao.controller;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.transacao.model.Transacao;
import br.com.transacao.repository.TransacaoRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

//Contagem de Pontos - TOTAL:4
//1 - Transacao
//1 - TransacaoRepository
//2 - If

@RestController
public class TransacaoController {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Value("${transacao.secret}")
	private String key;
	
	private Logger logger = LoggerFactory.getLogger(TransacaoController.class);
	
	@GetMapping(value = "/v1/transacao/{id}")
	public ResponseEntity<?> criaBiometria(@PathVariable("id") String id, UriComponentsBuilder builder, Principal principal, HttpServletRequest httpRequest) throws Throwable {
		
		String email = emailJWT(httpRequest);
		
		List<Transacao> transacoesEncontradas = transacaoRepository.findByIdCartao(id);
		if (transacoesEncontradas.isEmpty()) {
			logger.info("Transacao nao encontrada com idCartao[{}]", id);
			return new ResponseEntity<>("ID não encontrado",HttpStatus.NOT_FOUND);
		}
		logger.info("Encontrada [{}] transacao com idCartao[{}]", transacoesEncontradas.size(), id);
		
		if(!transacoesEncontradas.get(0).getEmail().equals(email)) {
			logger.info("Usuario com email [{}], diferente do cadastrado na transacao[{}]",email, transacoesEncontradas.get(1).getEmail());
			return new ResponseEntity<>("Voce nao tem permissao para visualizar esta transacao",HttpStatus.FORBIDDEN);
		}
		
		List<Transacao> transacoes = transacaoRepository.buscarUltimasTransacaos(id);
		logger.info("Lista das 10 ultimas transacoes encontradas {}", transacoes.toString());
		
		return new ResponseEntity<>(transacoes,HttpStatus.OK);
	}
	
    public PublicKey generatePublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec pubKeySpecX509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        return kf.generatePublic(pubKeySpecX509EncodedKeySpec);
    }
    
    public String emailJWT(HttpServletRequest request) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, NoSuchAlgorithmException, InvalidKeySpecException {
    	String token = request.getHeader("Authorization");
		String [] splitjwt = token.split(" ");
		String jwt = splitjwt[1];
		
		Claims result = Jwts.parser().setSigningKey(generatePublicKey(this.key)).parseClaimsJws(jwt).getBody();
		String email = result.get("email", String.class);
		
		return email;
    }
}
