def mediaNotas(nota1, nota2, nota3):
    mediaSimples = (nota1 + nota2 + nota3)/3
    mediaPonderada = nota1*.6+nota2*0.2+nota3*0.2
    return mediaSimples, mediaPonderada
    
mediaSim, mediaPond = mediaNotas(10, 17, 20)
print("Media simples é ", mediaSim)
print("Media ponderada é ", mediaPond)