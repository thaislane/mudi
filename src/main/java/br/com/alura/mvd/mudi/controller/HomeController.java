package br.com.alura.mvd.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvd.mudi.model.Pedido;
import br.com.alura.mvd.mudi.model.StatusPedido;
import br.com.alura.mvd.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String nome(Model model, Principal principal) {
		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		return "/home";
		
//		Pedido pedido = new Pedido();
//		pedido.setNomeProduto("Kindle 10a. geração");
//		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51ij0YhqZTS._AC_SY450_.jpg");
//		pedido.setUrlProduto("https://www.amazon.com.br/dp/B07FQK1TS9/ref=s9_acsd_al_bw_c2_x_4_t?pf_rd_m=A3RN7G7QC5MWSZ&pf_rd_s=merchandised-search-2&pf_rd_r=NA5G5RT5MK1T8F1RSPM2&pf_rd_t=101&pf_rd_p=212c7157-d160-4e47-9b52-70e30b027a93&pf_rd_i=17387223011");
//		pedido.setDescricao("Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia. O Kindle possui uma tela touchscreen antirreflexo, até mesmo sob o sol. É como se você estivesse lendo em papel.");
//		List<Pedido> pedidos = Arrays.asList(pedido);
//		model.addAttribute("pedidos", pedidos);
//		return "home";
	}
	
	
	
//	@GetMapping("/{status}")
//	public String porStatus(@PathVariable("status") String status, Model model) {
//		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
//		model.addAttribute("pedidos", pedidos);
//		model.addAttribute("status", status);
//		return "home";
//		
//	}
//	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public String onError() {
//		return "redirect:/home";
//	}
	
	

}
