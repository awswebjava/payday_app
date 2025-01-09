package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconcepto extends GXProcedure
{
   public newconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconcepto.class ), "" );
   }

   public newconcepto( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        boolean aP4 ,
                        byte aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        java.math.BigDecimal aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        String aP16 ,
                        int aP17 ,
                        boolean aP18 ,
                        String aP19 ,
                        boolean aP20 ,
                        boolean aP21 ,
                        boolean aP22 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             boolean aP4 ,
                             byte aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             int aP17 ,
                             boolean aP18 ,
                             String aP19 ,
                             boolean aP20 ,
                             boolean aP21 ,
                             boolean aP22 )
   {
      newconcepto.this.AV28CliCod = aP0;
      newconcepto.this.AV22ConCodigo = aP1;
      newconcepto.this.AV8ConDescrip = aP2;
      newconcepto.this.AV9ConTipo = aP3;
      newconcepto.this.AV10ConValUni = aP4;
      newconcepto.this.AV11ConVigencia = aP5;
      newconcepto.this.AV12ConImporte = aP6;
      newconcepto.this.AV13ConFormula = aP7;
      newconcepto.this.AV14ConValorGen = aP8;
      newconcepto.this.AV15ConObservacion = aP9;
      newconcepto.this.AV16ConVariable = aP10;
      newconcepto.this.AV17ConForExportar = aP11;
      newconcepto.this.AV18TipoConCod = aP12;
      newconcepto.this.AV19SubTipoConCod1 = aP13;
      newconcepto.this.AV20SubTipoConCod2 = aP14;
      newconcepto.this.AV21ConCodOld = aP15;
      newconcepto.this.AV23ConCodYDesc = aP16;
      newconcepto.this.AV24ConOrden = aP17;
      newconcepto.this.AV25ConForEditable = aP18;
      newconcepto.this.AV26ConTipoLiqGanancias = aP19;
      newconcepto.this.AV27ConCanti = aP20;
      newconcepto.this.AV29ConRecalcular = aP21;
      newconcepto.this.AV30exclusivoMensualEs = aP22;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV28CliCod, 6, 0))+httpContext.getMessage( " cod ", "")+AV22ConCodigo+httpContext.getMessage( " desc ", "")+AV8ConDescrip) ;
      if ( GXutil.strcmp(AV22ConCodigo, httpContext.getMessage( "CAL040", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "!!!&con rec ", "")+GXutil.trim( GXutil.booltostr( AV29ConRecalcular))) ;
      }
      /*
         INSERT RECORD ON TABLE Concepto

      */
      A3CliCod = AV28CliCod ;
      A41ConDescrip = AV8ConDescrip ;
      GXt_char1 = A2185ConDescripSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( AV8ConDescrip, GXv_char2) ;
      newconcepto.this.GXt_char1 = GXv_char2[0] ;
      A2185ConDescripSinAc = GXt_char1 ;
      A150ConHabilitado = true ;
      if ( ! (0==AV9ConTipo) )
      {
         A154ConTipo = AV9ConTipo ;
      }
      A143ConCanti = AV27ConCanti ;
      A158ConValUni = AV10ConValUni ;
      A152ConImporte = AV12ConImporte ;
      A162ConVigencia = AV11ConVigencia ;
      A148ConFormula = AV13ConFormula ;
      n148ConFormula = false ;
      A157ConValorGen = AV14ConValorGen ;
      n157ConValorGen = false ;
      A953ConCondicion = "A0" ;
      n953ConCondicion = false ;
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BONOS EXENTOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "FALLOS DE CAJA EXENTOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "SIMILAR NATURALEZA EXENTA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "HORAS EXTRAS EXENTAS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "SAC EXENTO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "MOVILIDAD Y VIATICOS EXENTOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "PERSONAL DOCENTE MATERIAL DIDACTICO EXENTOS", "")) == 0 ) )
      {
      }
      else
      {
      }
      if ( ( GXutil.strcmp(AV18TipoConCod, "CAL_ARG") != 0 ) && ( GXutil.strcmp(AV18TipoConCod, "DES_ARG") != 0 ) )
      {
         A1827ConBaseOSDif = (byte)(2) ;
         A1800ConBasePres = (byte)(1) ;
         A1801ConBaseAnt = (byte)(1) ;
      }
      else
      {
         A1827ConBaseOSDif = (byte)(0) ;
         A1800ConBasePres = (byte)(0) ;
         A1801ConBaseAnt = (byte)(0) ;
      }
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BONO 2", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "DECRETO 198/08 - TICKETS", "")) == 0 ) )
      {
         A1539ConSacDeven = (byte)(12) ;
         A1621ConBaseFer = (byte)(1) ;
         A1622ConBaseHorExt = (byte)(1) ;
         A1620ConBaseLic = (byte)(1) ;
         A1798ConBaseFerProm = (byte)(0) ;
         A1799ConBaseHorExtProm = (byte)(0) ;
         A1797ConBaseLicProm = (byte)(0) ;
         A1800ConBasePres = (byte)(0) ;
         A1801ConBaseAnt = (byte)(0) ;
      }
      else
      {
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "ADICIONAL", "")) == 0 )
         {
            A1539ConSacDeven = (byte)(1) ;
         }
         else
         {
            A1539ConSacDeven = (byte)(0) ;
         }
      }
      A1112AplIIGG = (short)(0) ;
      n1112AplIIGG = false ;
      n1112AplIIGG = true ;
      A153ConObservacion = AV15ConObservacion ;
      A159ConVariable = AV16ConVariable ;
      A151ConHisFormula = "" ;
      n151ConHisFormula = false ;
      A156ConUsuModFor = httpContext.getMessage( "DEFAULT", "") ;
      n156ConUsuModFor = false ;
      A145ConFchModFor = GXutil.serverNow( context, remoteHandle, pr_default) ;
      n145ConFchModFor = false ;
      A37TipoConCod = AV18TipoConCod ;
      if ( ! (GXutil.strcmp("", AV19SubTipoConCod1)==0) )
      {
         A38SubTipoConCod1 = AV19SubTipoConCod1 ;
         n38SubTipoConCod1 = false ;
      }
      else
      {
         A38SubTipoConCod1 = "" ;
         n38SubTipoConCod1 = false ;
         n38SubTipoConCod1 = true ;
      }
      if ( ! (GXutil.strcmp("", AV20SubTipoConCod2)==0) )
      {
         A39SubTipoConCod2 = AV20SubTipoConCod2 ;
         n39SubTipoConCod2 = false ;
      }
      else
      {
         A39SubTipoConCod2 = "" ;
         n39SubTipoConCod2 = false ;
         n39SubTipoConCod2 = true ;
      }
      A469ConCodOld = AV21ConCodOld ;
      A26ConCodigo = AV22ConCodigo ;
      A42ConCodYDesc = AV23ConCodYDesc ;
      n42ConCodYDesc = false ;
      if ( ! (0==AV24ConOrden) )
      {
         A40ConOrden = AV24ConOrden ;
      }
      else
      {
         GXv_int3[0] = AV50auxConOrden ;
         GXv_int4[0] = AV51auxConOrdEjec ;
         new web.defaultordenconcepto(remoteHandle, context).execute( AV28CliCod, AV18TipoConCod, GXv_int3, GXv_int4) ;
         newconcepto.this.AV50auxConOrden = GXv_int3[0] ;
         newconcepto.this.AV51auxConOrdEjec = GXv_int4[0] ;
         A510ConOrdEjec = AV51auxConOrdEjec ;
         A40ConOrden = AV50auxConOrden ;
      }
      if ( GXutil.strcmp(AV18TipoConCod, "REM_ARG") == 0 )
      {
         A895ConTipoOrden = (short)(1) ;
      }
      else if ( GXutil.strcmp(AV18TipoConCod, "NRE_ARG") == 0 )
      {
         A895ConTipoOrden = (short)(2) ;
      }
      else if ( GXutil.strcmp(AV18TipoConCod, "DES_ARG") == 0 )
      {
         A895ConTipoOrden = (short)(3) ;
      }
      else
      {
         A895ConTipoOrden = (short)(4) ;
      }
      A762ConRecalcular = AV29ConRecalcular ;
      if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "DEDUCCIONES GENERALES MENSUALES", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "&con rec ", "")+GXutil.trim( GXutil.booltostr( AV29ConRecalcular))) ;
      }
      A951ConObliga = AV31ConObliga ;
      n951ConObliga = false ;
      A952ConObligaSiSac = AV32ConObligaSiSac ;
      n952ConObligaSiSac = false ;
      if ( GXutil.strcmp(AV8ConDescrip, httpContext.getMessage( "ADELANTO RETENCIÓN GANANCIAS", "")) == 0 )
      {
         A1017ConEdiEnRec = true ;
      }
      else
      {
         A1017ConEdiEnRec = false ;
      }
      A1018ConRangoCant = "" ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "&ConDescrip ", "")+GXutil.trim( AV8ConDescrip)) ;
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 1 SUELDO", "")) == 0 )
      {
         A1066ConPreReq = "APO_SIPA_NoSacNiVac" ;
         n1066ConPreReq = false ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 1 - APORTES SIPA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "IMPORTE A DETRAER", "")) == 0 ) )
      {
         A1066ConPreReq = "APO_SIPA" ;
         n1066ConPreReq = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "concepto_prereq.APO_SIPA", "")) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 5 - APORTES INSSJYP", "")) == 0 )
      {
         A1066ConPreReq = "APO_INSSJyP" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 4 - APORTES OS Y FSR", "")) == 0 )
      {
         A1066ConPreReq = "APO_OS" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 6 - APORTES DIFERENCIALES", "")) == 0 )
      {
         A1066ConPreReq = "APO_DIF" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 7 - APORTES PERSONAL REGIMENES ESPECIALES", "")) == 0 )
      {
         A1066ConPreReq = "APO_ESP" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 2 - CONTRIBUCIONES SIPA E INSSJYP", "")) == 0 )
      {
         A1066ConPreReq = "CON_SIPA" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 8 - CONTRIBUCIONES OS Y FSR", "")) == 0 )
      {
         A1066ConPreReq = "CON_OS" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 3 - CONTRIBUCIONES FNE, AAFF, Y RENATRE", "")) == 0 )
      {
         A1066ConPreReq = "CON_FNE" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 9 - CONTRIBUCIONES LRT", "")) == 0 )
      {
         A1066ConPreReq = "CON_LRT" ;
         n1066ConPreReq = false ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "SUELDO BRUTO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "SUELDO BRUTO SIN SAC", "")) == 0 ) )
      {
         A1066ConPreReq = "BRUTA" ;
         n1066ConPreReq = false ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), new web.sueldobrutogravadodescrip(remoteHandle, context).executeUdp( AV28CliCod)) == 0 )
      {
         A1066ConPreReq = "EXENTOS" ;
         n1066ConPreReq = false ;
      }
      A1644ConceptoPais = (short)(0) ;
      n1644ConceptoPais = false ;
      n1644ConceptoPais = true ;
      A1645ConceptoConveCodigo = "" ;
      n1645ConceptoConveCodigo = false ;
      n1645ConceptoConveCodigo = true ;
      AV33palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(A41ConDescrip," ")) ;
      A1769ConCntPa = (byte)(AV33palabras.size()) ;
      A1822CliPadre = 0 ;
      n1822CliPadre = false ;
      n1822CliPadre = true ;
      A921ConPadre = "" ;
      n921ConPadre = false ;
      n921ConPadre = true ;
      A1826ConPueNov = false ;
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8ConDescrip)), httpContext.getMessage( "ASIG. NO REM. DEC 438/23", "")) == 0 )
      {
         A1488ConLiqBasica = (byte)(1) ;
      }
      else
      {
         A1488ConLiqBasica = (byte)(0) ;
      }
      A1974ConOldValues = "" ;
      A2013ConRelRef = "" ;
      /* Using cursor P00HN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A41ConDescrip, Boolean.valueOf(A150ConHabilitado), Integer.valueOf(A40ConOrden), Boolean.valueOf(A143ConCanti), Boolean.valueOf(A158ConValUni), Boolean.valueOf(A152ConImporte), Byte.valueOf(A162ConVigencia), Boolean.valueOf(n148ConFormula), A148ConFormula, Boolean.valueOf(n157ConValorGen), A157ConValorGen, A153ConObservacion, Boolean.valueOf(A159ConVariable), Boolean.valueOf(n151ConHisFormula), A151ConHisFormula, Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Byte.valueOf(A154ConTipo), A469ConCodOld, Long.valueOf(A510ConOrdEjec), Boolean.valueOf(A762ConRecalcular), Short.valueOf(A895ConTipoOrden), Boolean.valueOf(n951ConObliga), Boolean.valueOf(A951ConObliga), Boolean.valueOf(n952ConObligaSiSac), Boolean.valueOf(A952ConObligaSiSac), Boolean.valueOf(n953ConCondicion), A953ConCondicion, Boolean.valueOf(A1017ConEdiEnRec), A1018ConRangoCant, Boolean.valueOf(n1066ConPreReq), A1066ConPreReq, Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), Byte.valueOf(A1488ConLiqBasica), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1622ConBaseHorExt), Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Byte.valueOf(A1769ConCntPa), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre, Byte.valueOf(A1827ConBaseOSDif), Boolean.valueOf(A1826ConPueNov), A1974ConOldValues, A2013ConRelRef, A2185ConDescripSinAc});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         new web.msgdebug3(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "duplicate", "")) ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /* Using cursor P00HN3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV28CliCod), AV22ConCodigo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A26ConCodigo = P00HN3_A26ConCodigo[0] ;
         A3CliCod = P00HN3_A3CliCod[0] ;
         A41ConDescrip = P00HN3_A41ConDescrip[0] ;
         A1648ConCodAfip = P00HN3_A1648ConCodAfip[0] ;
         A1472ConSIPAApo = P00HN3_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = P00HN3_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = P00HN3_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = P00HN3_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = P00HN3_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = P00HN3_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = P00HN3_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = P00HN3_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = P00HN3_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = P00HN3_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = P00HN3_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = P00HN3_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = P00HN3_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = P00HN3_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = P00HN3_A1486ConRegEspApo[0] ;
         GXv_char2[0] = AV34ConAFIPSIPAApo ;
         GXv_char5[0] = AV35ConAFIPINSSJyPCont ;
         GXv_char6[0] = AV36ConAFIPFonSolRedApo ;
         GXv_char7[0] = AV37ConAFIPFonSolRedCont ;
         GXv_char8[0] = AV38ConAFIPAsigFamCont ;
         GXv_char9[0] = AV39ConAFIPRegEspApo ;
         GXv_char10[0] = AV40ConAFIPRegDifApo ;
         GXv_char11[0] = AV41ConAFIPRenateaCont ;
         GXv_char12[0] = AV42ConAFIPSIPACont ;
         GXv_char13[0] = AV43ConAFIPINSSJyPApo ;
         GXv_char14[0] = AV44ConAFIPObraSocApo ;
         GXv_char15[0] = AV45ConAFIPFonNacEmpCont ;
         GXv_char16[0] = AV46ConAFIPLeyRieTrabCont ;
         GXv_char17[0] = AV47ConAFIPObraSocCont ;
         GXv_char18[0] = AV48ConAFIPRenateaApo ;
         GXv_char19[0] = AV49ConCodAfip ;
         new web.crearconceptoafipdefault3(remoteHandle, context).execute( AV28CliCod, AV22ConCodigo, GXv_char2, GXv_char5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10, GXv_char11, GXv_char12, GXv_char13, GXv_char14, GXv_char15, GXv_char16, GXv_char17, GXv_char18, GXv_char19) ;
         newconcepto.this.AV34ConAFIPSIPAApo = GXv_char2[0] ;
         newconcepto.this.AV35ConAFIPINSSJyPCont = GXv_char5[0] ;
         newconcepto.this.AV36ConAFIPFonSolRedApo = GXv_char6[0] ;
         newconcepto.this.AV37ConAFIPFonSolRedCont = GXv_char7[0] ;
         newconcepto.this.AV38ConAFIPAsigFamCont = GXv_char8[0] ;
         newconcepto.this.AV39ConAFIPRegEspApo = GXv_char9[0] ;
         newconcepto.this.AV40ConAFIPRegDifApo = GXv_char10[0] ;
         newconcepto.this.AV41ConAFIPRenateaCont = GXv_char11[0] ;
         newconcepto.this.AV42ConAFIPSIPACont = GXv_char12[0] ;
         newconcepto.this.AV43ConAFIPINSSJyPApo = GXv_char13[0] ;
         newconcepto.this.AV44ConAFIPObraSocApo = GXv_char14[0] ;
         newconcepto.this.AV45ConAFIPFonNacEmpCont = GXv_char15[0] ;
         newconcepto.this.AV46ConAFIPLeyRieTrabCont = GXv_char16[0] ;
         newconcepto.this.AV47ConAFIPObraSocCont = GXv_char17[0] ;
         newconcepto.this.AV48ConAFIPRenateaApo = GXv_char18[0] ;
         newconcepto.this.AV49ConCodAfip = GXv_char19[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "Condescrip \"", "")+GXutil.trim( A41ConDescrip)+"\"") ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "ASIG. NO REM. DEC 438/23", "")) == 0 )
         {
            A1648ConCodAfip = "560006" ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "asigna ok", "")) ;
         }
         else
         {
            A1648ConCodAfip = AV49ConCodAfip ;
         }
         A1472ConSIPAApo = (byte)(((GXutil.strcmp(AV34ConAFIPSIPAApo, "1")==0) ? 1 : 0)) ;
         A1473ConSIPACont = (byte)(((GXutil.strcmp(AV42ConAFIPSIPACont, "1")==0) ? 1 : 0)) ;
         A1474ConINSSJyPApo = (byte)(((GXutil.strcmp(AV43ConAFIPINSSJyPApo, "1")==0) ? 1 : 0)) ;
         A1475ConINSSJyPCont = (byte)(((GXutil.strcmp(AV35ConAFIPINSSJyPCont, "1")==0) ? 1 : 0)) ;
         A1476ConObraSocApo = (byte)(((GXutil.strcmp(AV44ConAFIPObraSocApo, "1")==0) ? 1 : 0)) ;
         A1477ConObraSocCont = (byte)(((GXutil.strcmp(AV47ConAFIPObraSocCont, "1")==0) ? 1 : 0)) ;
         A1478ConFonSolRedApo = (byte)(((GXutil.strcmp(AV36ConAFIPFonSolRedApo, "1")==0) ? 1 : 0)) ;
         A1479ConFonSolRedCont = (byte)(((GXutil.strcmp(AV37ConAFIPFonSolRedCont, "1")==0) ? 1 : 0)) ;
         A1480ConRenateaApo = (byte)(((GXutil.strcmp(AV48ConAFIPRenateaApo, "1")==0) ? 1 : 0)) ;
         A1481ConRenateaCont = (byte)(((GXutil.strcmp(AV41ConAFIPRenateaCont, "1")==0) ? 1 : 0)) ;
         A1482ConAsigFamCont = (byte)(((GXutil.strcmp(AV38ConAFIPAsigFamCont, "1")==0) ? 1 : 0)) ;
         A1483ConFonNacEmpCont = (byte)(((GXutil.strcmp(AV45ConAFIPFonNacEmpCont, "1")==0) ? 1 : 0)) ;
         A1484ConLeyRieTrabCont = (byte)(((GXutil.strcmp(AV46ConAFIPLeyRieTrabCont, "1")==0) ? 1 : 0)) ;
         A1485ConRegDifApo = (byte)(((GXutil.strcmp(AV40ConAFIPRegDifApo, "1")==0) ? 1 : 0)) ;
         A1486ConRegEspApo = (byte)(((GXutil.strcmp(AV39ConAFIPRegEspApo, "1")==0) ? 1 : 0)) ;
         /* Using cursor P00HN4 */
         pr_default.execute(2, new Object[] {A1648ConCodAfip, Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      new web.newconctipoliq(remoteHandle, context).execute( AV28CliCod, AV22ConCodigo, AV19SubTipoConCod1, AV30exclusivoMensualEs) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV28CliCod, AV22ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconcepto");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV54Pgmname = "" ;
      A41ConDescrip = "" ;
      A2185ConDescripSinAc = "" ;
      GXt_char1 = "" ;
      A148ConFormula = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      A953ConCondicion = "" ;
      A153ConObservacion = "" ;
      A151ConHisFormula = "" ;
      A156ConUsuModFor = "" ;
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A469ConCodOld = "" ;
      A26ConCodigo = "" ;
      A42ConCodYDesc = "" ;
      GXv_int3 = new int[1] ;
      GXv_int4 = new long[1] ;
      A1018ConRangoCant = "" ;
      A1066ConPreReq = "" ;
      A1645ConceptoConveCodigo = "" ;
      AV33palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      A921ConPadre = "" ;
      A1974ConOldValues = "" ;
      A2013ConRelRef = "" ;
      Gx_emsg = "" ;
      scmdbuf = "" ;
      P00HN3_A26ConCodigo = new String[] {""} ;
      P00HN3_A3CliCod = new int[1] ;
      P00HN3_A41ConDescrip = new String[] {""} ;
      P00HN3_A1648ConCodAfip = new String[] {""} ;
      P00HN3_A1472ConSIPAApo = new byte[1] ;
      P00HN3_A1473ConSIPACont = new byte[1] ;
      P00HN3_A1474ConINSSJyPApo = new byte[1] ;
      P00HN3_A1475ConINSSJyPCont = new byte[1] ;
      P00HN3_A1476ConObraSocApo = new byte[1] ;
      P00HN3_A1477ConObraSocCont = new byte[1] ;
      P00HN3_A1478ConFonSolRedApo = new byte[1] ;
      P00HN3_A1479ConFonSolRedCont = new byte[1] ;
      P00HN3_A1480ConRenateaApo = new byte[1] ;
      P00HN3_A1481ConRenateaCont = new byte[1] ;
      P00HN3_A1482ConAsigFamCont = new byte[1] ;
      P00HN3_A1483ConFonNacEmpCont = new byte[1] ;
      P00HN3_A1484ConLeyRieTrabCont = new byte[1] ;
      P00HN3_A1485ConRegDifApo = new byte[1] ;
      P00HN3_A1486ConRegEspApo = new byte[1] ;
      A1648ConCodAfip = "" ;
      AV34ConAFIPSIPAApo = "" ;
      GXv_char2 = new String[1] ;
      AV35ConAFIPINSSJyPCont = "" ;
      GXv_char5 = new String[1] ;
      AV36ConAFIPFonSolRedApo = "" ;
      GXv_char6 = new String[1] ;
      AV37ConAFIPFonSolRedCont = "" ;
      GXv_char7 = new String[1] ;
      AV38ConAFIPAsigFamCont = "" ;
      GXv_char8 = new String[1] ;
      AV39ConAFIPRegEspApo = "" ;
      GXv_char9 = new String[1] ;
      AV40ConAFIPRegDifApo = "" ;
      GXv_char10 = new String[1] ;
      AV41ConAFIPRenateaCont = "" ;
      GXv_char11 = new String[1] ;
      AV42ConAFIPSIPACont = "" ;
      GXv_char12 = new String[1] ;
      AV43ConAFIPINSSJyPApo = "" ;
      GXv_char13 = new String[1] ;
      AV44ConAFIPObraSocApo = "" ;
      GXv_char14 = new String[1] ;
      AV45ConAFIPFonNacEmpCont = "" ;
      GXv_char15 = new String[1] ;
      AV46ConAFIPLeyRieTrabCont = "" ;
      GXv_char16 = new String[1] ;
      AV47ConAFIPObraSocCont = "" ;
      GXv_char17 = new String[1] ;
      AV48ConAFIPRenateaApo = "" ;
      GXv_char18 = new String[1] ;
      AV49ConCodAfip = "" ;
      GXv_char19 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconcepto__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P00HN3_A26ConCodigo, P00HN3_A3CliCod, P00HN3_A41ConDescrip, P00HN3_A1648ConCodAfip, P00HN3_A1472ConSIPAApo, P00HN3_A1473ConSIPACont, P00HN3_A1474ConINSSJyPApo, P00HN3_A1475ConINSSJyPCont, P00HN3_A1476ConObraSocApo, P00HN3_A1477ConObraSocCont,
            P00HN3_A1478ConFonSolRedApo, P00HN3_A1479ConFonSolRedCont, P00HN3_A1480ConRenateaApo, P00HN3_A1481ConRenateaCont, P00HN3_A1482ConAsigFamCont, P00HN3_A1483ConFonNacEmpCont, P00HN3_A1484ConLeyRieTrabCont, P00HN3_A1485ConRegDifApo, P00HN3_A1486ConRegEspApo
            }
            , new Object[] {
            }
         }
      );
      AV54Pgmname = "newConcepto" ;
      /* GeneXus formulas. */
      AV54Pgmname = "newConcepto" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9ConTipo ;
   private byte AV11ConVigencia ;
   private byte A154ConTipo ;
   private byte A162ConVigencia ;
   private byte A1827ConBaseOSDif ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1539ConSacDeven ;
   private byte A1621ConBaseFer ;
   private byte A1622ConBaseHorExt ;
   private byte A1620ConBaseLic ;
   private byte A1798ConBaseFerProm ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1797ConBaseLicProm ;
   private byte A1769ConCntPa ;
   private byte A1488ConLiqBasica ;
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
   private short A1112AplIIGG ;
   private short A895ConTipoOrden ;
   private short A1644ConceptoPais ;
   private short Gx_err ;
   private int AV28CliCod ;
   private int AV24ConOrden ;
   private int GX_INS7 ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private int AV50auxConOrden ;
   private int GXv_int3[] ;
   private int A1822CliPadre ;
   private long AV51auxConOrdEjec ;
   private long GXv_int4[] ;
   private long A510ConOrdEjec ;
   private java.math.BigDecimal AV14ConValorGen ;
   private java.math.BigDecimal A157ConValorGen ;
   private String AV22ConCodigo ;
   private String AV18TipoConCod ;
   private String AV19SubTipoConCod1 ;
   private String AV20SubTipoConCod2 ;
   private String AV21ConCodOld ;
   private String AV26ConTipoLiqGanancias ;
   private String AV54Pgmname ;
   private String GXt_char1 ;
   private String A953ConCondicion ;
   private String A156ConUsuModFor ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A469ConCodOld ;
   private String A26ConCodigo ;
   private String A1066ConPreReq ;
   private String A1645ConceptoConveCodigo ;
   private String A921ConPadre ;
   private String Gx_emsg ;
   private String scmdbuf ;
   private String A1648ConCodAfip ;
   private String AV34ConAFIPSIPAApo ;
   private String GXv_char2[] ;
   private String AV35ConAFIPINSSJyPCont ;
   private String GXv_char5[] ;
   private String AV36ConAFIPFonSolRedApo ;
   private String GXv_char6[] ;
   private String AV37ConAFIPFonSolRedCont ;
   private String GXv_char7[] ;
   private String AV38ConAFIPAsigFamCont ;
   private String GXv_char8[] ;
   private String AV39ConAFIPRegEspApo ;
   private String GXv_char9[] ;
   private String AV40ConAFIPRegDifApo ;
   private String GXv_char10[] ;
   private String AV41ConAFIPRenateaCont ;
   private String GXv_char11[] ;
   private String AV42ConAFIPSIPACont ;
   private String GXv_char12[] ;
   private String AV43ConAFIPINSSJyPApo ;
   private String GXv_char13[] ;
   private String AV44ConAFIPObraSocApo ;
   private String GXv_char14[] ;
   private String AV45ConAFIPFonNacEmpCont ;
   private String GXv_char15[] ;
   private String AV46ConAFIPLeyRieTrabCont ;
   private String GXv_char16[] ;
   private String AV47ConAFIPObraSocCont ;
   private String GXv_char17[] ;
   private String AV48ConAFIPRenateaApo ;
   private String GXv_char18[] ;
   private String AV49ConCodAfip ;
   private String GXv_char19[] ;
   private java.util.Date A145ConFchModFor ;
   private boolean AV10ConValUni ;
   private boolean AV12ConImporte ;
   private boolean AV16ConVariable ;
   private boolean AV17ConForExportar ;
   private boolean AV25ConForEditable ;
   private boolean AV27ConCanti ;
   private boolean AV29ConRecalcular ;
   private boolean AV30exclusivoMensualEs ;
   private boolean A150ConHabilitado ;
   private boolean A143ConCanti ;
   private boolean A158ConValUni ;
   private boolean A152ConImporte ;
   private boolean n148ConFormula ;
   private boolean n157ConValorGen ;
   private boolean n953ConCondicion ;
   private boolean n1112AplIIGG ;
   private boolean A159ConVariable ;
   private boolean n151ConHisFormula ;
   private boolean n156ConUsuModFor ;
   private boolean n145ConFchModFor ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n42ConCodYDesc ;
   private boolean A762ConRecalcular ;
   private boolean A951ConObliga ;
   private boolean AV31ConObliga ;
   private boolean n951ConObliga ;
   private boolean A952ConObligaSiSac ;
   private boolean AV32ConObligaSiSac ;
   private boolean n952ConObligaSiSac ;
   private boolean A1017ConEdiEnRec ;
   private boolean n1066ConPreReq ;
   private boolean n1644ConceptoPais ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1822CliPadre ;
   private boolean n921ConPadre ;
   private boolean A1826ConPueNov ;
   private String AV13ConFormula ;
   private String AV15ConObservacion ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A151ConHisFormula ;
   private String A1974ConOldValues ;
   private String AV8ConDescrip ;
   private String AV23ConCodYDesc ;
   private String A41ConDescrip ;
   private String A2185ConDescripSinAc ;
   private String A42ConCodYDesc ;
   private String A1018ConRangoCant ;
   private String A2013ConRelRef ;
   private IDataStoreProvider pr_default ;
   private String[] P00HN3_A26ConCodigo ;
   private int[] P00HN3_A3CliCod ;
   private String[] P00HN3_A41ConDescrip ;
   private String[] P00HN3_A1648ConCodAfip ;
   private byte[] P00HN3_A1472ConSIPAApo ;
   private byte[] P00HN3_A1473ConSIPACont ;
   private byte[] P00HN3_A1474ConINSSJyPApo ;
   private byte[] P00HN3_A1475ConINSSJyPCont ;
   private byte[] P00HN3_A1476ConObraSocApo ;
   private byte[] P00HN3_A1477ConObraSocCont ;
   private byte[] P00HN3_A1478ConFonSolRedApo ;
   private byte[] P00HN3_A1479ConFonSolRedCont ;
   private byte[] P00HN3_A1480ConRenateaApo ;
   private byte[] P00HN3_A1481ConRenateaCont ;
   private byte[] P00HN3_A1482ConAsigFamCont ;
   private byte[] P00HN3_A1483ConFonNacEmpCont ;
   private byte[] P00HN3_A1484ConLeyRieTrabCont ;
   private byte[] P00HN3_A1485ConRegDifApo ;
   private byte[] P00HN3_A1486ConRegEspApo ;
   private GXSimpleCollection<String> AV33palabras ;
}

