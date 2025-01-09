package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarconceptos2 extends GXProcedure
{
   public importarconceptos2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarconceptos2.class ), "" );
   }

   public importarconceptos2( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          int aP1 ,
                          String aP2 ,
                          boolean aP3 ,
                          short aP4 ,
                          String aP5 ,
                          int aP6 ,
                          long[] aP7 ,
                          String[] aP8 ,
                          short[] aP9 )
   {
      importarconceptos2.this.aP10 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        short aP4 ,
                        String aP5 ,
                        int aP6 ,
                        long[] aP7 ,
                        String[] aP8 ,
                        short[] aP9 ,
                        int[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             short aP4 ,
                             String aP5 ,
                             int aP6 ,
                             long[] aP7 ,
                             String[] aP8 ,
                             short[] aP9 ,
                             int[] aP10 )
   {
      importarconceptos2.this.AV82padre_clicod = aP0;
      importarconceptos2.this.AV14CliCod = aP1;
      importarconceptos2.this.AV98parmConCodigo = aP2;
      importarconceptos2.this.AV16clienteConvenioEs = aP3;
      importarconceptos2.this.AV94versionador_CliPaiConve = aP4;
      importarconceptos2.this.AV93versionador_CliConvenio = aP5;
      importarconceptos2.this.AV124CliRelSec = aP6;
      importarconceptos2.this.aP7 = aP7;
      importarconceptos2.this.aP8 = aP8;
      importarconceptos2.this.aP9 = aP9;
      importarconceptos2.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV100sueldoDescrip ;
      GXv_char2[0] = GXt_char1 ;
      new web.getsueldodescripconcepto(remoteHandle, context).execute( AV15clicod_sistema, GXv_char2) ;
      importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
      AV100sueldoDescrip = GXt_char1 ;
      GXt_char1 = AV85prefijoDED ;
      GXv_char2[0] = GXt_char1 ;
      new web.prefijodeduccion(remoteHandle, context).execute( GXv_char2) ;
      importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
      AV85prefijoDED = GXt_char1 ;
      new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "!!!&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
      AV66importar = true ;
      GXt_int3 = AV83PaiCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.clientegetpais(remoteHandle, context).execute( AV14CliCod, GXv_int4) ;
      importarconceptos2.this.GXt_int3 = GXv_int4[0] ;
      AV83PaiCod = GXt_int3 ;
      GXv_int5[0] = AV15clicod_sistema ;
      new web.clientenucleodepais(remoteHandle, context).execute( AV83PaiCod, GXv_int5) ;
      importarconceptos2.this.AV15clicod_sistema = GXv_int5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "!!!&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))+httpContext.getMessage( " &clicod_sistema ", "")+GXutil.trim( GXutil.str( AV15clicod_sistema, 6, 0))) ;
      if ( AV14CliCod == AV15clicod_sistema )
      {
         AV133GXLvl19 = (byte)(0) ;
         /* Using cursor P01OW2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV15clicod_sistema)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P01OW2_A3CliCod[0] ;
            A26ConCodigo = P01OW2_A26ConCodigo[0] ;
            AV133GXLvl19 = (byte)(1) ;
            httpContext.GX_msglist.addItem(httpContext.getMessage( "Función no disponible", ""));
            new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "Función no disponible", "")) ;
            AV66importar = false ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV133GXLvl19 == 0 )
         {
            AV28ConForExportar = true ;
            GXt_char1 = AV74Location_Host ;
            GXv_char2[0] = GXt_char1 ;
            new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "HOST_IMP_CONC", ""), GXv_char2) ;
            importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
            AV74Location_Host = GXt_char1 ;
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "PORT_IMP_CONC", ""), GXv_char2) ;
            importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
            AV75Location_Port = GXutil.lval( GXt_char1) ;
            AV76Location_Secure = (short)(0) ;
            GXt_char1 = AV73Location_BaseURL ;
            GXv_char2[0] = GXt_char1 ;
            new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "BASEURL_IMP_CONC", ""), GXv_char2) ;
            importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
            AV73Location_BaseURL = GXt_char1 ;
            GXv_objcol_Sdthttp_headers_http_headersItem6[0] = AV62http_headers ;
            new web.headerjsonadd(remoteHandle, context).execute( GXv_objcol_Sdthttp_headers_http_headersItem6) ;
            AV62http_headers = GXv_objcol_Sdthttp_headers_http_headersItem6[0] ;
            if ( ! (GXutil.strcmp("", AV98parmConCodigo)==0) )
            {
               AV12body = httpContext.getMessage( "ConCodigo=", "") + GXutil.trim( AV98parmConCodigo) ;
            }
            GXv_char2[0] = AV87responsejson ;
            GXv_int5[0] = 0 ;
            new web.restexecute(remoteHandle, context).execute( AV74Location_Host, (int)(AV75Location_Port), AV76Location_Secure, AV73Location_BaseURL, AV62http_headers, httpContext.getMessage( "POST", ""), AV12body, (short)(0), GXv_char2, GXv_int5) ;
            importarconceptos2.this.AV87responsejson = GXv_char2[0] ;
            if ( GXutil.strSearch( AV87responsejson, httpContext.getMessage( "ConDescrip", ""), 1) == 0 )
            {
               if ( (GXutil.strcmp("", AV87responsejson)==0) )
               {
                  AV60error = httpContext.getMessage( "El Webservice de importación no responde", "") ;
               }
               else
               {
                  AV60error = GXutil.trim( AV87responsejson) ;
               }
               httpContext.GX_msglist.addItem(GXutil.trim( AV60error));
               new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, AV60error) ;
            }
            else
            {
               AV87responsejson = GXutil.strReplace( AV87responsejson, httpContext.getMessage( "{\"sdt_concepto\":", ""), "") ;
               AV87responsejson = GXutil.substring( AV87responsejson, 1, GXutil.len( AV87responsejson)-1) ;
               AV9sdt_concepto.fromJSonString(AV87responsejson, null);
            }
         }
      }
      else
      {
         if ( AV16clienteConvenioEs )
         {
            AV28ConForExportar = true ;
         }
         else
         {
            AV28ConForExportar = false ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&&clienteConvenioEs ", "")+GXutil.trim( GXutil.booltostr( AV16clienteConvenioEs))) ;
         GXv_objcol_Sdtsdt_concepto_sdt_conceptoItem7[0] = AV9sdt_concepto ;
         new web.getconceptos2(remoteHandle, context).execute( AV82padre_clicod, AV14CliCod, GXv_objcol_Sdtsdt_concepto_sdt_conceptoItem7, AV16clienteConvenioEs, AV94versionador_CliPaiConve, AV93versionador_CliConvenio, AV124CliRelSec) ;
         AV9sdt_concepto = GXv_objcol_Sdtsdt_concepto_sdt_conceptoItem7[0] ;
      }
      new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&importar ", "")+GXutil.trim( GXutil.booltostr( AV66importar))+httpContext.getMessage( " exportar ", "")+GXutil.booltostr( AV28ConForExportar)) ;
      if ( AV66importar )
      {
         if ( AV9sdt_concepto.size() == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "No hay conceptos para actualizar", "")) ;
         }
         else
         {
            AV81nuevos = (short)(0) ;
            AV79modificados = (short)(0) ;
            AV9sdt_concepto.sort(httpContext.getMessage( "ConTipoOrden,ConCodigo", ""));
            AV134GXV1 = 1 ;
            while ( AV134GXV1 <= AV9sdt_concepto.size() )
            {
               AV69itemConcepto = (web.Sdtsdt_concepto_sdt_conceptoItem)((web.Sdtsdt_concepto_sdt_conceptoItem)AV9sdt_concepto.elementAt(-1+AV134GXV1));
               new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))+httpContext.getMessage( " &itemConcepto.ConCodigo ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo()+httpContext.getMessage( " padre ", "")+GXutil.trim( GXutil.str( AV82padre_clicod, 6, 0))) ;
               GXv_dtime8[0] = AV122padreReleaseDateTime ;
               new web.getreleasedatetime(remoteHandle, context).execute( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod(), AV124CliRelSec, GXv_dtime8) ;
               importarconceptos2.this.AV122padreReleaseDateTime = GXv_dtime8[0] ;
               AV135GXLvl112 = (byte)(0) ;
               /* Using cursor P01OW3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod()), AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo(), Integer.valueOf(AV14CliCod)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A921ConPadre = P01OW3_A921ConPadre[0] ;
                  n921ConPadre = P01OW3_n921ConPadre[0] ;
                  A1822CliPadre = P01OW3_A1822CliPadre[0] ;
                  n1822CliPadre = P01OW3_n1822CliPadre[0] ;
                  A3CliCod = P01OW3_A3CliCod[0] ;
                  A146ConForEditable = P01OW3_A146ConForEditable[0] ;
                  n146ConForEditable = P01OW3_n146ConForEditable[0] ;
                  A148ConFormula = P01OW3_A148ConFormula[0] ;
                  n148ConFormula = P01OW3_n148ConFormula[0] ;
                  A26ConCodigo = P01OW3_A26ConCodigo[0] ;
                  A1886ConRelSec = P01OW3_A1886ConRelSec[0] ;
                  A1905ConRelSecCli = P01OW3_A1905ConRelSecCli[0] ;
                  A159ConVariable = P01OW3_A159ConVariable[0] ;
                  A953ConCondicion = P01OW3_A953ConCondicion[0] ;
                  n953ConCondicion = P01OW3_n953ConCondicion[0] ;
                  A954ConCondCodigo = P01OW3_A954ConCondCodigo[0] ;
                  A162ConVigencia = P01OW3_A162ConVigencia[0] ;
                  A156ConUsuModFor = P01OW3_A156ConUsuModFor[0] ;
                  n156ConUsuModFor = P01OW3_n156ConUsuModFor[0] ;
                  A145ConFchModFor = P01OW3_A145ConFchModFor[0] ;
                  n145ConFchModFor = P01OW3_n145ConFchModFor[0] ;
                  A40ConOrden = P01OW3_A40ConOrden[0] ;
                  A510ConOrdEjec = P01OW3_A510ConOrdEjec[0] ;
                  A37TipoConCod = P01OW3_A37TipoConCod[0] ;
                  A38SubTipoConCod1 = P01OW3_A38SubTipoConCod1[0] ;
                  n38SubTipoConCod1 = P01OW3_n38SubTipoConCod1[0] ;
                  A39SubTipoConCod2 = P01OW3_A39SubTipoConCod2[0] ;
                  n39SubTipoConCod2 = P01OW3_n39SubTipoConCod2[0] ;
                  A1648ConCodAfip = P01OW3_A1648ConCodAfip[0] ;
                  A1821ConErrorSiCero = P01OW3_A1821ConErrorSiCero[0] ;
                  A1018ConRangoCant = P01OW3_A1018ConRangoCant[0] ;
                  A1077ConAdelDescu = P01OW3_A1077ConAdelDescu[0] ;
                  n1077ConAdelDescu = P01OW3_n1077ConAdelDescu[0] ;
                  A1539ConSacDeven = P01OW3_A1539ConSacDeven[0] ;
                  A734ConRetGanPropor = P01OW3_A734ConRetGanPropor[0] ;
                  A1112AplIIGG = P01OW3_A1112AplIIGG[0] ;
                  n1112AplIIGG = P01OW3_n1112AplIIGG[0] ;
                  A762ConRecalcular = P01OW3_A762ConRecalcular[0] ;
                  A1472ConSIPAApo = P01OW3_A1472ConSIPAApo[0] ;
                  A1473ConSIPACont = P01OW3_A1473ConSIPACont[0] ;
                  A1474ConINSSJyPApo = P01OW3_A1474ConINSSJyPApo[0] ;
                  A1475ConINSSJyPCont = P01OW3_A1475ConINSSJyPCont[0] ;
                  A1476ConObraSocApo = P01OW3_A1476ConObraSocApo[0] ;
                  A1477ConObraSocCont = P01OW3_A1477ConObraSocCont[0] ;
                  A1478ConFonSolRedApo = P01OW3_A1478ConFonSolRedApo[0] ;
                  A1479ConFonSolRedCont = P01OW3_A1479ConFonSolRedCont[0] ;
                  A1480ConRenateaApo = P01OW3_A1480ConRenateaApo[0] ;
                  A1481ConRenateaCont = P01OW3_A1481ConRenateaCont[0] ;
                  A1482ConAsigFamCont = P01OW3_A1482ConAsigFamCont[0] ;
                  A1483ConFonNacEmpCont = P01OW3_A1483ConFonNacEmpCont[0] ;
                  A1484ConLeyRieTrabCont = P01OW3_A1484ConLeyRieTrabCont[0] ;
                  A1485ConRegDifApo = P01OW3_A1485ConRegDifApo[0] ;
                  A1486ConRegEspApo = P01OW3_A1486ConRegEspApo[0] ;
                  A1801ConBaseAnt = P01OW3_A1801ConBaseAnt[0] ;
                  A1621ConBaseFer = P01OW3_A1621ConBaseFer[0] ;
                  A1798ConBaseFerProm = P01OW3_A1798ConBaseFerProm[0] ;
                  A1622ConBaseHorExt = P01OW3_A1622ConBaseHorExt[0] ;
                  A1799ConBaseHorExtProm = P01OW3_A1799ConBaseHorExtProm[0] ;
                  A1800ConBasePres = P01OW3_A1800ConBasePres[0] ;
                  A1620ConBaseLic = P01OW3_A1620ConBaseLic[0] ;
                  A2191ConBaseAus = P01OW3_A2191ConBaseAus[0] ;
                  A2192ConBaseAusProm = P01OW3_A2192ConBaseAusProm[0] ;
                  A1797ConBaseLicProm = P01OW3_A1797ConBaseLicProm[0] ;
                  A1827ConBaseOSDif = P01OW3_A1827ConBaseOSDif[0] ;
                  A41ConDescrip = P01OW3_A41ConDescrip[0] ;
                  A2185ConDescripSinAc = P01OW3_A2185ConDescripSinAc[0] ;
                  A150ConHabilitado = P01OW3_A150ConHabilitado[0] ;
                  AV135GXLvl112 = (byte)(1) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza 1 CliCod ", "")+GXutil.trim( GXutil.str( A3CliCod, 6, 0))+httpContext.getMessage( " ConCodigo  ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &itemConcepto.ConFormula + ", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula())+httpContext.getMessage( " ConFormula ", "")+GXutil.trim( A148ConFormula)+httpContext.getMessage( " &itemConcepto.ConForEditable ", "")+GXutil.trim( GXutil.booltostr( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable()))+httpContext.getMessage( " conforeditable ", "")+GXutil.trim( GXutil.booltostr( A146ConForEditable))) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemConcepto.ConRelSec ", "")+GXutil.trim( GXutil.str( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec(), 6, 0))+httpContext.getMessage( " ConRelSec ", "")+GXutil.trim( GXutil.str( A1886ConRelSec, 6, 0))) ;
                  GXv_dtime8[0] = AV123hijoReleaseDateTime ;
                  new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1886ConRelSec, GXv_dtime8) ;
                  importarconceptos2.this.AV123hijoReleaseDateTime = GXv_dtime8[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&padreReleaseDateTime ", "")+GXutil.trim( localUtil.ttoc( AV122padreReleaseDateTime, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+httpContext.getMessage( " &hijoReleaseDateTime ", "")+GXutil.trim( localUtil.ttoc( AV123hijoReleaseDateTime, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
                  if ( AV122padreReleaseDateTime.after( AV123hijoReleaseDateTime ) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza con desc ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()) ;
                     A1886ConRelSec = AV124CliRelSec ;
                     A1905ConRelSecCli = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod() ;
                     A159ConVariable = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable() ;
                     A953ConCondicion = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion() ;
                     n953ConCondicion = false ;
                     A954ConCondCodigo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo() ;
                     if ( (0==AV67ImpSec) )
                     {
                        GXv_int9[0] = AV67ImpSec ;
                        new web.crearimportacion(remoteHandle, context).execute( AV14CliCod, GXv_int9) ;
                        importarconceptos2.this.AV67ImpSec = GXv_int9[0] ;
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza 2", "")) ;
                     if ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia() == 0 )
                     {
                        A162ConVigencia = (byte)(0) ;
                     }
                     else
                     {
                        A162ConVigencia = (byte)(1) ;
                     }
                     new web.grabarhistorico(remoteHandle, context).execute( AV14CliCod, A26ConCodigo, GXutil.trim( A148ConFormula), GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula()), AV67ImpSec, false) ;
                     A148ConFormula = GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula()) ;
                     n148ConFormula = false ;
                     A156ConUsuModFor = httpContext.getMessage( "IMPORTACIÓN", "") ;
                     n156ConUsuModFor = false ;
                     A145ConFchModFor = GXutil.serverNow( context, remoteHandle, pr_default) ;
                     n145ConFchModFor = false ;
                     A40ConOrden = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden() ;
                     A510ConOrdEjec = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec() ;
                     A37TipoConCod = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod() ;
                     if ( ! (GXutil.strcmp("", AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1())==0) )
                     {
                        A38SubTipoConCod1 = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1() ;
                        n38SubTipoConCod1 = false ;
                     }
                     else
                     {
                        A38SubTipoConCod1 = "" ;
                        n38SubTipoConCod1 = false ;
                        n38SubTipoConCod1 = true ;
                     }
                     if ( ! (GXutil.strcmp("", AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2())==0) )
                     {
                        A39SubTipoConCod2 = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2() ;
                        n39SubTipoConCod2 = false ;
                     }
                     else
                     {
                        A39SubTipoConCod2 = "" ;
                        n39SubTipoConCod2 = false ;
                        n39SubTipoConCod2 = true ;
                     }
                     A1648ConCodAfip = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip() ;
                     A1821ConErrorSiCero = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero() ;
                     A1018ConRangoCant = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant() ;
                     A1077ConAdelDescu = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu() ;
                     n1077ConAdelDescu = false ;
                     A1539ConSacDeven = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven() ;
                     A734ConRetGanPropor = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor() ;
                     if ( ! (0==AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg()) )
                     {
                        A1112AplIIGG = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg() ;
                        n1112AplIIGG = false ;
                     }
                     else
                     {
                        A1112AplIIGG = (short)(0) ;
                        n1112AplIIGG = false ;
                        n1112AplIIGG = true ;
                     }
                     A762ConRecalcular = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular() ;
                     A1472ConSIPAApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo() ;
                     A1473ConSIPACont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont() ;
                     A1474ConINSSJyPApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo() ;
                     A1475ConINSSJyPCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont() ;
                     A1476ConObraSocApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo() ;
                     A1477ConObraSocCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont() ;
                     A1478ConFonSolRedApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo() ;
                     A1479ConFonSolRedCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont() ;
                     A1480ConRenateaApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo() ;
                     A1481ConRenateaCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont() ;
                     A1482ConAsigFamCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont() ;
                     A1483ConFonNacEmpCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont() ;
                     A1484ConLeyRieTrabCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont() ;
                     A1485ConRegDifApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo() ;
                     A1486ConRegEspApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo() ;
                     GXv_Sdtconcepto_old10[0] = AV125concepto_old;
                     new web.conceptogetold(remoteHandle, context).execute( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod(), AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo(), GXv_Sdtconcepto_old10) ;
                     AV125concepto_old = GXv_Sdtconcepto_old10[0] ;
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseant() ) && ( A1801ConBaseAnt == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseant() ) )
                     {
                        A1801ConBaseAnt = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasefer() ) && ( A1621ConBaseFer == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasefer() ) )
                     {
                        A1621ConBaseFer = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseferprom() ) && ( A1798ConBaseFerProm == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseferprom() ) )
                     {
                        A1798ConBaseFerProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasehorext() ) && ( A1622ConBaseHorExt == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasehorext() ) )
                     {
                        A1622ConBaseHorExt = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasehorextprom() ) && ( A1799ConBaseHorExtProm == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasehorextprom() ) )
                     {
                        A1799ConBaseHorExtProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasepres() ) && ( A1800ConBasePres == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbasepres() ) )
                     {
                        A1800ConBasePres = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaselic() ) && ( A1620ConBaseLic == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaselic() ) )
                     {
                        A1620ConBaseLic = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseaus() ) && ( A2191ConBaseAus == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseaus() ) )
                     {
                        A2191ConBaseAus = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseausprom() ) && ( A2192ConBaseAusProm == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseausprom() ) )
                     {
                        A2192ConBaseAusProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaselicprom() ) && ( A1797ConBaseLicProm == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaselicprom() ) )
                     {
                        A1797ConBaseLicProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom() ;
                     }
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif() != AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseosdif() ) && ( A1827ConBaseOSDif == AV125concepto_old.getgxTv_Sdtconcepto_old_Conbaseosdif() ) )
                     {
                        A1827ConBaseOSDif = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif() ;
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "CONCODIGO ", "")+GXutil.trim( A26ConCodigo)) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemConcepto.ConDescrip: ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()+"\"") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&concepto_old.ConDescrip: \"", "")+AV125concepto_old.getgxTv_Sdtconcepto_old_Condescrip()+"\"") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "ConDescrip: \"", "")+A41ConDescrip+"\"") ;
                     if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), AV125concepto_old.getgxTv_Sdtconcepto_old_Condescrip()) != 0 ) && ( GXutil.strcmp(A41ConDescrip, AV125concepto_old.getgxTv_Sdtconcepto_old_Condescrip()) == 0 ) )
                     {
                        A41ConDescrip = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip() ;
                        GXt_char1 = A2185ConDescripSinAc ;
                        GXv_char2[0] = GXt_char1 ;
                        new web.sacaracentos2(remoteHandle, context).execute( GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), GXv_char2) ;
                        importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                        A2185ConDescripSinAc = GXt_char1 ;
                     }
                     new web.deletetipoliq(remoteHandle, context).execute( A3CliCod, A26ConCodigo) ;
                     AV79modificados = (short)(AV79modificados+1) ;
                     AV111auxCliCod = A3CliCod ;
                     AV112auxConCodigo = A26ConCodigo ;
                     AV116auxConOrdEjec = A510ConOrdEjec ;
                     AV114auxConOrden = A40ConOrden ;
                     AV115auxConVigencia = A162ConVigencia ;
                     AV117auxConCondicion = A953ConCondicion ;
                     GXv_int11[0] = AV129auxCondSegPla ;
                     new web.getcondsegpla(remoteHandle, context).execute( A953ConCondicion, GXv_int11) ;
                     importarconceptos2.this.AV129auxCondSegPla = GXv_int11[0] ;
                     AV118auxConHabilitado = A150ConHabilitado ;
                     /* Execute user subroutine: 'TIPOS LIQ' */
                     S111 ();
                     if ( returnInSub )
                     {
                        pr_default.close(1);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     new web.deletemotivosconcepto(remoteHandle, context).execute( A3CliCod, A26ConCodigo) ;
                     AV126ConMegSec = (short)(0) ;
                     AV136GXV2 = 1 ;
                     while ( AV136GXV2 <= AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso().size() )
                     {
                        AV121ItemMotEgr = (web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem)((web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem)AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso().elementAt(-1+AV136GXV2));
                        /*
                           INSERT RECORD ON TABLE ConceptoMotivosEgreso

                        */
                        W3CliCod = A3CliCod ;
                        W26ConCodigo = A26ConCodigo ;
                        A3CliCod = AV14CliCod ;
                        A26ConCodigo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo() ;
                        A11MegCodigo = AV121ItemMotEgr.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo() ;
                        A1532MegPreaTipo = AV121ItemMotEgr.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo() ;
                        A1530ConMegMeses = AV121ItemMotEgr.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses() ;
                        A1534ConMegDura = AV121ItemMotEgr.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura() ;
                        A1529ConMegPropor = AV121ItemMotEgr.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor() ;
                        AV126ConMegSec = (short)(AV126ConMegSec+1) ;
                        A2077ConMegSec = AV126ConMegSec ;
                        /* Using cursor P01OW4 */
                        pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
                        Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
                        if ( (pr_default.getStatus(2) == 1) )
                        {
                           Gx_err = (short)(1) ;
                           Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                        }
                        else
                        {
                           Gx_err = (short)(0) ;
                           Gx_emsg = "" ;
                        }
                        A3CliCod = W3CliCod ;
                        A26ConCodigo = W26ConCodigo ;
                        /* End Insert */
                        AV136GXV2 = (int)(AV136GXV2+1) ;
                     }
                  }
                  /* Using cursor P01OW5 */
                  pr_default.execute(3, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, Integer.valueOf(A1886ConRelSec), Integer.valueOf(A1905ConRelSecCli), Boolean.valueOf(A159ConVariable), Boolean.valueOf(n953ConCondicion), A953ConCondicion, A954ConCondCodigo, Byte.valueOf(A162ConVigencia), Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Integer.valueOf(A40ConOrden), Long.valueOf(A510ConOrdEjec), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, A1648ConCodAfip, Boolean.valueOf(A1821ConErrorSiCero), A1018ConRangoCant, Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Byte.valueOf(A1539ConSacDeven), Boolean.valueOf(A734ConRetGanPropor), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), Boolean.valueOf(A762ConRecalcular), Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1801ConBaseAnt), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1622ConBaseHorExt), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A2191ConBaseAus), Byte.valueOf(A2192ConBaseAusProm), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1827ConBaseOSDif), A41ConDescrip, A2185ConDescripSinAc, Integer.valueOf(A3CliCod), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  pr_default.readNext(1);
               }
               pr_default.close(1);
               if ( AV135GXLvl112 == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "when none &itemConcepto.ConCodigo ", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo())+httpContext.getMessage( " &clicod_sistema ", "")+GXutil.trim( GXutil.str( AV15clicod_sistema, 6, 0))+httpContext.getMessage( " &Clicod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
                  if ( (0==AV67ImpSec) )
                  {
                     GXv_int9[0] = AV67ImpSec ;
                     new web.crearimportacion(remoteHandle, context).execute( AV14CliCod, GXv_int9) ;
                     importarconceptos2.this.AV67ImpSec = GXv_int9[0] ;
                  }
                  AV81nuevos = (short)(AV81nuevos+1) ;
                  AV30ConHabilitado = true ;
                  /*
                     INSERT RECORD ON TABLE Concepto

                  */
                  A3CliCod = AV14CliCod ;
                  AV23ConCodigo = "" ;
                  A41ConDescrip = GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemConcepto.ConDescrip.ToUpper() ", "")+GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemConcepto.ConDescrip.ToUpper().IndexOf(\"PLUS \") ", "")+GXutil.trim( GXutil.str( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PLUS ", ""), 1), 10, 0))) ;
                  if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "SIN GOCE", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "sin goce", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strcmp(GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "SUELDO BÁSICO", "")) == 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "Sueldo", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PLUS ", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "Plus", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DESCUENTO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "Desc", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADELANTO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "Adelanto", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTICIPO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "Anticipo", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "NO TRABAJADO", ""), 1) != 0 ) && ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "FERIADO", ""), 1) != 0 ) )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "feriado", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "NO TRABAJADO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "no trabajado", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "NO LABORA", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "no laborable", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "EGRESO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "egreso", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "QUINCENA", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "quincena", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "FERIADO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "feriado", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "SANGRE", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "sangre", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "FALLECIMIENTO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "fallec", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DOWN", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "down", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "MATERNIDAD", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "mater", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PREMATRIMO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "prematrimo", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "MATRIMO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "matrimo", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ENFERMEDAD", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "enferm", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "NORMALES", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "normal", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "EXCEDENCIA", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "excedencia", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "VACACIONES", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "vacaciones", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "MUDANZA", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "mudanza", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "RESERVA", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "reserva", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "NACIMIENTO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "nacimiento", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "FUERZA", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "fuerza", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "POR ESTUDIO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "por e", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), "198", 1) != 0 )
                  {
                     A2187ConOblPalabra = "198" ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "OBRA SOCIAL", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "OBRA", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ESTAD", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "ESTAD", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "VIAJE", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "VIAJE", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "TELETRABAJO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "TELETRABAJO", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GUARDER", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "GUARDER", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "TECH", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "TECH", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "NOCTUR", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "NOCTUR", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "SAC PREAVISO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "AVIS", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "HORAS DE VIAJE", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "VIAJE", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "INTEGRACIÓN MES DE DESPIDO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "INTEGR", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "EMBARGO", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "EMBARGO", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), "19032", 1) != 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "es pami", "")) ;
                     A2187ConOblPalabra = "032" ;
                     n2187ConOblPalabra = false ;
                  }
                  else if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DEVOLUCIÓN", ""), 1) != 0 )
                  {
                     A2187ConOblPalabra = httpContext.getMessage( "DEVOLUC", "") ;
                     n2187ConOblPalabra = false ;
                  }
                  else
                  {
                     A2187ConOblPalabra = "" ;
                     n2187ConOblPalabra = false ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "no es nada", "")) ;
                  }
                  GXt_char1 = A2185ConDescripSinAc ;
                  GXv_char2[0] = GXt_char1 ;
                  new web.sacaracentos2(remoteHandle, context).execute( GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), GXv_char2) ;
                  importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                  A2185ConDescripSinAc = GXt_char1 ;
                  if ( ! (0==AV124CliRelSec) )
                  {
                     A1886ConRelSec = AV124CliRelSec ;
                     A1905ConRelSecCli = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod() ;
                  }
                  A154ConTipo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() ;
                  A143ConCanti = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti() ;
                  A158ConValUni = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni() ;
                  A152ConImporte = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte() ;
                  if ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia() == 0 )
                  {
                     A162ConVigencia = (byte)(0) ;
                  }
                  else
                  {
                     A162ConVigencia = (byte)(1) ;
                  }
                  AV56ConVigencia = A162ConVigencia ;
                  A729ConFormulaPreResuelta = "" ;
                  A157ConValorGen = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen() ;
                  n157ConValorGen = false ;
                  A155ConTipoLiqGanancias = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias() ;
                  n155ConTipoLiqGanancias = false ;
                  A569ConFormulaExpl = httpContext.getMessage( "Aca tiene que estar la explicación de la fórmula", "") ;
                  A153ConObservacion = "" ;
                  if ( AV14CliCod == AV15clicod_sistema )
                  {
                     A720ConFormulaObs2 = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion() ;
                     AV44ConRecalcular = false ;
                  }
                  else
                  {
                     A720ConFormulaObs2 = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2() ;
                     AV44ConRecalcular = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular() ;
                  }
                  A151ConHisFormula = "" ;
                  n151ConHisFormula = false ;
                  A156ConUsuModFor = httpContext.getMessage( "IMPORTACIÓN", "") ;
                  n156ConUsuModFor = false ;
                  A145ConFchModFor = GXutil.serverNow( context, remoteHandle, pr_default) ;
                  n145ConFchModFor = false ;
                  AV35ConMostrarPos = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos() ;
                  AV109ConErrorSiCero = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero() ;
                  AV18ConAdelDescu = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu() ;
                  AV29ConFormula = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula() ;
                  if ( AV14CliCod != AV15clicod_sistema )
                  {
                     A159ConVariable = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable() ;
                     AV40ConOrden = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden() ;
                     A37TipoConCod = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod() ;
                     if ( ! (GXutil.strcmp("", AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1())==0) )
                     {
                        A38SubTipoConCod1 = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1() ;
                        n38SubTipoConCod1 = false ;
                     }
                     else
                     {
                        A38SubTipoConCod1 = "" ;
                        n38SubTipoConCod1 = false ;
                        n38SubTipoConCod1 = true ;
                     }
                     if ( ! (GXutil.strcmp("", AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2())==0) )
                     {
                        A39SubTipoConCod2 = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2() ;
                        n39SubTipoConCod2 = false ;
                     }
                     else
                     {
                        A39SubTipoConCod2 = "" ;
                        n39SubTipoConCod2 = false ;
                        n39SubTipoConCod2 = true ;
                     }
                     AV30ConHabilitado = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado() ;
                     AV49ConRetGanPropor = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor() ;
                     AV43ConRangoCant = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant() ;
                     AV24ConEdiEnRec = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec() ;
                  }
                  else
                  {
                     if ( ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADELANTO DE VACACIONES MES PRÓXIMO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DESCUENTO POR ADELANTO DE VACACIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTICIPO A PAGAR EN CUOTAS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CUOTA DESCUENTO POR ANTICIPO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DESCUENTO POR ADELANTO DE VACACIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DESCUENTO POR ANTICIPO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTICIPO DE SUELDO", "")) == 0 ) )
                     {
                        if ( ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADELANTO DE VACACIONES MES PRÓXIMO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTICIPO A PAGAR EN CUOTAS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTICIPO DE SUELDO", "")) == 0 ) )
                        {
                           AV18ConAdelDescu = (byte)(1) ;
                        }
                        else if ( ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DESCUENTO POR ADELANTO DE VACACIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DESCUENTO POR ANTICIPO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CUOTA DESCUENTO POR ANTICIPO", "")) == 0 ) )
                        {
                           AV18ConAdelDescu = (byte)(2) ;
                        }
                     }
                     else
                     {
                        AV18ConAdelDescu = (byte)(0) ;
                     }
                     if ( ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PRESENTISMO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "BONO POR PRODUCTIVIDAD", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ASISTENCIA PERFECTA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "COMPENSACIÓN GASTOS TELETRABAJO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CUOTA ALIMENTARIA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "EMBARGO JUDICIAL", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTICIPO DE SUELDO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTICIPO A PAGAR EN CUOTAS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "MOVILIDAD Y VIATICOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADICIONAL", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GRATIFICACIÓN", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "A CUENTA FUTUROS AUMENTOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "FERIADOS TRABAJADOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADICIONAL COMPAÑÍA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DECRETO 198/08 - TICKETS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "BONO NO REM. DECRETO 438/2023", "")) == 0 ) )
                     {
                        AV43ConRangoCant = "[1]" ;
                     }
                     else
                     {
                        AV43ConRangoCant = "" ;
                     }
                     if ( ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "RETENCIÓN GANANCIAS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADELANTO RETENCIÓN GANANCIAS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "REDONDEO", "")) == 0 ) )
                     {
                        AV35ConMostrarPos = true ;
                     }
                     if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.sac_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.sac_propor_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PRESENTISMO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTIGUEDAD", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "FERIADOS NO TRABAJADOS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "SAC INTEGRACIÓN MES DE DESPIDO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "INTEGRACIÓN MES DE DESPIDO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VACACIONES NO GOZADAS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VACACIONES NO GOZADAS DE AÑO ANTERIOR", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "SAC VACACIONES NO GOZADAS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DÍAS NO TRABAJADOS POR EGRESO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "SAC PREAVISO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADELANTO DE VACACIONES", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "JUBILACIÓN", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "OBRA SOCIAL", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LEY 19032", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "AYUDA ALIMENTARIA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VIANDA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "REDONDEO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "INDEMNIZACIÓN ANTIGUEDAD", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "OBRA SOCIAL DIFERENCIAL", "")) == 0 ) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV109ConErrorSiCero = false ;
                     }
                     else
                     {
                        AV109ConErrorSiCero = true ;
                     }
                     AV49ConRetGanPropor = false ;
                     AV19ConAplicGan = (byte)(0) ;
                     if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 4 ) || ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 6 ) || ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 7 ) )
                     {
                        A37TipoConCod = "CAL_ARG" ;
                        if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 4 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "OBRA SOCIAL - FSR (EX ANSSAL)", "")) == 0 ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           AV13calc = (short)(AV13calc+1) ;
                           GXt_char1 = AV23ConCodigo ;
                           GXv_char2[0] = GXt_char1 ;
                           new web.prefijocalculo(remoteHandle, context).execute( AV14CliCod, GXv_char2) ;
                           importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                           AV23ConCodigo = GXutil.trim( GXt_char1) + GXutil.padl( GXutil.str( AV13calc, 3, 0), (short)(3), "0") ;
                           GXt_char1 = A38SubTipoConCod1 ;
                           GXv_char2[0] = GXt_char1 ;
                           new web.subtipocontribucion(remoteHandle, context).execute( GXv_char2) ;
                           importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                           A38SubTipoConCod1 = GXt_char1 ;
                           n38SubTipoConCod1 = false ;
                           if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "OBRA SOCIAL - FSR (EX ANSSAL)", "")) == 0 )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              GXt_char1 = A39SubTipoConCod2 ;
                              GXv_char2[0] = GXt_char1 ;
                              new web.subtipo2dependenciacontr(remoteHandle, context).execute( GXv_char2) ;
                              importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                              A39SubTipoConCod2 = GXt_char1 ;
                              n39SubTipoConCod2 = false ;
                           }
                           else
                           {
                              A39SubTipoConCod2 = "" ;
                              n39SubTipoConCod2 = false ;
                              n39SubTipoConCod2 = true ;
                           }
                        }
                        else
                        {
                           if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "BASE IMPONIBLE", ""), 1) != 0 )
                           {
                              AV13calc = (short)(AV13calc+1) ;
                              GXt_char1 = AV23ConCodigo ;
                              GXv_char2[0] = GXt_char1 ;
                              new web.prefijocalculo(remoteHandle, context).execute( AV14CliCod, GXv_char2) ;
                              importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                              AV23ConCodigo = GXutil.trim( GXt_char1) + GXutil.padl( GXutil.str( AV13calc, 3, 0), (short)(3), "0") ;
                              GXt_char1 = A38SubTipoConCod1 ;
                              GXv_char2[0] = GXt_char1 ;
                              new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char2) ;
                              importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                              A38SubTipoConCod1 = GXt_char1 ;
                              n38SubTipoConCod1 = false ;
                              A39SubTipoConCod2 = "" ;
                              n39SubTipoConCod2 = false ;
                              n39SubTipoConCod2 = true ;
                           }
                           else
                           {
                              if ( ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), "649", 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GAN", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PDG", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ACUMULADO", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CÁLCULO SAC PRÓXIMO ESTIMADO", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( " TOTAL", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( " FINAL", ""), 1) != 0 ) )
                              {
                                 AV13calc = (short)(AV13calc+1) ;
                                 GXt_char1 = AV23ConCodigo ;
                                 GXv_char2[0] = GXt_char1 ;
                                 new web.prefijocalculo(remoteHandle, context).execute( AV14CliCod, GXv_char2) ;
                                 importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                 AV23ConCodigo = GXutil.trim( GXt_char1) + GXutil.padl( GXutil.str( AV13calc, 3, 0), (short)(3), "0") ;
                                 GXt_char1 = A38SubTipoConCod1 ;
                                 GXv_char2[0] = GXt_char1 ;
                                 new web.subtipocalculoganancias(remoteHandle, context).execute( GXv_char2) ;
                                 importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                 A38SubTipoConCod1 = GXt_char1 ;
                                 n38SubTipoConCod1 = false ;
                                 if ( GXutil.strSearch( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CÁLCULO SAC PRÓXIMO ESTIMADO", ""), 1) != 0 )
                                 {
                                    GXt_char1 = A39SubTipoConCod2 ;
                                    GXv_char2[0] = GXt_char1 ;
                                    new web.subtipo2gananciassac(remoteHandle, context).execute( GXv_char2) ;
                                    importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                    A39SubTipoConCod2 = GXt_char1 ;
                                    n39SubTipoConCod2 = false ;
                                 }
                                 else
                                 {
                                    A39SubTipoConCod2 = "" ;
                                    n39SubTipoConCod2 = false ;
                                    n39SubTipoConCod2 = true ;
                                 }
                              }
                              else
                              {
                                 if ( ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DONACIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "VEHICULOS DE CORREDORES Y VIAJANTES DE COMERCIO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE ADQUISICION DE INDUMENTARIA Y EQUIPAMIENTO PARA USO EXCLUSIVO EN EL LUGAR DE TRABAJO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "INTERESES DE HIPOTECAS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE MOVILIDAD E INTERESES DE CORREDORES Y VIAJANTES DE COMERCIO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CUOTA MEDICO ASISTENCIAL (PREPAGA)", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "HONORARIOS MEDICOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PRIMAS SEGURO DE VIDA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE SEPELIO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "APORTES CORRESPONDIENTES A PLANES DE SEGURO DE RETIRO PRIVADOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PERSONAL DOMÉSTICO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ALQUILER DE CASA HABITACIÓN", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "APORTE A SOCIEDADES DE GARANTIA RECIPROCA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PAGOS A CUENTA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "OTRAS DEDUCCIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PRIMAS DE AHORRO CORRESPONDIENTES A SEGUROS MIXTOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADQUISICION DE CUOTAPARTES DE FONDOS COMUNES DE INVERSION CON FINES DE RETIRO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "OTRAS DEDUCCIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE EDUCACIÓN", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ALQUILER DE CASA HABITACIÓN ART. 85 INQUILINOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ALQUILER DE CASA HABITACIÓN ART. 85 PROPIETARIOS", "")) == 0 ) )
                                 {
                                    AV44ConRecalcular = true ;
                                    AV10anualEs = false ;
                                    AV29ConFormula = httpContext.getMessage( "{calcu_deduc}", "") ;
                                    if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ADQUISICION DE CUOTAPARTES DE FONDOS COMUNES DE INVERSION CON FINES DE RETIRO", "")) == 0 )
                                    {
                                       AV10anualEs = true ;
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "025" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.cuotapartes_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PRIMAS DE AHORRO CORRESPONDIENTES A SEGUROS MIXTOS", "")) == 0 )
                                    {
                                       AV10anualEs = true ;
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "023" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.primasmixtos_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "OTRAS DEDUCCIONES", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "099" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.otrasdeducciones_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE EDUCACIÓN", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "032" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.gastosdeeducacion_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PAGOS A CUENTA", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "000" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.pagosacuenta_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ALQUILER DE CASA HABITACIÓN", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "022" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedalquiler_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ALQUILER DE CASA HABITACIÓN ART. 85 INQUILINOS", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "033" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedalq85inqui_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ALQUILER DE CASA HABITACIÓN ART. 85 PROPIETARIOS", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "034" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedalq85propie_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "DONACIONES", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "003" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_deddonaciones_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE ADQUISICION DE INDUMENTARIA Y EQUIPAMIENTO PARA USO EXCLUSIVO EN EL LUGAR DE TRABAJO", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "021" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedindumentaria_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "INTERESES DE HIPOTECAS", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "004" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedcredhipoteca_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE MOVILIDAD E INTERESES DE CORREDORES Y VIAJANTES DE COMERCIO", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "011" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedviaticorre_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "VEHICULOS DE CORREDORES Y VIAJANTES DE COMERCIO", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "010" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_vehicorre_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CUOTA MEDICO ASISTENCIAL (PREPAGA)", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "001" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedprepaga_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "HONORARIOS MEDICOS", "")) == 0 )
                                    {
                                       AV10anualEs = true ;
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "007" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_honomedi_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PRIMAS SEGURO DE VIDA", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "002" ;
                                       AV10anualEs = true ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedprimasegucodigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "GASTOS DE SEPELIO", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "005" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedsepelio_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "APORTES CORRESPONDIENTES A PLANES DE SEGURO DE RETIRO PRIVADOS", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "024" ;
                                       AV10anualEs = true ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedsegureti_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PERSONAL DOMÉSTICO", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "008" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_deddome_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    else if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "APORTE A SOCIEDADES DE GARANTIA RECIPROCA", "")) == 0 )
                                    {
                                       AV23ConCodigo = GXutil.trim( AV85prefijoDED) + "009" ;
                                       new web.grabaparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_dedrecipro_codigoparam(remoteHandle, context).executeUdp( ), AV23ConCodigo, httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())+"\"") ;
                                    }
                                    GXt_char1 = A38SubTipoConCod1 ;
                                    GXv_char2[0] = GXt_char1 ;
                                    new web.subtipocalculoganancias(remoteHandle, context).execute( GXv_char2) ;
                                    importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                    A38SubTipoConCod1 = GXt_char1 ;
                                    n38SubTipoConCod1 = false ;
                                    if ( AV10anualEs )
                                    {
                                       GXt_char1 = A39SubTipoConCod2 ;
                                       GXv_char2[0] = GXt_char1 ;
                                       new web.subtipo2deduccionesgeneralesanuales(remoteHandle, context).execute( GXv_char2) ;
                                       importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                       A39SubTipoConCod2 = GXt_char1 ;
                                       n39SubTipoConCod2 = false ;
                                    }
                                    else
                                    {
                                       if ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "PAGOS A CUENTA", "")) == 0 )
                                       {
                                          GXt_char1 = A39SubTipoConCod2 ;
                                          GXv_char2[0] = GXt_char1 ;
                                          new web.subtipo2deduccionesgenerales(remoteHandle, context).execute( GXv_char2) ;
                                          importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                          A39SubTipoConCod2 = GXt_char1 ;
                                          n39SubTipoConCod2 = false ;
                                       }
                                       else
                                       {
                                          GXt_char1 = A39SubTipoConCod2 ;
                                          GXv_char2[0] = GXt_char1 ;
                                          new web.subtipo2deduccionesgenerales(remoteHandle, context).execute( GXv_char2) ;
                                          importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                          A39SubTipoConCod2 = GXt_char1 ;
                                          n39SubTipoConCod2 = false ;
                                       }
                                    }
                                 }
                                 else
                                 {
                                    if ( ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "SAC PRIMER SEMESTRE", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "SAC SEGUNDO SEMESTRE", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "SAC - HABERES REMUNERATIVOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "CÁLCULO SAC", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "HABERES SAC", "")) == 0 ) )
                                    {
                                       GXt_char1 = A38SubTipoConCod1 ;
                                       GXv_char2[0] = GXt_char1 ;
                                       new web.subtipocalculosac(remoteHandle, context).execute( GXv_char2) ;
                                       importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                       A38SubTipoConCod1 = GXt_char1 ;
                                       n38SubTipoConCod1 = false ;
                                    }
                                    else
                                    {
                                       GXt_char1 = A38SubTipoConCod1 ;
                                       GXv_char2[0] = GXt_char1 ;
                                       new web.subtipocalculootros(remoteHandle, context).execute( GXv_char2) ;
                                       importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                       A38SubTipoConCod1 = GXt_char1 ;
                                       n38SubTipoConCod1 = false ;
                                    }
                                    A39SubTipoConCod2 = "" ;
                                    n39SubTipoConCod2 = false ;
                                    n39SubTipoConCod2 = true ;
                                    AV13calc = (short)(AV13calc+1) ;
                                    GXt_char1 = AV23ConCodigo ;
                                    GXv_char2[0] = GXt_char1 ;
                                    new web.prefijocalculo(remoteHandle, context).execute( AV14CliCod, GXv_char2) ;
                                    importarconceptos2.this.GXt_char1 = GXv_char2[0] ;
                                    AV23ConCodigo = GXutil.trim( GXt_char1) + GXutil.padl( GXutil.str( AV13calc, 3, 0), (short)(3), "0") ;
                                 }
                              }
                           }
                        }
                     }
                     else
                     {
                        GXv_char2[0] = AV88SubTipoConCod1 ;
                        GXv_char12[0] = AV89SubTipoConCod2 ;
                        GXv_char13[0] = AV90TipoConCod ;
                        GXv_char14[0] = AV22conceptocod_nuevo_aux ;
                        new web.getdefaultconafipremuneraitvo(remoteHandle, context).execute( AV14CliCod, AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo(), GXv_char2, GXv_char12, GXv_char13, GXv_char14) ;
                        importarconceptos2.this.AV88SubTipoConCod1 = GXv_char2[0] ;
                        importarconceptos2.this.AV89SubTipoConCod2 = GXv_char12[0] ;
                        importarconceptos2.this.AV90TipoConCod = GXv_char13[0] ;
                        importarconceptos2.this.AV22conceptocod_nuevo_aux = GXv_char14[0] ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "?? &&TipoConCod ", "")+AV90TipoConCod+httpContext.getMessage( " &itemConcepto.ConCodigo ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo()+httpContext.getMessage( " &itemConcepto.ConTipo ", "")+GXutil.str( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo(), 1, 0)) ;
                        if ( ! (GXutil.strcmp("", AV90TipoConCod)==0) )
                        {
                           A37TipoConCod = AV90TipoConCod ;
                           new web.msgdebug3(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "le asigna lo que viene", "")) ;
                        }
                        else
                        {
                           if ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 0 )
                           {
                              A37TipoConCod = "REM_ARG" ;
                              new web.msgdebug3(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "le asigna remu", "")) ;
                           }
                           else
                           {
                              if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 1 ) || ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 3 ) )
                              {
                                 A37TipoConCod = "NRE_ARG" ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "le asigna no remu", "")) ;
                              }
                              else
                              {
                                 if ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo() == 2 )
                                 {
                                    A37TipoConCod = "DES_ARG" ;
                                 }
                              }
                           }
                        }
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "TipoConCod ", "")+A37TipoConCod+httpContext.getMessage( " &SubTipoConCod1 ", "")+AV88SubTipoConCod1+httpContext.getMessage( " &SubTipoConCod2 ", "")+AV89SubTipoConCod2+httpContext.getMessage( " &itemConcepto.condescrip ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()) ;
                        if ( ( ( GXutil.strcmp(AV88SubTipoConCod1, new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV88SubTipoConCod1, new web.subtipopremio(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV88SubTipoConCod1, new web.subtipoadicional(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LICENCIA POR", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VACACIONES", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PLUS LICENCIA", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "AJUSTE", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "EGRESO", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "CESE", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS DE VIAJE", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTICIPO", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "INDEMNIZACIÓN", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PREAVISO", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DESPIDO", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DESPIDO", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "GUARDERÍA", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "NO REM", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DOCENTE", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "COMPENSACIÓN", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VIANDA", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ALIMENTARIA", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "TRABAJADOS", ""), 1) != 0 ) ) && ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTIGUEDAD", "")) != 0 ) && ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR TÍTULO", ""), 1) == 0 ) ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "es variable", "")) ;
                           A159ConVariable = true ;
                        }
                        else
                        {
                           A159ConVariable = false ;
                        }
                        if ( GXutil.strcmp(AV89SubTipoConCod2, new web.conceptoafipbonoproductividad(remoteHandle, context).executeUdp( )) == 0 )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           AV49ConRetGanPropor = true ;
                        }
                        else
                        {
                           AV49ConRetGanPropor = false ;
                        }
                        if ( ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "REDONDEO", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "SOBREGIRO", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "LICENCIA POR MATERNIDAD", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "LICENCIA POR MATERNIDAD (DESCUENTO)", "")) == 0 ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           AV19ConAplicGan = (byte)(0) ;
                        }
                        else
                        {
                           if ( ( GXutil.strcmp(AV89SubTipoConCod2, new web.conceptoafipindemnizapordespido(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV89SubTipoConCod2, new web.conceptoafipindemnizapreaviso(remoteHandle, context).executeUdp( )) == 0 ) )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              AV19ConAplicGan = (byte)(2) ;
                           }
                           else
                           {
                              if ( ( GXutil.strcmp(AV89SubTipoConCod2, new web.conceptoafipbonoproductividad(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.sac_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.sac_propor_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) )
                              {
                                 Cond_result = true ;
                              }
                              else
                              {
                                 Cond_result = false ;
                              }
                              if ( Cond_result )
                              {
                                 if ( GXutil.strcmp(AV89SubTipoConCod2, new web.conceptoafipbonoproductividad(remoteHandle, context).executeUdp( )) == 0 )
                                 {
                                    Cond_result = true ;
                                 }
                                 else
                                 {
                                    Cond_result = false ;
                                 }
                                 if ( Cond_result )
                                 {
                                    AV19ConAplicGan = (byte)(7) ;
                                 }
                                 else
                                 {
                                    AV19ConAplicGan = (byte)(6) ;
                                 }
                              }
                              else
                              {
                                 if ( ( GXutil.strcmp(AV89SubTipoConCod2, new web.conceptoafiphorasextras200(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV89SubTipoConCod2, new web.conceptoafiphorasextras100(remoteHandle, context).executeUdp( )) == 0 ) )
                                 {
                                    Cond_result = true ;
                                 }
                                 else
                                 {
                                    Cond_result = false ;
                                 }
                                 if ( Cond_result )
                                 {
                                    AV19ConAplicGan = (byte)(4) ;
                                 }
                                 else
                                 {
                                    AV19ConAplicGan = (byte)(1) ;
                                 }
                              }
                           }
                        }
                        if ( (GXutil.strcmp("", AV88SubTipoConCod1)==0) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           A38SubTipoConCod1 = "" ;
                           n38SubTipoConCod1 = false ;
                           n38SubTipoConCod1 = true ;
                        }
                        else
                        {
                           A38SubTipoConCod1 = AV88SubTipoConCod1 ;
                           n38SubTipoConCod1 = false ;
                        }
                        if ( (GXutil.strcmp("", AV89SubTipoConCod2)==0) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           A39SubTipoConCod2 = "" ;
                           n39SubTipoConCod2 = false ;
                           n39SubTipoConCod2 = true ;
                        }
                        else
                        {
                           A39SubTipoConCod2 = AV89SubTipoConCod2 ;
                           n39SubTipoConCod2 = false ;
                        }
                        if ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           AV86rem = (short)(AV86rem+1) ;
                           GXt_char1 = AV21conceptocod_nuevo ;
                           GXv_char14[0] = GXt_char1 ;
                           new web.prefijoremu(remoteHandle, context).execute( AV14CliCod, GXv_char14) ;
                           importarconceptos2.this.GXt_char1 = GXv_char14[0] ;
                           AV21conceptocod_nuevo = GXutil.trim( GXt_char1) + GXutil.padl( GXutil.str( AV86rem, 4, 0), (short)(3), "0") ;
                        }
                        else
                        {
                           if ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              AV80nre = (short)(AV80nre+1) ;
                              GXt_char1 = AV21conceptocod_nuevo ;
                              GXv_char14[0] = GXt_char1 ;
                              new web.prefijonoremu(remoteHandle, context).execute( AV14CliCod, GXv_char14) ;
                              importarconceptos2.this.GXt_char1 = GXv_char14[0] ;
                              AV21conceptocod_nuevo = GXutil.trim( GXt_char1) + GXutil.padl( GXutil.str( AV80nre, 4, 0), (short)(3), "0") ;
                           }
                           else
                           {
                              AV58des = (short)(AV58des+1) ;
                              GXt_char1 = AV21conceptocod_nuevo ;
                              GXv_char14[0] = GXt_char1 ;
                              new web.prefijodescuento(remoteHandle, context).execute( AV14CliCod, GXv_char14) ;
                              importarconceptos2.this.GXt_char1 = GXv_char14[0] ;
                              AV21conceptocod_nuevo = GXutil.trim( GXt_char1) + GXutil.padl( GXutil.str( AV58des, 4, 0), (short)(3), "0") ;
                           }
                        }
                        AV23ConCodigo = GXutil.trim( AV21conceptocod_nuevo) ;
                        if ( GXutil.len( AV23ConCodigo) > 10 )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           AV23ConCodigo = GXutil.substring( AV23ConCodigo, 1, 10) ;
                        }
                     }
                  }
                  if ( AV14CliCod == AV15clicod_sistema )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV120ConPueNov = false ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemConcepto.ConDescrip \"", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()+"\"") ;
                     if ( ( GXutil.strcmp(GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), GXutil.trim( AV100sueldoDescrip)) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "OBRA SOCIAL", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "OBRA SOCIAL ADHERENTE", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LEY 19032", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "JUBILACIÓN", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTIGUEDAD", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PRESENTISMO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "FERIADOS NO TRABAJADOS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PLUS LICENCIA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "NO LABORABLES NO TRABAJADOS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "CUOTA SINDICAL", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS NORMALES", "")) == 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LICENCIA POR", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR", ""), 1) != 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VACACIONES", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DÍAS NO TRABAJADOS POR LICENCIA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DÍAS NO TRABAJADOS POR VACACIONES", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DÍAS NO TRABAJADOS POR FERIADO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DÍAS NO TRABAJADOS POR NO LABORABLES", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VIANDA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "AYUDA ALIMENTARIA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS DE VIAJE", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS EXTRAS AL 100%", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS EXTRAS AL 50%", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS EXTRAS NOCTURNAS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS EXTRAS NOCTURNAS AL 100%", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ASIG. NO REM. DEC 438/23", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ASIGNACIÓN NO REMUNERATIVA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "MOVILIDAD Y VIATICOS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PERSONAL DOCENTE - MATERIAL DIDACTICO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "COMPENSACIÓN GASTOS TELETRABAJO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "INCAPACIDAD LABORAL TEMPORARIA (PRIMEROS 10 DÍAS)", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "INCAPACIDAD LABORAL TEMPORARIA (POR ART)", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTICIPO DE SUELDO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "REDONDEO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DÍAS NO TRABAJADOS POR MES PARCIAL", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "AUSENCIAS INJUSTIFICADAS", "")) == 0 ) || ( ( ( GXutil.strcmp(GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula()), httpContext.getMessage( "{novedad_importe}", "")) == 0 ) || (GXutil.strcmp("", AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula())==0) ) && ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia() == 1 ) && ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod(), "REM_ARG") == 0 ) ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "RESERVA DE PUESTO", "")) == 0 ) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV34ConLiqBasica = (byte)(1) ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "es basica", "")) ;
                     }
                     else
                     {
                        AV34ConLiqBasica = (byte)(0) ;
                     }
                     A469ConCodOld = GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo()) ;
                     if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "EMBARGO JUDICIAL", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "CUOTA ALIMENTARIA", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "CUOTA SINDICAL", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PORCENTAJE DE EMBARGO", "")) == 0 ) )
                     {
                        AV42ConPreReq = "REM" ;
                     }
                     else if ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HABERES SAC", "")) == 0 )
                     {
                        AV42ConPreReq = "REMNOSAC" ;
                     }
                     else if ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PLUS LICENCIA", "")) == 0 )
                     {
                        AV42ConPreReq = "LICENCIAS" ;
                     }
                     else if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VACACIONES", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LICENCIA POR ESTUDIO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LICENCIA POR MATRIMONIO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LICENCIA POR ENFERMEDAD", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LICENCIA POR NACIMIENTO", "")) == 0 ) )
                     {
                        AV69itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip( httpContext.getMessage( "LICENCIA POR FALLECIMIENTO DE FAMILIAR", "") );
                        AV42ConPreReq = "FIJAS" ;
                     }
                     else
                     {
                        AV42ConPreReq = "" ;
                     }
                     if ( ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV50ConSacDeven = (byte)(0) ;
                        AV95ConBaseFer = (byte)(0) ;
                        AV97ConBaseHorExt = (byte)(0) ;
                        AV96ConBaseLic = (byte)(0) ;
                        AV103ConBaseFerProm = (byte)(0) ;
                        AV128ConBaseAus = (byte)(0) ;
                        AV127ConBaseAusProm = (byte)(0) ;
                        AV101ConBaseHorExtProm = (byte)(0) ;
                        AV102ConBaseLicProm = (byte)(0) ;
                        AV104ConBasePres = (byte)(0) ;
                        AV105ConBaseAnt = (byte)(0) ;
                        AV119ConBaseOSDif = (byte)(0) ;
                     }
                     else
                     {
                        if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.sac_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.sac_propor_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.maternidad_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.maternidad_descuento_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), new web.ilt_art_descripcion_fija(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "DÍAS NO TRABAJADOS POR MES PARCIAL", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "AUSENCIAS INJUSTIFICADAS", "")) == 0 ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           AV50ConSacDeven = (byte)(0) ;
                        }
                        else
                        {
                           if ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "BONO POR PRODUCTIVIDAD", "")) == 0 )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              AV50ConSacDeven = (byte)(12) ;
                           }
                           else
                           {
                              AV50ConSacDeven = (byte)(1) ;
                           }
                        }
                        AV127ConBaseAusProm = (byte)(0) ;
                        if ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "SUELDO BÁSICO", "")) == 0 )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           AV128ConBaseAus = (byte)(1) ;
                        }
                        else
                        {
                           AV128ConBaseAus = (byte)(0) ;
                        }
                        if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS NORMALES", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), GXutil.trim( AV100sueldoDescrip)) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTIGUEDAD", "")) == 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADCIONAL POR TÍTULO", ""), 1) != 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR ZONA DESFAVORABLE", "")) == 0 ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS NORMALES", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR ZONA DESFAVORABLE", "")) == 0 ) )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              AV95ConBaseFer = (byte)(1) ;
                              AV97ConBaseHorExt = (byte)(1) ;
                              AV96ConBaseLic = (byte)(1) ;
                              AV103ConBaseFerProm = (byte)(0) ;
                              AV101ConBaseHorExtProm = (byte)(0) ;
                              AV102ConBaseLicProm = (byte)(0) ;
                              if ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS NORMALES", "")) == 0 )
                              {
                                 Cond_result = true ;
                              }
                              else
                              {
                                 Cond_result = false ;
                              }
                              if ( Cond_result )
                              {
                                 AV119ConBaseOSDif = (byte)(3) ;
                                 AV104ConBasePres = (byte)(1) ;
                                 AV105ConBaseAnt = (byte)(1) ;
                              }
                              else
                              {
                                 AV119ConBaseOSDif = (byte)(1) ;
                                 AV104ConBasePres = (byte)(1) ;
                                 AV105ConBaseAnt = (byte)(1) ;
                              }
                           }
                           else
                           {
                              if ( GXutil.strcmp(GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), GXutil.trim( AV100sueldoDescrip)) == 0 )
                              {
                                 Cond_result = true ;
                              }
                              else
                              {
                                 Cond_result = false ;
                              }
                              if ( Cond_result )
                              {
                                 AV95ConBaseFer = (byte)(3) ;
                                 AV97ConBaseHorExt = (byte)(3) ;
                                 AV96ConBaseLic = (byte)(3) ;
                                 AV103ConBaseFerProm = (byte)(0) ;
                                 AV101ConBaseHorExtProm = (byte)(0) ;
                                 AV102ConBaseLicProm = (byte)(0) ;
                                 AV104ConBasePres = (byte)(1) ;
                                 AV105ConBaseAnt = (byte)(1) ;
                                 AV119ConBaseOSDif = (byte)(1) ;
                                 AV120ConPueNov = true ;
                              }
                              else
                              {
                                 if ( GXutil.strcmp(GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()), httpContext.getMessage( "ANTIGUEDAD", "")) == 0 )
                                 {
                                    Cond_result = true ;
                                 }
                                 else
                                 {
                                    Cond_result = false ;
                                 }
                                 if ( Cond_result )
                                 {
                                    AV95ConBaseFer = (byte)(0) ;
                                    AV97ConBaseHorExt = (byte)(0) ;
                                    AV96ConBaseLic = (byte)(0) ;
                                 }
                                 else
                                 {
                                    AV95ConBaseFer = (byte)(1) ;
                                    AV97ConBaseHorExt = (byte)(1) ;
                                    AV96ConBaseLic = (byte)(1) ;
                                 }
                                 AV103ConBaseFerProm = (byte)(0) ;
                                 AV101ConBaseHorExtProm = (byte)(0) ;
                                 AV102ConBaseLicProm = (byte)(0) ;
                                 AV104ConBasePres = (byte)(0) ;
                                 AV105ConBaseAnt = (byte)(0) ;
                                 AV119ConBaseOSDif = (byte)(3) ;
                              }
                           }
                        }
                        else
                        {
                           if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR HORAS NOCTURNAS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PRESENTISMO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "INDEMNIZACIÓN POR CAUSA CLIMÁTICA", "")) == 0 ) )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              if ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR HORAS NOCTURNAS", "")) == 0 )
                              {
                                 Cond_result = true ;
                              }
                              else
                              {
                                 Cond_result = false ;
                              }
                              if ( Cond_result )
                              {
                                 AV95ConBaseFer = (byte)(4) ;
                                 AV97ConBaseHorExt = (byte)(4) ;
                                 AV96ConBaseLic = (byte)(4) ;
                                 AV103ConBaseFerProm = (byte)(0) ;
                                 AV101ConBaseHorExtProm = (byte)(0) ;
                                 AV102ConBaseLicProm = (byte)(0) ;
                                 AV104ConBasePres = (byte)(1) ;
                                 AV105ConBaseAnt = (byte)(1) ;
                                 AV119ConBaseOSDif = (byte)(2) ;
                              }
                              else
                              {
                                 AV95ConBaseFer = (byte)(0) ;
                                 AV97ConBaseHorExt = (byte)(0) ;
                                 AV96ConBaseLic = (byte)(0) ;
                                 AV103ConBaseFerProm = (byte)(0) ;
                                 AV101ConBaseHorExtProm = (byte)(0) ;
                                 AV102ConBaseLicProm = (byte)(1) ;
                                 AV104ConBasePres = (byte)(0) ;
                                 AV105ConBaseAnt = (byte)(0) ;
                                 if ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "PRESENTISMO", "")) == 0 )
                                 {
                                    Cond_result = true ;
                                 }
                                 else
                                 {
                                    Cond_result = false ;
                                 }
                                 if ( Cond_result )
                                 {
                                    AV119ConBaseOSDif = (byte)(1) ;
                                 }
                                 else
                                 {
                                    AV119ConBaseOSDif = (byte)(2) ;
                                    new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "pone es_base_OSDif.SiLiq", "")) ;
                                 }
                              }
                           }
                           else
                           {
                              if ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR", ""), 1) != 0 )
                              {
                                 Cond_result = true ;
                              }
                              else
                              {
                                 Cond_result = false ;
                              }
                              if ( Cond_result )
                              {
                                 AV95ConBaseFer = (byte)(1) ;
                                 AV97ConBaseHorExt = (byte)(4) ;
                                 AV96ConBaseLic = (byte)(1) ;
                                 AV103ConBaseFerProm = (byte)(0) ;
                                 AV101ConBaseHorExtProm = (byte)(0) ;
                                 AV102ConBaseLicProm = (byte)(0) ;
                                 AV104ConBasePres = (byte)(0) ;
                                 AV105ConBaseAnt = (byte)(0) ;
                                 AV119ConBaseOSDif = (byte)(3) ;
                              }
                              else
                              {
                                 if ( GXutil.strcmp(AV88SubTipoConCod1, new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 )
                                 {
                                    Cond_result = true ;
                                 }
                                 else
                                 {
                                    Cond_result = false ;
                                 }
                                 if ( Cond_result )
                                 {
                                    AV95ConBaseFer = (byte)(1) ;
                                    AV97ConBaseHorExt = (byte)(0) ;
                                    AV96ConBaseLic = (byte)(2) ;
                                    AV103ConBaseFerProm = (byte)(3) ;
                                    AV101ConBaseHorExtProm = (byte)(0) ;
                                    AV102ConBaseLicProm = (byte)(3) ;
                                    AV104ConBasePres = (byte)(1) ;
                                    AV105ConBaseAnt = (byte)(1) ;
                                    AV119ConBaseOSDif = (byte)(2) ;
                                 }
                                 else
                                 {
                                    AV95ConBaseFer = (byte)(0) ;
                                    AV97ConBaseHorExt = (byte)(0) ;
                                    AV96ConBaseLic = (byte)(0) ;
                                    if ( ( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable() ) && ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod(), "REM_ARG") == 0 ) && ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "LICENCIA", ""), 1) == 0 ) && ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "AJUSTE", ""), 1) == 0 ) && ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "TRABAJADO", ""), 1) == 0 ) && ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "VACACIONES", ""), 1) == 0 ) )
                                    {
                                       Cond_result = true ;
                                    }
                                    else
                                    {
                                       Cond_result = false ;
                                    }
                                    if ( Cond_result )
                                    {
                                       AV103ConBaseFerProm = (byte)(1) ;
                                       AV101ConBaseHorExtProm = (byte)(1) ;
                                       AV102ConBaseLicProm = (byte)(1) ;
                                    }
                                    else
                                    {
                                       AV103ConBaseFerProm = (byte)(0) ;
                                       AV101ConBaseHorExtProm = (byte)(0) ;
                                       AV102ConBaseLicProm = (byte)(0) ;
                                    }
                                    if ( ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "FERIADOS NO TRABAJADOS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "FERIADOS TRABAJADOS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "NO LABORABLES NO TRABAJADOS", "")) == 0 ) )
                                    {
                                       Cond_result = true ;
                                    }
                                    else
                                    {
                                       Cond_result = false ;
                                    }
                                    if ( Cond_result )
                                    {
                                       AV104ConBasePres = (byte)(1) ;
                                       AV105ConBaseAnt = (byte)(1) ;
                                       AV119ConBaseOSDif = (byte)(3) ;
                                    }
                                    else
                                    {
                                       AV104ConBasePres = (byte)(0) ;
                                       AV105ConBaseAnt = (byte)(0) ;
                                       if ( ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADICIONAL POR", ""), 1) != 0 ) || ( GXutil.strSearch( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "SUELDO ANUAL COMPLEMENTARIO", ""), 1) != 0 ) )
                                       {
                                          Cond_result = true ;
                                       }
                                       else
                                       {
                                          Cond_result = false ;
                                       }
                                       if ( Cond_result )
                                       {
                                          AV119ConBaseOSDif = (byte)(3) ;
                                       }
                                       else
                                       {
                                          AV119ConBaseOSDif = (byte)(2) ;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
                  else
                  {
                     AV42ConPreReq = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq() ;
                     AV52ConSIPAApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo() ;
                     AV53ConSIPACont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont() ;
                     AV31ConINSSJyPApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo() ;
                     AV32ConINSSJyPCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont() ;
                     AV38ConObraSocApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo() ;
                     AV39ConObraSocCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont() ;
                     AV26ConFonSolRedApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo() ;
                     AV27ConFonSolRedCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont() ;
                     AV47ConRenateaApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo() ;
                     AV48ConRenateaCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont() ;
                     AV20ConAsigFamCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont() ;
                     AV25ConFonNacEmpCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont() ;
                     AV33ConLeyRieTrabCont = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont() ;
                     AV45ConRegDifApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo() ;
                     AV46ConRegEspApo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo() ;
                     AV50ConSacDeven = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven() ;
                     AV95ConBaseFer = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer() ;
                     AV120ConPueNov = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov() ;
                     AV96ConBaseLic = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic() ;
                     AV128ConBaseAus = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus() ;
                     AV127ConBaseAusProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom() ;
                     AV97ConBaseHorExt = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext() ;
                     AV103ConBaseFerProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom() ;
                     AV102ConBaseLicProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom() ;
                     AV101ConBaseHorExtProm = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom() ;
                     AV104ConBasePres = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres() ;
                     AV105ConBaseAnt = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant() ;
                     AV119ConBaseOSDif = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif() ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( " old ", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo())+httpContext.getMessage( " &conceptocod_nuevo_aux ", "")+GXutil.trim( AV22conceptocod_nuevo_aux)+httpContext.getMessage( " &ConCodigo ", "")+AV23ConCodigo) ;
                  if ( (GXutil.strcmp("", AV23ConCodigo)==0) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "if &itemConcepto.ConDescrip ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))+httpContext.getMessage( " &clicod_sistema ", "")+GXutil.trim( GXutil.str( AV15clicod_sistema, 6, 0))+httpContext.getMessage( " &itemConcepto.SubTipoConCod1 ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1()+httpContext.getMessage( " &itemConcepto.SubTipoConCod2 ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2()) ;
                     if ( ( AV14CliCod != AV15clicod_sistema ) && new web.esdeduccionuotrosempleos(remoteHandle, context).executeUdp( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1(), AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2()) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "es deduccón ", "")) ;
                        AV23ConCodigo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo() ;
                     }
                     else
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemConcepto.TipoConCod ", "")+AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod()) ;
                        GXv_char14[0] = AV23ConCodigo ;
                        new web.proximoconcodigo(remoteHandle, context).execute( AV14CliCod, AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod(), GXv_char14) ;
                        importarconceptos2.this.AV23ConCodigo = GXv_char14[0] ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "proximo &ConCodigo ", "")+AV23ConCodigo) ;
                     }
                  }
                  A26ConCodigo = AV23ConCodigo ;
                  if ( (0==AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod()) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A1822CliPadre = 0 ;
                     n1822CliPadre = false ;
                     n1822CliPadre = true ;
                     A921ConPadre = "" ;
                     n921ConPadre = false ;
                     n921ConPadre = true ;
                  }
                  else
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemConcepto.CliCod ", "")+GXutil.trim( GXutil.str( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod(), 6, 0))+httpContext.getMessage( " &itemConcepto.ConCodigo ", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo())) ;
                     A1822CliPadre = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod() ;
                     n1822CliPadre = false ;
                     A921ConPadre = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo() ;
                     n921ConPadre = false ;
                  }
                  if ( ! (GXutil.strcmp("", AV22conceptocod_nuevo_aux)==0) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A42ConCodYDesc = GXutil.trim( A41ConDescrip) ;
                     n42ConCodYDesc = false ;
                  }
                  else
                  {
                     A42ConCodYDesc = GXutil.trim( AV23ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
                     n42ConCodYDesc = false ;
                  }
                  A40ConOrden = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden() ;
                  A150ConHabilitado = AV30ConHabilitado ;
                  A510ConOrdEjec = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec() ;
                  A734ConRetGanPropor = AV49ConRetGanPropor ;
                  if ( AV14CliCod == AV15clicod_sistema )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A1112AplIIGG = (short)(0) ;
                     n1112AplIIGG = false ;
                     n1112AplIIGG = true ;
                  }
                  else
                  {
                     A1112AplIIGG = (short)(0) ;
                     n1112AplIIGG = false ;
                     n1112AplIIGG = true ;
                  }
                  A762ConRecalcular = AV44ConRecalcular ;
                  A894ConImportado = true ;
                  A895ConTipoOrden = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden() ;
                  A922ConUsado = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado() ;
                  A954ConCondCodigo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo() ;
                  if ( ! (GXutil.strcmp("", AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion())==0) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A953ConCondicion = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion() ;
                     n953ConCondicion = false ;
                  }
                  else
                  {
                     A953ConCondicion = "" ;
                     n953ConCondicion = false ;
                     n953ConCondicion = true ;
                  }
                  A1018ConRangoCant = AV43ConRangoCant ;
                  A1017ConEdiEnRec = AV24ConEdiEnRec ;
                  A1066ConPreReq = AV42ConPreReq ;
                  n1066ConPreReq = false ;
                  A1068ConMostrarPos = AV35ConMostrarPos ;
                  A1821ConErrorSiCero = AV109ConErrorSiCero ;
                  A1077ConAdelDescu = AV18ConAdelDescu ;
                  n1077ConAdelDescu = false ;
                  A148ConFormula = AV29ConFormula ;
                  n148ConFormula = false ;
                  A1194ConSegunPla = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla() ;
                  if ( AV14CliCod == AV15clicod_sistema )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A1471ConNumero = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero() ;
                  }
                  else
                  {
                     GXt_int15 = A1471ConNumero ;
                     GXv_int11[0] = GXt_int15 ;
                     new web.getnextconnumero(remoteHandle, context).execute( AV14CliCod, GXv_int11) ;
                     importarconceptos2.this.GXt_int15 = GXv_int11[0] ;
                     A1471ConNumero = GXt_int15 ;
                  }
                  A1472ConSIPAApo = AV52ConSIPAApo ;
                  A1473ConSIPACont = AV53ConSIPACont ;
                  A1474ConINSSJyPApo = AV31ConINSSJyPApo ;
                  A1475ConINSSJyPCont = AV32ConINSSJyPCont ;
                  A1476ConObraSocApo = AV38ConObraSocApo ;
                  A1477ConObraSocCont = AV39ConObraSocCont ;
                  A1478ConFonSolRedApo = AV26ConFonSolRedApo ;
                  A1479ConFonSolRedCont = AV27ConFonSolRedCont ;
                  A1480ConRenateaApo = AV47ConRenateaApo ;
                  A1481ConRenateaCont = AV48ConRenateaCont ;
                  A1482ConAsigFamCont = AV20ConAsigFamCont ;
                  A1483ConFonNacEmpCont = AV25ConFonNacEmpCont ;
                  A1484ConLeyRieTrabCont = AV33ConLeyRieTrabCont ;
                  A1485ConRegDifApo = AV45ConRegDifApo ;
                  A1486ConRegEspApo = AV46ConRegEspApo ;
                  A1488ConLiqBasica = AV34ConLiqBasica ;
                  A1539ConSacDeven = AV50ConSacDeven ;
                  A1621ConBaseFer = AV95ConBaseFer ;
                  A1826ConPueNov = AV120ConPueNov ;
                  A1622ConBaseHorExt = AV97ConBaseHorExt ;
                  A1620ConBaseLic = AV96ConBaseLic ;
                  A2191ConBaseAus = AV128ConBaseAus ;
                  A2192ConBaseAusProm = AV127ConBaseAusProm ;
                  A1798ConBaseFerProm = AV103ConBaseFerProm ;
                  A1799ConBaseHorExtProm = AV101ConBaseHorExtProm ;
                  A1797ConBaseLicProm = AV102ConBaseLicProm ;
                  A1801ConBaseAnt = AV105ConBaseAnt ;
                  A1800ConBasePres = AV104ConBasePres ;
                  A1827ConBaseOSDif = AV119ConBaseOSDif ;
                  A1648ConCodAfip = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip() ;
                  if ( ! (GXutil.strcmp("", AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo())==0) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A1644ConceptoPais = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais() ;
                     n1644ConceptoPais = false ;
                     A1645ConceptoConveCodigo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo() ;
                     n1645ConceptoConveCodigo = false ;
                  }
                  else
                  {
                     A1644ConceptoPais = (short)(0) ;
                     n1644ConceptoPais = false ;
                     n1644ConceptoPais = true ;
                     A1645ConceptoConveCodigo = "" ;
                     n1645ConceptoConveCodigo = false ;
                     n1645ConceptoConveCodigo = true ;
                  }
                  AV99palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(A41ConDescrip," ")) ;
                  A1769ConCntPa = (byte)(AV99palabras.size()) ;
                  A1974ConOldValues = "" ;
                  A2013ConRelRef = "" ;
                  /* Using cursor P01OW6 */
                  pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A41ConDescrip, Boolean.valueOf(A150ConHabilitado), Integer.valueOf(A40ConOrden), Boolean.valueOf(A143ConCanti), Boolean.valueOf(A158ConValUni), Boolean.valueOf(A152ConImporte), Byte.valueOf(A162ConVigencia), Boolean.valueOf(n148ConFormula), A148ConFormula, Boolean.valueOf(n157ConValorGen), A157ConValorGen, Boolean.valueOf(n155ConTipoLiqGanancias), A155ConTipoLiqGanancias, A153ConObservacion, Boolean.valueOf(A159ConVariable), Boolean.valueOf(n151ConHisFormula), A151ConHisFormula, Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Byte.valueOf(A154ConTipo), A469ConCodOld, Long.valueOf(A510ConOrdEjec), A569ConFormulaExpl, A720ConFormulaObs2, A729ConFormulaPreResuelta, Boolean.valueOf(A734ConRetGanPropor), Boolean.valueOf(A762ConRecalcular), Boolean.valueOf(A894ConImportado), Short.valueOf(A895ConTipoOrden), Boolean.valueOf(A922ConUsado), Boolean.valueOf(n953ConCondicion), A953ConCondicion, A954ConCondCodigo, Boolean.valueOf(A1017ConEdiEnRec), A1018ConRangoCant, Boolean.valueOf(n1066ConPreReq), A1066ConPreReq, Boolean.valueOf(A1068ConMostrarPos), Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), Boolean.valueOf(A1194ConSegunPla), Byte.valueOf(A1471ConNumero), Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1488ConLiqBasica), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1622ConBaseHorExt), Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, A1648ConCodAfip, Byte.valueOf(A1769ConCntPa), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Boolean.valueOf(A1821ConErrorSiCero), Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre, Byte.valueOf(A1827ConBaseOSDif), Boolean.valueOf(A1826ConPueNov), Integer.valueOf(A1886ConRelSec), Integer.valueOf(A1905ConRelSecCli), A1974ConOldValues, A2013ConRelRef, Byte.valueOf(A2191ConBaseAus), Byte.valueOf(A2192ConBaseAusProm), A2185ConDescripSinAc, Boolean.valueOf(n2187ConOblPalabra), A2187ConOblPalabra});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( (pr_default.getStatus(4) == 1) )
                  {
                     Gx_err = (short)(1) ;
                     Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                  }
                  else
                  {
                     Gx_err = (short)(0) ;
                     Gx_emsg = "" ;
                  }
                  /* End Insert */
                  AV110actualizadosConCodigo.add(AV23ConCodigo, 0);
                  new web.grabarhistorico(remoteHandle, context).execute( AV14CliCod, AV23ConCodigo, "", GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula()), AV67ImpSec, true) ;
                  if ( AV14CliCod == AV15clicod_sistema )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     new web.altaconceptomotivos(remoteHandle, context).execute( AV14CliCod, AV23ConCodigo, AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip()) ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "itemConcepto.TipoLiquidacion count ", "")+GXutil.trim( GXutil.str( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().size(), 9, 0))) ;
                  AV137GXV3 = 1 ;
                  while ( AV137GXV3 <= AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().size() )
                  {
                     AV72itemLiq = (web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem)((web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem)AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().elementAt(-1+AV137GXV3));
                     if ( AV14CliCod != AV15clicod_sistema )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV92TLiqCod = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod() ;
                        AV54ConTLiqSinCausa = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa() ;
                        AV55ConTLiqSinPre = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre() ;
                        AV8ConTLTipEgr = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr() ;
                     }
                     else
                     {
                        AV54ConTLiqSinCausa = false ;
                        AV55ConTLiqSinPre = false ;
                        AV8ConTLTipEgr = "" ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "&itemLiq.TLiqCod ", "")+AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod()) ;
                        if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "A1Q", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "ADELANTOS_1", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "A2M", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "ADELANTOS_2yMes", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "AGU", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "AGUINALDO", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "FIN", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "EGRESO", "") ;
                           if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "INDEMNIZACIÓN ANTIGUEDAD", "")) == 0 )
                           {
                              AV54ConTLiqSinCausa = true ;
                              AV55ConTLiqSinPre = true ;
                              AV8ConTLTipEgr = "SINCAUSA" ;
                           }
                           else if ( ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "INTEGRACIÓN MES DE DESPIDO", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip())), httpContext.getMessage( "INDEMNIZACIÓN SUSTITUTIVA DEL PREAVISO", "")) == 0 ) )
                           {
                              AV54ConTLiqSinCausa = false ;
                              AV55ConTLiqSinPre = true ;
                              AV8ConTLTipEgr = "SINPREAVISO" ;
                           }
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "GAN", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "GANANCIAS", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "GRA", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "GRATIFICACIONES", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "MN", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "MENSUAL", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "PQN", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "QUINCENA_1", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "SQM", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "QUINCENA_2yMes", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "SQN", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "QUINCENA_2", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "VAC", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "VACACIONES", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "VAR", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "VARIOS", "") ;
                        }
                        else if ( GXutil.strcmp(AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), httpContext.getMessage( "ANT", "")) == 0 )
                        {
                           AV92TLiqCod = httpContext.getMessage( "ANTICIPO", "") ;
                        }
                     }
                     new web.msgdebug(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "!concodigo ", "")+GXutil.trim( AV23ConCodigo)+httpContext.getMessage( "!&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))+httpContext.getMessage( " &TLiqCod ", "")+GXutil.trim( AV92TLiqCod)+httpContext.getMessage( " &clicod_sistema ", "")+GXutil.trim( GXutil.str( AV15clicod_sistema, 6, 0))+httpContext.getMessage( "  &itemLiq.TLiqCod ", "")+AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod()) ;
                     GXv_char14[0] = AV59descripcion ;
                     new web.gettipoliqdesc(remoteHandle, context).execute( AV14CliCod, AV92TLiqCod, GXv_char14) ;
                     importarconceptos2.this.AV59descripcion = GXv_char14[0] ;
                     if ( ( AV14CliCod != AV15clicod_sistema ) || ( ( ( AV56ConVigencia == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ADELANTO DE VACACIONES MES PRÓXIMO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "HORAS TRABAJADAS", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTICIPO DE SUELDO", "")) == 0 ) || ( GXutil.strcmp(AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(), httpContext.getMessage( "ANTICIPO A PAGAR EN CUOTAS", "")) == 0 ) ) && ! (GXutil.strcmp("", AV59descripcion)==0) ) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "dentro de when none, inserta tipo liqs &ConCodigo ", "")+AV23ConCodigo+httpContext.getMessage( " &TLiqCod ", "")+AV92TLiqCod) ;
                        /*
                           INSERT RECORD ON TABLE ConceptoTipoLiquidacion

                        */
                        A3CliCod = AV14CliCod ;
                        A26ConCodigo = AV23ConCodigo ;
                        A950ConTLTipEgr = AV8ConTLTipEgr ;
                        A32TLiqCod = AV92TLiqCod ;
                        /* Using cursor P01OW7 */
                        pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod, A950ConTLTipEgr});
                        Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                        if ( (pr_default.getStatus(5) == 1) )
                        {
                           Gx_err = (short)(1) ;
                           Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                        }
                        else
                        {
                           Gx_err = (short)(0) ;
                           Gx_emsg = "" ;
                        }
                        /* End Insert */
                     }
                     AV137GXV3 = (int)(AV137GXV3+1) ;
                  }
                  new web.grabatipoliqaux(remoteHandle, context).execute( AV14CliCod, AV23ConCodigo) ;
               }
               AV134GXV1 = (int)(AV134GXV1+1) ;
            }
            if ( ( AV81nuevos == 0 ) && ( AV79modificados == 0 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               httpContext.GX_msglist.addItem(httpContext.getMessage( "Los conceptos ya se encuentran actualizados", ""));
               AV77mensaje = httpContext.getMessage( "Los conceptos ya se encuentran actualizados", "") ;
            }
            else
            {
            }
            if ( AV81nuevos > 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               if ( AV81nuevos == 1 )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV77mensaje = httpContext.getMessage( "Se creó ", "") + GXutil.trim( GXutil.str( AV81nuevos, 4, 0)) + httpContext.getMessage( " concepto. ", "") ;
               }
               else
               {
                  AV77mensaje = httpContext.getMessage( "Se crearon ", "") + GXutil.trim( GXutil.str( AV81nuevos, 4, 0)) + httpContext.getMessage( " conceptos. ", "") ;
               }
            }
            if ( AV79modificados > 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               if ( AV79modificados == 1 )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV77mensaje += httpContext.getMessage( "Se modificó ", "") + GXutil.trim( GXutil.str( AV79modificados, 4, 0)) + httpContext.getMessage( " fórmula existente.", "") ;
               }
               else
               {
                  AV77mensaje += httpContext.getMessage( "Se modificaron ", "") + GXutil.trim( GXutil.str( AV79modificados, 4, 0)) + httpContext.getMessage( " fórmulas existentes.", "") ;
               }
            }
         }
         if ( AV14CliCod == AV15clicod_sistema )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV65i = (short)(1) ;
            AV40ConOrden = 1 ;
            AV41ConOrdenDed = (short)(2000) ;
            AV90TipoConCod = "" ;
            while ( AV65i <= 4 )
            {
               if ( (GXutil.strcmp("", AV90TipoConCod)==0) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV90TipoConCod = "REM_ARG" ;
               }
               else
               {
                  if ( GXutil.strcmp(AV90TipoConCod, "REM_ARG") == 0 )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV90TipoConCod = "NRE_ARG" ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(AV90TipoConCod, "NRE_ARG") == 0 )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV90TipoConCod = "DES_ARG" ;
                     }
                     else
                     {
                        AV90TipoConCod = "CAL_ARG" ;
                     }
                  }
               }
               /* Using cursor P01OW8 */
               pr_default.execute(6, new Object[] {Integer.valueOf(AV15clicod_sistema), AV90TipoConCod});
               while ( (pr_default.getStatus(6) != 101) )
               {
                  A37TipoConCod = P01OW8_A37TipoConCod[0] ;
                  A3CliCod = P01OW8_A3CliCod[0] ;
                  A40ConOrden = P01OW8_A40ConOrden[0] ;
                  A26ConCodigo = P01OW8_A26ConCodigo[0] ;
                  if ( GXutil.strSearch( A26ConCodigo, GXutil.trim( AV85prefijoDED), 1) == 0 )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A40ConOrden = AV40ConOrden ;
                     GXt_int16 = AV40ConOrden ;
                     GXv_int5[0] = GXt_int16 ;
                     new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int5) ;
                     importarconceptos2.this.GXt_int16 = GXv_int5[0] ;
                     AV40ConOrden = (int)(AV40ConOrden+(GXt_int16)) ;
                  }
                  else
                  {
                     A40ConOrden = AV41ConOrdenDed ;
                     GXt_int16 = AV41ConOrdenDed ;
                     GXv_int5[0] = GXt_int16 ;
                     new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int5) ;
                     importarconceptos2.this.GXt_int16 = GXv_int5[0] ;
                     AV41ConOrdenDed = (short)(AV41ConOrdenDed+(GXt_int16)) ;
                  }
                  /* Using cursor P01OW9 */
                  pr_default.execute(7, new Object[] {Integer.valueOf(A40ConOrden), Integer.valueOf(A3CliCod), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  pr_default.readNext(6);
               }
               pr_default.close(6);
               AV65i = (short)(AV65i+1) ;
            }
         }
      }
      if ( AV14CliCod != AV15clicod_sistema )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.correccionconceptosformula(remoteHandle, context).execute( AV82padre_clicod, AV14CliCod, AV110actualizadosConCodigo) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'TIPOS LIQ' Routine */
      returnInSub = false ;
      AV139GXLvl1453 = (byte)(0) ;
      /* Using cursor P01OW10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV111auxCliCod), AV112auxConCodigo});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A26ConCodigo = P01OW10_A26ConCodigo[0] ;
         A3CliCod = P01OW10_A3CliCod[0] ;
         A32TLiqCod = P01OW10_A32TLiqCod[0] ;
         AV139GXLvl1453 = (byte)(1) ;
         new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza 3", "")) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(8);
      }
      pr_default.close(8);
      if ( AV139GXLvl1453 == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza  4", "")) ;
         AV140GXV4 = 1 ;
         while ( AV140GXV4 <= AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().size() )
         {
            AV72itemLiq = (web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem)((web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem)AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().elementAt(-1+AV140GXV4));
            GXv_char14[0] = AV59descripcion ;
            new web.gettipoliqdesc(remoteHandle, context).execute( AV14CliCod, AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(), GXv_char14) ;
            importarconceptos2.this.AV59descripcion = GXv_char14[0] ;
            new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza 5 &descripcion ", "")+AV59descripcion) ;
            new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza 6  &itemConcepto.ConCodigo ", "")+GXutil.trim( AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo())+httpContext.getMessage( " &itemLiq.TLiqCod ", "")+GXutil.trim( AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod())) ;
            /*
               INSERT RECORD ON TABLE ConceptoTipoLiquidacion

            */
            A3CliCod = AV14CliCod ;
            A26ConCodigo = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo() ;
            A32TLiqCod = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod() ;
            A925ConTLiqSinCausa = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa() ;
            n925ConTLiqSinCausa = false ;
            A926ConTLiqSinPre = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre() ;
            n926ConTLiqSinPre = false ;
            A950ConTLTipEgr = AV72itemLiq.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr() ;
            A1406ConTLOrdejec = AV116auxConOrdEjec ;
            A1407ConTLConOrd = (short)(AV114auxConOrden) ;
            A1409ConTLVigencia = AV115auxConVigencia ;
            n1409ConTLVigencia = false ;
            A1410ConTLCondicion = AV117auxConCondicion ;
            n1410ConTLCondicion = false ;
            A1470ConTLConHab = (byte)((byte)((AV118auxConHabilitado)?1:0)) ;
            A1789CONTLSegPla = AV129auxCondSegPla ;
            n1789CONTLSegPla = false ;
            A1788ConTLTipoCon = AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod() ;
            n1788ConTLTipoCon = false ;
            /* Using cursor P01OW11 */
            pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod, Boolean.valueOf(n925ConTLiqSinCausa), Boolean.valueOf(A925ConTLiqSinCausa), Boolean.valueOf(n926ConTLiqSinPre), Boolean.valueOf(A926ConTLiqSinPre), A950ConTLTipEgr, Long.valueOf(A1406ConTLOrdejec), Short.valueOf(A1407ConTLConOrd), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
            if ( (pr_default.getStatus(9) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            new web.msgdebug2(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( "actualiza 7", "")) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV132Pgmname, httpContext.getMessage( " llama desde aca", "")) ;
            new web.grabatipoliqaux(remoteHandle, context).execute( AV111auxCliCod, AV69itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo()) ;
            AV140GXV4 = (int)(AV140GXV4+1) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = importarconceptos2.this.AV67ImpSec;
      this.aP8[0] = importarconceptos2.this.AV77mensaje;
      this.aP9[0] = importarconceptos2.this.AV13calc;
      this.aP10[0] = importarconceptos2.this.AV40ConOrden;
      Application.commitDataStores(context, remoteHandle, pr_default, "importarconceptos2");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV77mensaje = "" ;
      AV100sueldoDescrip = "" ;
      AV85prefijoDED = "" ;
      AV132Pgmname = "" ;
      GXv_int4 = new short[1] ;
      scmdbuf = "" ;
      P01OW2_A3CliCod = new int[1] ;
      P01OW2_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      AV74Location_Host = "" ;
      AV73Location_BaseURL = "" ;
      AV62http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem6 = new GXBaseCollection[1] ;
      AV12body = "" ;
      AV87responsejson = "" ;
      AV60error = "" ;
      AV9sdt_concepto = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem>(web.Sdtsdt_concepto_sdt_conceptoItem.class, "sdt_conceptoItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_concepto_sdt_conceptoItem7 = new GXBaseCollection[1] ;
      AV69itemConcepto = new web.Sdtsdt_concepto_sdt_conceptoItem(remoteHandle, context);
      AV122padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      P01OW3_A921ConPadre = new String[] {""} ;
      P01OW3_n921ConPadre = new boolean[] {false} ;
      P01OW3_A1822CliPadre = new int[1] ;
      P01OW3_n1822CliPadre = new boolean[] {false} ;
      P01OW3_A3CliCod = new int[1] ;
      P01OW3_A146ConForEditable = new boolean[] {false} ;
      P01OW3_n146ConForEditable = new boolean[] {false} ;
      P01OW3_A148ConFormula = new String[] {""} ;
      P01OW3_n148ConFormula = new boolean[] {false} ;
      P01OW3_A26ConCodigo = new String[] {""} ;
      P01OW3_A1886ConRelSec = new int[1] ;
      P01OW3_A1905ConRelSecCli = new int[1] ;
      P01OW3_A159ConVariable = new boolean[] {false} ;
      P01OW3_A953ConCondicion = new String[] {""} ;
      P01OW3_n953ConCondicion = new boolean[] {false} ;
      P01OW3_A954ConCondCodigo = new String[] {""} ;
      P01OW3_A162ConVigencia = new byte[1] ;
      P01OW3_A156ConUsuModFor = new String[] {""} ;
      P01OW3_n156ConUsuModFor = new boolean[] {false} ;
      P01OW3_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P01OW3_n145ConFchModFor = new boolean[] {false} ;
      P01OW3_A40ConOrden = new int[1] ;
      P01OW3_A510ConOrdEjec = new long[1] ;
      P01OW3_A37TipoConCod = new String[] {""} ;
      P01OW3_A38SubTipoConCod1 = new String[] {""} ;
      P01OW3_n38SubTipoConCod1 = new boolean[] {false} ;
      P01OW3_A39SubTipoConCod2 = new String[] {""} ;
      P01OW3_n39SubTipoConCod2 = new boolean[] {false} ;
      P01OW3_A1648ConCodAfip = new String[] {""} ;
      P01OW3_A1821ConErrorSiCero = new boolean[] {false} ;
      P01OW3_A1018ConRangoCant = new String[] {""} ;
      P01OW3_A1077ConAdelDescu = new byte[1] ;
      P01OW3_n1077ConAdelDescu = new boolean[] {false} ;
      P01OW3_A1539ConSacDeven = new byte[1] ;
      P01OW3_A734ConRetGanPropor = new boolean[] {false} ;
      P01OW3_A1112AplIIGG = new short[1] ;
      P01OW3_n1112AplIIGG = new boolean[] {false} ;
      P01OW3_A762ConRecalcular = new boolean[] {false} ;
      P01OW3_A1472ConSIPAApo = new byte[1] ;
      P01OW3_A1473ConSIPACont = new byte[1] ;
      P01OW3_A1474ConINSSJyPApo = new byte[1] ;
      P01OW3_A1475ConINSSJyPCont = new byte[1] ;
      P01OW3_A1476ConObraSocApo = new byte[1] ;
      P01OW3_A1477ConObraSocCont = new byte[1] ;
      P01OW3_A1478ConFonSolRedApo = new byte[1] ;
      P01OW3_A1479ConFonSolRedCont = new byte[1] ;
      P01OW3_A1480ConRenateaApo = new byte[1] ;
      P01OW3_A1481ConRenateaCont = new byte[1] ;
      P01OW3_A1482ConAsigFamCont = new byte[1] ;
      P01OW3_A1483ConFonNacEmpCont = new byte[1] ;
      P01OW3_A1484ConLeyRieTrabCont = new byte[1] ;
      P01OW3_A1485ConRegDifApo = new byte[1] ;
      P01OW3_A1486ConRegEspApo = new byte[1] ;
      P01OW3_A1801ConBaseAnt = new byte[1] ;
      P01OW3_A1621ConBaseFer = new byte[1] ;
      P01OW3_A1798ConBaseFerProm = new byte[1] ;
      P01OW3_A1622ConBaseHorExt = new byte[1] ;
      P01OW3_A1799ConBaseHorExtProm = new byte[1] ;
      P01OW3_A1800ConBasePres = new byte[1] ;
      P01OW3_A1620ConBaseLic = new byte[1] ;
      P01OW3_A2191ConBaseAus = new byte[1] ;
      P01OW3_A2192ConBaseAusProm = new byte[1] ;
      P01OW3_A1797ConBaseLicProm = new byte[1] ;
      P01OW3_A1827ConBaseOSDif = new byte[1] ;
      P01OW3_A41ConDescrip = new String[] {""} ;
      P01OW3_A2185ConDescripSinAc = new String[] {""} ;
      P01OW3_A150ConHabilitado = new boolean[] {false} ;
      A921ConPadre = "" ;
      A148ConFormula = "" ;
      A953ConCondicion = "" ;
      A954ConCondCodigo = "" ;
      A156ConUsuModFor = "" ;
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A1648ConCodAfip = "" ;
      A1018ConRangoCant = "" ;
      A41ConDescrip = "" ;
      A2185ConDescripSinAc = "" ;
      AV123hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime8 = new java.util.Date[1] ;
      AV125concepto_old = new web.Sdtconcepto_old(remoteHandle, context);
      GXv_Sdtconcepto_old10 = new web.Sdtconcepto_old[1] ;
      AV112auxConCodigo = "" ;
      AV117auxConCondicion = "" ;
      AV121ItemMotEgr = new web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem(remoteHandle, context);
      W26ConCodigo = "" ;
      A11MegCodigo = "" ;
      A1532MegPreaTipo = "" ;
      A1534ConMegDura = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      GXv_int9 = new long[1] ;
      AV23ConCodigo = "" ;
      A2187ConOblPalabra = "" ;
      A729ConFormulaPreResuelta = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      A155ConTipoLiqGanancias = "" ;
      A569ConFormulaExpl = "" ;
      A153ConObservacion = "" ;
      A720ConFormulaObs2 = "" ;
      A151ConHisFormula = "" ;
      AV29ConFormula = "" ;
      AV43ConRangoCant = "" ;
      AV88SubTipoConCod1 = "" ;
      GXv_char2 = new String[1] ;
      AV89SubTipoConCod2 = "" ;
      GXv_char12 = new String[1] ;
      AV90TipoConCod = "" ;
      GXv_char13 = new String[1] ;
      AV22conceptocod_nuevo_aux = "" ;
      AV21conceptocod_nuevo = "" ;
      GXt_char1 = "" ;
      A469ConCodOld = "" ;
      AV42ConPreReq = "" ;
      A42ConCodYDesc = "" ;
      A1066ConPreReq = "" ;
      GXv_int11 = new byte[1] ;
      A1645ConceptoConveCodigo = "" ;
      AV99palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      A1974ConOldValues = "" ;
      A2013ConRelRef = "" ;
      AV110actualizadosConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72itemLiq = new web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem(remoteHandle, context);
      AV92TLiqCod = "" ;
      AV8ConTLTipEgr = "" ;
      AV59descripcion = "" ;
      A950ConTLTipEgr = "" ;
      A32TLiqCod = "" ;
      P01OW8_A37TipoConCod = new String[] {""} ;
      P01OW8_A3CliCod = new int[1] ;
      P01OW8_A40ConOrden = new int[1] ;
      P01OW8_A26ConCodigo = new String[] {""} ;
      GXv_int5 = new int[1] ;
      P01OW10_A26ConCodigo = new String[] {""} ;
      P01OW10_A3CliCod = new int[1] ;
      P01OW10_A32TLiqCod = new String[] {""} ;
      GXv_char14 = new String[1] ;
      A1410ConTLCondicion = "" ;
      A1788ConTLTipoCon = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarconceptos2__default(),
         new Object[] {
             new Object[] {
            P01OW2_A3CliCod, P01OW2_A26ConCodigo
            }
            , new Object[] {
            P01OW3_A921ConPadre, P01OW3_n921ConPadre, P01OW3_A1822CliPadre, P01OW3_n1822CliPadre, P01OW3_A3CliCod, P01OW3_A146ConForEditable, P01OW3_n146ConForEditable, P01OW3_A148ConFormula, P01OW3_n148ConFormula, P01OW3_A26ConCodigo,
            P01OW3_A1886ConRelSec, P01OW3_A1905ConRelSecCli, P01OW3_A159ConVariable, P01OW3_A953ConCondicion, P01OW3_n953ConCondicion, P01OW3_A954ConCondCodigo, P01OW3_A162ConVigencia, P01OW3_A156ConUsuModFor, P01OW3_n156ConUsuModFor, P01OW3_A145ConFchModFor,
            P01OW3_n145ConFchModFor, P01OW3_A40ConOrden, P01OW3_A510ConOrdEjec, P01OW3_A37TipoConCod, P01OW3_A38SubTipoConCod1, P01OW3_n38SubTipoConCod1, P01OW3_A39SubTipoConCod2, P01OW3_n39SubTipoConCod2, P01OW3_A1648ConCodAfip, P01OW3_A1821ConErrorSiCero,
            P01OW3_A1018ConRangoCant, P01OW3_A1077ConAdelDescu, P01OW3_n1077ConAdelDescu, P01OW3_A1539ConSacDeven, P01OW3_A734ConRetGanPropor, P01OW3_A1112AplIIGG, P01OW3_n1112AplIIGG, P01OW3_A762ConRecalcular, P01OW3_A1472ConSIPAApo, P01OW3_A1473ConSIPACont,
            P01OW3_A1474ConINSSJyPApo, P01OW3_A1475ConINSSJyPCont, P01OW3_A1476ConObraSocApo, P01OW3_A1477ConObraSocCont, P01OW3_A1478ConFonSolRedApo, P01OW3_A1479ConFonSolRedCont, P01OW3_A1480ConRenateaApo, P01OW3_A1481ConRenateaCont, P01OW3_A1482ConAsigFamCont, P01OW3_A1483ConFonNacEmpCont,
            P01OW3_A1484ConLeyRieTrabCont, P01OW3_A1485ConRegDifApo, P01OW3_A1486ConRegEspApo, P01OW3_A1801ConBaseAnt, P01OW3_A1621ConBaseFer, P01OW3_A1798ConBaseFerProm, P01OW3_A1622ConBaseHorExt, P01OW3_A1799ConBaseHorExtProm, P01OW3_A1800ConBasePres, P01OW3_A1620ConBaseLic,
            P01OW3_A2191ConBaseAus, P01OW3_A2192ConBaseAusProm, P01OW3_A1797ConBaseLicProm, P01OW3_A1827ConBaseOSDif, P01OW3_A41ConDescrip, P01OW3_A2185ConDescripSinAc, P01OW3_A150ConHabilitado
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01OW8_A37TipoConCod, P01OW8_A3CliCod, P01OW8_A40ConOrden, P01OW8_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P01OW10_A26ConCodigo, P01OW10_A3CliCod, P01OW10_A32TLiqCod
            }
            , new Object[] {
            }
         }
      );
      AV132Pgmname = "importarConceptos2" ;
      /* GeneXus formulas. */
      AV132Pgmname = "importarConceptos2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV133GXLvl19 ;
   private byte AV135GXLvl112 ;
   private byte A162ConVigencia ;
   private byte A1077ConAdelDescu ;
   private byte A1539ConSacDeven ;
   private byte A1472ConSIPAApo ;
   private byte A1473ConSIPACont ;
   private byte A1474ConINSSJyPApo ;
   private byte A1475ConINSSJyPCont ;
   private byte A1476ConObraSocApo ;
   private byte A1477ConObraSocCont ;
   private byte A1478ConFonSolRedApo ;
   private byte A1479ConFonSolRedCont ;
   private byte A1480ConRenateaApo ;
   private byte A1481ConRenateaCont ;
   private byte A1482ConAsigFamCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte A1485ConRegDifApo ;
   private byte A1486ConRegEspApo ;
   private byte A1801ConBaseAnt ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1800ConBasePres ;
   private byte A1620ConBaseLic ;
   private byte A2191ConBaseAus ;
   private byte A2192ConBaseAusProm ;
   private byte A1797ConBaseLicProm ;
   private byte A1827ConBaseOSDif ;
   private byte AV115auxConVigencia ;
   private byte AV129auxCondSegPla ;
   private byte A1530ConMegMeses ;
   private byte A154ConTipo ;
   private byte AV56ConVigencia ;
   private byte AV18ConAdelDescu ;
   private byte AV19ConAplicGan ;
   private byte AV34ConLiqBasica ;
   private byte AV50ConSacDeven ;
   private byte AV95ConBaseFer ;
   private byte AV97ConBaseHorExt ;
   private byte AV96ConBaseLic ;
   private byte AV103ConBaseFerProm ;
   private byte AV128ConBaseAus ;
   private byte AV127ConBaseAusProm ;
   private byte AV101ConBaseHorExtProm ;
   private byte AV102ConBaseLicProm ;
   private byte AV104ConBasePres ;
   private byte AV105ConBaseAnt ;
   private byte AV119ConBaseOSDif ;
   private byte AV52ConSIPAApo ;
   private byte AV53ConSIPACont ;
   private byte AV31ConINSSJyPApo ;
   private byte AV32ConINSSJyPCont ;
   private byte AV38ConObraSocApo ;
   private byte AV39ConObraSocCont ;
   private byte AV26ConFonSolRedApo ;
   private byte AV27ConFonSolRedCont ;
   private byte AV47ConRenateaApo ;
   private byte AV48ConRenateaCont ;
   private byte AV20ConAsigFamCont ;
   private byte AV25ConFonNacEmpCont ;
   private byte AV33ConLeyRieTrabCont ;
   private byte AV45ConRegDifApo ;
   private byte AV46ConRegEspApo ;
   private byte A1471ConNumero ;
   private byte GXt_int15 ;
   private byte GXv_int11[] ;
   private byte A1488ConLiqBasica ;
   private byte A1769ConCntPa ;
   private byte AV139GXLvl1453 ;
   private byte A1409ConTLVigencia ;
   private byte A1470ConTLConHab ;
   private byte A1789CONTLSegPla ;
   private short AV94versionador_CliPaiConve ;
   private short AV13calc ;
   private short AV83PaiCod ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short AV76Location_Secure ;
   private short AV81nuevos ;
   private short AV79modificados ;
   private short A1112AplIIGG ;
   private short AV126ConMegSec ;
   private short A2077ConMegSec ;
   private short Gx_err ;
   private short AV86rem ;
   private short AV80nre ;
   private short AV58des ;
   private short A895ConTipoOrden ;
   private short A1644ConceptoPais ;
   private short AV65i ;
   private short AV41ConOrdenDed ;
   private short A1407ConTLConOrd ;
   private int AV82padre_clicod ;
   private int AV14CliCod ;
   private int AV124CliRelSec ;
   private int AV40ConOrden ;
   private int AV15clicod_sistema ;
   private int A3CliCod ;
   private int AV134GXV1 ;
   private int A1822CliPadre ;
   private int A1886ConRelSec ;
   private int A1905ConRelSecCli ;
   private int A40ConOrden ;
   private int AV111auxCliCod ;
   private int AV114auxConOrden ;
   private int AV136GXV2 ;
   private int GX_INS261 ;
   private int W3CliCod ;
   private int GX_INS7 ;
   private int AV137GXV3 ;
   private int GX_INS8 ;
   private int GXt_int16 ;
   private int GXv_int5[] ;
   private int AV140GXV4 ;
   private long AV67ImpSec ;
   private long AV75Location_Port ;
   private long A510ConOrdEjec ;
   private long AV116auxConOrdEjec ;
   private long GXv_int9[] ;
   private long A1406ConTLOrdejec ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private java.math.BigDecimal A157ConValorGen ;
   private String AV98parmConCodigo ;
   private String AV93versionador_CliConvenio ;
   private String AV85prefijoDED ;
   private String AV132Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A921ConPadre ;
   private String A953ConCondicion ;
   private String A954ConCondCodigo ;
   private String A156ConUsuModFor ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A1648ConCodAfip ;
   private String AV112auxConCodigo ;
   private String AV117auxConCondicion ;
   private String W26ConCodigo ;
   private String A11MegCodigo ;
   private String A1532MegPreaTipo ;
   private String A1534ConMegDura ;
   private String Gx_emsg ;
   private String AV23ConCodigo ;
   private String A2187ConOblPalabra ;
   private String A155ConTipoLiqGanancias ;
   private String AV88SubTipoConCod1 ;
   private String GXv_char2[] ;
   private String AV89SubTipoConCod2 ;
   private String GXv_char12[] ;
   private String AV90TipoConCod ;
   private String GXv_char13[] ;
   private String AV22conceptocod_nuevo_aux ;
   private String AV21conceptocod_nuevo ;
   private String GXt_char1 ;
   private String A469ConCodOld ;
   private String AV42ConPreReq ;
   private String A1066ConPreReq ;
   private String A1645ConceptoConveCodigo ;
   private String AV92TLiqCod ;
   private String AV8ConTLTipEgr ;
   private String AV59descripcion ;
   private String A950ConTLTipEgr ;
   private String A32TLiqCod ;
   private String GXv_char14[] ;
   private String A1410ConTLCondicion ;
   private String A1788ConTLTipoCon ;
   private java.util.Date AV122padreReleaseDateTime ;
   private java.util.Date A145ConFchModFor ;
   private java.util.Date AV123hijoReleaseDateTime ;
   private java.util.Date GXv_dtime8[] ;
   private boolean AV16clienteConvenioEs ;
   private boolean AV66importar ;
   private boolean AV28ConForExportar ;
   private boolean n921ConPadre ;
   private boolean n1822CliPadre ;
   private boolean A146ConForEditable ;
   private boolean n146ConForEditable ;
   private boolean n148ConFormula ;
   private boolean A159ConVariable ;
   private boolean n953ConCondicion ;
   private boolean n156ConUsuModFor ;
   private boolean n145ConFchModFor ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean A1821ConErrorSiCero ;
   private boolean n1077ConAdelDescu ;
   private boolean A734ConRetGanPropor ;
   private boolean n1112AplIIGG ;
   private boolean A762ConRecalcular ;
   private boolean A150ConHabilitado ;
   private boolean AV118auxConHabilitado ;
   private boolean returnInSub ;
   private boolean AV30ConHabilitado ;
   private boolean n2187ConOblPalabra ;
   private boolean A143ConCanti ;
   private boolean A158ConValUni ;
   private boolean A152ConImporte ;
   private boolean n157ConValorGen ;
   private boolean n155ConTipoLiqGanancias ;
   private boolean AV44ConRecalcular ;
   private boolean n151ConHisFormula ;
   private boolean AV35ConMostrarPos ;
   private boolean AV109ConErrorSiCero ;
   private boolean AV49ConRetGanPropor ;
   private boolean AV24ConEdiEnRec ;
   private boolean Cond_result ;
   private boolean AV10anualEs ;
   private boolean AV120ConPueNov ;
   private boolean n42ConCodYDesc ;
   private boolean A894ConImportado ;
   private boolean A922ConUsado ;
   private boolean A1017ConEdiEnRec ;
   private boolean n1066ConPreReq ;
   private boolean A1068ConMostrarPos ;
   private boolean A1194ConSegunPla ;
   private boolean A1826ConPueNov ;
   private boolean n1644ConceptoPais ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean AV54ConTLiqSinCausa ;
   private boolean AV55ConTLiqSinPre ;
   private boolean A925ConTLiqSinCausa ;
   private boolean n925ConTLiqSinCausa ;
   private boolean A926ConTLiqSinPre ;
   private boolean n926ConTLiqSinPre ;
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean n1789CONTLSegPla ;
   private boolean n1788ConTLTipoCon ;
   private String A148ConFormula ;
   private String A729ConFormulaPreResuelta ;
   private String A569ConFormulaExpl ;
   private String A153ConObservacion ;
   private String A720ConFormulaObs2 ;
   private String A151ConHisFormula ;
   private String AV29ConFormula ;
   private String A1974ConOldValues ;
   private String AV77mensaje ;
   private String AV100sueldoDescrip ;
   private String AV74Location_Host ;
   private String AV73Location_BaseURL ;
   private String AV12body ;
   private String AV87responsejson ;
   private String AV60error ;
   private String A1018ConRangoCant ;
   private String A41ConDescrip ;
   private String A2185ConDescripSinAc ;
   private String AV43ConRangoCant ;
   private String A42ConCodYDesc ;
   private String A2013ConRelRef ;
   private int[] aP10 ;
   private long[] aP7 ;
   private String[] aP8 ;
   private short[] aP9 ;
   private IDataStoreProvider pr_default ;
   private int[] P01OW2_A3CliCod ;
   private String[] P01OW2_A26ConCodigo ;
   private String[] P01OW3_A921ConPadre ;
   private boolean[] P01OW3_n921ConPadre ;
   private int[] P01OW3_A1822CliPadre ;
   private boolean[] P01OW3_n1822CliPadre ;
   private int[] P01OW3_A3CliCod ;
   private boolean[] P01OW3_A146ConForEditable ;
   private boolean[] P01OW3_n146ConForEditable ;
   private String[] P01OW3_A148ConFormula ;
   private boolean[] P01OW3_n148ConFormula ;
   private String[] P01OW3_A26ConCodigo ;
   private int[] P01OW3_A1886ConRelSec ;
   private int[] P01OW3_A1905ConRelSecCli ;
   private boolean[] P01OW3_A159ConVariable ;
   private String[] P01OW3_A953ConCondicion ;
   private boolean[] P01OW3_n953ConCondicion ;
   private String[] P01OW3_A954ConCondCodigo ;
   private byte[] P01OW3_A162ConVigencia ;
   private String[] P01OW3_A156ConUsuModFor ;
   private boolean[] P01OW3_n156ConUsuModFor ;
   private java.util.Date[] P01OW3_A145ConFchModFor ;
   private boolean[] P01OW3_n145ConFchModFor ;
   private int[] P01OW3_A40ConOrden ;
   private long[] P01OW3_A510ConOrdEjec ;
   private String[] P01OW3_A37TipoConCod ;
   private String[] P01OW3_A38SubTipoConCod1 ;
   private boolean[] P01OW3_n38SubTipoConCod1 ;
   private String[] P01OW3_A39SubTipoConCod2 ;
   private boolean[] P01OW3_n39SubTipoConCod2 ;
   private String[] P01OW3_A1648ConCodAfip ;
   private boolean[] P01OW3_A1821ConErrorSiCero ;
   private String[] P01OW3_A1018ConRangoCant ;
   private byte[] P01OW3_A1077ConAdelDescu ;
   private boolean[] P01OW3_n1077ConAdelDescu ;
   private byte[] P01OW3_A1539ConSacDeven ;
   private boolean[] P01OW3_A734ConRetGanPropor ;
   private short[] P01OW3_A1112AplIIGG ;
   private boolean[] P01OW3_n1112AplIIGG ;
   private boolean[] P01OW3_A762ConRecalcular ;
   private byte[] P01OW3_A1472ConSIPAApo ;
   private byte[] P01OW3_A1473ConSIPACont ;
   private byte[] P01OW3_A1474ConINSSJyPApo ;
   private byte[] P01OW3_A1475ConINSSJyPCont ;
   private byte[] P01OW3_A1476ConObraSocApo ;
   private byte[] P01OW3_A1477ConObraSocCont ;
   private byte[] P01OW3_A1478ConFonSolRedApo ;
   private byte[] P01OW3_A1479ConFonSolRedCont ;
   private byte[] P01OW3_A1480ConRenateaApo ;
   private byte[] P01OW3_A1481ConRenateaCont ;
   private byte[] P01OW3_A1482ConAsigFamCont ;
   private byte[] P01OW3_A1483ConFonNacEmpCont ;
   private byte[] P01OW3_A1484ConLeyRieTrabCont ;
   private byte[] P01OW3_A1485ConRegDifApo ;
   private byte[] P01OW3_A1486ConRegEspApo ;
   private byte[] P01OW3_A1801ConBaseAnt ;
   private byte[] P01OW3_A1621ConBaseFer ;
   private byte[] P01OW3_A1798ConBaseFerProm ;
   private byte[] P01OW3_A1622ConBaseHorExt ;
   private byte[] P01OW3_A1799ConBaseHorExtProm ;
   private byte[] P01OW3_A1800ConBasePres ;
   private byte[] P01OW3_A1620ConBaseLic ;
   private byte[] P01OW3_A2191ConBaseAus ;
   private byte[] P01OW3_A2192ConBaseAusProm ;
   private byte[] P01OW3_A1797ConBaseLicProm ;
   private byte[] P01OW3_A1827ConBaseOSDif ;
   private String[] P01OW3_A41ConDescrip ;
   private String[] P01OW3_A2185ConDescripSinAc ;
   private boolean[] P01OW3_A150ConHabilitado ;
   private String[] P01OW8_A37TipoConCod ;
   private int[] P01OW8_A3CliCod ;
   private int[] P01OW8_A40ConOrden ;
   private String[] P01OW8_A26ConCodigo ;
   private String[] P01OW10_A26ConCodigo ;
   private int[] P01OW10_A3CliCod ;
   private String[] P01OW10_A32TLiqCod ;
   private GXSimpleCollection<String> AV99palabras ;
   private GXSimpleCollection<String> AV110actualizadosConCodigo ;
   private GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem> AV9sdt_concepto ;
   private GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem> GXv_objcol_Sdtsdt_concepto_sdt_conceptoItem7[] ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV62http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem6[] ;
   private web.Sdtsdt_concepto_sdt_conceptoItem AV69itemConcepto ;
   private web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem AV121ItemMotEgr ;
   private web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem AV72itemLiq ;
   private web.Sdtconcepto_old AV125concepto_old ;
   private web.Sdtconcepto_old GXv_Sdtconcepto_old10[] ;
}

