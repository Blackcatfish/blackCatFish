package com.blackfish.gb;
 
import lombok.*;
 
import java.util.List;
 
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {
 
    private String name;
 
    private String code;
    
    private String dataFromUrl;
 
    private List<Node> nodes;
}