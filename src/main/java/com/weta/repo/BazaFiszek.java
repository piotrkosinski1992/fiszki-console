package com.weta.repo;

import java.util.ArrayList;
import java.util.List;

import com.weta.model.Fiszka;

public class BazaFiszek {

	private List<Fiszka> listaFiszek = new ArrayList<Fiszka>();
	
	public BazaFiszek() {
//		listaFiszek.add(new Fiszka("po","�"));
//		listaFiszek.add(new Fiszka("daj takich dawek","D.t.d"));
//		listaFiszek.add(new Fiszka("w r�wnych cz�ciach","aa"));
//		listaFiszek.add(new Fiszka("do","ad"));
//		listaFiszek.add(new Fiszka("do op�atk�w","ad caps. amyl."));
//		listaFiszek.add(new Fiszka("dowolnie, wed�ug uznania","ad lib."));
//		listaFiszek.add(new Fiszka("r�wny","aeq"));
//		listaFiszek.add(new Fiszka("koszyczek kwiatowy","Anthod"));
//		listaFiszek.add(new Fiszka("woda","Aq."));
//		listaFiszek.add(new Fiszka("woda destylowana","Aq. dest."));
//		listaFiszek.add(new Fiszka("woda do iniekcji","Aq. pro inj."));
//		listaFiszek.add(new Fiszka("ga�ka","Bol."));
//		listaFiszek.add(new Fiszka("kapsu�ka","Caps."));
//		listaFiszek.add(new Fiszka("kora","Cort."));
//		listaFiszek.add(new Fiszka("daj, wydaj","D."));
//		listaFiszek.add(new Fiszka("odwar","Dec."));
//		
//		listaFiszek.add(new Fiszka("destylowany","dest"));
//		listaFiszek.add(new Fiszka("dra�etki","Drag."));
//		listaFiszek.add(new Fiszka("rozdziel, podziel","div."));
//		listaFiszek.add(new Fiszka("podziel na r�wne cz�ci","div. in part. aeq."));
//		listaFiszek.add(new Fiszka("emulsja","Emuls"));
//		listaFiszek.add(new Fiszka("w danym czasie","ex temp."));
//		listaFiszek.add(new Fiszka("wyci�g","Extr."));
//		listaFiszek.add(new Fiszka("niech powstanie, zr�b","f."));
//		listaFiszek.add(new Fiszka("kwiat, kwiaty","Fl."));
//		listaFiszek.add(new Fiszka("li��","Fol."));
//		listaFiszek.add(new Fiszka("owoc","Fr."));
//		listaFiszek.add(new Fiszka("gram","g"));
//		listaFiszek.add(new Fiszka("kropla","Gtt."));
//		listaFiszek.add(new Fiszka("ziele","Hb., H-ba"));
//		
//		listaFiszek.add(new Fiszka("napar","Inf"));
//		listaFiszek.add(new Fiszka("wstrzykni�cie, zastrzyk","Inj."));
//		listaFiszek.add(new Fiszka("wstrzykni�cie domi�niowe","Inj. i.m."));
//		listaFiszek.add(new Fiszka("wstrzykni�cie do�ylne","Inj. i.v."));
//		listaFiszek.add(new Fiszka("wstrzykni�cie podsk�rne","Inj. s.c."));
//		listaFiszek.add(new Fiszka("zgodnie ze sztuk�","l. a."));
//		listaFiszek.add(new Fiszka("naczynie, butelka","Lag."));
//		listaFiszek.add(new Fiszka("opakowanie oryginalne","Lag. orig."));
//		listaFiszek.add(new Fiszka("mazid�o","Lin."));
//		listaFiszek.add(new Fiszka("zmieszaj","m."));
//		listaFiszek.add(new Fiszka("zmieszaj, wydaj, oznacz","M. D. S."));
//		listaFiszek.add(new Fiszka("zmieszaj, zr�b","M. f"));
//		listaFiszek.add(new Fiszka("zmieszaj, zr�b proszek","M. f. pulv. "));
//		listaFiszek.add(new Fiszka("mieszanka","Mixt."));
//		
//		listaFiszek.add(new Fiszka("w liczbie","No, Nr"));
//		listaFiszek.add(new Fiszka("olej","Ol."));
//		listaFiszek.add(new Fiszka("cz��","p."));
//		listaFiszek.add(new Fiszka("r�wne cz�ci","p. aeq."));
//		listaFiszek.add(new Fiszka("proszek","Pulv."));
//		listaFiszek.add(new Fiszka("ile potrzeba","q.s."));
//		listaFiszek.add(new Fiszka("korze�","Rad."));
//		listaFiszek.add(new Fiszka("we�","Rp."));
//		listaFiszek.add(new Fiszka("powt�rzy�","rep."));
//		listaFiszek.add(new Fiszka("�ywica","Res."));
//		listaFiszek.add(new Fiszka("k��cze","Rhiz."));
//		listaFiszek.add(new Fiszka("nasienie","Sem."));
//		listaFiszek.add(new Fiszka("suchy","sicc."));
//		listaFiszek.add(new Fiszka("oznacz","S."));
//		
//		listaFiszek.add(new Fiszka("syrop","Sir."));
//		listaFiszek.add(new Fiszka("roztw�r","Sol."));
//		listaFiszek.add(new Fiszka("zi�ka","Spec."));
//		listaFiszek.add(new Fiszka("wyja�owiony","steril."));
//		listaFiszek.add(new Fiszka("sok","Succ."));
//		listaFiszek.add(new Fiszka("zawiesina","Susp."));
//		listaFiszek.add(new Fiszka("czopki","Supp."));
//		listaFiszek.add(new Fiszka("tabletki","Tabl."));
//		listaFiszek.add(new Fiszka("nalewka","Tct., T-ra"));
//		listaFiszek.add(new Fiszka("ma��","Ung."));

		
	}

	public List<Fiszka> getListaFiszek() {
		return listaFiszek;
	}

	public void setListaFiszek(List<Fiszka> listaFiszek) {
		this.listaFiszek = listaFiszek;
	}
	
	
	
}