final  class newconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00HN2", "SAVEPOINT gxupdate;INSERT INTO Concepto(CliCod, ConCodigo, ConDescrip, ConHabilitado, ConOrden, ConCanti, ConValUni, ConImporte, ConVigencia, ConFormula, ConValorGen, ConObservacion, ConVariable, ConHisFormula, ConUsuModFor, ConFchModFor, ConCodYDesc, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConTipo, ConCodOld, ConOrdEjec, ConRecalcular, ConTipoOrden, ConObliga, ConObligaSiSac, ConCondicion, ConEdiEnRec, ConRangoCant, ConPreReq, AplIIGG, ConLiqBasica, ConSacDeven, ConBaseLic, ConBaseFer, ConBaseHorExt, ConceptoPais, ConceptoConveCodigo, ConCntPa, ConBaseLicProm, ConBaseFerProm, ConBaseHorExtProm, ConBasePres, ConBaseAnt, CliPadre, ConPadre, ConBaseOSDif, ConPueNov, ConOldValues, ConRelRef, ConDescripSinAc, ConTipoLiqGanancias, ConForEditable, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConFormulaExpl, ConFormulaObs2, ConFormulaPreResuelta, ConRetGanPropor, ConAplicGan, ConImportado, ConUsado, ConCondCodigo, ConConveAux, ConClasifAux, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConCodAfip, ConErrorSiCero, ConRelSec, ConRelSecCli, ConBaseAus, ConBaseAusProm, ConOblPalabra) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', FALSE, '', '', '', '', '', '', FALSE, 0, FALSE, FALSE, '', '', '', FALSE, 0, FALSE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', FALSE, 0, 0, 0, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00HN3", "SELECT ConCodigo, CliCod, ConDescrip, ConCodAfip, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00HN4", "SAVEPOINT gxupdate;UPDATE Concepto SET ConCodAfip=?, ConSIPAApo=?, ConSIPACont=?, ConINSSJyPApo=?, ConINSSJyPCont=?, ConObraSocApo=?, ConObraSocCont=?, ConFonSolRedApo=?, ConFonSolRedCont=?, ConRenateaApo=?, ConRenateaCont=?, ConAsigFamCont=?, ConFonNacEmpCont=?, ConLeyRieTrabCont=?, ConRegDifApo=?, ConRegEspApo=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((byte[]) buf[18])[0] = rslt.getByte(19);
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
               stmt.setNLongVarchar(12, (String)parms[13], false);
               stmt.setBoolean(13, ((Boolean) parms[14]).booleanValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(14, (String)parms[16]);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[18], 20);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(16, (java.util.Date)parms[20], false);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(17, (String)parms[22], 400);
               }
               stmt.setString(18, (String)parms[23], 20);
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(19, (String)parms[25], 20);
               }
               if ( ((Boolean) parms[26]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(20, (String)parms[27], 20);
               }
               stmt.setByte(21, ((Number) parms[28]).byteValue());
               stmt.setString(22, (String)parms[29], 10);
               stmt.setLong(23, ((Number) parms[30]).longValue());
               stmt.setBoolean(24, ((Boolean) parms[31]).booleanValue());
               stmt.setShort(25, ((Number) parms[32]).shortValue());
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(26, ((Boolean) parms[34]).booleanValue());
               }
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(27, ((Boolean) parms[36]).booleanValue());
               }
               if ( ((Boolean) parms[37]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(28, (String)parms[38], 20);
               }
               stmt.setBoolean(29, ((Boolean) parms[39]).booleanValue());
               stmt.setVarchar(30, (String)parms[40], 400, false);
               if ( ((Boolean) parms[41]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(31, (String)parms[42], 20);
               }
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(32, ((Number) parms[44]).shortValue());
               }
               stmt.setByte(33, ((Number) parms[45]).byteValue());
               stmt.setByte(34, ((Number) parms[46]).byteValue());
               stmt.setByte(35, ((Number) parms[47]).byteValue());
               stmt.setByte(36, ((Number) parms[48]).byteValue());
               stmt.setByte(37, ((Number) parms[49]).byteValue());
               if ( ((Boolean) parms[50]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(38, ((Number) parms[51]).shortValue());
               }
               if ( ((Boolean) parms[52]).booleanValue() )
               {
                  stmt.setNull( 39 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(39, (String)parms[53], 20);
               }
               stmt.setByte(40, ((Number) parms[54]).byteValue());
               stmt.setByte(41, ((Number) parms[55]).byteValue());
               stmt.setByte(42, ((Number) parms[56]).byteValue());
               stmt.setByte(43, ((Number) parms[57]).byteValue());
               stmt.setByte(44, ((Number) parms[58]).byteValue());
               stmt.setByte(45, ((Number) parms[59]).byteValue());
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 46 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(46, ((Number) parms[61]).intValue());
               }
               if ( ((Boolean) parms[62]).booleanValue() )
               {
                  stmt.setNull( 47 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(47, (String)parms[63], 10);
               }
               stmt.setByte(48, ((Number) parms[64]).byteValue());
               stmt.setBoolean(49, ((Boolean) parms[65]).booleanValue());
               stmt.setNLongVarchar(50, (String)parms[66], false);
               stmt.setVarchar(51, (String)parms[67], 40, false);
               stmt.setVarchar(52, (String)parms[68], 400, false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 6);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setByte(14, ((Number) parms[13]).byteValue());
               stmt.setByte(15, ((Number) parms[14]).byteValue());
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setString(18, (String)parms[17], 10);
               return;
      }
   }

}

