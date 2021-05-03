def areaCircuferencia(raio):
    area =  3.14*raio**2
    return area

def volCilindro(raio, altura):
    areaCirc = areaCircuferencia(raio)
    vol = areaCirc * altura
    return vol
    
volume = volCilindro(10, 12)
print(volume)