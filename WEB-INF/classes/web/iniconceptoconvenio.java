package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class iniconceptoconvenio extends GXProcedure
{
   public iniconceptoconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( iniconceptoconvenio.class ), "" );
   }

   public iniconceptoconvenio( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      iniconceptoconvenio.this.AV10CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV11PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getpaicod(remoteHandle, context).execute( AV10CliCod, GXv_int2) ;
      iniconceptoconvenio.this.GXt_int1 = GXv_int2[0] ;
      AV11PaiCod = GXt_int1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TÍTULO TERCIARIO", ""), "", GXv_char4) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char3 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouecara(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "2") ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TÍTULO SECUNDARIO TÉCNICO", ""), "", GXv_char4) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char3 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouecara(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TÍTULO SECUNDARIO", ""), "", GXv_char4) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char3 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouecara(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO 101 a 500 KM", ""), "", GXv_char4) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char3 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouecara(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO 501 a 1.000 KM", ""), "", GXv_char4) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char3 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouecara(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO MAS DE 1.000 KM", ""), "", GXv_char4) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char3 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouecara(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char3 = AV8ConCodigo ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char4[0] = GXt_char5 ;
      new web.conveniouocra(remoteHandle, context).execute( GXv_char4) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char4[0] ;
      GXv_char6[0] = GXt_char3 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "SEGURO COLECTIVO DE VIDA OBLIGATORIO", ""), GXt_char5, GXv_char6) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char3 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TÍTULO HABILITANTE", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO HASTA 5 KM", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO HASTA DE 5 A 10 KM", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO HASTA DE 10 A 15 KM", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO HASTA DE 15 A 25 KM", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TRASLADO HASTA DE 25 A 30 KM", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR COLOCACIÓN DE AZULEJOS Y OTROS", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR EXCAVACIÓN", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ALTURA 4 A 26 M", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ALTURA 26 A 40 M", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ALTURA MAS DE 40 M", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR SOLDADOR ELÉCTRICO DE ALTA PRESIÓN", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR SOLDADOR MONTADOR/CAÑISTA/ELÉCTRICO/INSTRUMENTISTA/ELECTRISISTA", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR SOLDADOR AMIANTISTA/REVESTIDOR/LINGADOR/AUTOGENO/HERRERO/CALDERERO/MANDRILADOR/TALLER DE OBRA", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ESPECIALISTA EN A/C OFICIAL", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ESPECIALISTA EN A/C MEDIO OFICIAL", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ESPECIALISTA EN A/C AYUDANTE PRÁCTICO", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ENCARGADO", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR TECHADO ASFÁLTICO", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ESPECIALIDAD LAVADOR DE FRENTE", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ALOJAMIENTO/COMIDA/LAVADO DE ROPA", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ESTADÍA EN EL INTERIOR DEL PAÍS", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR COLADA DE HORMIGÓN", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "FONDO DE CESE LABORAL", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "GRATIFICACIÓN POR CESE LABORAL", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocra(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char3 ;
      new web.concepto_espersonaldepozo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char6[0] ;
      GXv_char4[0] = GXt_char5 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char3, GXv_char4) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "VIANDA", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "AYUDA ALIMENTARIA", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "HORAS DE VIAJE", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ALTURA 4 A 26 M", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ALTURA 26 A 40 M", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR ALTURA MAS DE 40 M", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "ADICIONAL POR COLADA DE HORMIGÓN", ""), "", GXv_char6) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char6[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      GXt_char5 = AV8ConCodigo ;
      GXt_char3 = AV8ConCodigo ;
      GXv_char6[0] = GXt_char3 ;
      new web.conveniouocrayac(remoteHandle, context).execute( GXv_char6) ;
      iniconceptoconvenio.this.GXt_char3 = GXv_char6[0] ;
      GXv_char4[0] = GXt_char5 ;
      new web.getconceptopordescsinconvenio(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "SEGURO COLECTIVO DE VIDA OBLIGATORIO", ""), GXt_char3, GXv_char4) ;
      iniconceptoconvenio.this.GXt_char5 = GXv_char4[0] ;
      AV8ConCodigo = GXt_char5 ;
      new web.newconceptoconvenio(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, AV11PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      AV14Pgmname = "" ;
      AV8ConCodigo = "" ;
      GXt_char5 = "" ;
      GXt_char3 = "" ;
      GXv_char6 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV14Pgmname = "iniConceptoConvenio" ;
      /* GeneXus formulas. */
      AV14Pgmname = "iniConceptoConvenio" ;
      Gx_err = (short)(0) ;
   }

   private short AV11PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV14Pgmname ;
   private String AV8ConCodigo ;
   private String GXt_char5 ;
   private String GXt_char3 ;
   private String GXv_char6[] ;
   private String GXv_char4[] ;
}

