package com.example.dumplingscloud.core.controller;

import com.example.dumplingscloud.core.model.Dumplings;
import com.example.dumplingscloud.core.model.DumplingsOrder;
import com.example.dumplingscloud.core.repo.DumplingsRepository;
import com.example.dumplingscloud.core.repo.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes({"dumplingsOrder", "dumplingsList"})
public class OrderController {

    private final OrderRepository orderRepository;
    private final DumplingsRepository dumplingsRepository;

    public OrderController(OrderRepository orderRepository, DumplingsRepository dumplingsRepository) {
        this.orderRepository = orderRepository;
        this.dumplingsRepository = dumplingsRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid DumplingsOrder dumplingsOrder, Errors errors,
                               List<Dumplings> dumplingsList,
                               SessionStatus sessionStatus, Model model) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        try {
            dumplingsRepository.saveAll(dumplingsList);
            try {
                orderRepository.save(dumplingsOrder);
            } catch (Exception e) {
                dumplingsRepository.deleteAll(dumplingsList);
                log.error("processOrder: Order saved error");
                model.addAttribute("error", "Order creation error. Try again");
                return "orderForm";
            }
            log.info("Order submitted: {}", dumplingsOrder);
            sessionStatus.setComplete();
        } catch (Exception e) {
            log.error("processOrder: Dumplings saved error");
            model.addAttribute("error", "Order creation error. Try again");
            return "orderForm";
        }

        return "redirect:/success";
    }
}
