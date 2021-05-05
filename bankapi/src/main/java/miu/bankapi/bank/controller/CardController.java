package miu.bankapi.bank.controller;


import java.time.Month;
import java.util.List;
import java.util.Map;


import miu.bankapi.bank.model.Card;
import miu.bankapi.bank.model.PaymentMethod;
import miu.bankapi.bank.model.TransactionHist;
import miu.bankapi.bank.service.CardService;
import miu.bankapi.bank.service.PaymentMethodService;
import miu.bankapi.bank.service.TransactionHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService service;

    @Autowired
    private TransactionHistService histService;

    @Autowired
    private PaymentMethodService payment;

    @PostMapping("/addcard")
    public ResponseEntity<?> addCard(@RequestBody Card card) {
        String resp = service.addNewCard(card);
        return new ResponseEntity<String>(resp, HttpStatus.OK);

    }

    @GetMapping("/getcard/{cardnumber}")
    public ResponseEntity<?> getCard(@PathVariable("cardnumber") Long cardnumber) {
        Card card = service.getCard(cardnumber);
        return new ResponseEntity<Card>(card, HttpStatus.OK);
    }



    @GetMapping("/paymentmethod/{id}")
    public ResponseEntity<?> getPaymentMethod(@PathVariable("id") Long id) {
        PaymentMethod paymentmethod = payment.findPaymentMethodById(id);
        return new ResponseEntity<PaymentMethod>(paymentmethod, HttpStatus.OK);
    }

    @GetMapping("/deletepaymentmethod/{id}")
    public ResponseEntity<?> deletePaymentMethod(@PathVariable("id") Long id) {
        payment.deletePaymentMethod(id);
        return new ResponseEntity<String>("Payment method deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/allpaymentmethod")
    public ResponseEntity<?> getAllPaymentMethod() {
        List<PaymentMethod> paymentmethod = payment.getAllPaymentMethod();
        return new ResponseEntity<List<PaymentMethod>>(paymentmethod, HttpStatus.OK);
    }

    @PostMapping("/addpaymentmethod")
    public ResponseEntity<?> createPaymentMethod(@RequestBody PaymentMethod paymentmethod) {
        payment.addPaymentMethod(paymentmethod);
        return new ResponseEntity<String>("Payment Method Created Successfully", HttpStatus.OK);
    }

    @GetMapping("/alltransaction")
    public ResponseEntity<?> allTransactionHist() {
        List<TransactionHist> transaction = histService.getAllTransactionHist();
        return new ResponseEntity<List<TransactionHist>>(transaction, HttpStatus.OK);
    }

    @GetMapping("/totalamtbymonth")
    public ResponseEntity<?> getTotalAmountByMonth() {
        Map<Month, Double> data = histService.getTransactionByMonth(2020);
        return new ResponseEntity<Map<Month,Double>>(data, HttpStatus.OK);

    }
}