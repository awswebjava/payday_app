package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crearrecibopdf extends GXProcedure
{
   public crearrecibopdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crearrecibopdf.class ), "" );
   }

   public crearrecibopdf( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      crearrecibopdf.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        boolean[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      crearrecibopdf.this.AV24CliCod = aP0;
      crearrecibopdf.this.AV28EmpCod = aP1;
      crearrecibopdf.this.AV50LiqNro = aP2;
      crearrecibopdf.this.AV41LegNumero = aP3;
      crearrecibopdf.this.AV76TempRecTipoRecibo = aP4;
      crearrecibopdf.this.AV96soloCrearHTML = aP5;
      crearrecibopdf.this.AV112invocacionPDFMetodoPalabra = aP6;
      crearrecibopdf.this.AV114imprimirLiqLeg = aP7;
      crearrecibopdf.this.AV119liquidando = aP8;
      crearrecibopdf.this.aP9 = aP9;
      crearrecibopdf.this.aP10 = aP10;
      crearrecibopdf.this.aP11 = aP11;
      crearrecibopdf.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV32EmpNom ;
      GXv_int2[0] = AV29EmpCUIT ;
      GXv_char3[0] = "" ;
      GXv_char4[0] = AV30EmpDir ;
      GXv_char5[0] = "" ;
      GXv_char6[0] = "" ;
      GXv_char7[0] = AV31EmpLocNom ;
      GXv_char8[0] = AV33EmpProvNom ;
      new web.getdatosempresa(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, GXv_char1, GXv_int2, GXv_char3, GXv_char4, GXv_char5, GXv_char6, GXv_char7, GXv_char8) ;
      crearrecibopdf.this.AV32EmpNom = GXv_char1[0] ;
      crearrecibopdf.this.AV29EmpCUIT = GXv_int2[0] ;
      crearrecibopdf.this.AV30EmpDir = GXv_char4[0] ;
      crearrecibopdf.this.AV31EmpLocNom = GXv_char7[0] ;
      crearrecibopdf.this.AV33EmpProvNom = GXv_char8[0] ;
      GXv_int9[0] = AV59TempRecSec ;
      new web.getrecibosecportipo(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV76TempRecTipoRecibo, GXv_int9) ;
      crearrecibopdf.this.AV59TempRecSec = GXv_int9[0] ;
      GXv_char8[0] = AV56TempRecHTML ;
      GXv_char7[0] = AV14TempRecHTMLBody ;
      GXv_char6[0] = AV57TempRecHTMLRow ;
      GXv_char5[0] = AV61tipoRecibo ;
      GXv_int9[0] = AV58TempRecPageSize ;
      GXv_char4[0] = AV84TempRecExplIIGG ;
      new web.gettemplaterecibo(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV59TempRecSec, GXv_char8, GXv_char7, GXv_char6, GXv_char5, GXv_int9, GXv_char4) ;
      crearrecibopdf.this.AV56TempRecHTML = GXv_char8[0] ;
      crearrecibopdf.this.AV14TempRecHTMLBody = GXv_char7[0] ;
      crearrecibopdf.this.AV57TempRecHTMLRow = GXv_char6[0] ;
      crearrecibopdf.this.AV61tipoRecibo = GXv_char5[0] ;
      crearrecibopdf.this.AV58TempRecPageSize = GXv_int9[0] ;
      crearrecibopdf.this.AV84TempRecExplIIGG = GXv_char4[0] ;
      GXv_char8[0] = AV115ambientePalabra ;
      new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "env", ""), GXv_char8) ;
      crearrecibopdf.this.AV115ambientePalabra = GXv_char8[0] ;
      if ( ( GXutil.strcmp(AV112invocacionPDFMetodoPalabra, httpContext.getMessage( "TRIGGER", "")) == 0 ) && ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV115ambientePalabra)), httpContext.getMessage( "DESA", "")) != 0 ) )
      {
         AV113sufijoPalabra = httpContext.getMessage( "_t_", "") ;
      }
      GXv_char8[0] = AV111urlStyleCss ;
      GXv_boolean10[0] = AV110localEs ;
      new web.geturlbases3_segunambiente(remoteHandle, context).execute( AV24CliCod, httpContext.getMessage( "HTML", ""), GXv_char8, GXv_boolean10) ;
      crearrecibopdf.this.AV111urlStyleCss = GXv_char8[0] ;
      crearrecibopdf.this.AV110localEs = GXv_boolean10[0] ;
      if ( GXutil.strcmp(AV61tipoRecibo, "Apaisado") == 0 )
      {
         if ( AV110localEs )
         {
            AV111urlStyleCss += httpContext.getMessage( "/style_local.css", "") ;
         }
         else
         {
            AV111urlStyleCss += httpContext.getMessage( "/style.css", "") ;
         }
      }
      else
      {
         if ( AV110localEs )
         {
            AV111urlStyleCss += httpContext.getMessage( "/stylePortrait_local.css", "") ;
         }
         else
         {
            AV111urlStyleCss += httpContext.getMessage( "/stylePortrait.css", "") ;
         }
      }
      GXv_char8[0] = AV99ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV24CliCod, new web.a3lutilitiesesdocker_codigoparam(remoteHandle, context).executeUdp( ), GXv_char8) ;
      crearrecibopdf.this.AV99ParmValue = GXv_char8[0] ;
      AV98dockerizadoEs = GXutil.boolval( AV99ParmValue) ;
      GXv_char8[0] = AV99ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV24CliCod, new web.modoahorros3_codigoparam(remoteHandle, context).executeUdp( ), GXv_char8) ;
      crearrecibopdf.this.AV99ParmValue = GXv_char8[0] ;
      AV104modoAhorrS3Es = GXutil.boolval( AV99ParmValue) ;
      GXv_char8[0] = AV116remuTipoConCod ;
      GXv_char7[0] = AV117noRemuTipoConCod ;
      GXv_char6[0] = AV118descuTipoConCod ;
      new web.gettiposconceptocod(remoteHandle, context).execute( AV24CliCod, GXv_char8, GXv_char7, GXv_char6) ;
      crearrecibopdf.this.AV116remuTipoConCod = GXv_char8[0] ;
      crearrecibopdf.this.AV117noRemuTipoConCod = GXv_char7[0] ;
      crearrecibopdf.this.AV118descuTipoConCod = GXv_char6[0] ;
      AV63LongVarchar = "" ;
      AV79i = (short)(1) ;
      while ( AV79i <= AV41LegNumero.size() )
      {
         AV82auxLegNumero = ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue() ;
         /* Execute user subroutine: 'NOMBRE ARCHIVO HTML' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_char8[0] = AV109LiqLinkS3Html ;
         new web.getlinks3recibo(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV50LiqNro, ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue(), AV61tipoRecibo, GXv_char8) ;
         crearrecibopdf.this.AV109LiqLinkS3Html = GXv_char8[0] ;
         if ( ! (GXutil.strcmp("", AV109LiqLinkS3Html)==0) )
         {
            AV97archivoExiste = true ;
         }
         else
         {
            AV97archivoExiste = false ;
         }
         if ( ! AV97archivoExiste )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "no existe el archivo ", "")+GXutil.trim( AV94rutaArchivo)) ;
            GXv_char8[0] = AV13OsoSigla ;
            GXv_char7[0] = AV8BanDescrip ;
            GXv_char6[0] = AV9LegBanTipCuen ;
            GXv_char5[0] = AV10LegCuentaBanc ;
            GXv_char4[0] = "" ;
            GXv_char3[0] = AV23CatDescrip ;
            GXv_char1[0] = AV38LegCBU ;
            GXv_date11[0] = AV11LegFecIngreso ;
            GXv_char12[0] = AV40LegId ;
            GXv_char13[0] = AV44LiqDetLegNomApe ;
            GXv_int2[0] = AV39LegCUIL ;
            GXv_decimal14[0] = AV55sueldo ;
            GXv_char15[0] = AV72ZonProvincia ;
            GXv_char16[0] = AV108ConveCodigo ;
            new web.getdatoslegajorecibo(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue(), AV50LiqNro, GXv_char8, GXv_char7, GXv_char6, GXv_char5, GXv_char4, GXv_char3, GXv_char1, GXv_date11, GXv_char12, GXv_char13, GXv_int2, GXv_decimal14, GXv_char15, GXv_char16) ;
            crearrecibopdf.this.AV13OsoSigla = GXv_char8[0] ;
            crearrecibopdf.this.AV8BanDescrip = GXv_char7[0] ;
            crearrecibopdf.this.AV9LegBanTipCuen = GXv_char6[0] ;
            crearrecibopdf.this.AV10LegCuentaBanc = GXv_char5[0] ;
            crearrecibopdf.this.AV23CatDescrip = GXv_char3[0] ;
            crearrecibopdf.this.AV38LegCBU = GXv_char1[0] ;
            crearrecibopdf.this.AV11LegFecIngreso = GXv_date11[0] ;
            crearrecibopdf.this.AV40LegId = GXv_char12[0] ;
            crearrecibopdf.this.AV44LiqDetLegNomApe = GXv_char13[0] ;
            crearrecibopdf.this.AV39LegCUIL = GXv_int2[0] ;
            crearrecibopdf.this.AV55sueldo = GXv_decimal14[0] ;
            crearrecibopdf.this.AV72ZonProvincia = GXv_char15[0] ;
            crearrecibopdf.this.AV108ConveCodigo = GXv_char16[0] ;
            GXt_char17 = AV66LegCUILAux ;
            GXv_char16[0] = GXt_char17 ;
            new web.agregarguionescuil(remoteHandle, context).execute( GXutil.trim( GXutil.str( AV39LegCUIL, 11, 0)), GXv_char16) ;
            crearrecibopdf.this.GXt_char17 = GXv_char16[0] ;
            AV66LegCUILAux = GXt_char17 ;
            AV60tipoCuenta = AV9LegBanTipCuen ;
            AV26depositadoEn = GXutil.trim( AV8BanDescrip) + " " + GXutil.trim( AV60tipoCuenta) + " " + GXutil.trim( AV10LegCuentaBanc) ;
            GXv_char16[0] = AV62TliqDesc ;
            GXv_char15[0] = AV90TLiqCod ;
            GXv_date11[0] = AV12LiqFecPago ;
            GXv_date18[0] = AV42LiqDepPrvFec ;
            GXv_date19[0] = AV68LiqPeriodo ;
            GXv_char13[0] = AV51LiqPerSinDia ;
            GXv_char12[0] = AV43LiqDepPrvPer ;
            GXv_decimal14[0] = AV46LiqImpNeto ;
            GXv_decimal20[0] = AV49LiqLegImpTotRemu ;
            GXv_decimal21[0] = AV47LiqLegImpTotDescu ;
            GXv_decimal22[0] = AV48LiqLegImpTotNoRemu ;
            GXv_char8[0] = AV70LiqDepBanDescrip ;
            GXv_decimal23[0] = AV85LiqLegImpDescuNeg ;
            new web.getdatosliquidacionrecibo(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV50LiqNro, ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue(), AV116remuTipoConCod, AV117noRemuTipoConCod, AV118descuTipoConCod, GXv_char16, GXv_char15, GXv_date11, GXv_date18, GXv_date19, GXv_char13, GXv_char12, GXv_decimal14, GXv_decimal20, GXv_decimal21, GXv_decimal22, GXv_char8, GXv_decimal23) ;
            crearrecibopdf.this.AV62TliqDesc = GXv_char16[0] ;
            crearrecibopdf.this.AV90TLiqCod = GXv_char15[0] ;
            crearrecibopdf.this.AV12LiqFecPago = GXv_date11[0] ;
            crearrecibopdf.this.AV42LiqDepPrvFec = GXv_date18[0] ;
            crearrecibopdf.this.AV68LiqPeriodo = GXv_date19[0] ;
            crearrecibopdf.this.AV51LiqPerSinDia = GXv_char13[0] ;
            crearrecibopdf.this.AV43LiqDepPrvPer = GXv_char12[0] ;
            crearrecibopdf.this.AV46LiqImpNeto = GXv_decimal14[0] ;
            crearrecibopdf.this.AV49LiqLegImpTotRemu = GXv_decimal20[0] ;
            crearrecibopdf.this.AV47LiqLegImpTotDescu = GXv_decimal21[0] ;
            crearrecibopdf.this.AV48LiqLegImpTotNoRemu = GXv_decimal22[0] ;
            crearrecibopdf.this.AV70LiqDepBanDescrip = GXv_char8[0] ;
            crearrecibopdf.this.AV85LiqLegImpDescuNeg = GXv_decimal23[0] ;
            GXt_char17 = AV92mensualTLiqCod ;
            GXt_char24 = AV92mensualTLiqCod ;
            GXv_char16[0] = GXt_char24 ;
            new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char16) ;
            crearrecibopdf.this.GXt_char24 = GXv_char16[0] ;
            GXv_char15[0] = GXt_char17 ;
            new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char24, GXv_char15) ;
            crearrecibopdf.this.GXt_char17 = GXv_char15[0] ;
            AV92mensualTLiqCod = GXt_char17 ;
            if ( GXutil.strcmp(AV90TLiqCod, AV92mensualTLiqCod) == 0 )
            {
               GXv_int25[0] = AV93LegClase ;
               GXv_char16[0] = AV121LegModTra ;
               new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue(), GXv_int25, GXv_char16) ;
               crearrecibopdf.this.AV93LegClase = GXv_int25[0] ;
               crearrecibopdf.this.AV121LegModTra = GXv_char16[0] ;
               GXv_char16[0] = AV88auxTliqDesc ;
               new web.gettliqmodfrecdesc(remoteHandle, context).execute( AV24CliCod, AV90TLiqCod, AV121LegModTra, AV93LegClase, GXv_char16) ;
               crearrecibopdf.this.AV88auxTliqDesc = GXv_char16[0] ;
            }
            else
            {
               AV88auxTliqDesc = GXutil.trim( AV62TliqDesc) ;
            }
            AV67periodDescripcion = GXutil.trim( AV88auxTliqDesc) + " " + GXutil.padl( GXutil.str( GXutil.month( AV68LiqPeriodo), 10, 0), (short)(2), "0") + "/" + GXutil.trim( GXutil.str( GXutil.year( AV68LiqPeriodo), 10, 0)) ;
            GXt_char24 = AV71importeEnPalabras ;
            GXv_char16[0] = GXt_char24 ;
            new web.numeroaletras(remoteHandle, context).execute( AV46LiqImpNeto, GXv_char16) ;
            crearrecibopdf.this.GXt_char24 = GXv_char16[0] ;
            AV71importeEnPalabras = GXt_char24 ;
            AV71importeEnPalabras = GXutil.upper( AV71importeEnPalabras) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&TempRecSec ", "")+GXutil.trim( GXutil.str( AV59TempRecSec, 4, 0))+httpContext.getMessage( " 1 &TempRecHTML ", "")+AV56TempRecHTML+httpContext.getMessage( " &tipoRecibo ", "")+AV61tipoRecibo+httpContext.getMessage( " &TempRecPageSize ", "")+GXutil.trim( GXutil.str( AV58TempRecPageSize, 4, 0))) ;
            if ( (GXutil.strcmp("", AV56TempRecHTML)==0) || (GXutil.strcmp("", AV14TempRecHTMLBody)==0) || (GXutil.strcmp("", AV57TempRecHTMLRow)==0) || (GXutil.strcmp("", AV61tipoRecibo)==0) || (0==AV58TempRecPageSize) )
            {
               AV34error = httpContext.getMessage( "Template Recibo no configurado", "") ;
               returnInSub = true;
               cleanup();
               if (true) return;
               new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&error ", "")+AV34error) ;
            }
            else
            {
               GXt_int26 = AV18cantFilas ;
               GXv_int9[0] = GXt_int26 ;
               new web.liquidacioncantconceptos(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV50LiqNro, ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue(), GXv_int9) ;
               crearrecibopdf.this.GXt_int26 = GXv_int9[0] ;
               AV18cantFilas = GXt_int26 ;
               AV20cantPaginasAux = DecimalUtil.doubleToDec(AV18cantFilas/ (double) (AV58TempRecPageSize)) ;
               AV19cantPaginas = (short)(GXutil.Int( DecimalUtil.decToDouble(AV20cantPaginasAux))) ;
               AV52mod = (short)(((int)((AV18cantFilas) % (AV58TempRecPageSize)))) ;
               if ( ! (0==AV52mod) )
               {
                  AV19cantPaginas = (short)(AV19cantPaginas+1) ;
               }
               AV54pagina = (short)(1) ;
               AV16body = "" ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV24CliCod, AV124Pgmname, httpContext.getMessage( "cnt paginas ", "")+GXutil.trim( GXutil.str( AV19cantPaginas, 4, 0))+httpContext.getMessage( " &TempRecPageSize ", "")+GXutil.trim( GXutil.str( AV58TempRecPageSize, 4, 0))+httpContext.getMessage( " &cantFilas ", "")+GXutil.trim( GXutil.str( AV18cantFilas, 4, 0))+httpContext.getMessage( " &cantPaginasAux ", "")+GXutil.trim( GXutil.str( AV20cantPaginasAux, 8, 2))+httpContext.getMessage( " &mod ", "")+GXutil.trim( GXutil.str( AV52mod, 4, 0))) ;
               if ( AV104modoAhorrS3Es )
               {
                  AV106urlLogo = httpContext.getMessage( "../../../logo.png", "") ;
                  AV105urlFirma = httpContext.getMessage( "../../../firma.png", "") ;
               }
               else
               {
                  GXv_char16[0] = AV103EmpLogoNom ;
                  GXv_char15[0] = AV102EmpFirmaNom ;
                  new web.getempfotosnom(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, GXv_char16, GXv_char15) ;
                  crearrecibopdf.this.AV103EmpLogoNom = GXv_char16[0] ;
                  crearrecibopdf.this.AV102EmpFirmaNom = GXv_char15[0] ;
                  if ( ! (GXutil.strcmp("", AV103EmpLogoNom)==0) )
                  {
                     GXv_char16[0] = AV106urlLogo ;
                     new web.devuelveurlfoto(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, 0, httpContext.getMessage( "logo", ""), AV103EmpLogoNom, GXv_char16) ;
                     crearrecibopdf.this.AV106urlLogo = GXv_char16[0] ;
                  }
                  if ( ! (GXutil.strcmp("", AV102EmpFirmaNom)==0) )
                  {
                     GXv_char16[0] = AV105urlFirma ;
                     new web.devuelveurlfoto(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, 0, httpContext.getMessage( "firma", ""), AV102EmpFirmaNom, GXv_char16) ;
                     crearrecibopdf.this.AV105urlFirma = GXv_char16[0] ;
                  }
               }
               while ( AV54pagina <= AV19cantPaginas )
               {
                  GXv_char16[0] = AV90TLiqCod ;
                  GXv_int25[0] = AV93LegClase ;
                  GXv_date19[0] = AV68LiqPeriodo ;
                  GXv_char15[0] = AV36filas ;
                  GXv_int9[0] = AV25cntFilas ;
                  new web.escribedetallerecibo(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV50LiqNro, ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue(), AV57TempRecHTMLRow, AV58TempRecPageSize, AV54pagina, GXv_char16, GXv_int25, GXv_date19, GXv_char15, GXv_int9) ;
                  crearrecibopdf.this.AV90TLiqCod = GXv_char16[0] ;
                  crearrecibopdf.this.AV93LegClase = GXv_int25[0] ;
                  crearrecibopdf.this.AV68LiqPeriodo = GXv_date19[0] ;
                  crearrecibopdf.this.AV36filas = GXv_char15[0] ;
                  crearrecibopdf.this.AV25cntFilas = GXv_int9[0] ;
                  AV17bodyResuelto = GXutil.strReplace( AV14TempRecHTMLBody, httpContext.getMessage( "$nombreEmpresa", ""), GXutil.trim( AV32EmpNom)) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&urlLogo ", "")+AV106urlLogo) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$logo", ""), GXutil.trim( AV106urlLogo)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$firmaEmpleador", ""), GXutil.trim( AV105urlFirma)) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&nombreArchivoLogo ", "")+GXutil.trim( AV77nombreArchivoLogo)) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&&nombreArchivoFirma ", "")+GXutil.trim( AV78nombreArchivoFirma)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$direccionEmpresa", ""), GXutil.trim( AV30EmpDir)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$localidadEmpresa", ""), GXutil.trim( AV31EmpLocNom)+", "+GXutil.trim( AV33EmpProvNom)) ;
                  GXv_char16[0] = AV87cuit ;
                  new web.agregarguionescuil(remoteHandle, context).execute( GXutil.trim( GXutil.str( AV29EmpCUIT, 11, 0)), GXv_char16) ;
                  crearrecibopdf.this.AV87cuit = GXv_char16[0] ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$cuitEmpresa", ""), GXutil.trim( AV87cuit)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$liquidacionNumero", ""), GXutil.trim( GXutil.str( AV50LiqNro, 8, 0))) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$legajoId", ""), GXutil.trim( AV40LegId)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$legajoNombre", ""), GXutil.upper( GXutil.trim( AV44LiqDetLegNomApe))) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$legajoCUIL", ""), GXutil.trim( AV66LegCUILAux)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$periodoAbonado", ""), GXutil.trim( AV51LiqPerSinDia)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$periodoDescripcion", ""), GXutil.trim( AV67periodDescripcion)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$fechaPago", ""), GXutil.trim( localUtil.dtoc( AV12LiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$lugarDeTrabajo", ""), GXutil.trim( AV72ZonProvincia)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$fechaIngreso", ""), GXutil.trim( localUtil.dtoc( AV11LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$sueldo", ""), localUtil.format( AV55sueldo, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$banco", ""), GXutil.trim( AV70LiqDepBanDescrip)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$fechaDepPrev", ""), GXutil.trim( localUtil.dtoc( AV42LiqDepPrvFec, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                  if ( ! (GXutil.strcmp("", AV108ConveCodigo)==0) )
                  {
                     AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$tituloCategoria", ""), httpContext.getMessage( "Convenio y categoría", "")) ;
                  }
                  else
                  {
                     AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$tituloCategoria", ""), httpContext.getMessage( "Puesto", "")) ;
                  }
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$categoria", ""), GXutil.trim( AV23CatDescrip)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$periodo", ""), GXutil.trim( AV43LiqDepPrvPer)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$netoImporte", ""), localUtil.format( AV46LiqImpNeto, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$netoPalabras", ""), GXutil.trim( AV71importeEnPalabras)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$depositadoEn", ""), GXutil.trim( AV26depositadoEn)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$cbu", ""), GXutil.trim( AV38LegCBU)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$lugarDePago", ""), GXutil.trim( AV72ZonProvincia)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$obraSocial", ""), GXutil.trim( AV13OsoSigla)) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$totalRemunerativos", ""), localUtil.format( AV49LiqLegImpTotRemu, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$totalDescuentos", ""), localUtil.format( AV47LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
                  AV86Importes = AV85LiqLegImpDescuNeg.add(AV48LiqLegImpTotNoRemu) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$totalNoRemu", ""), localUtil.format( AV86Importes, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
                  AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$TR_FilasDetalle", ""), GXutil.trim( AV36filas)) ;
                  AV16body += AV17bodyResuelto ;
                  AV54pagina = (short)(AV54pagina+1) ;
               }
               AV17bodyResuelto = GXutil.strReplace( AV17bodyResuelto, httpContext.getMessage( "$explicacionGanancias", ""), GXutil.trim( AV84TempRecExplIIGG)) ;
               new web.msgdebug7(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&body ", "")+GXutil.trim( AV16body)) ;
               new web.msgdebug7(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&&bodyResuelto ", "")+GXutil.trim( AV17bodyResuelto)) ;
               if ( (GXutil.strcmp("", AV16body)==0) )
               {
                  AV16body = httpContext.getMessage( "Error, sin datos. Cantidad de páginas: ", "") + GXutil.trim( GXutil.str( AV19cantPaginas, 4, 0)) + httpContext.getMessage( ". Páginas procesadas: ", "") + GXutil.trim( GXutil.str( AV54pagina, 4, 0)) + " " ;
               }
               AV63LongVarchar += GXutil.strReplace( AV56TempRecHTML, httpContext.getMessage( "$body", ""), AV16body) ;
            }
            AV63LongVarchar = GXutil.strReplace( AV63LongVarchar, httpContext.getMessage( "$HREF_CSS", ""), GXutil.trim( AV111urlStyleCss)) ;
            GXv_char16[0] = AV34error ;
            GXv_char15[0] = AV75nombreArchivoGenerado ;
            new web.enviahtmlas3(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV50LiqNro, ((Number) AV41LegNumero.elementAt(-1+AV79i)).intValue(), AV53NombreArchivo, AV63LongVarchar, AV61tipoRecibo, AV112invocacionPDFMetodoPalabra, AV114imprimirLiqLeg, AV119liquidando, GXv_char16, GXv_char15) ;
            crearrecibopdf.this.AV34error = GXv_char16[0] ;
            crearrecibopdf.this.AV75nombreArchivoGenerado = GXv_char15[0] ;
            if ( ! (GXutil.strcmp("", AV34error)==0) )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "ya existe el &rutaArchivo ", "")+GXutil.trim( AV94rutaArchivo)+httpContext.getMessage( " nombrearchivo ", "")+AV53NombreArchivo) ;
         }
         if ( ( GXutil.strcmp(AV112invocacionPDFMetodoPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) && ( GXutil.strcmp(AV114imprimirLiqLeg, httpContext.getMessage( "MASIVO", "")) == 0 ) && ! AV96soloCrearHTML )
         {
            /* Execute user subroutine: 'INVOCAR NODE' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV79i = (short)(AV79i+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&soloCrearHTML ", "")+GXutil.trim( GXutil.booltostr( AV96soloCrearHTML))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "!&error ", "")+AV34error) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'INVOCAR NODE' Routine */
      returnInSub = false ;
      GXv_char16[0] = AV34error ;
      GXv_char15[0] = AV73rutaPDF ;
      GXv_char13[0] = AV75nombreArchivoGenerado ;
      new web.invocarrecibopdf(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV82auxLegNumero, new web.nombrearchivorecibo(remoteHandle, context).executeUdp( AV24CliCod, AV28EmpCod, AV50LiqNro, AV82auxLegNumero, AV61tipoRecibo, "", ""), AV53NombreArchivo, GXv_char16, GXv_char15, GXv_char13) ;
      crearrecibopdf.this.AV34error = GXv_char16[0] ;
      crearrecibopdf.this.AV73rutaPDF = GXv_char15[0] ;
      crearrecibopdf.this.AV75nombreArchivoGenerado = GXv_char13[0] ;
      new web.msgdebug7(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&nombreArchivoGenerado ", "")+AV75nombreArchivoGenerado+httpContext.getMessage( " &error ", "")+AV34error) ;
      if ( (GXutil.strcmp("", AV34error)==0) )
      {
         GXv_char16[0] = AV99ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV24CliCod, new web.bucketnamepdf_codigo(remoteHandle, context).executeUdp( ), GXv_char16) ;
         crearrecibopdf.this.AV99ParmValue = GXv_char16[0] ;
         if ( ! (GXutil.strcmp("", AV99ParmValue)==0) )
         {
            GXt_char24 = AV107bucket_name ;
            GXt_char17 = AV107bucket_name ;
            GXv_char16[0] = GXt_char17 ;
            new web.bucketnamepdf_codigo(remoteHandle, context).execute( GXv_char16) ;
            crearrecibopdf.this.GXt_char17 = GXv_char16[0] ;
            GXv_char15[0] = GXt_char24 ;
            new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char17, GXv_char15) ;
            crearrecibopdf.this.GXt_char24 = GXv_char15[0] ;
            AV107bucket_name = GXt_char24 ;
            GXv_char16[0] = AV34error ;
            new web.invocarauploads3(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV28EmpCod, AV82auxLegNumero, AV82auxLegNumero, AV75nombreArchivoGenerado, httpContext.getMessage( "application/pdf", ""), AV107bucket_name, "", GXv_char16) ;
            crearrecibopdf.this.AV34error = GXv_char16[0] ;
            if ( ! (GXutil.strcmp("", AV34error)==0) )
            {
               returnInSub = true;
               if (true) return;
            }
         }
      }
      else
      {
         AV74falloGeneracionPDF = true ;
      }
      if ( ! (GXutil.strcmp("", AV34error)==0) )
      {
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'NOMBRE ARCHIVO HTML' Routine */
      returnInSub = false ;
      GXt_char24 = AV53NombreArchivo ;
      GXv_char16[0] = GXt_char24 ;
      new web.nombrearchivorecibo(remoteHandle, context).execute( AV24CliCod, AV28EmpCod, AV50LiqNro, AV82auxLegNumero, AV61tipoRecibo, httpContext.getMessage( "html", ""), AV113sufijoPalabra, GXv_char16) ;
      crearrecibopdf.this.GXt_char24 = GXv_char16[0] ;
      AV53NombreArchivo = GXt_char24 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV124Pgmname, httpContext.getMessage( "&&NombreArchivo ", "")+AV53NombreArchivo) ;
   }

   protected void cleanup( )
   {
      this.aP9[0] = crearrecibopdf.this.AV74falloGeneracionPDF;
      this.aP10[0] = crearrecibopdf.this.AV34error;
      this.aP11[0] = crearrecibopdf.this.AV73rutaPDF;
      this.aP12[0] = crearrecibopdf.this.AV75nombreArchivoGenerado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV34error = "" ;
      AV73rutaPDF = "" ;
      AV75nombreArchivoGenerado = "" ;
      AV32EmpNom = "" ;
      AV30EmpDir = "" ;
      AV31EmpLocNom = "" ;
      AV33EmpProvNom = "" ;
      AV56TempRecHTML = "" ;
      AV14TempRecHTMLBody = "" ;
      AV57TempRecHTMLRow = "" ;
      AV61tipoRecibo = "" ;
      AV84TempRecExplIIGG = "" ;
      AV115ambientePalabra = "" ;
      AV113sufijoPalabra = "" ;
      AV111urlStyleCss = "" ;
      GXv_boolean10 = new boolean[1] ;
      AV99ParmValue = "" ;
      AV116remuTipoConCod = "" ;
      AV117noRemuTipoConCod = "" ;
      AV118descuTipoConCod = "" ;
      AV63LongVarchar = "" ;
      AV109LiqLinkS3Html = "" ;
      AV124Pgmname = "" ;
      AV94rutaArchivo = "" ;
      AV13OsoSigla = "" ;
      AV8BanDescrip = "" ;
      GXv_char7 = new String[1] ;
      AV9LegBanTipCuen = "" ;
      GXv_char6 = new String[1] ;
      AV10LegCuentaBanc = "" ;
      GXv_char5 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV23CatDescrip = "" ;
      GXv_char3 = new String[1] ;
      AV38LegCBU = "" ;
      GXv_char1 = new String[1] ;
      AV11LegFecIngreso = GXutil.nullDate() ;
      AV40LegId = "" ;
      AV44LiqDetLegNomApe = "" ;
      GXv_int2 = new long[1] ;
      AV55sueldo = DecimalUtil.ZERO ;
      AV72ZonProvincia = "" ;
      AV108ConveCodigo = "" ;
      AV66LegCUILAux = "" ;
      AV60tipoCuenta = "" ;
      AV26depositadoEn = "" ;
      AV62TliqDesc = "" ;
      AV90TLiqCod = "" ;
      AV12LiqFecPago = GXutil.nullDate() ;
      GXv_date11 = new java.util.Date[1] ;
      AV42LiqDepPrvFec = GXutil.nullDate() ;
      GXv_date18 = new java.util.Date[1] ;
      AV68LiqPeriodo = GXutil.nullDate() ;
      AV51LiqPerSinDia = "" ;
      AV43LiqDepPrvPer = "" ;
      GXv_char12 = new String[1] ;
      AV46LiqImpNeto = DecimalUtil.ZERO ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      AV49LiqLegImpTotRemu = DecimalUtil.ZERO ;
      GXv_decimal20 = new java.math.BigDecimal[1] ;
      AV47LiqLegImpTotDescu = DecimalUtil.ZERO ;
      GXv_decimal21 = new java.math.BigDecimal[1] ;
      AV48LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      GXv_decimal22 = new java.math.BigDecimal[1] ;
      AV70LiqDepBanDescrip = "" ;
      GXv_char8 = new String[1] ;
      AV85LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      GXv_decimal23 = new java.math.BigDecimal[1] ;
      AV92mensualTLiqCod = "" ;
      AV121LegModTra = "" ;
      AV88auxTliqDesc = "" ;
      AV67periodDescripcion = "" ;
      AV71importeEnPalabras = "" ;
      AV20cantPaginasAux = DecimalUtil.ZERO ;
      AV16body = "" ;
      AV106urlLogo = "" ;
      AV105urlFirma = "" ;
      AV103EmpLogoNom = "" ;
      AV102EmpFirmaNom = "" ;
      GXv_int25 = new byte[1] ;
      GXv_date19 = new java.util.Date[1] ;
      AV36filas = "" ;
      GXv_int9 = new short[1] ;
      AV17bodyResuelto = "" ;
      AV77nombreArchivoLogo = "" ;
      AV78nombreArchivoFirma = "" ;
      AV87cuit = "" ;
      AV86Importes = DecimalUtil.ZERO ;
      AV53NombreArchivo = "" ;
      GXv_char13 = new String[1] ;
      AV107bucket_name = "" ;
      GXt_char17 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char24 = "" ;
      GXv_char16 = new String[1] ;
      AV124Pgmname = "crearReciboPDF" ;
      /* GeneXus formulas. */
      AV124Pgmname = "crearReciboPDF" ;
      Gx_err = (short)(0) ;
   }

   private byte AV93LegClase ;
   private byte GXv_int25[] ;
   private short AV28EmpCod ;
   private short AV59TempRecSec ;
   private short AV58TempRecPageSize ;
   private short AV79i ;
   private short AV18cantFilas ;
   private short GXt_int26 ;
   private short AV19cantPaginas ;
   private short AV52mod ;
   private short AV54pagina ;
   private short AV25cntFilas ;
   private short GXv_int9[] ;
   private short Gx_err ;
   private int AV24CliCod ;
   private int AV50LiqNro ;
   private int AV82auxLegNumero ;
   private long AV29EmpCUIT ;
   private long AV39LegCUIL ;
   private long GXv_int2[] ;
   private java.math.BigDecimal AV55sueldo ;
   private java.math.BigDecimal AV46LiqImpNeto ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal AV49LiqLegImpTotRemu ;
   private java.math.BigDecimal GXv_decimal20[] ;
   private java.math.BigDecimal AV47LiqLegImpTotDescu ;
   private java.math.BigDecimal GXv_decimal21[] ;
   private java.math.BigDecimal AV48LiqLegImpTotNoRemu ;
   private java.math.BigDecimal GXv_decimal22[] ;
   private java.math.BigDecimal AV85LiqLegImpDescuNeg ;
   private java.math.BigDecimal GXv_decimal23[] ;
   private java.math.BigDecimal AV20cantPaginasAux ;
   private java.math.BigDecimal AV86Importes ;
   private String AV76TempRecTipoRecibo ;
   private String AV112invocacionPDFMetodoPalabra ;
   private String AV114imprimirLiqLeg ;
   private String AV61tipoRecibo ;
   private String AV115ambientePalabra ;
   private String AV113sufijoPalabra ;
   private String AV116remuTipoConCod ;
   private String AV117noRemuTipoConCod ;
   private String AV118descuTipoConCod ;
   private String AV124Pgmname ;
   private String AV13OsoSigla ;
   private String GXv_char7[] ;
   private String AV9LegBanTipCuen ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char1[] ;
   private String AV40LegId ;
   private String AV108ConveCodigo ;
   private String AV66LegCUILAux ;
   private String AV60tipoCuenta ;
   private String AV90TLiqCod ;
   private String AV51LiqPerSinDia ;
   private String AV43LiqDepPrvPer ;
   private String GXv_char12[] ;
   private String GXv_char8[] ;
   private String AV92mensualTLiqCod ;
   private String AV121LegModTra ;
   private String AV77nombreArchivoLogo ;
   private String AV78nombreArchivoFirma ;
   private String AV87cuit ;
   private String GXv_char13[] ;
   private String GXt_char17 ;
   private String GXv_char15[] ;
   private String GXt_char24 ;
   private String GXv_char16[] ;
   private java.util.Date AV11LegFecIngreso ;
   private java.util.Date AV12LiqFecPago ;
   private java.util.Date GXv_date11[] ;
   private java.util.Date AV42LiqDepPrvFec ;
   private java.util.Date GXv_date18[] ;
   private java.util.Date AV68LiqPeriodo ;
   private java.util.Date GXv_date19[] ;
   private boolean AV96soloCrearHTML ;
   private boolean AV119liquidando ;
   private boolean AV74falloGeneracionPDF ;
   private boolean AV110localEs ;
   private boolean GXv_boolean10[] ;
   private boolean AV98dockerizadoEs ;
   private boolean AV104modoAhorrS3Es ;
   private boolean returnInSub ;
   private boolean AV97archivoExiste ;
   private String AV56TempRecHTML ;
   private String AV14TempRecHTMLBody ;
   private String AV84TempRecExplIIGG ;
   private String AV99ParmValue ;
   private String AV63LongVarchar ;
   private String AV36filas ;
   private String AV17bodyResuelto ;
   private String AV34error ;
   private String AV73rutaPDF ;
   private String AV75nombreArchivoGenerado ;
   private String AV32EmpNom ;
   private String AV30EmpDir ;
   private String AV31EmpLocNom ;
   private String AV33EmpProvNom ;
   private String AV57TempRecHTMLRow ;
   private String AV111urlStyleCss ;
   private String AV109LiqLinkS3Html ;
   private String AV94rutaArchivo ;
   private String AV8BanDescrip ;
   private String AV10LegCuentaBanc ;
   private String AV23CatDescrip ;
   private String AV38LegCBU ;
   private String AV44LiqDetLegNomApe ;
   private String AV72ZonProvincia ;
   private String AV26depositadoEn ;
   private String AV62TliqDesc ;
   private String AV70LiqDepBanDescrip ;
   private String AV88auxTliqDesc ;
   private String AV67periodDescripcion ;
   private String AV71importeEnPalabras ;
   private String AV16body ;
   private String AV106urlLogo ;
   private String AV105urlFirma ;
   private String AV103EmpLogoNom ;
   private String AV102EmpFirmaNom ;
   private String AV53NombreArchivo ;
   private String AV107bucket_name ;
   private GXSimpleCollection<Integer> AV41LegNumero ;
   private String[] aP12 ;
   private boolean[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
}