final  class importarconceptos2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01OW2", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01OW3", "SELECT ConPadre, CliPadre, CliCod, ConForEditable, ConFormula, ConCodigo, ConRelSec, ConRelSecCli, ConVariable, ConCondicion, ConCondCodigo, ConVigencia, ConUsuModFor, ConFchModFor, ConOrden, ConOrdEjec, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCodAfip, ConErrorSiCero, ConRangoCant, ConAdelDescu, ConSacDeven, ConRetGanPropor, AplIIGG, ConRecalcular, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConBaseAnt, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseLic, ConBaseAus, ConBaseAusProm, ConBaseLicProm, ConBaseOSDif, ConDescrip, ConDescripSinAc, ConHabilitado FROM Concepto WHERE (CliPadre = ? and ConPadre = ( ?)) AND (CliCod = ?) ORDER BY CliPadre, ConPadre  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01OW4", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01OW5", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?, ConRelSec=?, ConRelSecCli=?, ConVariable=?, ConCondicion=?, ConCondCodigo=?, ConVigencia=?, ConUsuModFor=?, ConFchModFor=?, ConOrden=?, ConOrdEjec=?, TipoConCod=?, SubTipoConCod1=?, SubTipoConCod2=?, ConCodAfip=?, ConErrorSiCero=?, ConRangoCant=?, ConAdelDescu=?, ConSacDeven=?, ConRetGanPropor=?, AplIIGG=?, ConRecalcular=?, ConSIPAApo=?, ConSIPACont=?, ConINSSJyPApo=?, ConINSSJyPCont=?, ConObraSocApo=?, ConObraSocCont=?, ConFonSolRedApo=?, ConFonSolRedCont=?, ConRenateaApo=?, ConRenateaCont=?, ConAsigFamCont=?, ConFonNacEmpCont=?, ConLeyRieTrabCont=?, ConRegDifApo=?, ConRegEspApo=?, ConBaseAnt=?, ConBaseFer=?, ConBaseFerProm=?, ConBaseHorExt=?, ConBaseHorExtProm=?, ConBasePres=?, ConBaseLic=?, ConBaseAus=?, ConBaseAusProm=?, ConBaseLicProm=?, ConBaseOSDif=?, ConDescrip=?, ConDescripSinAc=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01OW6", "SAVEPOINT gxupdate;INSERT INTO Concepto(CliCod, ConCodigo, ConDescrip, ConHabilitado, ConOrden, ConCanti, ConValUni, ConImporte, ConVigencia, ConFormula, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConVariable, ConHisFormula, ConUsuModFor, ConFchModFor, ConCodYDesc, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConTipo, ConCodOld, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConFormulaPreResuelta, ConRetGanPropor, ConRecalcular, ConImportado, ConTipoOrden, ConUsado, ConCondicion, ConCondCodigo, ConEdiEnRec, ConRangoCant, ConPreReq, ConMostrarPos, ConAdelDescu, AplIIGG, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConLiqBasica, ConSacDeven, ConBaseLic, ConBaseFer, ConBaseHorExt, ConceptoPais, ConceptoConveCodigo, ConCodAfip, ConCntPa, ConBaseLicProm, ConBaseFerProm, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConErrorSiCero, CliPadre, ConPadre, ConBaseOSDif, ConPueNov, ConRelSec, ConRelSecCli, ConOldValues, ConRelRef, ConBaseAus, ConBaseAusProm, ConDescripSinAc, ConOblPalabra, ConForEditable, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConAplicGan, ConObliga, ConObligaSiSac, ConConveAux, ConClasifAux) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, '', '', '', 0, FALSE, FALSE, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01OW7", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLTipEgr, ConTLiqSinCausa, ConTLiqSinPre, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, ?, FALSE, FALSE, 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01OW8", "SELECT TipoConCod, CliCod, ConOrden, ConCodigo FROM Concepto WHERE CliCod = ? and TipoConCod = ( ?) ORDER BY CliCod, TipoConCod, ConCodigo  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01OW9", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrden=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01OW10", "SELECT ConCodigo, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01OW11", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(6, 10);
               ((int[]) buf[10])[0] = rslt.getInt(7);
               ((int[]) buf[11])[0] = rslt.getInt(8);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(11, 20);
               ((byte[]) buf[16])[0] = rslt.getByte(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDateTime(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((int[]) buf[21])[0] = rslt.getInt(15);
               ((long[]) buf[22])[0] = rslt.getLong(16);
               ((String[]) buf[23])[0] = rslt.getString(17, 20);
               ((String[]) buf[24])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(19, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getString(20, 6);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(21);
               ((String[]) buf[30])[0] = rslt.getVarchar(22);
               ((byte[]) buf[31])[0] = rslt.getByte(23);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((byte[]) buf[33])[0] = rslt.getByte(24);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(25);
               ((short[]) buf[35])[0] = rslt.getShort(26);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((boolean[]) buf[37])[0] = rslt.getBoolean(27);
               ((byte[]) buf[38])[0] = rslt.getByte(28);
               ((byte[]) buf[39])[0] = rslt.getByte(29);
               ((byte[]) buf[40])[0] = rslt.getByte(30);
               ((byte[]) buf[41])[0] = rslt.getByte(31);
               ((byte[]) buf[42])[0] = rslt.getByte(32);
               ((byte[]) buf[43])[0] = rslt.getByte(33);
               ((byte[]) buf[44])[0] = rslt.getByte(34);
               ((byte[]) buf[45])[0] = rslt.getByte(35);
               ((byte[]) buf[46])[0] = rslt.getByte(36);
               ((byte[]) buf[47])[0] = rslt.getByte(37);
               ((byte[]) buf[48])[0] = rslt.getByte(38);
               ((byte[]) buf[49])[0] = rslt.getByte(39);
               ((byte[]) buf[50])[0] = rslt.getByte(40);
               ((byte[]) buf[51])[0] = rslt.getByte(41);
               ((byte[]) buf[52])[0] = rslt.getByte(42);
               ((byte[]) buf[53])[0] = rslt.getByte(43);
               ((byte[]) buf[54])[0] = rslt.getByte(44);
               ((byte[]) buf[55])[0] = rslt.getByte(45);
               ((byte[]) buf[56])[0] = rslt.getByte(46);
               ((byte[]) buf[57])[0] = rslt.getByte(47);
               ((byte[]) buf[58])[0] = rslt.getByte(48);
               ((byte[]) buf[59])[0] = rslt.getByte(49);
               ((byte[]) buf[60])[0] = rslt.getByte(50);
               ((byte[]) buf[61])[0] = rslt.getByte(51);
               ((byte[]) buf[62])[0] = rslt.getByte(52);
               ((byte[]) buf[63])[0] = rslt.getByte(53);
               ((String[]) buf[64])[0] = rslt.getVarchar(54);
               ((String[]) buf[65])[0] = rslt.getVarchar(55);
               ((boolean[]) buf[66])[0] = rslt.getBoolean(56);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setInt(3, ((Number) parms[3]).intValue());
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[6], 20);
               }
               stmt.setString(6, (String)parms[7], 20);
               stmt.setByte(7, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[10], 20);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(9, (java.util.Date)parms[12], false);
               }
               stmt.setInt(10, ((Number) parms[13]).intValue());
               stmt.setLong(11, ((Number) parms[14]).longValue());
               stmt.setString(12, (String)parms[15], 20);
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[17], 20);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[19], 20);
               }
               stmt.setString(15, (String)parms[20], 6);
               stmt.setBoolean(16, ((Boolean) parms[21]).booleanValue());
               stmt.setVarchar(17, (String)parms[22], 400, false);
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(18, ((Number) parms[24]).byteValue());
               }
               stmt.setByte(19, ((Number) parms[25]).byteValue());
               stmt.setBoolean(20, ((Boolean) parms[26]).booleanValue());
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(21, ((Number) parms[28]).shortValue());
               }
               stmt.setBoolean(22, ((Boolean) parms[29]).booleanValue());
               stmt.setByte(23, ((Number) parms[30]).byteValue());
               stmt.setByte(24, ((Number) parms[31]).byteValue());
               stmt.setByte(25, ((Number) parms[32]).byteValue());
               stmt.setByte(26, ((Number) parms[33]).byteValue());
               stmt.setByte(27, ((Number) parms[34]).byteValue());
               stmt.setByte(28, ((Number) parms[35]).byteValue());
               stmt.setByte(29, ((Number) parms[36]).byteValue());
               stmt.setByte(30, ((Number) parms[37]).byteValue());
               stmt.setByte(31, ((Number) parms[38]).byteValue());
               stmt.setByte(32, ((Number) parms[39]).byteValue());
               stmt.setByte(33, ((Number) parms[40]).byteValue());
               stmt.setByte(34, ((Number) parms[41]).byteValue());
               stmt.setByte(35, ((Number) parms[42]).byteValue());
               stmt.setByte(36, ((Number) parms[43]).byteValue());
               stmt.setByte(37, ((Number) parms[44]).byteValue());
               stmt.setByte(38, ((Number) parms[45]).byteValue());
               stmt.setByte(39, ((Number) parms[46]).byteValue());
               stmt.setByte(40, ((Number) parms[47]).byteValue());
               stmt.setByte(41, ((Number) parms[48]).byteValue());
               stmt.setByte(42, ((Number) parms[49]).byteValue());
               stmt.setByte(43, ((Number) parms[50]).byteValue());
               stmt.setByte(44, ((Number) parms[51]).byteValue());
               stmt.setByte(45, ((Number) parms[52]).byteValue());
               stmt.setByte(46, ((Number) parms[53]).byteValue());
               stmt.setByte(47, ((Number) parms[54]).byteValue());
               stmt.setByte(48, ((Number) parms[55]).byteValue());
               stmt.setVarchar(49, (String)parms[56], 400, false);
               stmt.setVarchar(50, (String)parms[57], 400, false);
               stmt.setInt(51, ((Number) parms[58]).intValue());
               stmt.setString(52, (String)parms[59], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(10, (String)parms[10]);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(11, (java.math.BigDecimal)parms[12], 4);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[14], 1);
               }
               stmt.setNLongVarchar(13, (String)parms[15], false);
               stmt.setBoolean(14, ((Boolean) parms[16]).booleanValue());
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(15, (String)parms[18]);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[20], 20);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(17, (java.util.Date)parms[22], false);
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(18, (String)parms[24], 400);
               }
               stmt.setString(19, (String)parms[25], 20);
               if ( ((Boolean) parms[26]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(20, (String)parms[27], 20);
               }
               if ( ((Boolean) parms[28]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(21, (String)parms[29], 20);
               }
               stmt.setByte(22, ((Number) parms[30]).byteValue());
               stmt.setString(23, (String)parms[31], 10);
               stmt.setLong(24, ((Number) parms[32]).longValue());
               stmt.setNLongVarchar(25, (String)parms[33], false);
               stmt.setNLongVarchar(26, (String)parms[34], false);
               stmt.setNLongVarchar(27, (String)parms[35], false);
               stmt.setBoolean(28, ((Boolean) parms[36]).booleanValue());
               stmt.setBoolean(29, ((Boolean) parms[37]).booleanValue());
               stmt.setBoolean(30, ((Boolean) parms[38]).booleanValue());
               stmt.setShort(31, ((Number) parms[39]).shortValue());
               stmt.setBoolean(32, ((Boolean) parms[40]).booleanValue());
               if ( ((Boolean) parms[41]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(33, (String)parms[42], 20);
               }
               stmt.setString(34, (String)parms[43], 20);
               stmt.setBoolean(35, ((Boolean) parms[44]).booleanValue());
               stmt.setVarchar(36, (String)parms[45], 400, false);
               if ( ((Boolean) parms[46]).booleanValue() )
               {
                  stmt.setNull( 37 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(37, (String)parms[47], 20);
               }
               stmt.setBoolean(38, ((Boolean) parms[48]).booleanValue());
               if ( ((Boolean) parms[49]).booleanValue() )
               {
                  stmt.setNull( 39 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(39, ((Number) parms[50]).byteValue());
               }
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 40 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(40, ((Number) parms[52]).shortValue());
               }
               stmt.setBoolean(41, ((Boolean) parms[53]).booleanValue());
               stmt.setByte(42, ((Number) parms[54]).byteValue());
               stmt.setByte(43, ((Number) parms[55]).byteValue());
               stmt.setByte(44, ((Number) parms[56]).byteValue());
               stmt.setByte(45, ((Number) parms[57]).byteValue());
               stmt.setByte(46, ((Number) parms[58]).byteValue());
               stmt.setByte(47, ((Number) parms[59]).byteValue());
               stmt.setByte(48, ((Number) parms[60]).byteValue());
               stmt.setByte(49, ((Number) parms[61]).byteValue());
               stmt.setByte(50, ((Number) parms[62]).byteValue());
               stmt.setByte(51, ((Number) parms[63]).byteValue());
               stmt.setByte(52, ((Number) parms[64]).byteValue());
               stmt.setByte(53, ((Number) parms[65]).byteValue());
               stmt.setByte(54, ((Number) parms[66]).byteValue());
               stmt.setByte(55, ((Number) parms[67]).byteValue());
               stmt.setByte(56, ((Number) parms[68]).byteValue());
               stmt.setByte(57, ((Number) parms[69]).byteValue());
               stmt.setByte(58, ((Number) parms[70]).byteValue());
               stmt.setByte(59, ((Number) parms[71]).byteValue());
               stmt.setByte(60, ((Number) parms[72]).byteValue());
               stmt.setByte(61, ((Number) parms[73]).byteValue());
               stmt.setByte(62, ((Number) parms[74]).byteValue());
               if ( ((Boolean) parms[75]).booleanValue() )
               {
                  stmt.setNull( 63 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(63, ((Number) parms[76]).shortValue());
               }
               if ( ((Boolean) parms[77]).booleanValue() )
               {
                  stmt.setNull( 64 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(64, (String)parms[78], 20);
               }
               stmt.setString(65, (String)parms[79], 6);
               stmt.setByte(66, ((Number) parms[80]).byteValue());
               stmt.setByte(67, ((Number) parms[81]).byteValue());
               stmt.setByte(68, ((Number) parms[82]).byteValue());
               stmt.setByte(69, ((Number) parms[83]).byteValue());
               stmt.setByte(70, ((Number) parms[84]).byteValue());
               stmt.setByte(71, ((Number) parms[85]).byteValue());
               stmt.setBoolean(72, ((Boolean) parms[86]).booleanValue());
               if ( ((Boolean) parms[87]).booleanValue() )
               {
                  stmt.setNull( 73 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(73, ((Number) parms[88]).intValue());
               }
               if ( ((Boolean) parms[89]).booleanValue() )
               {
                  stmt.setNull( 74 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(74, (String)parms[90], 10);
               }
               stmt.setByte(75, ((Number) parms[91]).byteValue());
               stmt.setBoolean(76, ((Boolean) parms[92]).booleanValue());
               stmt.setInt(77, ((Number) parms[93]).intValue());
               stmt.setInt(78, ((Number) parms[94]).intValue());
               stmt.setNLongVarchar(79, (String)parms[95], false);
               stmt.setVarchar(80, (String)parms[96], 40, false);
               stmt.setByte(81, ((Number) parms[97]).byteValue());
               stmt.setByte(82, ((Number) parms[98]).byteValue());
               stmt.setVarchar(83, (String)parms[99], 400, false);
               if ( ((Boolean) parms[100]).booleanValue() )
               {
                  stmt.setNull( 84 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(84, (String)parms[101], 20);
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               }
               stmt.setString(6, (String)parms[7], 20);
               stmt.setLong(7, ((Number) parms[8]).longValue());
               stmt.setShort(8, ((Number) parms[9]).shortValue());
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[11]).byteValue());
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[13], 20);
               }
               stmt.setByte(11, ((Number) parms[14]).byteValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[16], 20);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(13, ((Number) parms[18]).byteValue());
               }
               return;
      }
   }

}

