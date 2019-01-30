export class Form {

    id: number;
    town: string;
    skiarea: string;
    sizeskiarea: string;
    snowheight: string;
    mapskiarea: string;
    liftsopened: string;
    foto: string;

    constructor(id: number, town: string, skiarea: string, sizeskiarea: string, snowheight: string, 
      mapskiarea: string, liftsopened: string, foto: string) {
        
        this.id = id;
        this.town = town;
        this.skiarea = skiarea;
        this.sizeskiarea = sizeskiarea;
        this.snowheight = snowheight;
        this.mapskiarea = mapskiarea;
        this.liftsopened = liftsopened;
        this.foto = foto;
      }
    }

